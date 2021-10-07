package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Fabrica {

    private static Connection conexaoSINGLETON;
    private static final String usuario = "root";
    private static final String senha = "root";
    private static final String servidor = "localhost";
    private static final String porta = "3306";
    private static final String bd = "aulaRevisao?useTimezone=true&serverTimezone=UTC";
    private static final String urlconexao = "jdbc:mysql://" + servidor + ":" + porta + "/" + bd;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static Connection abrirConexao() {
        Connection conexao = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(urlconexao, usuario, senha);
            System.out.println("Conexão efetuada com sucesso!!!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro ao carregar driver de conexão\n" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro conectar no banco de dados\n" + ex.getMessage());
        }
        return conexao;
    }

    public static Connection getConexaoSINGLETON() {
        if (conexaoSINGLETON == null) {
            conexaoSINGLETON = abrirConexao();
        }
        return conexaoSINGLETON;
    }

    public static Connection getConexaoNOVA() {
        Connection conexao = null;
        try {
            conexao = abrirConexao();
            conexao.setAutoCommit(false);
            conexao.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return conexao;
    }
}
