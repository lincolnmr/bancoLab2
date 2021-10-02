package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import model.Extrato;

public class DAOextrato {

    public static void insert(Extrato obj) {
        Connection conexao = Fabrica.getConexaoSINGLETON();
        insert(obj, conexao);
    }
    
    public static void insert(Extrato obj, Connection conexao) {
        
        try {
            PreparedStatement sql = conexao.prepareStatement( 
                    "INSERT INTO "
                        + "TBL_EXTRATO (codigoExtrato_extrato, descricao_extrato , data_extrato, tipo_extrato, valor_extrato, extrato_codigoExtrato_conta) "
                        + "VALUES (?,?,?,?,?,?)");
            
            sql.setInt(1, obj.getCodigoExtrato());
            sql.setString(2, obj.getDescricaoExtrato());
            sql.setTimestamp(3, new Timestamp(obj.getDataExtrato().getTimeInMillis()));
            sql.setString(4, obj.getTipoExtrato());
            sql.setDouble(5, obj.getValorExtrato());
            sql.setInt(6, obj.getExtratoCodigoConta());
            
            sql.execute();
            System.out.println("Inserido \n");
        } catch (SQLException ex) {
            System.out.println("Não inserido - erro - DAO: \\n" + ex.getMessage());
        }
    }

    public static void update(Extrato obj) {
        Connection conexao = Fabrica.getConexaoSINGLETON();
        update(obj, conexao);
    }
    
    public static void update(Extrato obj, Connection conexao) {

        try {
            String sqlUpdate = "UPDATE "
                                + "TBL_EXTRATO "
                             + "SET "
                                + "descricao_extrato = ?, "
                                + "data_extrato = ?, "
                                + "tipo_extrato = ?, "
                                + "valor_extrato = ?, "
                                + "extrato_codigoExtrato_conta = ? "
                             + "WHERE "
                                + "codigoExtrato_extrato = ?";

            PreparedStatement sql = conexao.prepareStatement(sqlUpdate);

            sql.setString(1, obj.getDescricaoExtrato());
            sql.setTimestamp(2, new Timestamp(obj.getDataExtrato().getTimeInMillis()));
            sql.setString(3, obj.getTipoExtrato());
            sql.setDouble(4, obj.getValorExtrato());
            sql.setInt(5, obj.getExtratoCodigoConta());
            sql.setInt(6, obj.getCodigoExtrato());
            
            sql.executeUpdate();
            sql.close();

            System.out.println("Atualizado \n");
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar extrato - DAO \n" + ex.getMessage());
        }
    }

    public static boolean excluir(int codigoExtrato) { 
        Connection conexao = Fabrica.getConexaoSINGLETON();
        return excluir(codigoExtrato, conexao);
    }
    
    public static boolean excluir(int codigoExtrato, Connection conexao) {
        
        String sql = "DELETE FROM TBL_EXTRATO WHERE codigo_extrato = ?";

        try {
            PreparedStatement ST = (PreparedStatement) conexao.prepareStatement(sql);
            ST.setInt(1, codigoExtrato);
            ST.execute();
            System.out.println("Excluido");
            return true;
        } catch (SQLException err) {
            System.out.println("Erro ao excluir - DAO: " + err.getMessage());
        }
        return false;
    }
    
    public static Extrato recuperar(int codigoExtrato) {
        Connection conexao = Fabrica.getConexaoSINGLETON();
        return recuperar(codigoExtrato, conexao);
    }
    
    public static Extrato recuperar(int codigoExtrato, Connection conexao) {

        String sql = "SELECT * FROM TBL_EXTRATO where codigo_extrato  = ?";
        Extrato obj = null;

        try {
            PreparedStatement ST = conexao.prepareStatement(sql);
            ST.setInt(1, codigoExtrato);
            ResultSet objResultSet = ST.executeQuery();     
            objResultSet.next();
            
            obj = new Extrato();
            obj.setCodigoExtrato(objResultSet.getInt("codigo_extrato"));
            obj.setDescricaoExtrato(objResultSet.getString("descricao_extrato"));
            obj.getDataExtrato().setTime(objResultSet.getDate("data_extrato"));
            obj.setTipoExtrato(objResultSet.getString("tipo_extrato"));
            obj.setValorExtrato(objResultSet.getDouble("valor_extrato"));
            obj.setExtratoCodigoConta(objResultSet.getInt("extrato_codigo_conta"));
       
        } catch (Exception e) {
            System.err.println("Erro ao recuperar" + e.getMessage());
        }
        return obj;
    }
    
    public static ArrayList<Extrato> recuperarTodos(Connection conexao) {

        String sql = "SELECT codigoExtrato_extrato, descricao_extrato , data_extrato, "
                        + "tipo_extrato, valor_extrato, extrato_codigoExtrato_conta "
                    + "FROM TBL_EXTRATO";
        Extrato obj = null;
        ArrayList<Extrato> lista = new ArrayList<>();

        try {
            PreparedStatement ST = (PreparedStatement) conexao.prepareStatement(sql);
            ResultSet objResultSet = ST.executeQuery();

            while(objResultSet.next()) {

                obj = new Extrato();
                obj.setCodigoExtrato(objResultSet.getInt("codigo_extrato"));
                obj.setDescricaoExtrato(objResultSet.getString("descricao_extrato"));
                obj.getDataExtrato().setTime(objResultSet.getDate("data_extrato"));
                obj.setTipoExtrato(objResultSet.getString("tipo_extrato"));
                obj.setValorExtrato(objResultSet.getDouble("valor_extrato"));
                obj.setExtratoCodigoConta(objResultSet.getInt("extrato_codigo_conta"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Erro ao recuperar extrato - DAO \n" + ex.getMessage());
        }
        return null;
    }
    
    public static boolean verificar(int codigoExtrato) {

        Connection conexao = Fabrica.getConexaoSINGLETON();
        String sql = "SELECT * FROM TBL_EXTRATO WHERE codigo_extrato = ?";
            
        try {
            PreparedStatement ST = conexao.prepareStatement(sql);
            ST.setInt(1, codigoExtrato);
            ResultSet objResultSet = ST.executeQuery();
            if(!objResultSet.next()) return false; 
            
        } catch (Exception e) {
            System.out.println("Erro ao verificar - DAO" + e.getMessage());
        }
        return true;
    }    
}
