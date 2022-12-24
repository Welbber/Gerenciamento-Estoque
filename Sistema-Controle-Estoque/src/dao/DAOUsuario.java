package dao;

import utiuls.ConexaoSqLite;
import model.ModelUsuario;
import utiuls.Encriptografia;
import utiuls.QueriesProperties;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuario extends ConexaoSqLite {

    PreparedStatement ps;

    Connection con;

    ResultSet rs;
    ModelUsuario user;

    public DAOUsuario() {
        this.user = new ModelUsuario();
    }

    public boolean daoSalvarUsuario(ModelUsuario novoUsuario) {

        String sql = QueriesProperties.getString("insertUsuario");

        try {

            con = conectaBanco();

            ps = con.prepareStatement(sql);

            ps.setString(1, novoUsuario.getNome());
            ps.setString(2, novoUsuario.getLogin());
            ps.setString(3, novoUsuario.getSenha());
            int adicionado = ps.executeUpdate();

            if (adicionado > 0) {

                ps.close();
                con.close();
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.out.println("Erro ao salvar Usuario no banco de dados\n daoSalvarUsuario: " + e);
            return false;
        }
    }

    public List<ModelUsuario> daoGetListaUsuario() {

        List<ModelUsuario> listaUsuarios = new ArrayList<>();

        String sql = "SELECT * FROM tbl_usuario";
        try {
            con = conectaBanco();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                user = new ModelUsuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));

                listaUsuarios.add(user);
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Não foi possivel, busca a lista de usuarios no banco\n daoGetListaUsuario: " + e);
            return null;
        }
        return listaUsuarios;
    }

    public boolean daoExcluirUsuario(int codigoUser) {
        String sqlDelete = String.format("DELETE FROM tbl_usuario WHERE pk_codigo_usuario = %d;", codigoUser);

        try {
            con = conectaBanco();
            ps = con.prepareStatement(sqlDelete);

            int resultadoSql = ps.executeUpdate();
            if (resultadoSql > 0) {
                ps.close();
                con.close();
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.out.println("Erro ao Excluir Usuario do banco de dados, DaoExcluirUsuario: " + e);
            return false;
        }
    }

    public ModelUsuario daoBuscarUsuario(int codigoUser) {
        String sqlSelect = QueriesProperties.getString("selectUsuario");

        try {
            con = conectaBanco();
            ps = con.prepareStatement(sqlSelect);
            ps.setInt(1, codigoUser);
            rs = ps.executeQuery();

            if (rs.next()) {
                this.user = new ModelUsuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                ps.close();
                con.close();
                return user;
            }

            return null;

        } catch (SQLException e) {
            System.out.println("Erro ao Buscar Usuario do banco de dados, daoBuscarUsuario:\n" + e);
            return null;
        }
    }

    public boolean daoAlterarCadastroUsuario(ModelUsuario user) {
        String sqlUpdate = QueriesProperties.getString("updateUsuario");

        try {
            con = conectaBanco();
            ps = con.prepareStatement(sqlUpdate);

            ps.setString(1, user.getNome());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getSenha());
            ps.setInt(4, user.getCodigoId());

            int resultSql = ps.executeUpdate();

            if (resultSql > 0) {
                ps.close();
                con.close();
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.out.println("Atualização de Cadastro de um usuario Falhou\n daoAlterarCadastroUsuario: \n" + e);
        }
        return false;
    }

    public ModelUsuario daoAutenticarUsuario(String login, String senha) {
        String sqlSelect = QueriesProperties.getString("autenticarUsuario");
        try {
            con = conectaBanco();

            ps = con.prepareStatement(sqlSelect);
            ps.setString(1, login);
            ps.setString(2, Encriptografia.encriptografa(senha));

            rs = ps.executeQuery();

            if (rs.next()) {
                this.user = new ModelUsuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
                ps.close();
                con.close();
                return this.user;
            }

            return null;

        } catch (SQLException e) {
            System.out.println("Autenticação de Usuario Falhou\n daoAutenticarUsuario: \n" + e);
            return null;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Autenticação de Usuario Falhou\n daoAutenticarUsuario: \n" + e);
            throw new RuntimeException(e);
        }
    }
}
