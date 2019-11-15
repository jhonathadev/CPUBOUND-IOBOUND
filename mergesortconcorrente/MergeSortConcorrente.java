package mergesortconcorrente;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MergeSortConcorrente {
    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        Random r =  new Random(25);//para gerar numeros aleatorios
        Scanner s = new Scanner(System.in);
        Menu menu =  new Menu();
        long tinicial, tfinal;//medir o tempo de execução
        int opcao = 1;//registrar opcao escolhida
        int i = 0;//contador
        menu.intro(); 
        s.nextLine();//limpar o buffer
       
        do{
            for(i = 0; i < m.getV().length; i++){
                m.setV(i, (r.nextInt(10000)+1));//atribui novos elementos ao vetor
            }
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
            }while(opcao != 1 && opcao != 2);//valida a entrada do usuario
            
            if(opcao == 1){
                tinicial = System.currentTimeMillis();//tempo inicial
                System.out.println("\nVetor desordenado:");
                m.printVetor();
                m.mergeSortThread(0, m.getV().length-1);//chama o metodo passando os indices do primeiro e ultimo elemento
                System.out.println("\nVetor ordenado:");
                m.printVetor();
                tfinal = System.currentTimeMillis() - tinicial;//tempo final
                System.out.println("\nTempo de execução: " + tfinal + " milissegundos.\n");
            }
        }while(opcao != 2);   
    }
}
    

