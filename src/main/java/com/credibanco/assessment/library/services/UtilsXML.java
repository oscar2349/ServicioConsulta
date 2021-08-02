package com.credibanco.assessment.library.services;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.InputSource;
import com.credibanco.assessment.library.model.Proveedores;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Component
public class UtilsXML {

	public List<Proveedores> StringToXml(Object object) {
		List<Proveedores> datos = new ArrayList<>();
		Proveedores proveedores = new Proveedores();

		try {
			System.out.println("  ++++   "  +  object) ;
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new InputSource(new StringReader((String) object)));
			Element formato = document.getDocumentElement();
			proveedores = retornaRespose(formato);
			datos.add(proveedores);
			return datos;
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return datos;

	}

	private String getValueTag(String tagName, Element element) {
		String res = "";
		NodeList list = element.getElementsByTagName(tagName);
		if (list != null && list.getLength() > 0) {
			NodeList subList = list.item(0).getChildNodes();
			if (subList != null && subList.getLength() > 0) {
				res = subList.item(0).getNodeValue();
			}
		}
		return res;
	}
	
	public Proveedores retornaRespose(Element element) {
		
		Proveedores proveedores = new Proveedores();

		proveedores.setNombre(getValueTag("nombre", element));
		proveedores.setApellido(getValueTag("apellido", element));


		return proveedores;
	
	}
	

}
