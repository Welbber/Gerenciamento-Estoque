/**
 * Copyright (C) <2020>  <name of Samuel Amaro>

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

import dao.DaoTblProduto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ModelProduto;

/**
 * CLASSE QUE FAZ O INTERMEDIO ENTRE A VIEW E O MODEL;
 * ONDE CONTROLA OS ACESSOS A DADOS E VALIDAÇÕES DO SISTEMA DE UM CONTEXTO;
 * AQUI NO CASO E DA TABELA tbl_produtos;
 * @author SAMUE
 */
public class ControllerTblProduto {

   static DaoTblProduto daoProduto;
   static ModelProduto produto;
   static List<ModelProduto> listaProdutos;
   
   /**
    * Metodo que faz o controle de acesso a camada daoTblProduto, para acessar dados, ou inserir, na TBL_PRODUTO do banco de dados;
    * @param novoProduto
    * @return true(se cadastrou) false(erro no cadastro)
    */
   public boolean controllerCadastraProduto(ModelProduto novoProduto) {
       try {
           if(novoProduto.getDescricaoProduto().isEmpty() || novoProduto.getValorProduto() == 0) {
              return false; 
           }else{
                daoProduto = new DaoTblProduto();
                return daoProduto.daoCadastraProduto(novoProduto);
           }
       } catch (SQLException e) {
                System.out.println("OCORREU UM ERRO AO CADASTRA UM NOVO PRODUTO\n METODO: daoCadastraProduto\n erro: " + e);
                return false;
       }
   }
   
   /**
    * Metodo que controla o acesso aos produtos cadastrados na tabela TBL_PRODUTO do banco de dados;
    * @return ListModelProduto(se existir)
    */
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
   /**
    * Metodo que controla a entrada e saida ao metodo daoGetProduto;
    * Metodo que busca um produto no banco de dados, atraves de seu id, correspodente na tbl_produto;
    * @param codigoProduto
    * @return ModelProduto se existir
    */
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
    /**
     * Metdo que faz o controle de atualização de um produto na tbl_produto
     * @param produto
     * @return true se atualizou false se não
     */
    public boolean controllerAtualizaProduto(ModelProduto produto) {
        try {
            daoProduto = new DaoTblProduto();
            return daoProduto.daoAtualizaProduto(produto);
        } catch (SQLException e) {
                System.out.println("OCORREU UM ERRO AO atualizar PRODUTO\n METODO: daoAtualizarProduto\n erro: " + e);
               return false;
        }
    }
    /**
     * Metodo que faz verificações antes de excluir um produto;
     * @param idProduto
     * @return 
     */
    public boolean controllerExcluirProduto(int idProduto) {
        if(idProduto > 0) {
          daoProduto = new DaoTblProduto();
          try{
              return daoProduto.daoExcluirProduto(idProduto);
          }catch(SQLException e) {
                  System.out.println("erro na exclusão de um produto : " + e);
                  return false;
          }
        }else{
             return false;
        }
    }
}
