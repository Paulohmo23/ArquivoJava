package br.edu.uniaeso;
import java.io.*;

public class AdicionarArquivo {
    public static void main(String[] args) throws IOException{
        String nomeArquivo = "C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivotexto\\exercicio03\\meuarquivo.txt";

        PrintWriter escreverArquivo = new PrintWriter(new FileWriter(nomeArquivo,true));
        escreverArquivo.println("Isso é uma adição ");
        escreverArquivo.close();
        System.out.println("Mensagem adicionada com sucesso");
    }
}
