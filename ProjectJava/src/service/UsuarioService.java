package service;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioService() {
        usuarios.add(new Usuario("admin", "123"));
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean autenticar(String username, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
}

