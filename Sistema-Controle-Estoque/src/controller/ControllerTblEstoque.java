package controller;

import dao.DaoTblEstoque;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ModelEstoque;
import model.ModelProduto;
import model.ModelUsuario;

public class ControllerTblEstoque {

    private ModelProduto produto;
    private List<ModelProduto> listaProdutos;
    private DaoTblEstoque daoEstoque;
    private List<ModelEstoque> listaEstoque;

    public List<ModelProduto> controllerGetDescricaoProdutos() {
        try {
            this.daoEstoque = new DaoTblEstoque();
            this.listaProdutos = new ArrayList<>();
            this.listaProdutos = this.daoEstoque.daoGetDescricaoProdutos();
            return this.listaProdutos;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar DESCRIÇÃO PRODUTOS NO METODO controllerGetDescriçãoProduto()" + e);
            return null;
        }
    }

    public boolean controllerAddMovEstoque(ModelEstoque novoModEstoque) {
        switch (novoModEstoque.getTipo_movimentacao()) {
            case 0:
                if (novoModEstoque.getFk_produto() >= 0 && novoModEstoque.getQuantidade() > 0 && novoModEstoque.getPreco() != 0.0 && novoModEstoque.getFk_usuario() >= 0) {
                    try {
                        this.daoEstoque = new DaoTblEstoque();
                        if (this.daoEstoque.daoSetEstoque(novoModEstoque)) {
                            return true;
                        }
                    } catch (SQLException ex) {
                        System.out.println("Ocorreu um erro no metodo controlerAddMovEstoque ao adiconar uma nova movimentação de entrada no estoque \n " + ex);
                        return false;
                    }
                    break;
                }
            case 1:
                if (novoModEstoque.getFk_produto() >= 0 && novoModEstoque.getQuantidade() > 0 && novoModEstoque.getPreco() != 0.0 && novoModEstoque.getFk_usuario() >= 0) {
                    try {
                        this.daoEstoque = new DaoTblEstoque();
                        if (this.daoEstoque.daoSetEstoque(novoModEstoque)) {
                            return true;
                        }
                    } catch (SQLException ex) {
                        System.out.println("Ocorreu um erro no metodo controlerAddMovEstoque ao adiconar uma nova movimentação de saida no estoque \n " + ex);
                        return false;
                    }
                } else {
                    return false;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    public List<ModelEstoque> controlerGetEstoques(ModelUsuario userLogado) {
        this.daoEstoque = new DaoTblEstoque();
        this.listaEstoque = new ArrayList<>();
        try {
            this.listaEstoque = this.daoEstoque.daoGetEstoques(userLogado);
            return this.listaEstoque;
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar lista de estoque e movimentações de estoque do usuario logado no metodo controlerGetEstoques: " + ex);
            return null;
        }
    }

    public Integer controllerContaMovimentacao(int idProduto, int tipoMovimentacao) {
        int quantidadeProdutoMovimentacao = -1;
        if ((idProduto > -1 && idProduto != 0) && (tipoMovimentacao > -1 && tipoMovimentacao <= 1)) {
            this.daoEstoque = new DaoTblEstoque();
            try {
                quantidadeProdutoMovimentacao = this.daoEstoque.daoContaMovimentacao(tipoMovimentacao, idProduto);
                return quantidadeProdutoMovimentacao;
            } catch (SQLException e) {
                System.out.println("ocorreu um erro no metodo: controlerContaMovimentacao: " + e);
                return -1;
            }
        } else {
            return -1;
        }
    }

    public List<ModelEstoque> controllerGetEstoques() {
        this.listaEstoque = new ArrayList<>();
        this.daoEstoque = new DaoTblEstoque();
        try {
            this.listaEstoque = this.daoEstoque.daoGetEstoques();
            return this.listaEstoque;
        } catch (SQLException e) {
            System.out.println("Metodo controlerGetEstoques: ocorreu um erro: " + e);
            return null;
        }
    }

    public ModelProduto controlerGetDetalhesProduto(int idProduto) {
        if (idProduto > -1 && idProduto != 0) {
            this.daoEstoque = new DaoTblEstoque();
            this.produto = new ModelProduto();
            try {
                this.produto = this.daoEstoque.daoGetDetalhesProduto(idProduto);
                return this.produto;
            } catch (SQLException e) {
                System.out.println("Ocorreu um erro no metodo controlerGetDetalhesProduto: " + e);
                return null;
            }
        } else {
            return null;
        }
    }

    public ModelUsuario controlerGetUsuario(int idUsuario) {
        if (idUsuario > -1 && idUsuario != 0) {
            ControllerUsuario controlaUsuario = new ControllerUsuario();
            ModelUsuario user = controlaUsuario.controlerBuscaUsuario(idUsuario);
            return user;
        } else {
            return null;
        }
    }
}