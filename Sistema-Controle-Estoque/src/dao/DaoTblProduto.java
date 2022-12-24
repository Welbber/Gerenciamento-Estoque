package dao;

import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.ModelProduto;
import utiuls.ConexaoSqLite;
import utiuls.QueriesProperties;

public class DaoTblProduto extends ConexaoSqLite {

    private Connection conexaoBanco;
    private PreparedStatement preparaSql;
    private ResultSet resultadoSql;
    private ModelProduto produto;
    private List<ModelProduto> produtos;

    public boolean daoCadastraProduto(ModelProduto novoProduto) throws SQLException {
        String insertSql = QueriesProperties.getString("insertCadastraProduto");

        this.conexaoBanco = conectaBanco();

        this.preparaSql = this.conexaoBanco.prepareStatement(insertSql);

        this.preparaSql.setString(1, novoProduto.getDescricaoProduto());
        this.preparaSql.setDouble(2, novoProduto.getValorProduto());

        int quantidadeAdicionados = this.preparaSql.executeUpdate();

        if (quantidadeAdicionados > 0) {
            this.preparaSql.close();
            return true;
        }
        this.preparaSql.close();
        return false;
    }

    public List<ModelProduto> daoGetListaProdutos() throws SQLException {
        String selectSql = QueriesProperties.getString("selectListaProdutos");

        this.conexaoBanco = conectaBanco();

        this.preparaSql = this.conexaoBanco.prepareStatement(selectSql);

        this.resultadoSql = this.preparaSql.executeQuery();

        this.produtos = new ArrayList<>();

        while (resultadoSql.next()) {
            this.produto = new ModelProduto(this.resultadoSql.getInt(1),
                    this.resultadoSql.getString(2),
                    this.resultadoSql.getDouble(3));

            this.produtos.add(produto);
        }

        this.preparaSql.close();
        this.resultadoSql.close();

        return this.produtos;
    }

    public ModelProduto daoGetProduto(int codigoProduto) throws SQLException {
        String selectSql = QueriesProperties.getString("selectProduto");

        this.conexaoBanco = conectaBanco();

        this.preparaSql = this.conexaoBanco.prepareStatement(selectSql);
        this.preparaSql.setInt(1, codigoProduto);

        this.resultadoSql = this.preparaSql.executeQuery();

        if (this.resultadoSql.next()) {
            this.produto = new ModelProduto(this.resultadoSql.getInt(1),
                    this.resultadoSql.getString(2),
                    this.resultadoSql.getDouble(3));
            this.preparaSql.close();
            this.resultadoSql.close();
            return this.produto;
        }
        this.preparaSql.close();
        this.resultadoSql.close();
        return null;
    }

    public boolean daoAtualizaProduto(ModelProduto produto) throws SQLException {

        String updateSql = QueriesProperties.getString("atualizaProduto");

        this.conexaoBanco = conectaBanco();
        this.preparaSql = this.conexaoBanco.prepareStatement(updateSql);

        this.preparaSql.setString(1, produto.getDescricaoProduto());
        this.preparaSql.setDouble(2, produto.getValorProduto());
        this.preparaSql.setInt(3, produto.getIdProduto());

        int executou = this.preparaSql.executeUpdate();

        if (executou > 0) {
            this.preparaSql.close();
            return true;
        }
        this.preparaSql.close();
        return false;
    }

    public boolean daoExcluirProduto(int idProduto) throws SQLException {
        String sqlDelete = String.format("DELETE FROM tbl_produto WHERE pk_codigo_produto = %d;", idProduto);

        this.conexaoBanco = conectaBanco();
        this.preparaSql = this.conexaoBanco.prepareStatement(sqlDelete);

        int resultado = this.preparaSql.executeUpdate();

        return resultado > 0;
    }
}