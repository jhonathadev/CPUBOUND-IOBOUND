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
	//Um método para ler arquivos (ainda não implementado).
	/*public static ArrayList<Integer> lerArquivo(String path) {
		return 0
	}*/
	
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.printf("Hello World");
		//ArrayList<Integer> lista = new ArrayList<Integer>();
		//Testando método criarDiretorio.
		String path = criarDiretorio();
	}

}
