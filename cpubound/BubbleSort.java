/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpubound;

/**
 *
 * @author john
 */
public class BubbleSort {
    private int n;
    
    
    int elementos[] = new int[10000];
    
    int i = 0 , j = 0, x = 0;

    public void insertionSort(){
        for(i = 0; i < n; i++){
            j = i-1;
            x = elementos[i];
            while(x < elementos[j] && j >= 0){
                elementos[j+1] = elementos [j];
                elementos[j] = x;
                j--;
            }
        }
    }
}