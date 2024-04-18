package br.edu.uniaeso;


import java.io.RandomAccessFile;
import java.io.IOException;

class Funcionario {
    private int id;
    private String nome;
    private double salario;

    public Funcionario(int id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}

public class GerenciaFuncionarios {
    private static final String FILE_PATH = "C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivobinario\\exercicio17\\funcionarios.dat";

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw");

        Funcionario funcionario = new Funcionario(1, "Paulo", 7000.0);
        file.writeInt(funcionario.getId());
        file.writeUTF(funcionario.getNome());
        file.writeDouble(funcionario.getSalario());

        file.seek((funcionario.getId() - 1) * (Integer.BYTES + funcionario.getNome().length() + Double.BYTES));
        funcionario.setNome("Esley ");
        funcionario.setSalario(8500.0);
        file.writeInt(funcionario.getId());
        file.writeUTF(funcionario.getNome());
        file.writeDouble(funcionario.getSalario());

        Funcionario funcionarioExcluido = new Funcionario(1, "", 0.0);
        file.writeInt(funcionarioExcluido.getId());
        file.writeUTF(funcionarioExcluido.getNome());
        file.writeDouble(funcionarioExcluido.getSalario());

        file.close();
    }
}
