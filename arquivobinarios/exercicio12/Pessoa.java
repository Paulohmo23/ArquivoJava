package br.edu.uniaeso;

import java.io.*;

class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + "]";
    }
}

public class Deserializacao {
    public static void main(String[] args) {
        try (ObjectInputStream objetoEntrada = new ObjectInputStream(new FileInputStream("C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivobinario\\exercicio12\\pessoa.dat"))) {
            Pessoa pessoa = (Pessoa) objetoEntrada.readObject();
            System.out.println("Detalhes da Pessoa:");
            System.out.println(pessoa);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
