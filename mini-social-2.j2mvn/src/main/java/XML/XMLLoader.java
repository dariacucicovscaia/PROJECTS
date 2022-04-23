package XML;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLLoader {

	private Document xml;
	private long lastFileModif;

	public Document load(String fileName) throws ParserConfigurationException, SAXException, IOException {

		File file = new File(fileName);
		lastFileModif = file.lastModified();

		if (xml == null || lastFileModif == file.lastModified()) {

			InputStream classLoader = XMLLoader.class.getClassLoader().getResourceAsStream(fileName);
			DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			xml = docBuilder.parse(classLoader);
		}
		return xml;

	}
}
