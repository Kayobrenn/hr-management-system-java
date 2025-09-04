package main;

import controller.FuncionarioController;
import controller.SetorController;
import controller.UsuarioController;
import enums.Sexo;
import model.Setor;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    private static SetorController setorController = new SetorController();
    private static FuncionarioController funcionarioController = new FuncionarioController();
    private static UsuarioController usuarioController = new UsuarioController();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("======================================================");
        System.out.println("                🚀  BEM-VINDO AO SISTEMA               ");
        System.out.println("                    💼 RH MANAGER                      ");
        System.out.println("------------------------------------------------------");
        System.out.println("       Sistema de Gestão de Funcionários e Setores     ");
        System.out.println("------------------------------------------------------");
        System.out.println("© 2025 - Todos os direitos reservados.                ");
        System.out.println("Desenvolvido por: Kayo Brenno Gomes Cunha              ");
        System.out.println("Estudante de Ciência da Computação - UNIESP            ");
        System.out.println("------------------------------------------------------");
        System.out.println("Versão: 1.0                                            ");
        System.out.println("======================================================");
        System.out.println();


        System.out.println("Iniciando Sistema...");
        Thread.sleep(3000);
        System.out.println();

        telaInicial();
    }

    private static void telaInicial() throws InterruptedException {
        while (true) {
            System.out.println("=========================================================");
            System.out.println("                   🔰  TELA INICIAL                      ");
            System.out.println("---------------------------------------------------------");
            System.out.println("                 🔐  [1] Entrar                          ");
            System.out.println("                 📝  [2] Cadastrar-se                    ");
            System.out.println("                 ❌  [0] Sair                             ");
            System.out.println("=========================================================");
            System.out.print(" 🔸 Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    telaDeLogin();
                    break;
                case "2":
                    cadastrarUsuario();
                    break;
                case "0":
                    System.out.println("\nEncerrando o sistema... 👋");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n❌ Opção inválida! Tente novamente.\n");
            }
        }
    }

    private static void telaDeLogin() throws InterruptedException {
        System.out.println("=========================================================");
        System.out.println("                    🔐  TELA DE LOGIN                    ");
        System.out.println("---------------------------------------------------------");
        System.out.println("    Informe seu usuário e senha para acessar o sistema.  ");
        System.out.println("=========================================================");
        System.out.println();

        boolean autenticado = false;
        int tentativas = 0;

        while (!autenticado && tentativas < 3) {
            System.out.print("👤 Usuário: ");
            String username = scanner.nextLine();
            System.out.print("🔑 Senha  : ");
            String senha = scanner.nextLine();

            if (usuarioController.login(username, senha)) {
                autenticado = true;
                System.out.println("\n✅ Login bem-sucedido! Acessando sistema...");
                Thread.sleep(1500);
                menuPrincipal();
            } else {
                System.out.println("\n❌ Usuário ou senha inválidos.\n");
                tentativas++;
            }
        }

        if (!autenticado) {
            System.out.println("\n⚠️  Número de tentativas excedido. Retornando à tela inicial.\n");
            Thread.sleep(1500);
        }
    }

    private static void menuPrincipal() {
        boolean sair = false;

        while (!sair) {
            System.out.println("==========================================================");
            System.out.println("                        📋 MENU PRINCIPAL                 ");
            System.out.println("----------------------------------------------------------");
            System.out.println(" 🏢 [1] Gestão de Setores");
            System.out.println(" 👥 [2] Gestão de Funcionários");
            System.out.println(" 🔐 [3] Gestão de Usuários");
            System.out.println("----------------------------------------------------------");
            System.out.println(" ❌ [0] Sair para tela de login");
            System.out.println("==========================================================");
            System.out.print(" 🔸 Escolha uma opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    menuSetor();
                    break;
                case "2":
                    menuFuncionario();
                    break;
                case "3":
                    menuUsuarios();
                    break;
                case "0":
                    sair = true;
                    System.out.println("\nSaindo do sistema... Obrigado por utilizar o RH Manager!");
                    System.out.println("Até a próxima! 👋\n");
                    break;
                default:
                    System.out.println("\n❌ Opção inválida! Tente novamente.\n");
            }
        }
    }

    private static void menuSetor() {
        System.out.println("==========================================================");
        System.out.println("                 🏢 GESTÃO DE SETORES                     ");
        System.out.println("----------------------------------------------------------");
        System.out.println(" ➕ [1] Cadastrar Setor");
        System.out.println(" ❌ [2] Excluir Setor");
        System.out.println(" 📑 [3] Listar Setores");
        System.out.println("----------------------------------------------------------");
        System.out.println(" 🔙 [0] Voltar ao Menu Principal");
        System.out.println("==========================================================");
        System.out.print(" 🔸 Escolha uma opção: ");

        String opcao = scanner.nextLine();

        switch (opcao) {
            case "1":
                cadastrarSetor();
                break;
            case "2":
                excluirSetor();
                break;
            case "3":
                setorController.listarSetores();
                break;
            case "0":
                menuPrincipal();
                break;
            default:
                System.out.println("\n❌ Opção inválida! Tente novamente.\n");
        }
    }


    private static void excluirSetor() {
        System.out.println("=========================================================");
        System.out.println("                   ❌ EXCLUIR SETOR                      ");
        System.out.println("---------------------------------------------------------");
        System.out.print("🔸 Digite o nome do setor que deseja excluir: ");
        String nomeSetor = scanner.nextLine();

        boolean excluido = setorController.excluirSetor(nomeSetor);
        if (excluido) {
            System.out.println("\n✅ Setor excluído com sucesso!\n");
        } else {
            System.out.println("\n❌ Setor com nome informado não encontrado.\n");
        }
    }


    private static void cadastrarSetor() {
        System.out.println("===========================================================");
        System.out.println("                🏢 CADASTRO DE SETOR                       ");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Preencha as informações para cadastrar ou excluir um setor.");
        System.out.println("===========================================================");
        System.out.println();
        System.out.print("🔸 Digite o nome do setor: ");
        String nome = scanner.nextLine();

        System.out.print("🔸 Digite a descrição do setor: ");
        String descricao = scanner.nextLine();

        setorController.cadastrarOuExcluirSetor(nome, descricao);
    }

    private static void menuFuncionario() {
        System.out.println("==========================================================");
        System.out.println("                👥 GESTÃO DE FUNCIONÁRIOS                 ");
        System.out.println("----------------------------------------------------------");
        System.out.println(" ➕ [1] Cadastrar Funcionário");
        System.out.println(" ❌ [2] Excluir Funcionário");
        System.out.println(" 📑 [3] Listar Funcionários");
        System.out.println("----------------------------------------------------------");
        System.out.println(" 🔙 [0] Voltar ao Menu Principal");
        System.out.println("==========================================================");
        System.out.print(" 🔸 Escolha uma opção: ");

        String opcao = scanner.nextLine();

        switch (opcao) {
            case "1":
                cadastrarFuncionario();
                break;
            case "2":
                excluirFuncionario();
                break;
            case "3":
                funcionarioController.listarFuncionarios();
                break;
            case "0":
                menuPrincipal();
                break;
            default:
                System.out.println("\n❌ Opção inválida! Tente novamente.\n");
        }
    }


    private static void cadastrarFuncionario() {
        System.out.println("=========================================================");
        System.out.println("              👨‍💼 CADASTRO DE FUNCIONÁRIO                 ");
        System.out.println("---------------------------------------------------------");
        System.out.println("  Preencha as informações para cadastrar um funcionário. ");
        System.out.println("=========================================================");
        System.out.println();

        System.out.print("🔸 Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.print("🔸 Digite o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("🔸 Digite o RG: ");
        String rg = scanner.nextLine();

        System.out.print("🔸 Digite a data de nascimento: ");
        String dataNascimento = scanner.nextLine();

        System.out.print("🔸 Digite a idade: ");
        int idade;
        try {
            idade = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Idade inválida!");
            return;
        }

        System.out.print("🔸 Digite o Estado Cívil: ");
        String estadoCivil = scanner.nextLine();

        System.out.print("🔸 Digite o Cargo: ");
        String cargo = scanner.nextLine();

        System.out.print("🔸 Digite a data de admissão (dd/MM/yyyy): ");
        String dataAdmissao = scanner.nextLine();

        System.out.print("🔸 Digite o salário: ");
        String salario = scanner.nextLine();

        System.out.print("🔸 Tipo de pagamento (Mensal ou Quinzenal): ");
        String tipoPagamento = scanner.nextLine();

        System.out.print("🔸 Digite o email: ");
        String email = scanner.nextLine();

        System.out.print("🔸 Digite o telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("🔸 Digite o sexo: (Masculino, Feminino ou Outros): ");
        Sexo sexo;
        try {
            sexo = Sexo.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Sexo inválido!");
            return;
        }

        System.out.print("🔸 Informe o nome do setor que ele pertence: ");
        String nomeSetor = scanner.nextLine();
        Setor setor = setorController.buscarSetorPorNome(nomeSetor);

        funcionarioController.cadastrarFuncionario(nome, cpf, rg, idade, dataNascimento, email, telefone, sexo,
                                                    setor, cargo, dataAdmissao, salario, tipoPagamento, estadoCivil);
    }

    private static void excluirFuncionario() {
        System.out.println("=========================================================");
        System.out.println("              ❌ EXCLUIR FUNCIONÁRIO                     ");
        System.out.println("---------------------------------------------------------");
        System.out.print("🔸 Digite o CPF do funcionário que deseja excluir: ");
        String cpf = scanner.nextLine();

        boolean sucesso = funcionarioController.excluirFuncionario(cpf);
        if (sucesso) {
            System.out.println("\n✅ Funcionário excluído com sucesso!\n");
        } else {
            System.out.println("\n❌ Funcionário não encontrado.\n");
        }
    }


    private static void cadastrarUsuario() {
        System.out.println("=========================================================");
        System.out.println("                 📝 CADASTRO DE USUÁRIO                  ");
        System.out.println("---------------------------------------------------------");
        System.out.println("  Crie seu nome de usuário e senha para acessar o sistema");
        System.out.println("=========================================================");
        System.out.println();

        System.out.print("👤 Nome de usuário: ");
        String username = scanner.nextLine();

        System.out.print("🔑 Senha: ");
        String senha = scanner.nextLine();

        usuarioController.cadastrarUsuario(username, senha);
        System.out.println("\n✅ Usuário cadastrado com sucesso!\n");
    }

    private static void menuUsuarios() {
        System.out.println("==========================================================");
        System.out.println("                   🔐 GESTÃO DE USUÁRIOS                  ");
        System.out.println("----------------------------------------------------------");
        System.out.println(" ➕ [1] Cadastrar Usuário");
        System.out.println(" 📑 [2] Listar Usuários");
        System.out.println("----------------------------------------------------------");
        System.out.println(" 🔙 [0] Voltar ao Menu Principal");
        System.out.println("==========================================================");
        System.out.print(" 🔸 Escolha uma opção: ");

        String opcao = scanner.nextLine();

        switch (opcao) {
            case "1":
                cadastrarUsuario();
                break;
            case "2":
                usuarioController.listarUsuarios();
                break;
            case "0":
                menuPrincipal();
                break;
            default:
                System.out.println("\n❌ Opção inválida! Tente novamente.\n");
        }
    }
}
