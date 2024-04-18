package br.edu.uniaeso;

import java.io.*;
public class RemoveLinhas {

    public static void main(String[] args) {
        try {

            File arquivoEntrada = new File("C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivotexto\\exercicio08\\meuarquivo.txt");
            BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada));

            File arquivoSaida = new File("C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivotexto\\exercicio08\\meuarquivo_sem_excluir.txt");
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida));

            String palavraRemover = "excluir";

            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (!linha.contains(palavraRemover)) {
                    escritor.write(linha);
                    escritor.newLine();
                }
            }

            leitor.close();
            escritor.close();

            System.out.println("Linhas com a palavra \"" + palavraRemover + "\" removidas com sucesso !!!");
        } catch (IOException e) {
            System.out.println("Erro ao ler ou escrever o arquivo: " + e.getMessage());
        }
    }
}
