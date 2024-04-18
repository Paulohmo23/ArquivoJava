package br.edu.uniaeso;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", preco=" + preco + "]";
    }
}

public class SerializacaoDeserializacaoLista {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Camisa", 95.99));
        produtos.add(new Produto("Bermuda", 165.99));
        produtos.add(new Produto("Tenis", 399.99));

        try (ObjectOutputStream objetoSaida = new ObjectOutputStream(new FileOutputStream("C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivobinario\\exercicio13\\produtos.dat"))) {
            objetoSaida.writeObject(produtos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream objetoEntrada = new ObjectInputStream(new FileInputStream("C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivobinario\\exercicio13\\produtos.dat"))) {
            List<Produto> produtosDeserializados = (List<Produto>) objetoEntrada.readObject();
            System.out.println("Produtos:");
            for (Produto produto : produtosDeserializados) {
                System.out.println(produto);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
