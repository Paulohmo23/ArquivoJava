package br.edu.uniaeso;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivocsv\\exercicio24\\funcionarios.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            List<String[]> funcionarios = new ArrayList<>();
            String[] nextRecord;

            while ((nextRecord = reader.readNext()) != null) {
                funcionarios.add(nextRecord);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.println("Filtrar funcionários por:");
            System.out.println("1. Cargo");
            System.out.println("2. Salário mínimo");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o cargo para filtrar: ");
                    String cargo = scanner.next();
                    filtrarPor(funcionarios, 1, cargo);
                    break;
                case 2:
                    System.out.print("Digite o salário mínimo para filtrar: ");
                    double salarioMinimo = scanner.nextDouble();
                    filtrarPor(funcionarios, 2, String.valueOf(salarioMinimo));
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    private static void filtrarPor(List<String[]> funcionarios, int indice, String valor) {
        for (String[] funcionario : funcionarios) {
            if (funcionario[indice].equalsIgnoreCase(valor)) {
                System.out.println(funcionario[0] + ", " + funcionario[1] + ", R$" + funcionario[2]);
            }
        }
    }
}
