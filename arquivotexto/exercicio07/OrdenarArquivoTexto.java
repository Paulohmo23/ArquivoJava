package br.edu.uniaeso;

import java.io.*;
import java.util.*;

public class OrdenarArquivoTexto {
    public static void main(String[] args) {
        try {
            File arquivoEntrada = new File("C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivotexto\\exercicio07\\meuarquivo.txt");
            BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada));

            List<String> linhas = new ArrayList<>();
            String linha;
            while ((linha = leitor.readLine()) != null) {
                linhas.add(linha);
            }
            leitor.close();
            Collections.sort(linhas);

            File arquivoSaida = new File("C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivotexto\\exercicio07\\meuarquivo_ordenado.txt");
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSaida));
            for (String linhaOrdenada : linhas) {
                escritor.write(linhaOrdenada);
                escritor.newLine();
            }
            escritor.close();

            System.out.println("Arquivo ordenado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao ler ou escrever o arquivo: " + e.getMessage());
        }
    }
}
