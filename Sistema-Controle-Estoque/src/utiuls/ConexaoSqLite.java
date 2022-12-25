package utiuls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSqLite {

    public static Connection conectaBanco() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:src/resources/gerenciamento.db";

             return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Conexão Não Estabelicida com o banco " + e);
            return null; 
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
