package br.edu.uniaeso;

import java.io.*;

class ContaBancaria implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nomeCliente;
    private double saldo;

    public ContaBancaria(String nomeCliente, double saldo) {
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public String toString() {
        return "ContaBancaria [nomeCliente=" + nomeCliente + ", saldo=" + saldo + "]";
    }
}

public class AtualizacaoContaBancaria {
    public static void main(String[] args) {
        ContaBancaria conta = null;
        try (ObjectInputStream objetoEntrada = new ObjectInputStream(new FileInputStream("C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivobinario\\exercicio14\\conta.dat"))) {
            conta = (ContaBancaria) objetoEntrada.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        conta.depositar(300.0);

        try (ObjectOutputStream objetoSaida = new ObjectOutputStream(new FileOutputStream("C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivobinario\\exercicio14\\conta.dat"))) {
            objetoSaida.writeObject(conta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
