package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ModelEstoque;
import model.ModelProduto;
import model.ModelUsuario;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import utiuls.ConexaoSqLite;
import utiuls.QueriesProperties;


public class DaoTblEstoque extends ConexaoSqLite {

    private Connection conexaoBanco;
    private PreparedStatement preparaSql;
    private ResultSet resultadoSql;
    private ModelProduto produto;
    private ModelEstoque estoque;
    private List<ModelEstoque> listaEstoque;

    public List<ModelProduto> daoGetDescricaoProdutos() throws SQLException {

        String sqlSelectProdutos = "SELECT * FROM tbl_produto;";

        conexaoBanco = conectaBanco();

        preparaSql = conexaoBanco.prepareStatement(sqlSelectProdutos);
        resultadoSql = preparaSql.executeQuery();

        List<ModelProduto> listaProdutos = new ArrayList<>();

        while (resultadoSql.next()) {
            this.produto = new ModelProduto(resultadoSql.getInt(1),
                    this.resultadoSql.getString(2),
                    this.resultadoSql.getDouble(3));

            listaProdutos.add(produto);
        }
        this.conexaoBanco.close();
        this.resultadoSql.close();
        return listaProdutos;
    }

    public boolean daoSetEstoque(ModelEstoque novoMovEstoque) throws SQLException {

        String dmlInsert = QueriesProperties.getString("dqlAno");

        this.conexaoBanco = conectaBanco();
        this.preparaSql = conexaoBanco.prepareStatement(dmlInsert);

        this.preparaSql.setInt(1, novoMovEstoque.getQuantidade());
        this.preparaSql.setDouble(2, novoMovEstoque.getPreco());
        this.preparaSql.setInt(3, novoMovEstoque.getTipo_movimentacao());
        this.preparaSql.setInt(4, novoMovEstoque.getFk_usuario());
        this.preparaSql.setInt(5, novoMovEstoque.getFk_produto());

        int confirmaAdd = this.preparaSql.executeUpdate();

        if (confirmaAdd > 0) {
            this.conexaoBanco.close();
            return true;
        }
        return false;
    }


    public List<ModelEstoque> daoGetEstoques(ModelUsuario usuarioLogado) throws SQLException {

        String dmlSelect = QueriesProperties.getString("dmlSelect");

        this.conexaoBanco = conectaBanco();
        this.preparaSql = this.conexaoBanco.prepareStatement(dmlSelect);

        this.preparaSql.setInt(1, usuarioLogado.getCodigoId());

        this.resultadoSql = this.preparaSql.executeQuery();

        this.listaEstoque = new ArrayList<>();
        while (resultadoSql.next()) {
            this.estoque = new ModelEstoque(this.resultadoSql.getInt(1),
                    this.resultadoSql.getInt(2),
                    this.resultadoSql.getDouble(3),
                    this.resultadoSql.getInt(4),
                    this.resultadoSql.getString(5),
                    this.resultadoSql.getInt(6),
                    this.resultadoSql.getInt(7));

            this.listaEstoque.add(estoque);
        }
        this.preparaSql.close();
        this.resultadoSql.close();
        return this.listaEstoque;
    }

    public Integer daoContaMovimentacao(int tipoMovimentacao, int idProduto) throws SQLException {
        String dqlSelect = QueriesProperties.getString("dqlSelect");

        this.conexaoBanco = conectaBanco();

        this.preparaSql = this.conexaoBanco.prepareStatement(dqlSelect);
        this.preparaSql.setInt(1, idProduto);
        this.preparaSql.setInt(2, tipoMovimentacao);

        this.resultadoSql = this.preparaSql.executeQuery();

        if (this.resultadoSql.next()) {
            int qtProdutoMovimentacao = this.resultadoSql.getInt(1);
            this.resultadoSql.close();
            this.preparaSql.close();
            return qtProdutoMovimentacao;
        } else {
            this.resultadoSql.close();
            this.preparaSql.close();
            return -1;
        }
    }

    public List<ModelEstoque> daoGetEstoques() throws SQLException {
        String dmlSelect = QueriesProperties.getString("dmlSelectAll");

        this.conexaoBanco = conectaBanco();
        this.preparaSql = this.conexaoBanco.prepareStatement(dmlSelect);

        this.resultadoSql = this.preparaSql.executeQuery();

        this.listaEstoque = new ArrayList<>();

        while (resultadoSql.next()) {
            this.estoque = new ModelEstoque(this.resultadoSql.getInt(1),
                    this.resultadoSql.getInt(2),
                    this.resultadoSql.getDouble(3),
                    this.resultadoSql.getInt(4),
                    this.resultadoSql.getString(5),
                    this.resultadoSql.getInt(6),
                    this.resultadoSql.getInt(7));

            this.listaEstoque.add(estoque);
        }
        this.preparaSql.close();
        this.resultadoSql.close();
        return this.listaEstoque;
    }

    public ModelProduto daoGetDetalhesProduto(int idProduto) throws SQLException {

        String dqlWhere = QueriesProperties.getString("dqlWhere");

        this.conexaoBanco = conectaBanco();

        this.preparaSql = this.conexaoBanco.prepareStatement(dqlWhere);

        this.preparaSql.setInt(1, idProduto);

        this.resultadoSql = this.preparaSql.executeQuery();

        if (this.resultadoSql.next()) {
            this.produto = new ModelProduto(this.resultadoSql.getInt(1),
                    this.resultadoSql.getString(2),
                    this.resultadoSql.getDouble(3));

            this.preparaSql.close();
            this.resultadoSql.close();
            return this.produto;
        } else {
            return null;
        }
    }

    public List<ModelEstoque> daoBuscarEstoque(String filtroPesquisa, String valorFiltro) {
        this.conexaoBanco = conectaBanco();

        this.listaEstoque = new ArrayList<>();
        switch (filtroPesquisa) {
            case "ANO":
                String dqlAno = QueriesProperties.getString("dqlAno");

        }
        throw new NotImplementedException();
    }
}