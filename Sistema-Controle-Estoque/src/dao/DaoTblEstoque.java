package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.time.Instant.now;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.ModelEstoque;
import model.ModelProduto;
import model.ModelUsuario;
import utiuls.ConexaoSqLite;

/**
 * Classe onde concentra toda entrada e saida de dados para o banco de dados;
 *
 * @author SAMUE
 */
public class DaoTblEstoque extends ConexaoSqLite {

    //variaveis necessarias
    private Connection conexaoBanco;
    private PreparedStatement preparaSql;
    private ResultSet resultadoSql;
    private ModelProduto produto;
    private ModelEstoque estoque;
    private List<ModelProduto> listaProdutos;
    private List<ModelEstoque> listaEstoque;

    /**
     * Metodo que vai trazer a descrição de todos os produtos;
     *
     * @return list de tipo obejto produto
     * @throws java.sql.SQLException quem chama o metodo trata o erro de sql
     */
    public List<ModelProduto> daoGetDescricaoProdutos() throws SQLException {
        String sqlSelectProdutos = "SELECT * FROM tbl_produto;";
        conexaoBanco = conectaBanco();
        preparaSql = conexaoBanco.prepareStatement(sqlSelectProdutos);
        resultadoSql = preparaSql.executeQuery();
        //armazena descrições do produto um array de tipo obejto produto
        this.listaProdutos = new ArrayList<>();
        //sei que vai trazer varias linhas do banco de dados por isso tem que iterar
        while (resultadoSql.next()) {
            this.produto = new ModelProduto();
            //popula objeto com a linha do banco de dados
            this.produto.setIdProduto(resultadoSql.getInt(1));
            this.produto.setDescricaoProduto(this.resultadoSql.getString(2));
            this.produto.setValorProduto(this.resultadoSql.getDouble(3));
            //add objeto populado na list
            this.listaProdutos.add(produto);
        }
        this.conexaoBanco.close();
        this.resultadoSql.close();
        return this.listaProdutos;
    }

    /**
     * Metodo que vai inserir uma nova movimentação no estoque;
     *
     * @param novoMovEstoque
     * @return true se add a mov false se não add
     * @throws java.sql.SQLException
     */
    public boolean daoSetEstoque(ModelEstoque novoMovEstoque) throws SQLException {
        String dmlInsert = "INSERT INTO tbl_estoque(quantidade_estoque,"
                + "preco_estoque,"
                + "tipo_movimentacao_estoque,"
                + "data_estoque,"
                + "fk_usuario,"
                + "fk_produto)"
                + " VALUES(?,?,?,CURRENT_DATE,?,?);";
        //FAZENDO CONEXÃO COM O BANCO
        this.conexaoBanco = conectaBanco();
        this.preparaSql = conexaoBanco.prepareStatement(dmlInsert);
        //setando valores no comando sql insert
        this.preparaSql.setInt(1, novoMovEstoque.getQuantidade());
        this.preparaSql.setDouble(2, novoMovEstoque.getPreco());
        this.preparaSql.setInt(3, novoMovEstoque.getTipo_movimentacao());
        this.preparaSql.setInt(4, novoMovEstoque.getFk_usuario());
        this.preparaSql.setInt(5, novoMovEstoque.getFk_produto());
        int confirmaAdd = this.preparaSql.executeUpdate();
        //verificando se add a mov na tabela
        if (confirmaAdd > 0) {
            //add uma linha no banco de dados
            this.conexaoBanco.close();
            return true;
        } else {
            return false;
        }
    }

    /**
     * metodo que vai trazer todas as movimentações de estoque do usuario logado
     *
     * @param usuarioLogado objeto que traz informações do usuario logado no
     * sistema
     * @return
     * @throws java.sql.SQLException
     */
    public List<ModelEstoque> daoGetEstoques(ModelUsuario usuarioLogado) throws SQLException {
       String dmlSelect = "SELECT pk_codigo_estoque,"
               + "quantidade_estoque,"
               + "preco_estoque,"
               + "tipo_movimentacao_estoque,"
               + "data_estoque,"
               + "fk_usuario,"
               + "fk_produto "
               + "FROM tbl_estoque "
               + "WHERE pk_codigo_estoque = ?;";
       this.conexaoBanco = conectaBanco();
       this.preparaSql = this.conexaoBanco.prepareStatement(dmlSelect);
       //aplicando um filtro para trazer movimentações de estoque so do usuario logado no sistema
       this.preparaSql.setInt(1,usuarioLogado.getCodigoId());
       //executa consulta
       this.resultadoSql = this.preparaSql.executeQuery();
       //enquanto tiver linhas do banco de dados com dados vai iterar sobre o resultSet
       this.listaEstoque = new ArrayList<ModelEstoque>();
       while(this.resultadoSql.next()) {
            this.estoque = new ModelEstoque();
            this.estoque.setId_pk(this.resultadoSql.getInt(1));
            this.estoque.setQuantidade(this.resultadoSql.getInt(2));
            this.estoque.setPreco(this.resultadoSql.getDouble(3));
            this.estoque.setDataMovimentacao(this.resultadoSql.getDate(4));
            this.estoque.setFk_usuario(this.resultadoSql.getInt(5));
            this.estoque.setFk_produto(this.resultadoSql.getInt(6));
            this.listaEstoque.add(estoque);
       }
       this.preparaSql.close();
       this.resultadoSql.close();
       return this.listaEstoque;
    }
}
