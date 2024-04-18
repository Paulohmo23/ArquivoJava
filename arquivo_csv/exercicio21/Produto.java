package br.edu.uniaeso;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        String csvFile = "C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivocsv\\exercicio21\\produtos.csv";

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

            Scanner scanner = new Scanner(System.in);

            System.out.println("Digite o nome do produto:");
            String nome = scanner.nextLine();

            System.out.println("Digite o preço do produto:");
            double preco = scanner.nextDouble();

            System.out.println("Digite a quantidade do produto:");
            int quantidade = scanner.nextInt();

            Produto novoProduto = new Produto(nome, preco, quantidade);
            produtos.add(novoProduto);

            CSVWriter writer = new CSVWriter(new FileWriter(csvFile));
            for (Produto produto : produtos) {
                String[] linha = {produto.getNome(), String.valueOf(produto.getPreco()), String.valueOf(produto.getQuantidade())};
                writer.writeNext(linha);
            }
            writer.close();

            System.out.println("Produto adicionado com sucesso!");

            reader.close();
            scanner.close();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}
