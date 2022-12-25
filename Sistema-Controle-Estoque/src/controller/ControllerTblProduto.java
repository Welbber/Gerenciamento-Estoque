package controller;

import dao.DaoTblProduto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ModelProduto;

public class ControllerTblProduto {

    static DaoTblProduto daoProduto;
    static ModelProduto produto;
    static List<ModelProduto> listaProdutos;

    public boolean controllerCadastraProduto(ModelProduto novoProduto) {
        try {
            if (novoProduto.getDescricaoProduto().isEmpty() || novoProduto.getValorProduto() == 0) {
                return false;
            } else {
                daoProduto = new DaoTblProduto();
                return daoProduto.daoCadastraProduto(novoProduto);
            }
        } catch (SQLException e) {
            System.out.println("OCORREU UM ERRO AO CADASTRA UM NOVO PRODUTO\n METODO: daoCadastraProduto\n erro: " + e);
            return false;
        }
    }

    public List<ModelProduto> controllerGetListaProdutos() {
        try {
            listaProdutos = new ArrayList<>();
            daoProduto = new DaoTblProduto();
            produto = new ModelProduto();
            listaProdutos = daoProduto.daoGetListaProdutos();
            return listaProdutos;
        } catch (SQLException e) {
            System.out.println("OCORREU UM ERRO AO LISTAR PRODUTOS CADASTRADOS\n METODO: daoGetListaProduto\n erro: " + e);
            return null;
        }
    }

    public ModelProduto controllerGetProduto(int codigoProduto) {
        try {
            daoProduto = new DaoTblProduto();
            produto = new ModelProduto();
            produto = daoProduto.daoGetProduto(codigoProduto);
            return produto;
        } catch (SQLException e) {
            System.out.println("OCORREU UM ERRO AO BUSCAR PRODUTO ATRAVES DE SEU CODIGO ID\n METODO: daoGetProduto\n erro: " + e);
            return null;
        }
    }

    public boolean controllerAtualizaProduto(ModelProduto produto) {
        try {
            daoProduto = new DaoTblProduto();
            return daoProduto.daoAtualizaProduto(produto);
        } catch (SQLException e) {
            System.out.println("OCORREU UM ERRO AO atualizar PRODUTO\n METODO: daoAtualizarProduto\n erro: " + e);
            return false;
        }
    }

    public boolean controllerExcluirProduto(int idProduto) {
        if (idProduto > 0) {
            daoProduto = new DaoTblProduto();
            try {
                return daoProduto.daoExcluirProduto(idProduto);
            } catch (SQLException e) {
                System.out.println("erro na exclusão de um produto : " + e);
                return false;
            }
        } else {
            return false;
        }
    }
}