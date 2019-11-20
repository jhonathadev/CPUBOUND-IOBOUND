package mergesortsequencial;

import java.util.Random;

class MergeSort extends Thread{
    private int v[] = new int[10000000]; //vetor que sera ordenado
    private int aux[] = new int[10000000]; //vetor auxiliar
    private int i = 0; //contador
    Random r =  new Random(10); //para gerar numeros aleatorios
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
    //metodo para dividir o vetor
    public void mergeSort(int ini, int fim, int num){//recebe os indices do primeiro e do ultimo elemento
        if(ini < fim){
            int meio = ((ini + fim)/2);//variavel para armazenar o meio do vetor
            mergeSort(ini, meio, num);
            mergeSort(meio+1, fim, num);
            ordenarVetores(ini, meio, fim);//ordenar as duas metades dos vetores
        }
    }
    // Metodo para ordenar o vetor
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
    // Metodo para printar o vetor
    public void printVetor(){
        for(i = 0; i < v.length; i++){
            if(i % 20 == 0){
                System.out.println(" ");
            } 
            System.out.print(v[i]+ " ");
        }
        System.out.println("");
    }
    // Metodo para gerar os elementos do vetor
    public void geraVetor(){
        for(i = 0; i < this.getV().length; i++){
            this.setV(i, (r.nextInt(this.getV().length+1)));//atribui novos elementos ao vetor
        }
    }
}

