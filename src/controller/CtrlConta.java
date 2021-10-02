package controller;

import DAO.DAOconta;
import java.sql.Connection;
import java.util.ArrayList;
import model.Conta;

public class CtrlConta {

    public static void inserir(String[] dados) {

        try {
            Conta obj = new Conta();
            obj.setCodigoConta(Integer.parseInt(dados[0]));
            obj.setNumeroConta(dados[1]);
            obj.setAgenciaConta(dados[2]);
            obj.setSaldoConta(Double.parseDouble(dados[3]));            

            if (!verifica(obj.getCodigoConta())){
                DAO.DAOconta.insert(obj);
            } else {
                DAO.DAOconta.update(obj);
            }
             
        } catch (Exception f) {
            System.out.println("Erro ao gravar objeto na classe controle: " + f.getMessage());
        }
    }
    
    public static void inserir(String[] dados, Connection conexao) {

        try {
            Conta obj = new Conta();
            obj.setCodigoConta(Integer.parseInt(dados[0]));
            obj.setNumeroConta(dados[1]);
            obj.setAgenciaConta(dados[2]);
            obj.setSaldoConta(Double.parseDouble(dados[3]));            

            if (!verifica(obj.getCodigoConta())){
                DAO.DAOconta.insert(obj, conexao);
            } else {
                DAO.DAOconta.update(obj, conexao);
            }
             
        } catch (Exception f) {
            System.out.println("Erro ao gravar objeto na classe controle: " + f.getMessage());
        }
    }

    public static boolean excluir(int codigoConta) {
        return DAOconta.excluir(codigoConta);
    }
    
    public static boolean excluir(int codigoConta, Connection conexao) {
        return DAOconta.excluir(codigoConta, conexao);
    }

    public static String[] recuperar(int codigoConta) {
        Conta objContato = DAOconta.recuperar(codigoConta);
        return objContato.toArray();
    }
    
    public static String[] recuperar(int codigoConta, Connection conexao) {
        Conta objContato = DAOconta.recuperar(codigoConta, conexao);
        return objContato.toArray();
    }
     
    public static String[][] recuperarTodos(Connection conexao){

        ArrayList<Conta> lista = DAOconta.recuperarTodos(conexao);
        String[][] matrizReturn = null;
        matrizReturn = new String[lista.size()][4];

        for (int i = 0; i < lista.size(); i++) {
            matrizReturn[i] = lista.get(i).toArray();
        }
        return matrizReturn;
    }
   
    public static boolean verifica(int codigoConta) {
        return DAOconta.verificar(codigoConta); 
    }
}
