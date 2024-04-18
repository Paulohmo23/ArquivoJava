package br.edu.uniaeso;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String nomeArquivo = "C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivotexto\\exercicio09\\meuarquivo.txt";
        String palavraLer = "Java";
        int contador = 0;

        try {
            BufferedReader in = new BufferedReader(new FileReader(nomeArquivo));
            String linha;

            while ((linha = in.readLine()) != null) {
                String[] palavras = linha.split(" ");

                for (String palavra : palavras) {
                 
                    if (palavra.equals(palavraLer)) {
                        contador++;
                    }
                }
            }

            in.close();

            System.out.println("A palavra 'Java' aparece " + contador + " vezes no arquivo.");

        } catch (IOException e) {
            
        }
    }
}
