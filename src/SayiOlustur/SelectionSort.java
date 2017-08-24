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
public class SelectionSort <T extends List<U>,U extends Comparable> implements Sorter<T, U>  {

    //algoritmik complexity bilgisi  = O(n2)
    
    @Override
    public void sort(T liste) {
    
        for (int i = 0; i < liste.size() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < liste.size(); j++)
                if (liste.get(j).compareTo(liste.get(index))<0) 
                    index = j;
           
            Collections.swap(liste, index, i);
            
        }
        
    }
    
    
    
}
