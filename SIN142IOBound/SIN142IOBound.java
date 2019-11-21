/**
 * Main
 */
//PS: Clonar diretório e fazer commit apenas da pasta /src.
//Crie um projeto SIN-142-Projeto-Avaliativo e um package chamado SIN142IOBound para rodar o código abaixo.
package SIN142IOBound;

/**
 * @author victor
 *
 */
import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class SIN142IOBound {

    //Método para impressão de ArrayList.
    //Método para impressão de ArrayList.
    public static void printArray(ArrayList<Integer> lista) {
        int n;
        n = lista.size();
        int i;
        int j = 0;
        for (i = 0; i < n; i++) {
            System.out.printf("%d ", lista.get(i));
            j++;
            if (j == 10) {
                j = 0;
                System.out.println();
            }
        }
        return;
    }

    /*
	 * Método para criar diretório /arquivos/ na pasta do programa.
	 * Retorno: string com o caminho da pasta.
     */
    public static String criarDiretorio() throws IOException {
        // Pega endereço do aplicativo.
        String path = System.getProperty("user.dir");
        // Cria diretório em path + /arquivos/. Path = pasta do projeto.
        File dir = new File(path + "/arquivos/");
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("Diretório /arquivos/ criado.");
                return path + "/arquivos/";
            } else {
                throw new IOException("\nDiretório não foi criado corretamente.");
            }
        } else {
            System.out.println("Diretório já existe!");
            return path + "/arquivos/";
        }
    }//Fim criarDiretorio	

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //Variáveis
        ArrayList<Integer> lista = new ArrayList<Integer>();
        ArrayList<File> lista_files = new ArrayList<File>();
        long startTime = System.currentTimeMillis();
        File file;
        boolean checagem = true;
        int i, tam = 30000;
        try {
            String path = criarDiretorio();
            for (i = 5; i >= 0; i--) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.printf("\n%d segundo(s) para continuar para criação e escrita...", i);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
            /*
			 * Testando classes novas.
			 * 1 - Cria arquivos.
			 * 2 - Lê arquivos.
			 * 3 - Deleta arquivos.
             */

            //0 - Criando uma lista com arquivos.
            for (i = 0; i < tam; i++) {
                file = new File(path + Integer.toString(i) + ".txt");
                lista_files.add(file);
            }

            // 1 - Criando vários arquivos: retorno void.
            while (checagem) {
                checagem = false;
                CriadorArquivos criador = new CriadorArquivos();
                criador.criarVariosArquivos(path);
                for (i = 5; i >= 0; i--) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        System.out.printf("\n%d segundo(s) para continuar para verificação...", i);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
                System.out.println("Iniciando verificação do conteúdo dos arquivos, aguarde...");
                for (i = 0; i < tam; i++) {
                    BufferedReader br = new BufferedReader(new FileReader(lista_files.get(i)));
                    if (br.readLine() == null) {
                        System.out.printf("\nArquivo %d existe, mas sem conteúdo. Processo de escrita será reiniciado...", i);
                        checagem = true;
                        for (i = 5; i >= 0; i--) {
                            try {
                                TimeUnit.SECONDS.sleep(1);
                                System.out.printf("\n%d segundo(s) para reiniciar escrita...", i);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                Thread.currentThread().interrupt();
                                e.printStackTrace();
                            }
                        }//Tempo
                    }//if do leitor
                    br.close();
                }//for checagem.
                if (!checagem) {
                    System.out.println("A escrita dos arquivos foi um sucesso!");
                    for (i = 3; i >= 0; i--) {
                        try {
                            TimeUnit.SECONDS.sleep(1);
                            System.out.printf("\n%d segundo(s) para leitura e deleção dos arquivos...", i);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            Thread.currentThread().interrupt();
                            e.printStackTrace();
                        }
                    }
                }//if checagem.
            }//while checagem
            checagem = true;

            // 2 - Lendo arquivos: retorno ArrayList.
            LeitorArquivos leitor = new LeitorArquivos();
            lista = leitor.lerVariosArquivos(path);

            for (i = 5; i >= 0; i--) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.printf("\n%d segundo(s) para imprimir dados lidos...", i);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }

            //Execução finalizada.
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;

            // Verificando resultado //
            printArray(lista);
            System.out.printf("\nQuantidade de arquivos lidos: %d\n", lista.size());

            for (i = 5; i >= 0; i--) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.printf("\n%d segundo(s) para salvar resultados encontrados...", i);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }

            file = new File(path + "arquivo_final" + ".txt");
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            for (i = 0; i < tam; i++) {
                bw.write(lista.get(i).toString());
                bw.newLine();
                System.out.printf("\nLinha %d escrita: %d", i, lista.get(i));
            }
            bw.close();

            System.out.printf("\nTempo de execução total do programa (criação, escrita, leitura e deleção):");
            System.out.println(elapsedTime + "ms");
        }//try
        catch (IOException e) {
            System.out.println(e);
        }//catch
        return;
    }//main
}//classe principal
