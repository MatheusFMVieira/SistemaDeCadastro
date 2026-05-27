package util;

import java.util.List;
import java.util.Scanner;

import entities.User;
import services.UserService;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private UserService userService = new UserService();

    private void exibirMenu(){
        System.out.println("\n==== MENU ====");
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Listar usuário");
        System.out.println("3 - Buscar usuário");
        System.out.println("4 - Atualizar usuário");
        System.out.println("5 - Remover usuário");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

    }

    public void executar(){
        int opcao;
        do{
            exibirMenu();
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    buscarPorId();
                    break;
                case 4:
                    atualizar();
                    break;
                case 5:
                    remover();
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while (opcao != 0);
    }

    private void cadastrar(){
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.print("E-mail: ");
        String email = sc.nextLine();

        if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
            System.out.println("E-mail inválido.");
            return;
        }

        User user = new User(id, idade, nome, email);

        userService.cadastrar(user);

        System.out.println("Usuário cadastrado com sucesso!");
    }

    private void listarUsuarios(){
        List<User> usuarios = userService.listar();

        if(usuarios.isEmpty()){
            System.out.println("Nenhum usuário foi cadastrado!");
            return;
        }
        for(User user : usuarios){
            System.out.println(user);
        }
    }

    private void buscarPorId(){
        System.out.print("Digite o ID do usuário: ");
        int id = sc.nextInt();
        sc.nextLine();

        User user = userService.buscarPorId(id);
        if(user != null){
            System.out.println(user);
        }else {
            System.out.println("Usuário não encontrado!");
        }
    }

    private void atualizar(){
        System.out.print("Digite o ID do usuário: ");
        int id = sc.nextInt();
        sc.nextLine();

        User user = userService.buscarPorId(id);

        if(user == null){
            System.out.println("Usuário não encontrado.");
            return;
        }

        String opcao;

        System.out.println(user);

        System.out.print("Deseja alterar o nome(s/n): ");
        opcao = sc.nextLine();
        if(opcao.equalsIgnoreCase("s")){
            System.out.print("Novo nome: ");
            String nome = sc.nextLine();

            user.setNome(nome);
        }

        System.out.print("Deseja alterar a idade(s/n): ");
        opcao = sc.nextLine();
        if(opcao.equalsIgnoreCase("s")){
            System.out.print("Nova idade: ");
            int idade = sc.nextInt();
            sc.nextLine();

            user.setIdade(idade);
        }

        System.out.print("Deseja alterar o e-mail(s/n): ");
        opcao = sc.nextLine();
        if(opcao.equalsIgnoreCase("s")){
            System.out.print("Novo e-mail: ");
            String email = sc.nextLine();
            if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
                System.out.println("E-mail inválido.");
                return;
            }
            user.setEmail(email);
        }
        
        
        System.out.println("Usuário atualizado com sucesso!");
    }

    private void remover(){
        System.out.print("Digite o ID usuário: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean removido = userService.remover(id);
        if(removido){
            System.out.println("Usuário removido com sucesso!");
        }else {
            System.out.println("Usuário não encontrado.");
        }
    }
}
