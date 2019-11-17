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
import java.util.concurrent.TimeUnit;
import java.io.*;

public class SIN142IOBound {
	
	//Método para impressão de ArrayList.
	public static void printArray(ArrayList<Integer> lista) {
		int n;
		n = lista.size();
		int i;
		int j = 0;
		for(i=0; i<n; i++)
		{
			System.out.printf("%d ", lista.get(i));
			j++;
			if(j == 10) {
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
			} 
			else {
				throw new IOException("\nDiretório não foi criado corretamente.");
			}
		}
		else {
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
		long startTime = System.currentTimeMillis();
		int i;
		ArrayList<File> lista_files = new ArrayList<File>();
		ArrayList<Integer> lista_valores = new ArrayList<Integer>();
		File file;
		boolean statusCriador = false;
		boolean statusEscritor = false;
		boolean statusLeitor = false;
		boolean checagem = true;
		
		try {
			String path = criarDiretorio();
			for(i=5; i>=0; i--) {
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.printf("\n%d segundo(s) para continuar para criação...", i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
			}
			/*
			 * Testando classes novas.
			 * 1 - Cria arquivos.
			 * 1.5 - Escreve Arquivos.
			 * 2 - Lê e deleta arquivos.
			 */
			
			// 1 - Criando vários arquivos.		
			CriadorArquivos criador = new CriadorArquivos();
			CriadorArquivos.setPath(path);
			criador.criarVariosArquivos();
			while (statusCriador == false) {
				statusCriador = criador.status;
			}
			for(i=5; i>=0; i--) {
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.printf("\n%d segundo(s) para continuar para escrita...", i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
			}
			
			for(i = 0; i<100000; i++) {
				file = new File(path + Integer.toString(i) + ".txt");
				lista_files.add(file);
			}
			//1.5 - Escrevendo nos arquivos criados.

			while(checagem) {
				checagem = false;
				EscreveArquivosCriados escritor = new EscreveArquivosCriados(lista_files);
				escritor.escreveVariosArquivos(lista_files);
				while (statusEscritor == false)
				{
					statusEscritor = escritor.status;
				}
				for(i=5; i>=0; i--) {
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
				for(i=0; i<100000; i++) {
					BufferedReader br = new BufferedReader(new FileReader(lista_files.get(i)));     
					if (br.readLine() == null) {
					    System.out.printf("\nArquivo %d existe, mas sem conteúdo. Processo de escrita será reiniciado...", i);
					    checagem = true;
					    for(i=5; i>=0; i--) {
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
				if(!checagem) {
					System.out.println("A escrita dos arquivos foi um sucesso!");
					for(i=3; i>=0; i--) {
						try {
							TimeUnit.SECONDS.sleep(1);
							System.out.printf("\n%d segundo(s) para leitura e deleção dos arquivos...", i);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							Thread.currentThread().interrupt();
							e.printStackTrace();
						}
					}
				}
			}//fim do while checagem.	
			checagem = true;
			
			// 2 - Lendo e deletando arquivos.
		
			LeitorArquivos leitor = new LeitorArquivos();
			LeitorArquivos.lista_files = lista_files;
			lista_valores = leitor.lerVariosArquivos();
			while (statusLeitor == false)
			{
				statusLeitor = leitor.status;
			}
			for(i=5; i>=0; i--) {
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.printf("\n%d segundo(s) para imprimir dados lidos...", i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
			}
			
			long stopTime = System.currentTimeMillis();
		    long elapsedTime = stopTime - startTime;
		    
			// Verificando resultado //
			printArray(lista_valores);
			System.out.printf("\nQuantidade de arquivos lidos: %d\n", lista_valores.size());			
			for(i=5; i>=0; i--) {
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.printf("\n%d segundo(s) para salvar resultados encontrados...", i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
			}
		    
			//Cria arquivo com o resultado.
			file = new File(path + "arquivo_final" + ".txt");
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			
			for (i=0; i<100000; i++) {
				bw.write(lista_valores.get(i).toString());
				bw.newLine();
				System.out.printf("\nLinha %d escrita: %d", i, lista_valores.get(i));
			}
		 
			bw.close();
		    System.out.printf("\nTempo de execução total do programa (criação, escrita, leitura e deleção):");
		    System.out.println(elapsedTime + "ms");
		    
		}//try
		catch(IOException e) {
			System.out.println(e);
		}//catch
		return;
	}//main
}//classe principal
