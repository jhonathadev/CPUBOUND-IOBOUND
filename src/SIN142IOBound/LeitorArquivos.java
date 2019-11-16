package SIN142IOBound;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeitorArquivos {
	//Um método para ler arquivos.
	public static ArrayList<File> lista_files = new ArrayList<File>(); 
	public boolean status = false;
	public ArrayList<Integer> lerArquivo(int i, ArrayList<Integer> temp) throws IOException {
		int valor;
		BufferedReader leitor;
		try {
			leitor = new BufferedReader(new FileReader(lista_files.get(i)));
			String linha = leitor.readLine();
			while(linha != null)
			{
				valor = Integer.valueOf(linha);
				temp.add(valor);
				linha = leitor.readLine();
			}
			leitor.close();
//			System.out.printf("\nArquivo %d lido com sucesso.", i);
			ApagadorArquivos apagador1 = new ApagadorArquivos(i, lista_files);
			Thread apagador_thread = new Thread(apagador1);
			apagador_thread.start();
		} catch(IOException e) {
			throw new IOException("\nErro na leitura do arquivo.");
		}
		return temp;
	}//fim lerArquivo
	
	//Uma função para ler N arquivos.
	//Retorna uma ArrayList atualizada com todos os arquivos lidos.
	public ArrayList<Integer> lerVariosArquivos() throws IOException
	{
		ArrayList<Integer> lista_valores = new ArrayList<Integer>();
		int i;
		for(i = 0; i<100000; i++)
		{
			lista_valores = lerArquivo(i, lista_valores);
		}
		status = true;
		return lista_valores;
	}//Fim lerVariosArquivos
}//Fim da classe
