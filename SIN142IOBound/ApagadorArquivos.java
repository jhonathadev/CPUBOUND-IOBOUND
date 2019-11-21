package SIN142IOBound;

import java.io.File;
import java.io.IOException;

public class ApagadorArquivos {
    //Um método para excluir arquivos.

    public void deletaArquivo(String path, int i) throws IOException {
        File file = new File(path + Integer.toString(i) + ".txt");
        file.delete();
        if (!file.exists()) {
            System.out.printf("\nArquivo %s deletado.", file.getName());
            return;
        } else {
            throw new IOException("\nErro, arquivo não foi deletado.");
        }
    }//Fim deletaArquivo
}//Fim da classe
