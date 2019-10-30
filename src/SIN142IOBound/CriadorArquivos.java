package SIN142IOBound;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CriadorArquivos {
	/*
	 * Método que cria um arquivo com um nome numérico.
	 * num_arquivo é o parâmetro que define como se chamará o arquivo.
	 * path é o destino do arquivo (veja criarDiretorio()).
	 */
	public File criarArquivo(int num_arquivo, String path)
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
	}//Fim criarArquivo
	
	//Um método para criar N arquivos
	//path = caminho do diretório.
	public void criarVariosArquivos(String path) throws IOException
	{
		File file;
		int i;
		for(i=0; i<11; i++)
		{
			file = criarArquivo(i, path);
			if(file == null) {
				System.out.printf("\nErro na criação do arquivo %d.", i);
				continue;
			}//if
			else {
				FileWriter writer;
				writer = new FileWriter(file);
				writer.write(Integer.toString(i));
				writer.close();
			}//else	
		}//for
		return;
	}//fim criarVariosArquivos
}//Fim classe
