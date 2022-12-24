/**
 * Copyright (C) <2020>  <name of year>

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package controller;

import dao.DaoTblEstoque;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ModelEstoque;
import model.ModelProduto;
import model.ModelUsuario;

/**
 * CLASSE QUE FAZ O INTERMEDIO ENTRE A VIEW E O MODEL; ONDE CONTROLA OS ACESSOS
 * A DADOS E VALIDAÇÕES DO SISTEMA DENTRO DE UM CONTEXTO;
 *
 * @author SAMUE
 */
public class ControllerTblEstoque {

    private ModelProduto produto;
    private List<ModelProduto> listaProdutos;
    private DaoTblEstoque daoEstoque;
    private List<ModelEstoque> listaEstoque;

    /**
     * Metodo que faz o controle e verificações para poder acessar os dados do
     * banco de dados relacionados aos produtos;
     *
     * @return
     */
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

    /**
     * metodo que faz o controle e validação de dados para poder mandar para a 3
     * camada dao para add na tabela;
     * Metodo que verifica se a movimentação de estoque e valida
     *
     * @param novoModEstoque
     * @return
     */
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

    /**
     * Metodo que faz a validação e verifica se pode mostrar todas as
     * movimentações de estoque relacionado a um usuario;
     *
     * @param userLogado
     * @return list objetos de tipo model estoque
     */
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
    
    /**
     * Metodo que faz as verificações necessarias, antes de fazer a contagem de uma operação;
     * verifica se os idds são corretos, e se as infomações passadas por usuario são validas;
     * @param idProduto
     * @param tipoMovimentacao
     * @return 
     */
    public Integer controllerContaMovimentacao(int idProduto,int tipoMovimentacao) {
      int quantidadeProdutoMovimentacao = -1;
      if((idProduto > -1 && idProduto != 0) && (tipoMovimentacao > -1 && tipoMovimentacao <= 1)) {
          this.daoEstoque = new DaoTblEstoque();
             try {
                    quantidadeProdutoMovimentacao = this.daoEstoque.daoContaMovimentacao(tipoMovimentacao, idProduto);
                    return quantidadeProdutoMovimentacao;
             } catch (SQLException e) {
                 System.out.println("ocorreu um erro no metodo: controlerContaMovimentacao: " + e);
                 return -1;
             }
      }else{
           return -1;
      }      
    }
    
    /**
     * metdo que faz verificações antes de retornas todas as movimentações de estoque efetuadas por todos os usuarios
     * @return uma list com todos os obejtos estoque com suas moviemntações
     */
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
    
    /**
     * metodo que faz verificações antes de buscar um produto cadastrado no sistema
     * @param idProduto
     * @return 
     */
    public ModelProduto controlerGetDetalhesProduto(int idProduto) {
       if(idProduto > -1 && idProduto != 0) {
          this.daoEstoque = new DaoTblEstoque();
          this.produto = new ModelProduto();
           try {
                this.produto = this.daoEstoque.daoGetDetalhesProduto(idProduto);
               return this.produto;
           } catch (SQLException e) {
                    System.out.println("Ocorreu um erro no metodo controlerGetDetalhesProduto: " + e);
                    return null;
           }
       }else{
            return null;
       }
    }
    
    /**
        * Metodo que faz verificações antes de buscar um usuario no sistema
        * @param idUsuario
        * @return 
        */
       public ModelUsuario controlerGetUsuario(int idUsuario) {
           if(idUsuario > -1 && idUsuario != 0) {
                ControllerUsuario controlaUsuario = new ControllerUsuario();
               ModelUsuario user = controlaUsuario.controlerBuscaUsuario(idUsuario);
                return user;
           }else{
               return null;
           }
       }
}
