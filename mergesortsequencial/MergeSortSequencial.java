package mergesortsequencial;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MergeSortSequencial {
    public static void main(String[] args) {
        // cria 10 novas instâncias de MergeSort
        MergeSort m1 = new MergeSort();
        Scanner s = new Scanner(System.in);
        Menu menu =  new Menu(); // cria uma nova instância de Menu
        long tinicial = 0, tfinal = 0; // Variáveis auxiliares para medir tempo de execução
        int opcao = 1; // registra opcao escolhida
        int i = 0; // contador
        menu.intro(); // chama introdução 
        s.nextLine(); // lê o proximo caracter
        do{
            do{
                try{
                    menu.menu();
                    opcao = s.nextInt();
                }catch(InputMismatchException e){ // trata entrada invalida
                    s.nextLine(); // limpar o buffer
                }
                if(opcao != 1 && opcao != 2){
                    System.out.println("Digite uma opção válida.");
                }
            }while(opcao != 1 && opcao != 2);
            if(opcao == 1){
                tinicial = System.currentTimeMillis(); // começa a medir o tempo 
                for(i = 0; i < 100; i++){
                    System.out.printf("\nIniciando Ordenação do vetor 1 - [ %d ]\n", i+1);
                    m1.geraVetor();  
                    m1.mergeSort(0, m1.getV().length-1, 1);
                    System.out.printf("\n\nVetor 1 - [ %d ] ordenado\n", i+1);
                    //m1.printVetor();
                }
                tfinal = System.currentTimeMillis() - tinicial; // terminar de medir o tempo
                System.out.println("\nTempo de execução: " + tfinal + " milissegundos.\n");
            }
        }while(opcao != 2); 
    }   
}
