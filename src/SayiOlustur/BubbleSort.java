/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SayiOlustur;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author ferhat
 */
public class BubbleSort <T extends List<U>,U extends Comparable> implements Sorter<T, U>  {

    //algoritmik complexity bilgisi  = O(n2)
    
    
    @Override
    public void sort(T liste) {
        
         for (int i = (liste.size()-1); i >=0; i++)
        {
            
            for (int j =  1; j < i; j++){
                
                if(liste.get(j-1).compareTo(liste.get(i))>0)
                {
                     Collections.swap(liste, j-1, j);
                   
                }
            }
                
              
            
        }
        
        
        
        
    }
    
}
