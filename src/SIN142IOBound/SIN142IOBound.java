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

public class SIN142IOBound {
	
	//Método para impressão de ArrayList.
	public static void printArray(ArrayList<Integer> lista) {
		int n;
		n = lista.size();
		int i;
		for(i=0; i<n; i++)
		{
			System.out.printf("%d ", lista.get(i));
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
		ArrayList<Integer> lista = new ArrayList<Integer>();
//		File file;
//		int i;
		try {
			String path = criarDiretorio();
			/*
			 * Testando classes novas.
			 * 1 - Cria arquivos.
			 * 2 - Lê arquivos.
			 * 3 - Deleta arquivos.
			 */
			
			// 1 - Criando vários arquivos: retorno void.
//			CriadorArquivos criador = new CriadorArquivos();
//			criador.criarVariosArquivos(path);
			
			CriadorArquivos criador = new CriadorArquivos();
			criador.setPath(path);
			criador.criarVariosArquivos();
			
//			// 2 - Lendo arquivos: retorno ArrayList.
//			LeitorArquivos leitor = new LeitorArquivos();
//			lista = leitor.lerVariosArquivos(path);
//			
//			// Verificando resultado //
//			System.out.println();
//			printArray(lista);
//			
//			// 3 - Apagando arquivos: retorno void.
//			ApagadorArquivos apagador = new ApagadorArquivos();
//			apagador.deletaArquivo(path, 1);
			/*
			 * Implementando Threads.
			 */
		}//try
		catch(IOException e) {
			System.out.println(e);
		}//catch
	}//main
}//classe principal
