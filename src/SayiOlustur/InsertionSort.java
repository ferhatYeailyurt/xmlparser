/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SayiOlustur;

import java.util.List;

/**
 *
 * @author ferhat
 */
public class InsertionSort <T extends List<U>,U extends Comparable> implements Sorter<T, U>  {
    
    //algoritmik complexity bilgisi  = O(n2)
    
    
    @Override
    public void sort(T liste) {
        for (int i = 0; i < liste.size(); i++) {
            
            U index=liste.get(i);
            
            int j=i;
            while(j>0 && liste.get(j-1).compareTo(j-1)>0)
            {
                liste.set(j,liste.get(j-1));
                j--;
            }
            
            liste.set(j, index); 
            
            
            
        }
        
} 
        
        
    }
    

