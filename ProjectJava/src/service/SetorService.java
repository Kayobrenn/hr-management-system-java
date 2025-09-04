package service;

import model.Setor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SetorService {
    private List<Setor> setores = new ArrayList<>();

    public void cadastrarSetor(Setor setor) {
        setores.add(setor);
    }

    public List<Setor> listarSetores() {
        return setores;
    }

    public Setor buscarPorNome(String nome) {
        for (Setor setor : setores) {
            if (setor.getNome().equalsIgnoreCase(nome)) {
                return setor;
            }
        }
        return null;
    }

    public boolean excluirSetor(String nomeSetor) {
        Iterator<Setor> iterator = setores.iterator();
        while (iterator.hasNext()) {
            Setor setor = iterator.next();
            if (setor.getNome().equalsIgnoreCase(nomeSetor)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}

