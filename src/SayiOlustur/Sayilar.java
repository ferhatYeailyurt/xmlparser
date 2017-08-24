/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SayiOlustur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author ferhat
 */
public class Sayilar {

    private List<Sayi> sayilarList = new ArrayList<Sayi>();
   
    private String xmlName;
    
    private boolean tekrarli=false;
    
    public Sayilar(boolean sorted)
    {
        if (sorted) {
            this.xmlName="sortedList";
        }
        else
            this.xmlName="sayiList";
   
    }
    
    public String toString()
    {
        return sayilarList.toString();
    }
    public void writeDocument(Document d, Node n)
    {
        
        Element e=  d.createElement(xmlName);
        n.appendChild(e);
        int index=1;
        for (Sayi s:sayilarList) {
            s.writeDocument(d, e,index++,tekrarli);
        }
        
    }
          
    
    public  void yeniSayiEkle(Sayi s)
    {
        sayilarList.add(s);
        
        
    }
    
    public  void sayilariSirala(Sorter sorter)
    {
     sorter.sort(this.sayilarList); 
    }
    
    public static Sayilar sayilariBirlestir(Sayilar... s)
    {
        Sayilar sayilar=new Sayilar(false);
        for (Sayilar birlesecekSayilar : s) {
            sayilar.sayilarList.addAll(birlesecekSayilar.sayilarList);
            }
     return sayilar;
    }
    
    
    public  void tekrarSayisiHesapla()
    {
        //sayıların sıralı olarak buraya gelmesi lazım
        
        Iterator<Sayi> i=sayilarList.iterator();
        Sayi simdikiDeger=null,sonrakiDeger;
        while(i.hasNext())
        {
            sonrakiDeger= i.next();
            if (simdikiDeger==null || simdikiDeger.compareValues(sonrakiDeger) != 0 ) {
                simdikiDeger=sonrakiDeger;
                continue;
            }
            
            simdikiDeger.tekrarSayisiArttir(sonrakiDeger);
            i.remove();
                        
        }
        
        tekrarli=true;
        
    }
    
    public void sayilariAl(int [] sayiDizisi)
    {
        for (int i : sayiDizisi) {
            sayilarList.add(new Sayi(i));
        }
    
        
    }
    
    
   
    
    
    
}
