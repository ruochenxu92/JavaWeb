package us.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlWriter {
	private static String filepath;
	static{  //get filename
		filepath = XmlWriter.class.getClassLoader().getResource("users.xml").getPath();
	}
	public static Document getDocument() throws DocumentException{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(filepath));//read xml document, and put it on document
		return document;//return document
	}
	
	public static void write2Xml(Document document) throws IOException{
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");

		XMLWriter writer = new XMLWriter(new FileOutputStream(filepath));
		writer.write(document);
		writer.close();//we need to writer.close() to flush the data to file

	}
	
}
