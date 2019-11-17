
package mergesortconcorrente;

public class Menu {
    
    public Menu(){}
    
    public void menu(){
        System.out.println("            .: CPU-BOUND CONCORRENTE :.");
        System.out.printf("\n");
        System.out.println("1 - Iniciar execução.");
        System.out.println("2 - Sair.");
        
        System.out.printf("Digite a opção desejada: ");
    }
    public void intro(){
        System.out.println("            .: CPU-BOUND CONCORRENTE :.");            
        System.out.printf("                 .: Observações :.\n\n");
        System.out.println("=> A cada execução, 10 novos vetores de 500 números 'aleatórios' são gerados automaticamente;");
        System.out.println("=> Os numeros são gerados pelo método random, com semente 25 e variam entre 0 e 10.500;");
        System.out.println("=> O vetor será ordenado de forma concorrente pelo algoritmo MergeSort;");
        System.out.println("=> A cada execução do algoritmo, o vetor será exibido;");
        System.out.println("=> Ao final também será mostrado o tempo final de execução do algoritmo.");
        System.out.println("\nPressione qualquer tecla para continuar...");
    }
}
