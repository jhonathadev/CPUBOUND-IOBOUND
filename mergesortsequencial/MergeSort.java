package mergesortsequencial;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSort {
    private int v[] = new int[500];//vetor que sera ordenado
    private int aux[] = new int[500];//vetor auxiliar
    private int i = 0;//contador
    Random r =  new Random(25); //para gerar numeros aleatorios
    //construtor
    public MergeSort(){
    }
    //metodos get e set
    public void setV(int j, int valor){
        this.v[j] = valor;
    }
    public int[] getV(){
        return this.v;
    }
    //outros metodos
    public void mergeSort(int ini, int fim, int num){//recebe os indices do primeiro e do ultimo elemento
        if(ini < fim){
            int meio = ((ini + fim)/2);//variavel para armazenar o meio do vetor
            System.out.printf("[Vetor %d] Sort Inicio - Meio [%d , %d]\n",num ,ini ,meio);
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(MergeSort.class.getName()).log(Level.SEVERE, null, ex);
            }
            mergeSort(ini, meio, num);//primeira metade do vetor
            System.out.printf("[Vetor %d] Sort Meio - Fim [%d , %d]\n",num, meio+1, fim);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(MergeSort.class.getName()).log(Level.SEVERE, null, ex);
            }
            mergeSort(meio+1, fim, num);//segunda metade do vetor
            ordenarVetores(ini, meio, fim);
        }
    }
    public void ordenarVetores(int ini, int meio, int fim){
        for(i = ini; i <= fim; i++){//copia o vetor para auxiliar
            aux[i]=v[i];
        }
        int n = ini;//recebecomeço do primeiro vetor
        int m = meio+1;//recebe começo do segundo vetor

        for(i = ini; i <= fim; i++){//verifica qual elemento entre os vetores e menor e copia para vetor principal
            if(n > meio){//primeiro vetor acabou
                v[i] = aux[m];
                m++;
            }else if(m > fim){//segundo vetor acabou
                v[i] = aux[n];
                n++;
            }else if(aux[n] < aux[m]){//elemento do primeiro vetor e maior que do segundo
                v[i] = aux[n];
                n++;
            }else{//elemento do segundo vetor e maior que do primeiro
                v[i] = aux[m];
                m++;
            }
        }
    }
    
    public void printVetor(){
        for(i = 0;i < v.length; i++){
            if(i%10 == 0){
                System.out.println(" ");
            } 
            System.out.printf("%d, ", v[i]);
        }
        System.out.println("");
    } 
    
    public void geraVetor(int n){
        for(i = 0; i < this.getV().length; i++){
            this.setV(i, (r.nextInt(10000)+n));//atribui novos elementos ao vetor
        }
    }
}
