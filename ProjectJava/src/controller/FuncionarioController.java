package controller;

import enums.Sexo;
import model.Funcionario;
import model.Setor;
import service.FuncionarioService;
import java.util.List;

public class FuncionarioController {
    private FuncionarioService funcionarioService = new FuncionarioService();

    public void cadastrarFuncionario(String nome, String cpf, String rg, int idade, String dataNascimento,
                                     String email, String telefone, Sexo sexo,
                                     Setor setor, String cargo, String dataAdmissao,
                                     String salario, String tipoPagamento, String estadoCivil) {
        if (setor == null) {
            System.out.println("Setor inválido. Cadastro não realizado.");
            return;
        }

        Funcionario funcionario = new Funcionario(nome, cpf, rg, idade, dataNascimento, email, telefone, sexo, setor,
                                                    cargo, dataAdmissao, salario, tipoPagamento, estadoCivil);
        funcionarioService.cadastrarFuncionario(funcionario);
        System.out.println("\n✅ Funcionário cadastrado com sucesso!\n");
    }

    public void listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario f : funcionarios) {
                f.exibirDados();
            }
        }
    }

    public boolean excluirFuncionario(String cpf) {
        return funcionarioService.excluirFuncionario(cpf);
    }

}

