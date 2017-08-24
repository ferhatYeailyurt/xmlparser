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
public interface Sorter <T extends List<U>,U extends Comparable> {
    
    public  void sort(T te);
    
    
}
