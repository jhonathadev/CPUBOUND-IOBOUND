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
	public static String criarDiretorio() {
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
				System.out.println("Exception: IOException.");
				return path;
			}
		}
		else {
			System.out.println("Diretório já existe!");
			return path + "/arquivos/";
		}
	}	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//Variáveis
		ArrayList<Integer> lista = new ArrayList<Integer>();
		File file;
//		int i;
		String path = criarDiretorio();
		
		/*
		 * Testando classes novas.
		 * 1 - Cria arquivos.
		 * 2 - Lê arquivos.
		 * 3 - Deleta arquivos.
		 */
		
		// 1 - Criando vários arquivos: retorno void.
		CriadorArquivos criador = new CriadorArquivos();
		try {
			criador.criarVariosArquivos(path);
		} catch(IOException e) {
			System.out.println(e);
		}
		// 2 - Lendo arquivos: retorno ArrayList.
		LeitorArquivos leitor = new LeitorArquivos();
		lista = leitor.lerVariosArquivos(path);
		// Verificando resultado //
		System.out.println();
		printArray(lista);
		
		// 3 - Apagando arquivos: retorno void.
		ApagadorArquivos apagador = new ApagadorArquivos();
		try {
		apagador.deletaArquivo(path, 1);
		} catch(IOException e) {
			System.out.println(e);
		}
		/*
		 * Implementando Threads.
		 */
	}//main
}//classe principal
