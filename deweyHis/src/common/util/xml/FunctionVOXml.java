package common.util.xml;

import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.XMLOutputter;

public class FunctionVOXml {

	public String BuildXMLDoc() throws IOException, JDOMException {

		// �������ڵ� list;
		Element root = new Element("list");

		// ���ڵ���ӵ��ĵ��У�
		Document Doc = new Document(root);

		// �˴� for ѭ�����滻�� ���� ���ݿ��Ľ��������;
		for (int i = 0; i < 5; i++) {

			// �����ڵ� user;
			Element elements = new Element("user");

			// �� user �ڵ�������� id;
			elements.setAttribute("id", "" + i);

			// �� user �ڵ�����ӽڵ㲢��ֵ��
			// new Element("name")�е� "name" �滻�ɱ�����Ӧ�ֶΣ�setText("xuehui")�� "xuehui
			// �滻�ɱ��м�¼ֵ��
			elements.addContent(new Element("name").setText("xuehui"));
			elements.addContent(new Element("age").setText("28"));
			elements.addContent(new Element("sex").setText("Male"));

			// �����ڵ�list���user�ӽڵ�;
			root.addContent(elements);
		}
		
		// ��� user.xml �ļ���
		XMLOutputter XMLOut = new XMLOutputter();
		XMLOut.output(Doc, new FileOutputStream("user.xml"));
		
		return Doc.toString();
	}

	public static void main(String[] args) {
		try {
			FunctionVOXml j2x = new FunctionVOXml();
			System.out.println("���� mxl �ļ�...");
			System.out.println(j2x.BuildXMLDoc());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
