package mergesortsequencial;

public class Menu {
    
    public Menu(){}
    
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
        System.out.println("=> A cada execução, um novo vetor de 1000 números aleatórios é gerado, automaticamente;");
        System.out.println("=> Os numeros são gerados pelo método random, com semente 25 e variam entre 0 e 10.000;");
        System.out.println("=> O vetor será ordenado de forma sequencial pelo algoritmo MergeSort;");
        System.out.println("=> A cada execução desse algoritmo, o vetor será exibido;");
        System.out.println("=> E também será mostrado o tempo de execução do algoritmo.");
        System.out.println("\nPressione qualquer tecla para continuar...");
    }
}