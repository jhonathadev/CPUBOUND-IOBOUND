package SIN142IOBound;

import java.io.File;
import java.util.ArrayList;

public class ApagadorArquivos implements Runnable{
	public static ArrayList<File> lista_files = new ArrayList<File>();
	public int i;
	
	//Construtor obrigatório
	
	public ApagadorArquivos(int i, ArrayList<File> lista_files_recebida) {
		this.i = i;
		ApagadorArquivos.lista_files = lista_files_recebida;
	}
	
	//Um método para excluir arquivos.
	public void run()
	{
		lista_files.get(i).delete();
		if(!lista_files.get(i).exists()) {
			System.out.printf("\nArquivo %s deletado.", i);
			return;
		}
		else {
			System.out.println("Erro, arquivo não foi deletado. Tentando novamente.");
			run();
		}
	}//Fim deletaArquivo
}//Fim da classe
