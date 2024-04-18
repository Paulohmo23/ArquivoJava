import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

class Pessoa implements Serializable {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
}

public class SerializaPessoa {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Paulo", 33);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\paulo\\OneDrive\\Documentos\\ArquivoJava\\arquivotexto\\exercicio08\\pessoa.dat"))) {
            out.writeObject(pessoa);
            System.out.println("Objeto serializado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
