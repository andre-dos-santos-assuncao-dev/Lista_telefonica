import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Contatos {
    public Map<Integer, Map<String, String>> contatos = new HashMap<>();

    public void adicionarContato(Map<String, String> contato) {
        int minId = contatos.isEmpty() ? 1 : contatos.keySet().stream().max(Integer::compare).get() + 1;
        contatos.put(minId, contato);
    }

    public void removerContato(int id) {
        contatos.remove(id);
        Map <Integer, Map<String, String>> newContatos = new HashMap<>();
        for (Entry<Integer, Map<String, String>> entry : contatos.entrySet()) {
            if (entry.getKey() > id) {
                newContatos.put(entry.getKey() - 1, entry.getValue());
            } else {
                newContatos.put(entry.getKey(), entry.getValue());
            }
        }
        contatos = newContatos;
    }

    public void atualizarContato(int id, String nome, String telefone, String email, String endereco) {
        Contato contato = new Contato(nome, telefone, email, endereco);
        contatos.replace(id, contato.contato);
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
