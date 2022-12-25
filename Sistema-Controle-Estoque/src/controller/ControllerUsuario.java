package controller;

import dao.DAOUsuario;

import java.util.List;

import model.ModelUsuario;

public class ControllerUsuario {
    private DAOUsuario user;
    private ModelUsuario usuario;

    public boolean controlerSalvarUsuario(ModelUsuario novoUsuario) {
        this.user = new DAOUsuario();
        return this.user.daoSalvarUsuario(novoUsuario);
    }

    public List<ModelUsuario> getUsuariosControler() {
        user = new DAOUsuario();
        return this.user.daoGetListaUsuario();
    }

    public boolean controlerExcluirUsuario(int codigoUser) {
        user = new DAOUsuario();
        return this.user.daoExcluirUsuario(codigoUser);
    }

    public ModelUsuario controlerBuscaUsuario(int codigoUser) {
        this.user = new DAOUsuario();
        if (this.user.daoBuscarUsuario(codigoUser) != null) {
            usuario = new ModelUsuario();
            usuario = this.user.daoBuscarUsuario(codigoUser);
            return usuario;
        } else {
            return null;
        }
    }

    public boolean controlerAlterarCadastroUsuario(ModelUsuario userAtu) {
        return this.user.daoAlterarCadastroUsuario(userAtu);
    }

    public ModelUsuario controlerAutenticarUsuarioLogin(String login, String senha) {
        this.usuario = new ModelUsuario();
        this.user = new DAOUsuario();
        this.usuario = this.user.daoAutenticarUsuario(login, senha);
        return this.usuario;
    }
}