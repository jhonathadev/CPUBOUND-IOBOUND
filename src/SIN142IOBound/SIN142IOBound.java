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
	/*Um método para ler arquivos (ainda não implementado).
	*public static ArrayList<Integer> lerArquivo(String path) {
	*	return 0
	*}
	*/
	
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
            System.out.println("Falha para criar o diretório.");
            return path;
            }
		}
		else {
			System.out.println("Diretório já existe!");
			return path + "/arquivos/";
		}
	}
	
	/*
	 * Método que cria um arquivo com um nome numérico.
	 * num_arquivo é o parâmetro que define como se chamará o arquivo.
	 * path é o destino do arquivo (veja criarDiretorio()).
	 */
	public static File criarArquivo(int num_arquivo, String path)
	{
		File file = new File(path + Integer.toString(num_arquivo) + ".txt");
		try{
			file.createNewFile();
			System.out.printf("\nArquivo %d.txt criado.", num_arquivo);
			return file;
		}catch(IOException e) {
		    System.out.printf("Arquivo %d.txt não pôde ser criado", num_arquivo);
		    return null;
		}
		
		//Trecho alternativo não utilizado.
		
//		if (file.createNewFile()){
//		    System.out.printf("\nArquivo {0}.txt criado.", num_arquivo);
//		    return file;
//		}
//		else {
//		    System.out.printf("Arquivo {0}.txt já existe.", num_arquivo);
//		    return file;
//		}
	}//fim método criarArquivo.
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.printf("Hello World");
		//ArrayList<Integer> lista = new ArrayList<Integer>();
		
		//Testando método criarDiretorio.
		File file;
		int i;
		String path = criarDiretorio();
		
		/*
		 * Teste: Criando 10 arquivos com nome {número de 0 a 10}.txt
		 * e escrevendo nestes arquivos o número de 0 a 10 correspondente ao
		 * seu nome.
		 * 
		 * PS:. Isso pode virar um método futuramente.
		 */
		for(i=0; i<11; i++)
		{
			file = criarArquivo(i, path);
			if(file == null) {
				System.out.printf("\nErro na criação do arquivo %d.", i);
				continue;
			}//if
			else {
				FileWriter writer;
				try {
					writer = new FileWriter(file);
					writer.write(Integer.toString(i));
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//Exception
			}//else	
		}//for
	}//main
}//classe principal
