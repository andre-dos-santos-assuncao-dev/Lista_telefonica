import java.util.HashMap;
import java.util.Map;

public class Contato {
    String nome;
    String telefone;
    String email;
    String endereco;

    public Map<String, String> contato = new HashMap<>();

    public Contato(String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;

        this.contato.put("Nome:", this.nome);   
        this.contato.put("Telefone:", this.telefone);
        this.contato.put("Email:", this.email);
        this.contato.put("Endereco:", this.endereco);
    }
}
