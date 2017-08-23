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
import java.util.Arrays;

/**
 *
 * @author ferhat
 */
public class XmlOkuYaz {
    
    public void xmlYaz()
    {
       
       RandomSayiOlusturClass randomSayi=new RandomSayiOlusturClass();
       
       int[]intSayiDizisi = randomSayi.sayiOlustur();
       
       Arrays.sort(intSayiDizisi);
       //sıralama ile ilgili method ekle. 3 tane
        
       //silinecek
        System.out.println("////////////////////");
        
        for (int i= 0; i < intSayiDizisi.length; i++) {
            System.out.println("Dizinin " + (i+1) + ". elemanı :" + intSayiDizisi[i] );
        }
        System.out.println("////////////////////");
       //silinecek
       
       
        
        
         try {
      
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("sayiList");
            doc.appendChild(rootElement);
       
      
            for (int i = 1; i <intSayiDizisi.length ; i++) {
            Element firstname = doc.createElement("sayi");
            firstname.setAttribute("index", ""+i);
            
                    
            firstname.appendChild(doc.createTextNode(""+intSayiDizisi[i]));
                    
           
            rootElement.appendChild(firstname);
             }
          
      /** İçeriğin bir XML dosyasına yazılması */
      TransformerFactory transformerFactory = TransformerFactory.newInstance();
      Transformer transformer = transformerFactory.newTransformer();
      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(new File("fileasd.xml"));
    
      transformer.transform(source, result);
    }catch (Exception e) {
      e.printStackTrace();
    }
        
    }
    
   
}