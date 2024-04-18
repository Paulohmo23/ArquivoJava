package br.edu.uniaeso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

public class App_Csv {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivotexto\\exercicio06\dados.csv");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {

                String[] campos = linha.split(",");

                for (String campo : campos) {
                    System.out.print(campo + " ");
                }
                System.out.println();
            }
            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }
}
