package controller;

import model.Usuario;
import service.UsuarioService;

public class UsuarioController {
    private UsuarioService usuarioService = new UsuarioService();

    public boolean login(String username, String senha) {
        return usuarioService.autenticar(username, senha);
    }

    public void cadastrarUsuario(String username, String senha) {
        Usuario usuario = new Usuario(username, senha);
        usuarioService.cadastrarUsuario(usuario);
    }

    public void listarUsuarios() {
        for (Usuario u : usuarioService.listarUsuarios()) {
            System.out.println("=========================================================");
            System.out.println("                 👥 DADOS DO USUÁRIO                     ");
            System.out.println("=========================================================");
            System.out.println("👤 Usuário: " + u.getUsername());
            System.out.println("🔒 Senha  : " + u.getSenha());
            System.out.println("=========================================================\n");
        }
    }
}

