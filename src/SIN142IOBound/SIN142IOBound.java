/**
 * Main
 */
package SIN142IOBound;

/**
 * @author victor
 *
 */

import java.util.*;
import java.io.*;

public class SIN142IOBound {
	/*public static ArrayList<Integer> lerArquivo(String local) {
		return 1
	}*/
	
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
		ArrayList<Integer> lista = new ArrayList<Integer>();
		//Testando método criarDiretorio.
		String path = criarDiretorio();
	}

}
