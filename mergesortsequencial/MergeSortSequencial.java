package mergesortsequencial;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MergeSortSequencial {
    public static void main(String[] args) {
        MergeSort m1 = new MergeSort();
        MergeSort m2 = new MergeSort();
        MergeSort m3 = new MergeSort();
        MergeSort m4 = new MergeSort();
        Scanner s = new Scanner(System.in);
        Menu menu =  new Menu(); // cria uma nova instância de Menu
        long tinicial = 0, tfinal = 0; // Variáveis auxiliares para medir tempo de execução
        int opcao = 1, i = 0; // registra opcao escolhida
        menu.intro(); // chama introdução 
        s.nextLine(); // lê o proximo caracter
        do{
            do{
                try{
                    menu.menu(); // chama o menu principal
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
                for(i = 0; i < 25; i++){
                    System.out.printf("\nIniciando Ordenação do vetor 1 - [ %d ]\n", i+1);
                    m1.geraVetor(); // gera um novo vetor "aleatorio"
                    m1.mergeSort(0, m1.getV().length-1, 1);
                    System.out.printf("\n\nVetor 1 - [ %d ] ordenado\n", i+1);
                }
                for(i = 0; i < 25; i++){
                    System.out.printf("\nIniciando Ordenação do vetor 2 - [ %d ]\n", i+1);
                    m2.geraVetor(); // gera um novo vetor "aleatorio"
                    m2.mergeSort(0, m2.getV().length-1, 1);
                    System.out.printf("\n\nVetor 2 - [ %d ] ordenado\n", i+1);
                }
                for(i = 0; i < 25; i++){
                    System.out.printf("\nIniciando Ordenação do vetor 3 - [ %d ]\n", i+1);
                    m3.geraVetor(); // gera um novo vetor "aleatorio"
                    m3.mergeSort(0, m3.getV().length-1, 1);
                    System.out.printf("\n\nVetor 3 - [ %d ] ordenado\n", i+1);
                }
                for(i = 0; i < 25; i++){
                    System.out.printf("\nIniciando Ordenação do vetor 4 - [ %d ]\n", i+1);
                    m4.geraVetor(); // gera um novo vetor "aleatorio"
                    m4.mergeSort(0, m4.getV().length-1, 1);
                    System.out.printf("\n\nVetor 4 - [ %d ] ordenado\n", i+1);
                }
                tfinal = System.currentTimeMillis() - tinicial; // terminar de medir o tempo
                System.out.println("\nTempo de execução: " + tfinal + " milissegundos.\n");
            }
        }while(opcao != 2); 
    }   
}
