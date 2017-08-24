package taskproject;

/**
 *
 * @author ferhat
 */

import java.io.File;
import java.io.IOException;
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

import SayiOlustur.Sayi;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.xml.sax.SAXException;
import xmlcontroller.XmlOkuYaz;
import SayiOlustur.RandomSayiOlusturClass;
import SayiOlustur.Sayilar;
import SayiOlustur.SelectionSort;
import SayiOlustur.SortSecici;
import SayiOlustur.Sorter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.xml.parsers.ParserConfigurationException;
public class TaskProject {

    public static Sorter sorter=null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TransformerException, ParserConfigurationException  {
        System.out.println("Sıralama işleminde kullanılacak algoritmalardan: Insertion Sort için 1 , Bubble Sort için 2 , Selection Short için 3 yazıp  enter'a  basınız:");

        Scanner sc=new Scanner(System.in);
        String ifade=sc.nextLine();
        

       final SortSecici sortSecici= new SortSecici();

       sorter=sortSecici.formatAl(ifade);
       List<Sayilar> sayilarListesi = rastgeleSayilarOlustur(10, 1, 10, 100);
        
        SayilariYaz(sayilarListesi, "cikti", false);
        System.out.println("cikti 1 yapıldı.");
        
        List<Sayilar> okuSayilar =sayilariOku("cikti", 10);
        System.out.println("sayilar okundu");
        
        SayilariYaz(okuSayilar, "orderedcikti", true);
        System.out.println("Sayilar yazildi");
        
        List<Sayilar> siraliSayilar =sayilariOku("orderedcikti", 10);
       Sayilar birlestirilmisSayilar =  Sayilar.sayilariBirlestir(siraliSayilar.toArray(new Sayilar[10] ));
       
       birlestirilmisSayilar.sayilariSirala(sorter);
        System.out.println(birlestirilmisSayilar);
       
       birlestirilmisSayilar.tekrarSayisiHesapla();
        System.out.println(birlestirilmisSayilar);
       birlestirilmisSayilar.sayilariSirala(sorter);
       
       XmlOkuYaz.xmlYaz(birlestirilmisSayilar, "birleşik");
       
       
      // yazmaIslemi();

  }
    public static List<Sayilar> rastgeleSayilarOlustur(int sayilarAdeti, int minDeger, int maxDeger, int sayiAdeti)
    {
        List<Sayilar> sayilarListesi=new ArrayList<>();
        for (int i = 0; i < sayilarAdeti; i++) {
           int [] sayilarDizisi = RandomSayiOlusturClass.Nesne().sayiOlustur(sayiAdeti, minDeger, maxDeger);
           Sayilar sayilar=new Sayilar(false);
           sayilar.sayilariAl(sayilarDizisi);
           sayilarListesi.add(sayilar);
           
        }
        return sayilarListesi;
        
    }

    public static void SayilariYaz(List<Sayilar> sayilarListesi,String prefix, boolean sirala)
    {
         List<Thread> threadler=new ArrayList<>();
         
        for (int i = 0; i < sayilarListesi.size(); i++) {
             final int dosyaNumarasi =i+1;
            Sayilar sayilar=sayilarListesi.get(i);
                Thread t= new Thread(()->{
              try {
                  if (sirala) {
                      sayilar.sayilariSirala(sorter);
                  }
                    XmlOkuYaz.xmlYaz(sayilar,prefix+dosyaNumarasi);
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
                 Logger.getLogger(TaskProject.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
    }
    
    
   
    public static List<Sayilar> sayilariOku(String prefix,int dosyaAdedi)
    {
        

        List<CompletableFuture<Sayilar>> cfs=new ArrayList<>();
        for(int i=0; i<dosyaAdedi; i++){
            final int dosyaNumarasi = i+1;
            cfs.add(CompletableFuture.supplyAsync(() -> {
                try {
                    return XmlOkuYaz.xmlOku((prefix + (dosyaNumarasi)));
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }));
        }

        CompletableFuture.allOf(cfs.toArray(new CompletableFuture[cfs.size()])).join();
        List<Sayilar> sayilar = cfs.stream().map(f -> {
            try {
                return f.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());


        return sayilar;
    }
}