/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SayiOlustur;

import java.util.Random;

/**
 *
 * @author ferhat
 */
public class RandomSayiOlusturClass {
    
    
     public static int[] sayiOlustur(int sayiAdeti, int mindeger , int maxdeger)
    {
     
        Random rnd = new Random();
        
        int[] intSayiDizisi = new int[sayiAdeti];
        
        for (int i= 0; i < intSayiDizisi.length; i++) {
            intSayiDizisi[i] = rnd.nextInt(mindeger+maxdeger+1)+mindeger;
        }
        
        return intSayiDizisi;
    }
    
}
