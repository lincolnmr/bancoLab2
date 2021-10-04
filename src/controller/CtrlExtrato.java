package controller;

import DAO.DAOextrato;
import Utilitario.Funcoes;
import java.sql.Connection;
import java.util.ArrayList;
import model.Extrato;

public class CtrlExtrato {

    public static void inserir(String[] dados) {

        try {   
            Extrato obj = new Extrato();
            obj.setCodigoExtrato(Integer.parseInt(dados[0]));
            obj.setDescricaoExtrato(dados[1]);
            obj.setDataExtrato(Funcoes.stringToDate(dados[2]));
            obj.setTipoExtrato(dados[3]);
            obj.setValorExtrato(Double.parseDouble(dados[4]));
            obj.setExtratoCodigoConta(Integer.parseInt(dados[5]));   

            if ("0".equals(dados[0])){
                DAO.DAOextrato.insert(obj);
            } else {
                DAO.DAOextrato.update(obj);
            }  
        } catch (Exception f) {
            System.out.println("Erro ao gravar objeto na classe controle: " + f.getMessage());
        }
    }
    
    public static void inserir(String[] dados, Connection conexao) {
        
        try {   
            Extrato obj = new Extrato();
            obj.setCodigoExtrato(Integer.parseInt(dados[0]));
            obj.setDescricaoExtrato(dados[1]);
            obj.setDataExtrato(Funcoes.stringToDate(dados[2]));
            obj.setTipoExtrato(dados[3]);
            obj.setValorExtrato(Double.parseDouble(dados[4]));
            obj.setExtratoCodigoConta(Integer.parseInt(dados[5]));   

            if ("0".equals(dados[0])){
                DAO.DAOextrato.insert(obj, conexao);
            } else {
                DAO.DAOextrato.update(obj, conexao);
            }  
        } catch (Exception f) {
            System.out.println("Erro ao gravar objeto na classe controle: " + f.getMessage());
        }
    }

    public static boolean excluir(int codigoExtrato) {
        return DAOextrato.excluir(codigoExtrato);
    }
    
    public static boolean excluir(int codigoExtrato, Connection conexao) {
        return DAOextrato.excluir(codigoExtrato, conexao);
    }

    public static String[] recuperar(int codigoExtrato) {
        Extrato objExtratoto = DAOextrato.recuperar(codigoExtrato);
        return objExtratoto.toArray();
    }
    
    public static String[] recuperar(int codigoConta, Connection conexao) {
        Extrato objExtrato = DAOextrato.recuperar(codigoConta, conexao);
        return objExtrato.toArray();
    }
    
    public static String[][] recuperarExtratoConta(int codigoConta, Connection conexao){

        ArrayList<Extrato> lista = DAOextrato.recuperarExtratoConta(codigoConta, conexao);

        String[][] matrizReturn = null;
        matrizReturn = new String[lista.size()][6];

        for (int i = 0; i < lista.size(); i++) {
            matrizReturn[i] = lista.get(i).toArray();
        }
        return matrizReturn;
    }

    public static boolean verifica(int codigoExtrato) {
        return DAOextrato.verificar(codigoExtrato); 
    }
}
