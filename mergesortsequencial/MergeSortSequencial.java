package mergesortsequencial;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MergeSortSequencial {
    public static void main(String[] args) {
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
        int opcao = 1; // registra opcao escolhida
        int i = 0; // contador
        menu.intro(); // chama introdução 
        s.nextLine(); // lê o proximo caracter
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
                }catch(InputMismatchException e){ // trata entrada invalida
                    s.nextLine(); // limpar o buffer
                }
                if(opcao != 1 && opcao != 2){
                    System.out.println("Digite uma opção válida.");
                }
            }while(opcao != 1 && opcao != 2);
            if(opcao == 1){
                tinicial = System.currentTimeMillis(); // começa a medir o tempo 
                System.out.println("Iniciando Ordenação do vetor 1");
                m1.mergeSort(0, m1.getV().length-1, 1);
                System.out.println("\nVetor 1 ordenado");
                System.out.println("Iniciando Ordenação do vetor 2");
                m2.mergeSort(0, m2.getV().length-1, 2);
                System.out.println("\nVetor 2 ordenado");
                System.out.println("Iniciando Ordenação do vetor 3");
                m3.mergeSort(0, m3.getV().length-1, 3);
                System.out.println("\nVetor 3 ordenado");
                System.out.println("Iniciando Ordenação do vetor 4");
                m4.mergeSort(0, m4.getV().length-1, 4);
                System.out.println("\nVetor 4 ordenado");
                System.out.println("Iniciando Ordenação do vetor 5");
                m5.mergeSort(0, m5.getV().length-1, 5);
                System.out.println("\nVetor 5 ordenado");
                System.out.println("Iniciando Ordenação do vetor 6");
                m6.mergeSort(0, m6.getV().length-1, 6);
                System.out.println("\nVetor 6 ordenado");
                System.out.println("Iniciando Ordenação do vetor 7");
                m7.mergeSort(0, m7.getV().length-1, 7);
                System.out.println("\nVetor 7 ordenado");
                System.out.println("Iniciando Ordenação do vetor 8");
                m8.mergeSort(0, m8.getV().length-1, 8);
                System.out.println("\nVetor 8 ordenado");
                System.out.println("Iniciando Ordenação do vetor 9");
                m9.mergeSort(0, m9.getV().length-1, 9);
                System.out.println("\nVetor 9 ordenado");
                System.out.println("Iniciando Ordenação do vetor 10");
                m10.mergeSort(0, m10.getV().length-1, 10);
                System.out.println("\nVetor 10 ordenado");
                tfinal = System.currentTimeMillis() - tinicial; // terminar de medir o tempo 
                System.out.println("\nVetor => 1");
                m1.printVetor();
                System.out.println("\nVetor => 2");
                m2.printVetor();
                System.out.println("\nVetor => 3");
                m3.printVetor();
                System.out.println("\nVetor => 4");
                m4.printVetor();
                System.out.println("\nVetor => 5");
                m5.printVetor();
                System.out.println("\nVetor => 6");
                m6.printVetor();
                System.out.println("\nVetor => 7");
                m7.printVetor();
                System.out.println("\nVetor => 8");
                m8.printVetor();
                System.out.println("\nVetor => 9");
                m9.printVetor();
                System.out.println("\nVetor => 10");
                m10.printVetor();
                System.out.println("\nTempo de execução: " + tfinal + " milissegundos.\n");
            }
        }while(opcao != 2); 
    }   
}
