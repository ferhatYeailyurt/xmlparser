/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SayiOlustur;

/**
 *
 * @author ferhat
 */
public class SortSecici {
    
    //fabrika tasarım deseni
    
    public Sorter formatAl(String ifade)
    {
        if(ifade.equals("1"))
        {
          return new InsertionSort();
        }
        else if(ifade.equals("2"))
        {
         return new BubbleSort();
        }
        else if(ifade.equals("3"))
        {
         return new SelectionSort();
        }
        throw new IllegalArgumentException("yanlış ifade girildi");
        
    }
    
}
