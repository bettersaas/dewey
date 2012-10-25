package common.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;

/**
 * 异步io的服务器 并实现了单线程对应多个socket的功能，但是java的tutorial上依旧只有同步
 * 的服务器例子，而且是为每一个客户建立一个线程，后来我发现了java.nio这个 包，专门是用来写异步I/O程序的，以下是一个简单的我写的例子程序：
 * 服务器端
 * 
 * @author Administrator
 * 
 */
public class NIOServer {

	static int BLOCK = 4096;

	// 处理与客户端的交互
	public class HandleClient {

		protected FileChannel channel;

		protected ByteBuffer buffer;

		public HandleClient() throws IOException {
			this.channel = new FileInputStream(filename).getChannel();
			this.buffer = ByteBuffer.allocate(BLOCK);
		}

		public ByteBuffer readBlock() {
			try {
				buffer.clear();
				int count = channel.read(buffer);
				buffer.flip();
				if (count <= 0)
					return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
			return buffer;
		}

		public void close() {
			try {
				channel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected Selector selector;

	protected String filename = "d:\\bigfile.dat"; // a big file

	protected ByteBuffer clientBuffer = ByteBuffer.allocate(BLOCK);

	protected CharsetDecoder decoder;

	public NIOServer(int port) throws IOException {
		selector = this.getSelector(port);
		Charset charset = Charset.forName("GB2312");
		decoder = charset.newDecoder();
	}

	protected Selector getSelector(int port) throws IOException {
		ServerSocketChannel server = ServerSocketChannel.open();
		Selector sel = Selector.open();
		server.socket().bind(new InetSocketAddress(port));
		server.configureBlocking(false);
		server.register(sel, SelectionKey.OP_ACCEPT);
		return sel;
	}

	// 监听端口
	public void listen() {
		try {
			for (;;) {
				selector.select();
				Iterator<?> iter = selector.selectedKeys().iterator();
				while (iter.hasNext()) {
					SelectionKey key = (SelectionKey) iter.next();
					iter.remove();
					handleKey(key);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void handleKey(SelectionKey key) throws IOException {
		if (key.isAcceptable()) { // 接收请求
			System.out.println("receive connection....");
			ServerSocketChannel server = (ServerSocketChannel) key.channel();
			SocketChannel channel = server.accept();
			channel.configureBlocking(false);
			channel.register(selector, SelectionKey.OP_READ);
		} else if (key.isReadable()) { // 读信息
			System.out.println("begin reading....");
			SocketChannel channel = (SocketChannel) key.channel();
			int count = channel.read(clientBuffer);
			if (count > 0) {
				clientBuffer.flip();
				CharBuffer charBuffer = decoder.decode(clientBuffer);
				System.out.println("Client >>" + charBuffer.toString());
				SelectionKey wKey = channel.register(selector, SelectionKey.OP_WRITE);
				wKey.attach(new HandleClient());
			} else
				channel.close();
			clientBuffer.clear();
		} else if (key.isWritable()) { // 写事件
			System.out.println("begin writing");
			SocketChannel channel = (SocketChannel) key.channel();
			HandleClient handle = (HandleClient) key.attachment();
			ByteBuffer block = handle.readBlock();
			if (block != null)
				channel.write(block);
			else {
				handle.close();
				channel.close();
			}
		}
	}

	public static void main(String[] args) {
		int port = 12345;
		try {
			NIOServer server = new NIOServer(port);
			System.out.println("Listernint on " + port);
			while (true) {
				server.listen();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
