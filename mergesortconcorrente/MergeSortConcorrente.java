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
        Scanner s = new Scanner(System.in);
        Menu menu =  new Menu(); // cria uma nova instância de Menu
        long tinicial, tfinal; // Variáveis auxiliares para medir tempo de execução
        int opcao = 1; //registra opcao escolhida
        menu.intro(); // chama menu de introdução do programa
        s.nextLine();//limpar o buffer
        do{
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
                int th1 = 0;
                @Override
                    public void run(){
                        for(th1 = 0; th1 < 25; th1++){
                            System.out.printf("\nIniciando Ordenação do vetor 1 - [ %d ]\n",th1+1);
                            m1.geraVetor(); 
                            m1.mergeSortThread(0, m1.getV().length-1, 1);
                            System.out.printf("\n\nVetor 1 - [ %d ] ordenado\n", th1+1);
                        }
                        
                    }
                };
                Thread t2 = new Thread(){
                int th2 = 0;
                @Override
                    public void run(){
                        for(th2 = 0; th2 < 25; th2++){
                            System.out.printf("\nIniciando Ordenação do vetor 2 - [ %d ]\n",th2+1);
                            m2.geraVetor();  
                            m2.mergeSortThread(0, m2.getV().length-1, 2);
                            System.out.printf("\n\nVetor 2 - [ %d ] ordenado\n", th2+1);
                        }
                        
                    }
                };
                Thread t3 = new Thread(){
                int th3 = 0;
                @Override
                    public void run(){
                        for(th3 = 0; th3 < 25; th3++){
                            System.out.printf("\nIniciando Ordenação do vetor 3 - [ %d ]\n", th3+1);
                            m3.geraVetor(); 
                            m3.mergeSortThread(0, m3.getV().length-1, 3);
                            System.out.printf("\n\nVetor 3 - [ %d ] ordenado\n", th3+1);
                        }
                        
                    }
                };
                Thread t4 = new Thread(){
                int th4 = 0;
                @Override
                    public void run(){
                        for(th4 = 0; th4 < 25; th4++){
                            System.out.printf("\nIniciando Ordenação do vetor 4 - [ %d ]\n", th4+1);
                            m4.geraVetor(); 
                            m4.mergeSortThread(0, m4.getV().length-1, 4);
                            System.out.printf("\n\nVetor 4 - [ %d ] ordenado\n", th4+1);
                        }
                        
                    }
                };
                
                t1.start(); //iniciar thread 1
                t2.start(); //iniciar thread 2
                t3.start(); //iniciar thread 3
                t4.start(); //iniciar thread 4
              
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
                
                tfinal = System.currentTimeMillis() - tinicial; // terminar de medir o tempo 
             
                System.out.println("\nTempo de execução: " + tfinal + " milissegundos.\n");
            }
        }while(opcao != 2);   
    }
}
    

