package adapters;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import config.ConfigProvider;

public class XML2MapAdatper {
	Document xml;
	ConfigProvider configMap = new ConfigProvider();
	Map<String, String> mapnew = new HashMap<String, String>();

	public XML2MapAdatper() {
	}

	public XML2MapAdatper(Document xml) {
		setXMLdoc(xml);
	}

	public Document getXMLdoc() {
		return xml;
	}

	public void setXMLdoc(Document xml) {
		this.xml = xml;
	}
	public Map<String, String> toMap() {
		
		NodeList list = getXMLdoc().getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {

			Node u = list.item(i);
			if (u.getNodeType() == Node.ELEMENT_NODE) {
				Element appname = (Element) u;
					
				for (Entry<String, String> pairEntry : mapnew.entrySet()) {
					String key = appname.getTagName();
					String value = appname.getTextContent();
					
					pairEntry.setValue(configMap.get(key));
					configMap.set(key, value);
		
					mapnew.put(pairEntry.getKey(), pairEntry.getValue());
				}
			}
		}
		return mapnew;
//  ConfigProvider<---------------Adaptor<------------Loader
//		     
//privateMap(key, value)-----------key<---------appname.getTagName();
//                   ^------------value<------appname.getTextContent();
		
	}

}
