package SIN142IOBound;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CriadorArquivos {

    private Random gerador = new Random(10);

    /*
	 * Método que cria um arquivo com um nome numérico.
	 * num_arquivo é o parâmetro que define como se chamará o arquivo.
	 * path é o destino do arquivo (veja criarDiretorio()).
     */
    public File criarArquivo(int num_arquivo, String path) throws IOException {
        File file = new File(path + Integer.toString(num_arquivo) + ".txt");
        file.createNewFile();
        if (file.exists()) {
            System.out.printf("\nArquivo %d.txt criado.", num_arquivo);
            return file;
        } else {
            throw new IOException("\nArquivo .txt não pôde ser criado.");
        }
    }//Fim criarArquivo

    //Um método para criar N arquivos
    //path = caminho do diretório.
    public void criarVariosArquivos(String path) throws IOException {
        File file;
        int i, tam = 30000;
        for (i = 0; i < tam; i++) {
            file = criarArquivo(i, path);
            FileWriter writer;
            writer = new FileWriter(file);
            writer.write(Integer.toString(gerador.nextInt(tam+1)));
            System.out.printf("\nArquivo %d escrito =>(caminho: %s).", i, file.toString());
            writer.close();
        }//for
        return;
    }//fim criarVariosArquivos
}//Fim classe
