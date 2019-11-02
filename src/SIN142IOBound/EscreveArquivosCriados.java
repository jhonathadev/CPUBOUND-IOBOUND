package SIN142IOBound;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.*;

public class EscreveArquivosCriados implements Runnable{
	public int i=0;
	public static ArrayList<File> lista_files = new ArrayList<File>();
	
	
	 public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public static ArrayList<File> getLista_files() {
		return lista_files;
	}

	public static void setLista_files(ArrayList<File> lista_files) {
		EscreveArquivosCriados.lista_files = lista_files;
	}

	//Construtores
	public EscreveArquivosCriados(int i) {
		 setI(i);
	 }
	
	public void escreveVariosArquivos(ArrayList<File> lista_par) throws IOException
	{
		lista_files = lista_par;
		for(i=0; i<11; i++)
		{
			EscreveArquivosCriados escritor1 = new EscreveArquivosCriados(i);
			Thread escritor_thread = new Thread(escritor1);
			escritor_thread.start();
		}//for
		return;
	}//fim criarVariosArquivos
	
	@Override
	public void run()
	{
		try {
		FileWriter writer;
		
		File file_atual = lista_files.get(i);
		writer = new FileWriter(file_atual);
		writer.write(Integer.toString(i));
		System.out.println("Arquivo escrito.");
		writer.close();
		}
		catch(IOException e){
			System.out.println("IOExcepetion.");
		}
	}
}
