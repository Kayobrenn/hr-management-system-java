package controller;

import model.Setor;
import service.SetorService;

import java.util.List;

import static main.Main.scanner;

public class SetorController {
    private SetorService setorService = new SetorService();

    public void cadastrarSetor(String nome, String descricao) {
        Setor setor = new Setor(nome, descricao);
        setorService.cadastrarSetor(setor);
        System.out.println("\n✅ Setor cadastrado com sucesso!\n");
    }

    public void listarSetores() {
        List<Setor> setores = setorService.listarSetores();
        if (setores.isEmpty()) {
            System.out.println("Nenhum setor cadastrado.");
        } else {
            for (Setor s : setores) {
                s.exibirDados();
            }
        }
    }

    public Setor buscarSetorPorNome(String nome) {
        return setorService.buscarPorNome(nome);
    }

    public void cadastrarOuExcluirSetor(String nome, String descricao) {
        Setor existente = setorService.buscarPorNome(nome);

        if (existente != null) {
            System.out.println("\n⚠️ O setor \"" + nome + "\" já existe.");
            System.out.print("Deseja excluir este setor? (Sim/Nâo): ");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("Sim") || resposta.equalsIgnoreCase("SIM")) {
                setorService.excluirSetor(nome);
                System.out.println("\n✅ Setor excluído com sucesso!\n");
            } else {
                System.out.println("\nOperação cancelada. Nenhuma alteração feita.\n");
            }
        } else {
            Setor setor = new Setor(nome, descricao);
            setorService.cadastrarSetor(setor);
            System.out.println("\n✅ Setor cadastrado com sucesso!\n");
        }
    }

    public boolean excluirSetor(String nomeSetor) {
        return setorService.excluirSetor(nomeSetor);
    }

}

