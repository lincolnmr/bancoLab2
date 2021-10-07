package Fachada;
/*
import DAO.DAOconta;
import DAO.DAOextrato;
import java.sql.Connection;

public class TransferenciaContas {
    
        public static boolean tranfererir(int contaOrigem, int contaDestino, double valor){
            
            Connection conexao = DAO.Fabrica.getConexaoNOVA();
            
            try {
                
                DAOconta daoConta = new DAOconta(conexao);
                DAOextrato dAOextrato = new DAOextrato(conexao);
                
                Conta contaOrigem = daoConta.recuperar(contaOrigem);
                if(contaOrigem.getSaldo() < valor){
                    System.out.println("Saldo insuficiente");
                    return false;
                }
                
                conexao.commit();
                return true;
            } catch (Exception e) {
                conexao.rollback();
                System.out.println("Erro na transferencia" + e);
            }
            
        }
}*/
