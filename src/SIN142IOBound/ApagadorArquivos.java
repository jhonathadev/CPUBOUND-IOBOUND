package SIN142IOBound;

import java.io.File;
import java.io.IOException;

public class ApagadorArquivos {
	//Um método para excluir arquivos.
	public void deletaArquivo(String path, int i) throws IOException
	{
		File file = new File(path + Integer.toString(i) + ".txt");
		if(file.delete()) {
			System.out.printf("\nArquivo %s deletado.", file.getName());
			return;
		}
		else {
			System.out.println("Arquivo não deletado: algo deu errado.");
			return;
		}
	}//Fim deletaArquivo
}//Fim da classe
