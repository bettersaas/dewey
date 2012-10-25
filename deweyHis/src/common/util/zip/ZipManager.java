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
 * Description: ��������... ��java��ZipOutputStream���ѹ�ļ����ļ����е��ļ�
 * 
 * @author
 * @version 1.0.0
 */
public class ZipManager {

	/**
	 * zipѹ�����ܲ���. ��d:\\temp\\zipoutĿ¼�µ������ļ���ͬ��Ŀ¼ѹ����d:\\temp\\out.zip.
	 * 
	 * @param baseDir
	 *            ��Ҫѹ����Ŀ¼������������·����
	 * @param objFileName
	 *            ѹ������ļ���
	 * @throws Exception
	 */
	public void createZip(String baseDir, String objFileName) throws Exception {
		File folderObject = new File(baseDir);

		if (folderObject.exists()) {
			List<File> fileList = getSubFiles(new File(baseDir));

			// ѹ���ļ���
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(
					objFileName));

			ZipEntry ze = null;
			byte[] buf = new byte[1024];
			int readLen = 0;
			for (int i = 0; i < fileList.size(); i++) {
				File f = (File) fileList.get(i);
				System.out.println("Adding: " + f.getPath() + f.getName());

				// ����һ��ZipEntry��������Name��������һЩ����
				ze = new ZipEntry(getAbsFileName(baseDir, f));
				ze.setSize(f.length());
				ze.setTime(f.lastModified());

				// ��ZipEntry�ӵ�zos�У���д��ʵ�ʵ��ļ�����
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
	 * zipѹ�����ܲ���. ��ָ���ļ�ѹ����浽һѹ���ļ���
	 * 
	 * @param baseDir
	 *            ��Ҫѹ�����ļ���
	 * @param objFileName
	 *            ѹ������ļ���
	 * @return ѹ�����ļ��Ĵ�С
	 * @throws Exception
	 */
	public long createFileToZip(String zipFilename, String sourceFileName)
			throws Exception {

		File sourceFile = new File(sourceFileName);

		byte[] buf = new byte[1024];
		// ѹ���ļ���
		File objFile = new File(zipFilename);

		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(objFile));

		ZipEntry ze = null;
		// ����һ��ZipEntry��������Name��������һЩ����
		ze = new ZipEntry(sourceFile.getName());
		ze.setSize(sourceFile.length());
		ze.setTime(sourceFile.lastModified());

		// ��ZipEntry�ӵ�zos�У���д��ʵ�ʵ��ļ�����
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
	 * zipѹ�����ܲ���. ��ָ���ļ�ѹ����浽һѹ���ļ���
	 * 
	 * @param baseDir
	 *            ��Ҫѹ�����ļ���
	 * @param objFileName
	 *            ѹ������ļ���
	 * @return ѹ�����ļ��Ĵ�С
	 * @throws Exception
	 */
	public long createFileToZip(File sourceFile, File zipFile)
			throws IOException {

		byte[] buf = new byte[1024];

		// ѹ���ļ���
		File objFile = zipFile;

		ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(objFile));

		ZipEntry ze = null;
		// ����һ��ZipEntry��������Name��������һЩ����
		ze = new ZipEntry(sourceFile.getName());
		ze.setSize(sourceFile.length());
		ze.setTime(sourceFile.lastModified());

		// ��ZipEntry�ӵ�zos�У���д��ʵ�ʵ��ļ�����
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
	 * ���Խ�ѹ������. ��d:\\download\\test.zip��ͬ��Ŀ¼��ѹ��d:\\temp\\zipoutĿ¼��.
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
			// ��ZipFile�еõ�һ��ZipEntry
			ze = (ZipEntry) zList.nextElement();
			if (ze.isDirectory()) {
				continue;
			}
			// ��ZipEntryΪ�����õ�һ��InputStream����д��OutputStream��
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
	 * ȡ��ָ��Ŀ¼�µ������ļ��б�������Ŀ¼.
	 * 
	 * @param baseDir
	 *            File ָ����Ŀ¼
	 * @return ����java.io.File��List
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
	 * ������Ŀ¼������һ�����·������Ӧ��ʵ���ļ���.
	 * 
	 * @param baseDir
	 *            ָ����Ŀ¼
	 * @param absFileName
	 *            ���·������������ZipEntry�е�name
	 * @return java.io.File ʵ�ʵ��ļ�
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
	 * ������Ŀ¼��������һ���ļ��������·��������zip�ļ��е�·��.
	 * 
	 * @param baseDir
	 *            java.lang.String ��Ŀ¼
	 * @param realFileName
	 *            java.io.File ʵ�ʵ��ļ���
	 * @return ����ļ���
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
			// ��ZipFile�еõ�һ��ZipEntry
			ze = (ZipEntry) zList.nextElement();
			if (ze.isDirectory()) {
				continue;
			}
			// ��ZipEntryΪ�����õ�һ��InputStream����д��OutputStream��
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
	 * ʹ��ZipInputStream��ZipOutputStream���ļ���Ŀ¼����ѹ���ͽ�ѹ����
	 *<br>����˵����ʵ���ļ���ѹ������
	 *<br>���������String[] fs ѹ�����ļ�����
	 *<br>�������ͣ�
	 */
	  public void ZipFiles(String[] fs){
	   try{
	     String fileName = fs[0];
	     FileOutputStream f =
	       new FileOutputStream(fileName+".zip");
	     //ʹ����������
	     CheckedOutputStream cs = 
	        new CheckedOutputStream(f,new Adler32());
	      //�������zip��
	      ZipOutputStream out =
	        new ZipOutputStream(new BufferedOutputStream(cs));
	      //дһ��ע��
	      out.setComment("A test of Java Zipping");
	      //�Զ��ļ�����ѹ��
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
	       //�ر������
	       out.close();
	       System.out.println("Checksum::"+cs.getChecksum().getValue());
	    }catch(Exception e){
	       System.err.println(e);
	    }
	  }

	/**
	 *<br>����˵������ѹ��Zip�ļ�
	 *<br>���������String fileName ��ѹzip�ļ���
	 *<br>�������ͣ�
	 */
	  public void unZipFile(String fileName){
	    try{
	       System.out.println("��ȡZIP�ļ�........");
	       //�ļ�������
	       FileInputStream fi =
	         new FileInputStream(fileName+".zip");
	       //���������
	       CheckedInputStream csi = new CheckedInputStream(fi,new Adler32());
	       //������ѹ��
	       ZipInputStream in2 =
	         new ZipInputStream(
	           new BufferedInputStream(csi));
	       ZipEntry ze;
	       System.out.println("Checksum::"+csi.getChecksum().getValue());
	       //��ѹȫ���ļ�
	       while((ze = in2.getNextEntry())!=null){
	         System.out.println("Reading file "+ze);
	         int x;
	         while((x= in2.read())!=-1)
	           //������д�ļ���write����byte��ʽ�����
	           System.out.write(x);
	       }
	       in2.close();
	    }catch(Exception e){
	      System.err.println(e);
	    }
	  }
	/**
	 *<br>����˵������ȡZip�ļ��б�
	 *<br>���������String fileName zip�ļ���
	 *<br>�������ͣ�Vector �ļ��б�
	 */
	  public Vector<ZipEntry> listFile(String fileName){
	    try{
//	       String[] aRst=null;
	       Vector<ZipEntry> vTemp = new Vector<ZipEntry>();
	       //zip�ļ�����
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
