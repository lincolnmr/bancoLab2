package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Conta;

public class DAOconta {

    public static void insert(Conta obj) {
        Connection conexao = Fabrica.getConexaoSINGLETON();
        insert(obj, conexao);
    }
    
    public static void insert(Conta obj, Connection conexao) {
     
        try {
            PreparedStatement sql = conexao.prepareStatement( 
                            "INSERT INTO "
                                + "TBL_CONTA (codigo_conta, numero_conta , agencia_conta, saldo_conta)"
                                + "VALUES (?,?,?,?)");
            sql.setInt(1, obj.getCodigoConta());
            sql.setString(2, obj.getNumeroConta());
            sql.setString(3, obj.getAgenciaConta());
            sql.setDouble(4, obj.getSaldoConta());

            sql.execute();
            System.out.println("Inserido \n");
        } catch (SQLException ex) {
            System.out.println("Não inserido no DAO - erro: \\n" + ex.getMessage());
        }
    }

    public static void update(Conta obj) {
        Connection conexao = Fabrica.getConexaoSINGLETON();
        update(obj, conexao);
    }
    
    public static void update(Conta obj, Connection conexao) {

       try {
            PreparedStatement sql = conexao.prepareStatement("UPDATE TBL_CONTA SET numero_conta = ?, agencia_conta = ?, saldo_conta = ? WHERE codigo_conta = ?");

            sql.setString(1, obj.getNumeroConta());
            sql.setString(2, obj.getAgenciaConta());
            sql.setDouble(3, obj.getSaldoConta());
            sql.setInt(4, obj.getCodigoConta());
            
            sql.executeUpdate();
            sql.close();

            System.out.println("Atualizado \n");
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar conta - DAO \n" + ex.getMessage());
        }
    }

    public static boolean excluir(int codigoConta) {
        Connection conexao = Fabrica.getConexaoSINGLETON();
        return excluir(codigoConta, conexao);   
    }
    
    public static boolean excluir(int codigoConta, Connection conexao) {
        
        String sql = "DELETE FROM TBL_CONTA WHERE codigo_conta = ?";

        try {
            PreparedStatement ST = (PreparedStatement) conexao.prepareStatement(sql);

            ST.setInt(1, codigoConta);
            ST.execute();

            System.out.println("Excluido");
            return true;
        } catch (SQLException err) {
            System.err.println("Erro ao excluir - DAO: " + err.getMessage());
        }
        return false;
    }
    
    public static Conta recuperar(int codigoConta) {
        Connection conexao = Fabrica.getConexaoSINGLETON();
        return recuperar(codigoConta, conexao);
    }
    
    public static Conta recuperar(int codigoConta, Connection conexao) {

        String sql = "SELECT * FROM TBL_CONTA WHERE codigo_conta  = ?";
        Conta obj = null;
        
        try {
            PreparedStatement ST = conexao.prepareStatement(sql);
            ST.setInt(1, codigoConta);
            
            ResultSet objResultSet = ST.executeQuery();
            objResultSet.next();
            
            obj = new Conta();
            obj.setCodigoConta(objResultSet.getInt("codigo_conta"));
            obj.setNumeroConta(objResultSet.getString("numero_conta"));
            obj.setAgenciaConta(objResultSet.getString("agencia_conta"));
            obj.setSaldoConta(objResultSet.getDouble("saldo_conta"));

        } catch (Exception e) {
            System.err.println("Erro ao recuperar - DAO" + e.getMessage());
        }
        return obj;
    }
    
    public static ArrayList<Conta> recuperarTodos(Connection conexao) {

        String sql = "SELECT codigo_conta, numero_conta, agencia_conta, saldo_conta FROM TBL_CONTA";
        Conta obj = null;
        ArrayList<Conta> lista = new ArrayList<>();

        try {

            PreparedStatement ST = (PreparedStatement) conexao.prepareStatement(sql);

            ResultSet objResultSet = ST.executeQuery();

            while(objResultSet.next()) {

                obj = new Conta();
                obj.setCodigoConta(objResultSet.getInt("codigo_conta"));
                obj.setNumeroConta(objResultSet.getString("numero_conta"));
                obj.setAgenciaConta(objResultSet.getString("agencia_conta"));
                obj.setSaldoConta(objResultSet.getDouble("saldo_conta"));

                lista.add(obj);
            }
            return lista;

        } catch (SQLException ex) {
            System.out.println("Erro ao recuperar todos - DAO \n" + ex.getMessage());
        }
        return null;
    }
    
    public static boolean verificar(int codigoConta) {
        Connection conexao = Fabrica.getConexaoSINGLETON();
        String sql = "SELECT * FROM TBL_CONTA WHERE codigo_conta  = ?";
            
        try {
            PreparedStatement ST = conexao.prepareStatement(sql);
            ST.setInt(1, codigoConta);
            ResultSet objResultSet = ST.executeQuery();
            if(!objResultSet.next()) return false;
            
        } catch (Exception e) {
            System.err.println("Erro ao verificar - DAO" + e.getMessage());
        }
        return true;
    }
}
