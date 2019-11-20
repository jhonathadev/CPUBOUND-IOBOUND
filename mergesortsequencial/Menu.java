package mergesortsequencial;

public class Menu {
    
    MergeSort m1 = new MergeSort();
    
     public void menu(){
        System.out.println("            .: CPU-BOUND SEQUENCIAL :.");
        System.out.printf("\n");
        System.out.println("1 - Iniciar execução.");
        System.out.println("2 - Sair.");
        System.out.printf("Digite a opcão desejada: ");
    }
    public void intro(){
        System.out.println("            .: CPU-BOUND SEQUENCIAL :.");            
        System.out.printf("                 .: Observações :.\n\n");
         System.out.printf("=> A cada execução do programa, 100 vetores de %d números 'aleatórios' são gerados;\n", m1.getV().length);
        System.out.printf("=> Os numeros são gerados pelo método random, com semente 10 e variam entre 0 e %d;\n", m1.getV().length);
        System.out.println("=> Os vetores serão ordenados sequencialmente pelo algoritmo MergeSort;");
        System.out.println("=> Ao final também será mostrado o tempo final de execução do algoritmo.");
        System.out.println("\nPressione qualquer tecla para continuar...");
    }
}