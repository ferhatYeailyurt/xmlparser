/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SayiOlustur;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author ferhat
 */
public class Sayi implements Comparable<Sayi>{
    
    private int value;
    private int tekrarSayisi=1;
    private String xmlName;
    
    public Sayi(int value)
    {
        this.value=value;
        this.xmlName="sayi";
        
    }
    public Sayi(int value, String xmlName)
    {
        this.value=value;
        this.xmlName=xmlName;
        
    }
    
     public void writeDocument(Document d, Node n,int index,boolean tekrarla)
    {
      Element e=d.createElement(xmlName);
      e.setAttribute("index", ""+index);

        if (tekrarla) {
            e.setAttribute("tekrarAdet", ""+tekrarSayisi);
        }
        e.appendChild(d.createTextNode(""+value));
        n.appendChild(e);
        
        
    }

    @Override
    public int compareTo(Sayi o) {
        int tekrarSayisiFarki = o.tekrarSayisi - this.tekrarSayisi;
        if (tekrarSayisiFarki!=0) {
            return tekrarSayisiFarki;
        }
        return this.value - o.value;
        
    }

    public int compareValues(Sayi o){
        return this.value - o.value;
    }
    
    public String toString()
    {
        return  tekrarSayisi+ " - "+value;
    }
    
    public void tekrarSayisiArttir(Sayi sayi)
    {
        tekrarSayisi+=sayi.tekrarSayisi;
        
    }
    
    
    
    
    
}
