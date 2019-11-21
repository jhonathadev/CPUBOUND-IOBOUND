package SIN142IOBound;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeitorArquivos {
    //Um método para ler arquivos.

    public ArrayList<Integer> lerArquivo(String path, int i, ArrayList<Integer> temp) throws IOException {
        int valor;
        BufferedReader leitor;
        try {
            leitor = new BufferedReader(new FileReader(path + Integer.toString(i) + ".txt"));
            String linha = leitor.readLine();
            while (linha != null) {
                valor = Integer.valueOf(linha);
                temp.add(valor);
                linha = leitor.readLine();
            }
            leitor.close();
            System.out.printf("\nArquivo %d lido com sucesso.", i);
            ApagadorArquivos apagador = new ApagadorArquivos();
            apagador.deletaArquivo(path, i);
        } catch (IOException e) {
            throw new IOException("\nErro na leitura do arquivo.");
        }
        return temp;
    }//fim lerArquivo

    //Uma função para ler N arquivos.
    //Retorna uma ArrayList atualizada com todos os arquivos lidos.
    public ArrayList<Integer> lerVariosArquivos(String path) throws IOException {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        int i, tam = 30000;
        for (i = 0; i < tam; i++) {
            lista = lerArquivo(path, i, lista);
        }
        return lista;
    }//Fim lerVariosArquivos
}//Fim da classe
