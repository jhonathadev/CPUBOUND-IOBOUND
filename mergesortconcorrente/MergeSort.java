package mergesortconcorrente;

class MergeSort extends Thread{
    private int v[] = new int[10000]; //vetor que sera ordenado
    private int aux[] = new int[10000]; //vetor auxiliar
    private int i = 0;//contador
    
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
    //metodo merge sort
    public void mergeSortThread(int ini, int fim){//recebe os indices do primeiro e do ultimo elemento
        if(ini < fim){
            int meio = ((ini + fim)/2);//variavel para armazenar o meio do vetor
            Thread t1 = new Thread(){//nova thread para ordenar a primeira metade do vetor
                public void run(){
                    mergeSortThread(ini, meio);
                }
            };
            Thread t2 = new Thread(){//nova thread para ordeanar a segunda metade do vetor
                @Override
                public void run(){
                    mergeSortThread(meio+1, fim);
                }
            };
            t1.start();//iniciar thread 1
            t2.start();//iniciar thread 2
            try{
                t1.join();//esperar thread 1 terminar
                //t2.join();//esperar thread 2 terminar
            }catch(InterruptedException e){
            }
            try{
                t2.join();//esperar thread 2 terminar
            }catch(InterruptedException e){
            }
            ordenarVetores(ini, meio, fim);//ordenar as duas metades dos vetores
        }
    }
    //outros metodos
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
        for(i = 0; i < v.length; i++){
            if(i%10 == 0){
                System.out.println(" ");
            } 
            System.out.print(v[i]+ " ");
        }
        System.out.println("");
    }
}

