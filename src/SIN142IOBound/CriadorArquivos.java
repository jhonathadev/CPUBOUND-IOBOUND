package SIN142IOBound;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CriadorArquivos implements Runnable{
	public int i;
	public static ArrayList<File> lista_files = new ArrayList<File>();
	public File file = null;
	
	//Construtores;
	public CriadorArquivos(int i) {
		super();
		this.i = i;
	}
	
	public CriadorArquivos() {}
	
	public CriadorArquivos(int i, String caminho) {
		super();
		path = caminho;
		this.i = i;
	}
	
	//Get/Set
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public static String path;
	
	public String getPath() {
		return path;
	}
	
	public static void setPath(String caminho) {
		path = caminho;
	}
	
	/*
	 * Método que cria um arquivo com um nome numérico.
	 * num_arquivo é o parâmetro que define como se chamará o arquivo.
	 * path é o destino do arquivo (veja criarDiretorio()).
	 */
	
	@Override
	public void run() {
		file = new File(path + Integer.toString(i) + ".txt");
		try {
			file.createNewFile();
			System.out.printf("\nArquivo %d.txt criado.", i);
			lista_files.add(file);
			return;
		}
		catch(IOException e) {
			System.out.println("\nArquivo .txt não pôde ser criado.");
		}	
		return;
	}
	
	//Um método para criar N arquivos
	//path = caminho do diretório.
	
	//Chamar passando caminho.
	public ArrayList<File> criarVariosArquivos() throws IOException
	{
		for(i=0; i<501; i++)
		{
			CriadorArquivos criador1 = new CriadorArquivos(i);
			Thread criador_thread = new Thread(criador1);
			criador_thread.start();
		}//for
		return lista_files;
	}//fim criarVariosArquivos
}//Fim classe
