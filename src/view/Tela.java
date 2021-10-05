package view;

import DAO.Fabrica;
import controller.CtrlConta;
import controller.CtrlExtrato;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tela extends javax.swing.JFrame {

    private Connection conexao;
    int ctrl = 0;
        
    public Tela() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPBanco = new javax.swing.JTabbedPane();
        jPaConta = new javax.swing.JPanel();
        jBNovo = new javax.swing.JButton();
        jBGrava = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jBExtrato = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContas = new javax.swing.JTable();
        jTFNumero = new javax.swing.JTextField();
        jTFAgencia = new javax.swing.JTextField();
        jTFSaldo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox = new javax.swing.JComboBox();
        jBAbrir = new javax.swing.JButton();
        bCommit = new javax.swing.JButton();
        bRollback = new javax.swing.JButton();
        bCarregar = new javax.swing.JButton();
        jPaExtrato = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableExtrato = new javax.swing.JTable();
        jBEGravar = new javax.swing.JButton();
        jBEExcluir = new javax.swing.JButton();
        jTFData = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTADescricao = new javax.swing.JTextArea();
        jTFValor = new javax.swing.JTextField();
        jTFCodConta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jBENovo = new javax.swing.JButton();
        jCBTipo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jBNovo.setText("Novo");
        jBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoActionPerformed(evt);
            }
        });

        jBGrava.setText("Gravar");
        jBGrava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGravaActionPerformed(evt);
            }
        });

        jBEditar.setText("Editar");
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jBExtrato.setText("Extrato");
        jBExtrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExtratoActionPerformed(evt);
            }
        });

        jTableContas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Numero", "Agencia", "Saldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableContas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableContasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableContas);
        if (jTableContas.getColumnModel().getColumnCount() > 0) {
            jTableContas.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setText("Número");

        jLabel2.setText("Agencia");

        jLabel3.setText("Saldo");

        jLabel4.setText("Isolamento");

        jComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nenhum", "Read Uncommited", "Read Commited", "Repetable Read", "Serializable" }));

        jBAbrir.setText("Abrir Isolamento");
        jBAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAbrirActionPerformed(evt);
            }
        });

        bCommit.setText("Commit");
        bCommit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCommitActionPerformed(evt);
            }
        });

        bRollback.setText("Rollback");
        bRollback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRollbackActionPerformed(evt);
            }
        });

        bCarregar.setText("Carregar Tabela");
        bCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCarregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPaContaLayout = new javax.swing.GroupLayout(jPaConta);
        jPaConta.setLayout(jPaContaLayout);
        jPaContaLayout.setHorizontalGroup(
            jPaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaContaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPaContaLayout.createSequentialGroup()
                        .addGroup(jPaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jBAbrir, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bCarregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(75, 75, 75)
                        .addGroup(jPaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103)
                        .addGroup(jPaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTFAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(106, 106, 106)
                        .addGroup(jPaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaContaLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(bRollback)
                .addGap(39, 39, 39)
                .addComponent(bCommit)
                .addGap(33, 33, 33)
                .addComponent(jBNovo)
                .addGap(27, 27, 27)
                .addComponent(jBGrava)
                .addGap(35, 35, 35)
                .addComponent(jBEditar)
                .addGap(39, 39, 39)
                .addComponent(jBExcluir)
                .addGap(27, 27, 27)
                .addComponent(jBExtrato)
                .addGap(24, 24, 24))
        );
        jPaContaLayout.setVerticalGroup(
            jPaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaContaLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addGroup(jPaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPaContaLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPaContaLayout.createSequentialGroup()
                                .addGroup(jPaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(10, 10, 10)
                                .addGroup(jPaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTFAgencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaContaLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(10, 10, 10)
                                .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPaContaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jBAbrir)))
                .addGap(12, 12, 12)
                .addComponent(bCarregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPaContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bRollback)
                    .addComponent(bCommit)
                    .addComponent(jBNovo)
                    .addComponent(jBGrava)
                    .addComponent(jBEditar)
                    .addComponent(jBExcluir)
                    .addComponent(jBExtrato))
                .addContainerGap())
        );

        jPBanco.addTab("Conta", jPaConta);

        jTableExtrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descrição", "Data", "Tipo", "Valor", "Codigo Conta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableExtrato);

        jBEGravar.setText("Gravar");
        jBEGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEGravarActionPerformed(evt);
            }
        });

        jBEExcluir.setText("Excluir");
        jBEExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEExcluirActionPerformed(evt);
            }
        });

        jTADescricao.setColumns(20);
        jTADescricao.setRows(5);
        jScrollPane3.setViewportView(jTADescricao);

        jLabel5.setText("Descrição");

        jLabel6.setText("Data");

        jLabel7.setText("Tipo");

        jLabel8.setText("Valor");

        jLabel9.setText("Código Conta");

        jBENovo.setText("Novo");
        jBENovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBENovoActionPerformed(evt);
            }
        });

        jCBTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nenhum", "E", "S" }));

        javax.swing.GroupLayout jPaExtratoLayout = new javax.swing.GroupLayout(jPaExtrato);
        jPaExtrato.setLayout(jPaExtratoLayout);
        jPaExtratoLayout.setHorizontalGroup(
            jPaExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaExtratoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPaExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                    .addGroup(jPaExtratoLayout.createSequentialGroup()
                        .addGroup(jPaExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(88, 88, 88)
                        .addGroup(jPaExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPaExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPaExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPaExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFCodConta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaExtratoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBENovo)
                .addGap(74, 74, 74)
                .addComponent(jBEGravar)
                .addGap(68, 68, 68)
                .addComponent(jBEExcluir)
                .addGap(211, 211, 211))
        );
        jPaExtratoLayout.setVerticalGroup(
            jPaExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaExtratoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addGroup(jPaExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPaExtratoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(77, Short.MAX_VALUE))
                    .addGroup(jPaExtratoLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPaExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPaExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFCodConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPaExtratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBEGravar)
                            .addComponent(jBEExcluir)
                            .addComponent(jBENovo))
                        .addContainerGap())))
        );

        jPBanco.addTab("Extrato", jPaExtrato);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPBanco)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPBanco)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void gravaConta() {
        String[] dados = new String[4];
        int iLinha = jTableContas.getSelectedRow();
        
        if (ctrl == 0) {
            dados[0] = "0";
            dados[1] = jTFNumero.getText();
            dados[2] = jTFAgencia.getText();
            dados[3] = jTFSaldo.getText();
            CtrlConta.inserir(dados, conexao);
        } 
        else {
            dados[0] = (String) jTableContas.getValueAt(iLinha, 0);
            dados[1] = jTFNumero.getText();
            dados[2] = jTFAgencia.getText();
            dados[3] = jTFSaldo.getText();
    
            CtrlConta.inserir(dados, conexao);
        }
    }
    
    private void gravaExtrato() {
        String[] dados = new String[6];
        int iLinha = jTableExtrato.getSelectedRow();
        
        if (ctrl == 0) {
            dados[0] = "0";
            dados[1] = jTADescricao.getText();
            dados[2] = jTFData.getText();
            dados[3] = String.valueOf(jCBTipo.getSelectedItem());
            dados[4] = jTFValor.getText();
            dados[5] = jTFCodConta.getText();

            CtrlExtrato.inserir(dados, conexao);
        } 
        else {
            dados[0] = (String) jTableExtrato.getValueAt(iLinha, 0);
            dados[1] = jTFNumero.getText();
            dados[2] = jTFAgencia.getText();
            dados[3] = jTFSaldo.getText();
    
            CtrlExtrato.inserir(dados, conexao);
        }
    }
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro ao encerrar conexão na tela" + e);
        }
    }//GEN-LAST:event_formWindowClosed

    private void jBGravaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGravaActionPerformed
        gravaConta();
    }//GEN-LAST:event_jBGravaActionPerformed

    private void jBAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAbrirActionPerformed
        int iOpcao = jComboBox.getSelectedIndex();

        switch (iOpcao) {
            case 1:
            iOpcao = Connection.TRANSACTION_READ_UNCOMMITTED;
            break;
            case 2:
            iOpcao = Connection.TRANSACTION_READ_COMMITTED;
            break;
            case 3:
            iOpcao = Connection.TRANSACTION_REPEATABLE_READ;
            break;
            case 4:
            iOpcao = Connection.TRANSACTION_SERIALIZABLE;
            break;
            default:
            iOpcao = Connection.TRANSACTION_NONE;
            break;
        }

        try {
            conexao = Fabrica.getConexaoNOVA(iOpcao);
        } catch (Exception e) {
            System.out.println("Erro ao carregar conexão na tela" + e);
        }

    }//GEN-LAST:event_jBAbrirActionPerformed

    private void bCommitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCommitActionPerformed
        try {
            conexao.commit();
        } catch (SQLException ex) {
            System.out.println("Erro no COMMIT: " + ex.getMessage());
        }
    }//GEN-LAST:event_bCommitActionPerformed

    private void bRollbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRollbackActionPerformed
        try {
            conexao.rollback();
        } catch (SQLException ex) {
            System.out.println("Erro no rollback: " + ex.getMessage());
        }
    }//GEN-LAST:event_bRollbackActionPerformed

    private void bCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCarregarActionPerformed
        carregarTabelaConta();
    }//GEN-LAST:event_bCarregarActionPerformed

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        jTFNumero.setText("");
        jTFAgencia.setText("");
        jTFSaldo.setText("");
        ctrl = 0;
    }//GEN-LAST:event_jBNovoActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        int codigoConta = Integer.parseInt((String) jTableContas.getValueAt(jTableContas.getSelectedRow(), 0));
            
        if (codigoConta >= 0) {
            if(JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro? ") == 0){
                CtrlConta.excluir(codigoConta, conexao);
            }
        }
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTableContasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableContasMousePressed
        jTFNumero.setText((String) jTableContas.getValueAt(jTableContas.getSelectedRow(), 1));
        jTFAgencia.setText((String) jTableContas.getValueAt(jTableContas.getSelectedRow(), 2));
        jTFSaldo.setText((String) jTableContas.getValueAt(jTableContas.getSelectedRow(), 3));
    }//GEN-LAST:event_jTableContasMousePressed

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        ctrl = 1;
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBEGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEGravarActionPerformed
       gravaExtrato();
       limparTelaExtrato();
    }//GEN-LAST:event_jBEGravarActionPerformed

    private void jBEExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEExcluirActionPerformed
        int codigoExtrato = Integer.parseInt((String) jTableExtrato.getValueAt(jTableExtrato.getSelectedRow(), 0));
        if (codigoExtrato >= 0) {
            if(JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro? ") == 0){
                CtrlExtrato.excluir(codigoExtrato, conexao);
            }
        }
    }//GEN-LAST:event_jBEExcluirActionPerformed

    private void jBENovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBENovoActionPerformed
        ctrl = 0;
        limparTelaExtrato();
    }//GEN-LAST:event_jBENovoActionPerformed

    private void jBExtratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExtratoActionPerformed
        carregarTabelaExtrato();
    }//GEN-LAST:event_jBExtratoActionPerformed

    private void limparTelaExtrato(){
        jTADescricao.setText("");
        jTFData.setText("");
        //jTFTipo.setText("");
        jTFValor.setText("");
        jTFCodConta.setText("");
    }
    
    private void carregarTabelaConta(){

        DefaultTableModel model = (DefaultTableModel) jTableContas.getModel();
        model.setNumRows(0);

        String[][] lista = CtrlConta.recuperarTodos(conexao);

        for (String[] dado : lista) {
            model.addRow(dado);
        }
    }
    
    private void carregarTabelaExtrato(){

        int codConta = Integer.parseInt((String) jTableContas.getValueAt(jTableContas.getSelectedRow(), 0));
        DefaultTableModel model = (DefaultTableModel) jTableExtrato.getModel();
        model.setNumRows(0);

        String[][] lista = CtrlExtrato.recuperarExtratoConta(codConta, conexao);

        for (String[] dado : lista) {
            model.addRow(dado);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCarregar;
    private javax.swing.JButton bCommit;
    private javax.swing.JButton bRollback;
    private javax.swing.JButton jBAbrir;
    private javax.swing.JButton jBEExcluir;
    private javax.swing.JButton jBEGravar;
    private javax.swing.JButton jBENovo;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBExtrato;
    private javax.swing.JButton jBGrava;
    private javax.swing.JButton jBNovo;
    private javax.swing.JComboBox jCBTipo;
    private javax.swing.JComboBox jComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTabbedPane jPBanco;
    private javax.swing.JPanel jPaConta;
    private javax.swing.JPanel jPaExtrato;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTADescricao;
    private javax.swing.JTextField jTFAgencia;
    private javax.swing.JTextField jTFCodConta;
    private javax.swing.JTextField jTFData;
    private javax.swing.JTextField jTFNumero;
    private javax.swing.JTextField jTFSaldo;
    private javax.swing.JTextField jTFValor;
    private javax.swing.JTable jTableContas;
    private javax.swing.JTable jTableExtrato;
    // End of variables declaration//GEN-END:variables
}
