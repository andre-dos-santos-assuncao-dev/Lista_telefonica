import java.util.Scanner;

public class Main {
    static Contatos contatos = new Contatos();
    public static void Lista_telefonica() {
        try (Scanner sc = new Scanner(System.in)) {
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

        System.out.println("Digite o nome do contato:");
        String nome = sc.nextLine();

        System.out.println("Digite o telefone do contato:");
        String telefone = sc.nextLine();

        System.out.println("Digite o email do contato:");
        String email = sc.nextLine();

        System.out.println("Digite o endereco do contato:");
        String endereco = sc.nextLine();

        System.out.println("\nContato cadastrado com sucesso!\n");
        System.out.println("----------------------------------\n");

        Contato contato = new Contato(nome, telefone, email, endereco);
        contatos.adicionarContato(contato.contato);
    }     
    
    public static void gerenciarContatos(Scanner sc, Contatos contatos) {
        System.out.println("\n----------------------------------");
        System.out.println("\nEscolha uma opcao:");
        System.out.println("1 - Adicionar contato");
        System.out.println("2 - Remover contato");
        System.out.println("3 - Voltar\n");

        System.out.println("Digite o numero da opcao escolhida: ");

        while (!sc.hasNextInt()) {
            System.out.println("Digite um numero valido!");
            sc.next();
        }
        int opecao_gerenciar = sc.nextInt();

        while (opecao_gerenciar > 3) {
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
                System.out.println("\n----------------------------------\n");
                Lista_telefonica();
            }
            default -> {
            }
        }    
    }

    public static void main(String[] args) {
        System.out.println("\nBem-vindo a Lista Telefonica!\n");
        Lista_telefonica();
    }    
}
