import java.util.HashMap;
import java.util.Map;

public class Contatos {
    public Map<Integer, Map<String, String>> contatos = new HashMap<>();

    public void adicionarContato(Map<String, String> contato) {
        int id = contatos.size() + 1;
        contatos.put(id, contato);
    }

    public void verContatos() {
        if (contatos.isEmpty()) {
            System.out.println("\nNenhum contato cadastrado.\n");
            System.out.println("----------------------------------\n");
            return;
        }
        for (Map.Entry<Integer, Map<String, String>> entry : contatos.entrySet()) {
            System.out.println("----------------------------------");
            System.out.println("ID: " + entry.getKey());
            System.out.println("Nome: " + entry.getValue().get("Nome:"));
            System.out.println("Telefone: " + entry.getValue().get("Telefone:"));
            System.out.println("Email: " + entry.getValue().get("Email:"));
            System.out.println("Endereco: " + entry.getValue().get("Endereco:"));
            System.out.println("----------------------------------\n");
        }
    }
}
