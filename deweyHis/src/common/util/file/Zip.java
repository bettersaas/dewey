package common.util.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * java.util.zip 的解压和压缩文件夹
 * 
 */
public class Zip {
	public static final int BUFFER = 2048;

	private byte[] data = new byte[BUFFER];

	private static ZipOutputStream zos = null;

	private BufferedInputStream bis = null;

	private BufferedOutputStream bos = null;

	private Enumeration<ZipEntry> entries = null;

	public static void main(String[] args) throws IOException {
		String s = "D:\\dingjing";
		// String s = "D:\\2.txt";
		File f = new File(s);
		Zip zip = new Zip();
		zip.zip(f);
		s = "dingjing.zip";
		zip.unzip(new File(s));
	}

	public void zip(File file) throws IOException {
		File zipFile = new File(file.getName() + ".zip");
		zos = new ZipOutputStream(new FileOutputStream(zipFile));
		realZip(file, zos);
		zos.close();
	}

	public void realZip(File file, ZipOutputStream zos) throws IOException {
		if (file.isDirectory()) {
			// file.getPath().substring(3)： 去除盘符
			zos.putNextEntry(new ZipEntry(file.getPath().substring(3) + "/"));
			zos.closeEntry();
			File[] files = file.listFiles();
			if (files.length == 0) {
				return;
			} else {
				for (File f : files) {
					System.out.println(f.getPath());
					if (f.isDirectory()) {
						realZip(f, zos);
					} else {
						handleZip(f, zos);
					}
				}
			}
		} else {
			handleZip(file, zos);
		}
	}

	public void handleZip(File f, ZipOutputStream zos) {
		try {
			bis = new BufferedInputStream(new FileInputStream(f));
			zos.putNextEntry(new ZipEntry(f.getPath().substring(3)));
			int count = -1;
			while ((count = bis.read(data, 0, BUFFER)) != -1) {
				zos.write(data, 0, count);
			}
			bis.close();
			zos.closeEntry();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void unzip(File file) {
		ZipFile zf;
		try {
			zf = new ZipFile(file);
			entries = (Enumeration<ZipEntry>) zf.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				if (entry.isDirectory()) {
					System.out.println("create dir: " + entry.getName());
					new File(entry.getName()).mkdirs();
					continue;
				} else {
					bos = new BufferedOutputStream(new FileOutputStream(
							new File(entry.getName()).getPath()));
					handleUnZip(zf.getInputStream(entry), bos);
				}
			}
		} catch (ZipException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void handleUnZip(InputStream is, BufferedOutputStream bos) {
		int count;
		try {
			while ((count = is.read(data, 0, BUFFER)) != -1) {
				bos.write(data, 0, count);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
