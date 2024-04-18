package br.edu.uniaeso;
import java.io.*;

public class ConcatenaArquivos {
    public static void main(String[] args) {
        String nomeArquivo1 = "arquivo1.txt";
        String nomeArquivo2 = "arquivo2.txt";
        String nomeArquivoConcatenado = "C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivotexto\\exercicio10\\meuarquivo.txt";

        try {
            
            BufferedWriter out1 = new BufferedWriter(new FileWriter(nomeArquivo1));
            out1.write("Conteúdo do arquivo 1");
            out1.newLine();
            out1.close();

            BufferedWriter out2 = new BufferedWriter(new FileWriter(nomeArquivo2));
            out2.write("Conteúdo do arquivo 2");
            out2.newLine();
            out2.close();
          
            BufferedWriter outConcatenado = new BufferedWriter(new FileWriter(nomeArquivoConcatenado));
            concatenarArquivos(nomeArquivo1, outConcatenado);
            concatenarArquivos(nomeArquivo2, outConcatenado);
            outConcatenado.close();

            System.out.println("Arquivos concatenados e salvos em " + nomeArquivoConcatenado);

        } catch (IOException e) {
            System.err.println("Erro ao manipular arquivos: " + e.getMessage());
        }
    }
    private static void concatenarArquivos(String nomeArquivoOrigem, BufferedWriter out) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(nomeArquivoOrigem));
        String linha;
        while ((linha = in.readLine()) != null) {
            out.write(linha);
            out.newLine();
        }
        in.close();
    }
}
