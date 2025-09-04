package service;

import model.Funcionario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FuncionarioService {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    public boolean excluirFuncionario(String cpf) {
        Iterator<Funcionario> iterator = funcionarios.iterator();
        while (iterator.hasNext()) {
            Funcionario f = iterator.next();
            if (f.getCpf().equalsIgnoreCase(cpf)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}

