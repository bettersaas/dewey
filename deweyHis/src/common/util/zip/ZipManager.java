package common.util.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


/**
 * Description: 此类用于... 用java的ZipOutputStream类解压文件或文件夹中的文件
 * 
 * @author
 * @version 1.0.0
 */
public class ZipManager {

	/**
	 * zip压缩功能测试. 将d:\\temp\\zipout目录下的所有文件连同子目录压缩到d:\\temp\\out.zip.
	 * 
	 * @param baseDir
	 *            所要压缩的目录名（包含绝对路径）
	 * @param objFileName
	 *            压缩后的文件名
	 * @throws Exception
	 */
	public void createZip(String baseDir, String objFileName) throws Exception {
		File folderObject = new File(baseDir);

		if (folderObject.exists()) {
			List<File> fileList = getSubFiles(new File(baseDir));

			// 压缩文件名
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(
					objFileName));

			ZipEntry ze = null;
			byte[] buf = new byte[1024];
			int readLen = 0;
			for (int i = 0; i < fileList.size(); i++) {
				File f = (File) fileList.get(i);
				System.out.println("Adding: " + f.getPath() + f.getName());

				// 创建一个ZipEntry，并设置Name和其它的一些属性
				ze = new ZipEntry(getAbsFileName(baseDir, f));
				ze.setSize(f.length());
				ze.setTime(f.lastModified());

				// 将ZipEntry加到zos中，再写入实际的文件内容
				zos.putNextEntry(ze);
				InputStream is = new BufferedInputStream(new FileInputStream(f));
				while ((readLen = is.read(buf, 0, 1024)) != -1) {
					zos.write(buf, 0, readLen);
				}
				is.close();
				System.out.println("done...");
			}
			zos.close();
		} else {
			throw new Exception("this folder isnot exist!");
		}
	}

	/**
	 * zip压缩功能测试. 将指定文件压缩后存到一压缩文件中
	 * 
	 * @param baseDir
	 *            所要压缩的文件名
	 * @param objFileName
	 *            压缩后的文件名
	 * @return 压缩后文件的大小
	 * @throws Exception
	 */
	public long createFileToZip(String zipFilename, String sourceFileName)
			throws Exception {

		File sourceFile = new File(sourceFileName);

		byte[] buf = new byte[1024];
		// 压缩文件名
		File objFile = new File(zipFilename);

		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(objFile));

		ZipEntry ze = null;
		// 创建一个ZipEntry，并设置Name和其它的一些属性
		ze = new ZipEntry(sourceFile.getName());
		ze.setSize(sourceFile.length());
		ze.setTime(sourceFile.lastModified());

		// 将ZipEntry加到zos中，再写入实际的文件内容
		zos.putNextEntry(ze);

		InputStream is = new BufferedInputStream(
				new FileInputStream(sourceFile));

		int readLen = -1;
		while ((readLen = is.read(buf, 0, 1024)) != -1) {
			zos.write(buf, 0, readLen);
		}
		is.close();
		zos.close();

		return objFile.length();
	}

	/**
	 * zip压缩功能测试. 将指定文件压缩后存到一压缩文件中
	 * 
	 * @param baseDir
	 *            所要压缩的文件名
	 * @param objFileName
	 *            压缩后的文件名
	 * @return 压缩后文件的大小
	 * @throws Exception
	 */
	public long createFileToZip(File sourceFile, File zipFile)
			throws IOException {

		byte[] buf = new byte[1024];

		// 压缩文件名
		File objFile = zipFile;

		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(objFile));

		ZipEntry ze = null;
		// 创建一个ZipEntry，并设置Name和其它的一些属性
		ze = new ZipEntry(sourceFile.getName());
		ze.setSize(sourceFile.length());
		ze.setTime(sourceFile.lastModified());

		// 将ZipEntry加到zos中，再写入实际的文件内容
		zos.putNextEntry(ze);

		InputStream is = new BufferedInputStream(
				new FileInputStream(sourceFile));

		int readLen = -1;
		while ((readLen = is.read(buf, 0, 1024)) != -1) {
			zos.write(buf, 0, readLen);
		}
		is.close();
		zos.close();

		return objFile.length();
	}

	/**
	 * 测试解压缩功能. 将d:\\download\\test.zip连同子目录解压到d:\\temp\\zipout目录下.
	 * 
	 * @throws Exception
	 */
	public void releaseZipToFile(String sourceZip, String outFileName)
			throws IOException {
		ZipFile zfile = new ZipFile(sourceZip);
		System.out.println(zfile.getName());
		Enumeration<?> zList = zfile.entries();
		ZipEntry ze = null;
		byte[] buf = new byte[1024];
		while (zList.hasMoreElements()) {
			// 从ZipFile中得到一个ZipEntry
			ze = (ZipEntry) zList.nextElement();
			if (ze.isDirectory()) {
				continue;
			}
			// 以ZipEntry为参数得到一个InputStream，并写到OutputStream中
			OutputStream os = new BufferedOutputStream(new FileOutputStream(
					getRealFileName(outFileName, ze.getName())));
			InputStream is = new BufferedInputStream(zfile.getInputStream(ze));
			int readLen = 0;
			while ((readLen = is.read(buf, 0, 1024)) != -1) {
				os.write(buf, 0, readLen);
			}
			is.close();
			os.close();
			System.out.println("Extracted: " + ze.getName());
		}
		zfile.close();
	}

	/**
	 * 取得指定目录下的所有文件列表，包括子目录.
	 * 
	 * @param baseDir
	 *            File 指定的目录
	 * @return 包含java.io.File的List
	 */
	private List<File> getSubFiles(File baseDir) {
		List<File> ret = new ArrayList<File>();
		// File base=new File(baseDir);
		File[] tmp = baseDir.listFiles();
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i].isFile()) {
				ret.add(tmp[i]);
			}
			if (tmp[i].isDirectory()) {
				ret.addAll(getSubFiles(tmp[i]));
			}
		}
		return ret;
	}

	/**
	 * 给定根目录，返回一个相对路径所对应的实际文件名.
	 * 
	 * @param baseDir
	 *            指定根目录
	 * @param absFileName
	 *            相对路径名，来自于ZipEntry中的name
	 * @return java.io.File 实际的文件
	 */
	private File getRealFileName(String baseDir, String absFileName) {
		String[] dirs = absFileName.split("/");
		// System.out.println(dirs.length);
		File ret = new File(baseDir);
		// System.out.println(ret);
		if (dirs.length > 1) {
			for (int i = 0; i < dirs.length - 1; i++) {
				ret = new File(ret, dirs[i]);
			}
		}
		if (!ret.exists()) {
			ret.mkdirs();
		}
		ret = new File(ret, dirs[dirs.length - 1]);
		return ret;
	}

	/**
	 * 给定根目录，返回另一个文件名的相对路径，用于zip文件中的路径.
	 * 
	 * @param baseDir
	 *            java.lang.String 根目录
	 * @param realFileName
	 *            java.io.File 实际的文件名
	 * @return 相对文件名
	 */
	private String getAbsFileName(String baseDir, File realFileName) {
		File real = realFileName;
		File base = new File(baseDir);
		String ret = real.getName();
		while (true) {
			real = real.getParentFile();
			if (real == null)
				break;
			if (real.equals(base))
				break;
			else {
				ret = real.getName() + "/" + ret;
			}
		}
		System.out.println("TTTTT" + ret);
		return ret;
	}

	public void testReadZip() throws Exception {
		String baseDir = "d:\\temp\\zipout";
		ZipFile zfile = new ZipFile("d:\\download\\src.zip");
		System.out.println(zfile.getName());
		Enumeration<?> zList = zfile.entries();
		ZipEntry ze = null;
		byte[] buf = new byte[1024];
		while (zList.hasMoreElements()) {
			// 从ZipFile中得到一个ZipEntry
			ze = (ZipEntry) zList.nextElement();
			if (ze.isDirectory()) {
				continue;
			}
			// 以ZipEntry为参数得到一个InputStream，并写到OutputStream中
			OutputStream os = new BufferedOutputStream(new FileOutputStream(
					getRealFileName(baseDir, ze.getName())));
			InputStream is = new BufferedInputStream(zfile.getInputStream(ze));
			int readLen = 0;
			while ((readLen = is.read(buf, 0, 1024)) != -1) {
				os.write(buf, 0, readLen);
			}
			is.close();
			os.close();
			System.out.println("Extracted: " + ze.getName());
		}
		zfile.close();
	}

	public static void main(String args[]) {
		ZipManager manager = new ZipManager();
		try {
			// manager.releaseZipToFile("c:\\test.zip","c:\\test");
			manager.testReadZip();
		} catch (Exception e) {
		}
		System.out.println("over");
		
	    try{
	        String fileName = args[0];
	        manager.ZipFiles(args);
	        manager.unZipFile(fileName);
	        Vector<?> dd = manager.listFile(fileName);
	        System.out.println("File List: "+dd);
	       }catch(Exception e){
	       	e.printStackTrace();
	       }
	}
	
	/**
	 * 使用ZipInputStream和ZipOutputStream对文件和目录进行压缩和解压处理
	 *<br>方法说明：实现文件的压缩处理
	 *<br>输入参数：String[] fs 压缩的文件数组
	 *<br>返回类型：
	 */
	  public void ZipFiles(String[] fs){
	   try{
	     String fileName = fs[0];
	     FileOutputStream f =
	       new FileOutputStream(fileName+".zip");
	     //使用输出流检查
	     CheckedOutputStream cs = 
	        new CheckedOutputStream(f,new Adler32());
	      //声明输出zip流
	      ZipOutputStream out =
	        new ZipOutputStream(new BufferedOutputStream(cs));
	      //写一个注释
	      out.setComment("A test of Java Zipping");
	      //对多文件进行压缩
	      for(int i=1;i<fs.length;i++){
	        System.out.println("Write file "+fs[i]);
	        BufferedReader in =
	           new BufferedReader(
	             new FileReader(fs[i]));
	         out.putNextEntry(new ZipEntry(fs[i]));
	         int c;
	         while((c=in.read())!=-1)
	          out.write(c);
	        in.close();
	       }
	       //关闭输出流
	       out.close();
	       System.out.println("Checksum::"+cs.getChecksum().getValue());
	    }catch(Exception e){
	       System.err.println(e);
	    }
	  }

	/**
	 *<br>方法说明：解压缩Zip文件
	 *<br>输入参数：String fileName 解压zip文件名
	 *<br>返回类型：
	 */
	  public void unZipFile(String fileName){
	    try{
	       System.out.println("读取ZIP文件........");
	       //文件输入流
	       FileInputStream fi =
	         new FileInputStream(fileName+".zip");
	       //输入流检查
	       CheckedInputStream csi = new CheckedInputStream(fi,new Adler32());
	       //输入流压缩
	       ZipInputStream in2 =
	         new ZipInputStream(
	           new BufferedInputStream(csi));
	       ZipEntry ze;
	       System.out.println("Checksum::"+csi.getChecksum().getValue());
	       //解压全部文件
	       while((ze = in2.getNextEntry())!=null){
	         System.out.println("Reading file "+ze);
	         int x;
	         while((x= in2.read())!=-1)
	           //这里是写文件，write是以byte方式输出。
	           System.out.write(x);
	       }
	       in2.close();
	    }catch(Exception e){
	      System.err.println(e);
	    }
	  }
	/**
	 *<br>方法说明：读取Zip文件列表
	 *<br>输入参数：String fileName zip文件名
	 *<br>返回类型：Vector 文件列表
	 */
	  public Vector<ZipEntry> listFile(String fileName){
	    try{
//	       String[] aRst=null;
	       Vector<ZipEntry> vTemp = new Vector<ZipEntry>();
	       //zip文件对象
	       ZipFile zf = new ZipFile(fileName+".zip");
	       Enumeration<?> e = zf.entries();
	       while(e.hasMoreElements()){
	         ZipEntry ze2 = (ZipEntry)e.nextElement();
	         System.out.println("File: "+ze2);
	         vTemp.addElement(ze2);
	       }
	       return  vTemp;
	    }catch(Exception e){
	      System.err.println(e);
	      return null;
	    }
	  }
}
