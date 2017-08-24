/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlcontroller;

import java.io.File;
import java.util.Random;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import SayiOlustur.RandomSayiOlusturClass;
import SayiOlustur.Sayi;
import SayiOlustur.Sayilar;
import SayiOlustur.SelectionSort;
import java.io.IOException;
import java.util.Arrays;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author ferhat
 */
public class XmlOkuYaz {
    
    public static void xmlYaz(Sayilar sayilar, String dosyaAdi) throws TransformerException, ParserConfigurationException
    {
 
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            
            sayilar.writeDocument(doc, doc);
                
            /** İçeriğin bir XML dosyasına yazılması */
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(dosyaAdi+".xml"));
    
            transformer.transform(source, result);
          
        
    }
    
    public static Sayilar xmlOku(String dosyaAdi) throws ParserConfigurationException, SAXException, IOException
    {
        Sayilar sayilar=null;

        File fXmlFile = new File(dosyaAdi+".xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
        
        doc.getDocumentElement().normalize();
        
       
            Element sayilarElement=doc.getDocumentElement();
            
            if (sayilarElement.getNodeName()== "sayiList" ) {
                sayilar=new Sayilar(false);
            }
            else if((sayilarElement.getNodeName()== "sortedList" )){
                sayilar=new Sayilar(true);
            }
            else
                throw new IllegalArgumentException("Yanlış ifade");
        
     for (int temp = 0; temp < sayilarElement.getChildNodes().getLength(); temp++) {

		Node nNode = sayilarElement.getChildNodes().item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
                       Node node= nNode.getFirstChild();
                       
                        if (node.getNodeType()==Node.TEXT_NODE) {
                            String str=node.getNodeValue();
                            int sayi=Integer.parseInt(str);
                            sayilar.yeniSayiEkle(new Sayi(sayi,nNode.getNodeName()));      
                    }
                       
		}
                
	}
     return sayilar;  
  }
}

   
