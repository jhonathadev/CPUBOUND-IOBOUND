package SIN142IOBound;

import java.io.File;
import java.io.IOException;

public class CriadorArquivos implements Runnable{
	public int i;
	public File file = null;
	public static String path;
	public boolean status;
	
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
			return;
		}
		catch(IOException e) {
			System.out.println("\nArquivo .txt não pôde ser criado.");
			//Tenta de novo.
			CriadorArquivos criador1 = new CriadorArquivos(i);
			Thread criador_thread = new Thread(criador1);
			criador_thread.start();
		}	
		catch(Exception e) {
			System.out.println("\nArquivo .txt não pôde ser criado.");
			//Tenta de novo.
			CriadorArquivos criador1 = new CriadorArquivos(i);
			Thread criador_thread = new Thread(criador1);
			criador_thread.start();
		}	
		return;
	}
	
	//Um método para criar N arquivos
	//path = caminho do diretório.
	
	//Chamar passando caminho.
	public void criarVariosArquivos() throws IOException
	{
		for(i=0; i<100000; i++)
		{
			CriadorArquivos criador1 = new CriadorArquivos(i);
			Thread criador_thread = new Thread(criador1);
			criador_thread.start();
		}//for
		status = true;
		return;
	}//fim criarVariosArquivos
}//Fim classe
