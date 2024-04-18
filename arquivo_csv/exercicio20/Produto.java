package br.edu.uniaeso;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + nome + ", Preço: R$" + preco + ", Quantidade em estoque: " + quantidade);
    }

    public static void main(String[] args) {
        String csvFile = "C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivocsv\\exercicio20\\produtos.csv";

        try {
            CSVReader reader = new CSVReader(new FileReader(csvFile));
            List<String[]> produtosCSV = reader.readAll();

            List<Produto> produtos = new ArrayList<>();

            for (String[] produtoInfo : produtosCSV) {
                String nome = produtoInfo[0];
                double preco = Double.parseDouble(produtoInfo[1]);
                int quantidade = Integer.parseInt(produtoInfo[2]);
                Produto produto = new Produto(nome, preco, quantidade);
                produtos.add(produto);
            }

            System.out.println("Detalhes dos produtos:");
            for (Produto produto : produtos) {
                produto.exibirDetalhes();
            }

            reader.close();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
