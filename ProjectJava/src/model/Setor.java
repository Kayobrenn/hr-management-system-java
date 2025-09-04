package model;

import model.interfaces.Cadastravel;

public class Setor implements Cadastravel {
    private String nome;
    private String descricao;

    public Setor(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void exibirDados() {
        System.out.println("=========================================================");
        System.out.println("                    🏢 DADOS DO SETOR                 ");
        System.out.println("=========================================================");
        System.out.println("Nome do Setor    : " + nome);
        System.out.println("Descrição        : " + descricao);
        System.out.println("=========================================================\n");
    }

}

