package Utilitario;

import DAO.DAOconta;
import DAO.DAOextrato;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
import model.Conta;
import model.Extrato;

public class TransferenciaContas {
    
        public static boolean transferir(int codContaOrigem, int codContaDestino, double valor) throws SQLException{
            Connection conexao = DAO.Fabrica.getConexaoNOVA();
            
            try {
                DAOconta daoConta = new DAOconta(conexao);
                Conta contaOrigem = daoConta.recuperar(codContaOrigem);
                Conta contaDestino = daoConta.recuperar(codContaDestino);

                if(contaOrigem.getSaldoConta() < valor){
                    JOptionPane.showConfirmDialog(null, "Saldo insuficiente");
                    return false;
                }
                atualizarOrigem(contaOrigem, contaDestino, valor, conexao);
                atualizarDestino(contaDestino, contaOrigem, valor, conexao);
                conexao.commit();
                
                JOptionPane.showMessageDialog(null, "Transferencia realizada com sucesso");
            } catch (Exception e) {
                conexao.rollback();
                System.out.println("Erro na transferencia" + e);
            }
            return true;
        }
        
        public static boolean atualizarOrigem(Conta contaOrigem, Conta contaDestino, double valor, Connection conexao){
            try {
                DAOconta daoConta = new DAOconta(conexao);           
                contaOrigem.setSaldoConta(contaOrigem.getSaldoConta() - valor);
                daoConta.update(contaOrigem);
                
            } catch (Exception e) {
                System.out.println("Erro ao atualizar saldo conta origem  - Transferencia" + e);
                return false;
            }
            
            try {
                DAOextrato daoExtrato = new DAOextrato(conexao);
                
                Extrato extr = new Extrato();
                extr.setCodigoExtrato(0);
                extr.setDescricaoExtrato("Enviado p/ conta: " + contaDestino.getCodigoConta());
                extr.setDataExtrato(Calendar.getInstance());
                extr.setTipoExtrato("S");
                extr.setValorExtrato(valor);
                extr.setExtratoCodigoConta(contaOrigem.getCodigoConta());
                daoExtrato.insert(extr);
            } catch (Exception e) {
                System.out.println("Erro ao inserir extrato da conta origem - Transferencia " + e);
                return false;
            }
            
        return true;    
        }
        
        public static boolean atualizarDestino(Conta contaDestino, Conta contaOrigem, double valor, Connection conexao){
            try {
                DAOconta daoConta = new DAOconta(conexao);           
                contaDestino.setSaldoConta(contaDestino.getSaldoConta() + valor);
                daoConta.update(contaDestino);
                
            } catch (Exception e) {
                System.out.println("Erro ao atualizar saldo conta destino  - Transferencia" + e);
                return false;
            }
            
            try {
                DAOextrato daoExtrato = new DAOextrato(conexao);
                
                Extrato extr = new Extrato();
                extr.setCodigoExtrato(0);
                extr.setDescricaoExtrato("Recebido da conta: " + contaOrigem.getCodigoConta());
                extr.setDataExtrato(Calendar.getInstance());
                extr.setTipoExtrato("E");
                extr.setValorExtrato(valor);
                extr.setExtratoCodigoConta(contaDestino.getCodigoConta());
                daoExtrato.insert(extr);
            } catch (Exception e) {
                System.out.println("Erro ao inserir extrato da conta destino - Transferencia " + e);
                return false;
            }
            
        return true;    
        }
}

        
