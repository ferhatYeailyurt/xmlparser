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
import SayiOlustur.Sayilar;
import SayiOlustur.SelectionSort;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
public class TaskProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        
       yazmaIslemi();
        
        
        
        
  }
    
    public static void yazmaIslemi()
    {
         List<Thread> threadler=new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            
            final int dosyaNumarasi =i+1;
            Thread t= new Thread(()->{
                
        
        Sayilar sayilar=new Sayilar(false);
        sayilar.sayilariAl(RandomSayiOlusturClass.sayiOlustur(100000,1,1000000));
                try {
                    XmlOkuYaz.xmlYaz(sayilar,"cikti"+dosyaNumarasi);
                } catch (TransformerException ex) {
                    Logger.getLogger(TaskProject.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(TaskProject.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
            t.start();
            threadler.add(t);
            
        } 
        threadler.forEach(t->{
            try {
                t.join();
            } catch (InterruptedException ex) {
                throw new RuntimeException("hata calisma 1");
            }
        });
       
       
    }
    
    public static void okumaIslemi()
    {
        
    }
}