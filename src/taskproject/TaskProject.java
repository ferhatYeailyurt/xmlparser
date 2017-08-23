/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskproject;

/**
 *
 * @author ferhat
 */

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import static javax.management.Query.attr;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import xmlcontroller.XmlOkuYaz;
import SayiOlustur.RandomSayiOlusturClass;
public class TaskProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TransformerConfigurationException, TransformerException {
            
        XmlOkuYaz goster=new XmlOkuYaz();
        goster.xmlYaz();
   
         
  }
}