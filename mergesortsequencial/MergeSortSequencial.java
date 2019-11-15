package mergesortsequencial;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MergeSortSequencial {
    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        Random r =  new Random(25); //para gerar numeros aleatorios
        Scanner s = new Scanner(System.in);
        Menu menu =  new Menu();
        long tinicial, tfinal; //medir o tempo de execução
        int opcao = 1; //registrar opcao escolhida
        int i = 0; //contador
        
        menu.intro();
        s.nextLine();
        do{
            for(i = 0; i < m.getV().length; i++){
                m.setV(i, r.nextInt(10000)+1);//atribui novos elementos ao vetor
            }
            do{
                try{
                    menu.menu();
                    opcao = s.nextInt();
                }catch(InputMismatchException e){//digitar char no lugar de int
                    s.nextLine();//limpar o buffer
                }
                if(opcao != 1 && opcao != 2){
                    System.out.println("Digite uma opção válida.");
                }
            }while(opcao != 1 && opcao != 2);
            
            if(opcao == 1){
                tinicial = System.currentTimeMillis();//tempo inicial
                System.out.println("\nVetor desordenado:");
                m.printVetor();
                m.mergeSort(0, m.getV().length-1);
                System.out.printf("\n\n");
                System.out.println("Vetor ordenado:");
                m.printVetor();
                tfinal = System.currentTimeMillis() - tinicial;//tempo final
                System.out.println("Tempo de execução: " + tfinal + " milissegundos.\n");
            }
        }while(opcao != 2); 
    }   
}
