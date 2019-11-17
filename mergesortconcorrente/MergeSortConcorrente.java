package mergesortconcorrente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MergeSortConcorrente extends Thread {
    public static void main(String[] args){
        // cria 10 novas instâncias de MergeSort
        MergeSort m1 = new MergeSort();
        MergeSort m2 = new MergeSort();
        MergeSort m3 = new MergeSort();
        MergeSort m4 = new MergeSort();
        MergeSort m5 = new MergeSort();
        MergeSort m6 = new MergeSort();
        MergeSort m7 = new MergeSort();
        MergeSort m8 = new MergeSort();
        MergeSort m9 = new MergeSort();
        MergeSort m10 = new MergeSort();
        Scanner s = new Scanner(System.in);
        Menu menu =  new Menu(); // cria uma nova instância de Menu
        long tinicial, tfinal; // Variáveis auxiliares para medir tempo de execução
        int opcao = 1; //registra opcao escolhida
        int i = 0; //contador
        menu.intro(); 
        s.nextLine();//limpar o buffer
        do{
            // gera 10 novos vetores "aleatórios"
            m1.geraVetor(25); 
            m2.geraVetor(10);  
            m3.geraVetor(30); 
            m4.geraVetor(40);
            m5.geraVetor(35); 
            m6.geraVetor(15); 
            m7.geraVetor(45); 
            m8.geraVetor(5); 
            m9.geraVetor(20);
            m10.geraVetor(50);
            do{
                try{
                    menu.menu();
                    opcao = s.nextInt();
                }catch(InputMismatchException e){//digitar char no lugar de int
                    s.nextLine();//limpar o buffer
                }if(opcao != 1 && opcao != 2){
                    opcao = 0;
                    System.out.println("Digite uma opção válida.");
                }
            }while(opcao != 1 && opcao != 2); // valida a entrada do usuario
            if(opcao == 1){
                tinicial = System.currentTimeMillis(); // começa a medir o tempo 
                Thread t1 = new Thread(){
                @Override
                    public void run(){
                       System.out.println("Iniciando Ordenação do vetor 1");
                       m1.mergeSortThread(0, m1.getV().length-1, 1);
                       System.out.println("\nVetor 1 ordenado");
                    }
                };
                Thread t2 = new Thread(){
                @Override
                    public void run(){
                        System.out.println("Iniciando Ordenação do vetor 2");
                        m2.mergeSortThread(0, m2.getV().length-1, 2);
                        System.out.println("\nVetor 2 ordenado");
                    }
                };
                Thread t3 = new Thread(){
                @Override
                    public void run(){
                        System.out.println("Iniciando Ordenação do vetor 3");
                        m3.mergeSortThread(0, m3.getV().length-1, 3);
                        System.out.println("\nVetor 3 ordenado");
                    }
                };
                Thread t4 = new Thread(){
                @Override
                    public void run(){
                        System.out.println("Iniciando Ordenação do vetor 4");
                        m4.mergeSortThread(0, m4.getV().length-1, 4);
                        System.out.println("\nVetor 4 ordenado");
                    }
                };
                Thread t5 = new Thread(){
                @Override
                    public void run(){
                        System.out.println("Iniciando Ordenação do vetor 5");
                        m5.mergeSortThread(0, m5.getV().length-1, 5);
                        System.out.println("\nVetor 5 ordenado");
                    }
                };
                Thread t6 = new Thread(){ 
                @Override
                    public void run(){
                        System.out.println("Iniciando Ordenação do vetor 6");
                        m6.mergeSortThread(0, m6.getV().length-1, 6);
                        System.out.println("\nVetor 6 ordenado");
                    }
                };
                Thread t7 = new Thread(){
                @Override
                    public void run(){
                        System.out.println("Iniciando Ordenação do vetor 7");
                        m7.mergeSortThread(0, m7.getV().length-1, 7);
                        System.out.println("\nVetor 7 ordenado");
                    }
                };
                Thread t8 = new Thread(){ 
                @Override
                    public void run(){
                        System.out.println("Iniciando Ordenação do vetor 8");
                        m8.mergeSortThread(0, m8.getV().length-1, 8);
                        System.out.println("\nVetor 8 ordenado");
                    }
                };
                Thread t9 = new Thread(){ 
                @Override
                    public void run(){
                        System.out.println("Iniciando Ordenação do vetor 9");
                        m9.mergeSortThread(0, m9.getV().length-1, 9);
                        System.out.println("\nVetor 9 ordenado");
                    }
                };
                Thread t10 = new Thread(){
                @Override
                    public void run(){
                        System.out.println("Iniciando Ordenação do vetor 10");
                        m10.mergeSortThread(0, m10.getV().length-1, 10);
                        System.out.println("\nVetor 10 ordenado");
                    }
                };
                t1.start(); //iniciar thread 1
                t2.start(); //iniciar thread 2
                t3.start(); //iniciar thread 3
                t4.start(); //iniciar thread 4
                t5.start(); //iniciar thread 5
                t6.start(); //iniciar thread 6
                t7.start(); //iniciar thread 7
                t8.start(); //iniciar thread 8
                t9.start(); //iniciar thread 9
                t10.start(); //iniciar thread 10
                try{
                    t1.join(); //espera thread 1 terminar
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                try{
                    t2.join();//espera thread 2 terminar
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                try{
                    t3.join(); //espera thread 3 terminar
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                try{
                    t4.join(); //espera thread 4 terminar
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                try{
                    t5.join(); //espera thread 5 terminar
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                try{
                    t6.join(); //espera thread 6 terminar
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                try{
                    t7.join(); //espera thread 7 terminar
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                try{
                    t8.join(); //espera thread 8 terminar
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                try{
                    t9.join(); //espera thread 9 terminar
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                try{
                    t10.join(); //espera thread 10 terminar
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                tfinal = System.currentTimeMillis() - tinicial; // terminar de medir o tempo 
                System.out.println("\nVetor => 1");
                m1.printVetor(); // chama a funçao print para mostrar o vetor
                System.out.println("\nVetor => 2");
                m2.printVetor(); // chama a funçao print para mostrar o vetor
                System.out.println("\nVetor => 3");
                m3.printVetor(); // chama a funçao print para mostrar o vetor 
                System.out.println("\nVetor => 4");
                m4.printVetor(); // chama a funçao print para mostrar o vetor
                System.out.println("\nVetor => 5");
                m5.printVetor(); // chama a funçao print para mostrar o vetor
                System.out.println("\nVetor => 6");
                m6.printVetor(); // chama a funçao print para mostrar o vetor
                System.out.println("\nVetor => 7");
                m7.printVetor(); // chama a funçao print para mostrar o vetor
                System.out.println("\nVetor => 8");
                m8.printVetor(); // chama a funçao print para mostrar o vetor
                System.out.println("\nVetor => 9");
                m9.printVetor(); // chama a funçao print para mostrar o vetor
                System.out.println("\nVetor => 10");
                m10.printVetor(); // chama a funçao print para mostrar o vetor
                System.out.println("\nTempo de execução: " + tfinal + " milissegundos.\n");
            }
        }while(opcao != 2);   
    }
}
    

