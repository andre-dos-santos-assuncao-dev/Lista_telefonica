import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Contatos contatos = new Contatos();
    public static void Lista_telefonica() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("--Lista Telefonica--\n");
            System.out.println("Escolha uma opcao:");

            System.out.println("1 - Gerenciar contatos");
            System.out.println("2 - Ver contatos");
            System.out.println("3 - Sair\n");

            System.out.println("Digite o numero da opcao escolhida: ");

            while (!sc.hasNextInt()) {
                System.out.println("Digite um numero valido!");
                sc.next();
            }
            int opecao = sc.nextInt();

            while (opecao > 3) {
                System.out.println("Digite o numero de uma operação!");
                try {
                    opecao = sc.nextInt();
                } catch (Exception e) {
                    sc.next();
                }
            }

            switch (opecao) {
                case 1 -> gerenciarContatos(sc, contatos);   
                case 2 -> contatos.verContatos();
                case 3 -> {
                    System.out.println("\nObrigado por usar a Lista Telefonica!\n");
                    System.exit(0);
                }
                default -> {
                }
            }
            if (opecao != 3) {
                Lista_telefonica();
            }
        }
    }

    public static void novoContato(Scanner sc, Contatos contatos) {
        sc.nextLine();
        var contato_Valores = contatoValores(sc);
        String nome = contato_Valores.get(0);
        String telefone = contato_Valores.get(1);
        String email = contato_Valores.get(2);
        String endereco = contato_Valores.get(3);

        System.out.println("\nContato adicionado com sucesso!\n");
        System.out.println("----------------------------------\n");

        Contato contato = new Contato(nome, telefone, email, endereco);
        contatos.adicionarContato(contato.contato);
    }     
    
    public static void gerenciarContatos(Scanner sc, Contatos contatos) {
        System.out.println("\n----------------------------------");
        System.out.println("\n--Gerenciar Contatos--");
        System.out.println("\nEscolha uma opcao:");
        System.out.println("1 - Adicionar contato");
        System.out.println("2 - Remover contato");
        System.out.println("3 - Atualizar contato");
        System.out.println("4 - Voltar\n");

        System.out.println("Digite o numero da opcao escolhida: ");

        while (!sc.hasNextInt()) {
            System.out.println("Digite um numero valido!");
            sc.next();
        }
        int opecao_gerenciar = sc.nextInt();

        while (opecao_gerenciar > 4) {
            System.out.println("Digite o numero de uma operação!");
            try {
                opecao_gerenciar = sc.nextInt();
            } catch (Exception e) {
                sc.next();
             }
        }     
                    
        switch (opecao_gerenciar) {
            case 1 -> novoContato(sc, contatos);
            case 2 -> {
                System.out.println("\nDigite o ID do contato que deseja remover:");

                while (!sc.hasNextInt()) {
                    System.out.println("Digite um numero valido!");
                     sc.next();
                }
                int id = sc.nextInt();

                if (contatos.contatos.containsKey(id)) {
                    contatos.removerContato(id);
                    System.out.println("\nContato removido com sucesso!\n");
                    System.out.println("----------------------------------\n");
                } else {             
                    System.out.println("\nContato nao encontrado!");
                    gerenciarContatos(sc, contatos);
                }
            }
            case 3 -> {
                System.out.println("\nDigite o ID do contato que deseja atualizar:");

                while (!sc.hasNextInt()) {
                    System.out.println("Digite um numero valido!");
                    sc.next();
                }
                int id = sc.nextInt();

                if (contatos.contatos.containsKey(id)) {
                    sc.nextLine();
                    var contato_Valores = contatoValores(sc);
                    String nome = contato_Valores.get(0);
                    String telefone = contato_Valores.get(1);
                    String email = contato_Valores.get(2);
                    String endereco = contato_Valores.get(3);
                    
                    contatos.atualizarContato(id, nome, telefone, email, endereco);
                    System.out.println("\nAtualizacao feita com sucesso!\n");
                    System.out.println("----------------------------------\n");                    
                } else {
                    System.out.println("\nContato nao encontrado!");
                    gerenciarContatos(sc, contatos);
                }
            }    
            case 4 -> {
                System.out.println("\n----------------------------------\n");
                Lista_telefonica();
            }
            default -> {
            }
        }    
    }

    public static List<String> contatoValores(Scanner sc) {
        System.out.println("Digite o nome do contato:");
        String nome = sc.nextLine();

        System.out.println("Digite o telefone do contato:");
        String telefone = sc.nextLine();

        System.out.println("Digite o email do contato:");
        String email = sc.nextLine();

        System.out.println("Digite o endereco do contato:");
        String endereco = sc.nextLine();
        return Arrays.asList(nome, telefone, email, endereco);
    }

    public static void main(String[] args) {
        System.out.println("\nBem-vindo a Lista Telefonica!\n");
        Lista_telefonica();
    }    
}
