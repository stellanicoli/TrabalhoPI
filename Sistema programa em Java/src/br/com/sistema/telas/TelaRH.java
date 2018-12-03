/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.telas;

import java.sql.*;
import br.com.sistema.dal.Conexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Petrônio Santos
 */
public class TelaRH extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaRH
     */
    public TelaRH() {
        initComponents();
        conexao = Conexao.conector();
    }

    private void adicionar() {
        String sql = "INSERT INTO rh(codigo, nome_diretor,nome_gerente, limite_credito_diretor, limite_credito_gerente) VALUES(?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtRhCodigo.getText());
            pst.setString(2, txtRhNomeDiretor.getText());
            pst.setString(3, txtRhNomeGerente.getText());
            pst.setString(4, txtRhLimiteCreditoDiretor.getText());
            pst.setString(5, txtRhLimiteCreditoGerente.getText());

            if ((txtRhCodigo.getText().isEmpty()) || (txtRhNomeDiretor.getText().isEmpty()) || (txtRhNomeGerente.getText().isEmpty()) || (txtRhLimiteCreditoDiretor.getText().isEmpty() || (txtRhLimiteCreditoGerente.getText().isEmpty()))) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {

                int adicionado = pst.executeUpdate();
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso");
                    txtRhCodigo.setText(null);
                    txtRhNomeDiretor.setText(null);
                    txtRhNomeGerente.setText(null);
                    txtRhLimiteCreditoDiretor.setText(null);
                    txtRhLimiteCreditoGerente.setText(null);

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void alterar() {
        String sql = "UPDATE rh SET codigo=?, nome_diretor=?, nome_gerente=?, limite_credito_diretor=?, limite_credito_gerente=? WHERE id_rh=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtRhCodigo.getText());
            pst.setString(2, txtRhNomeDiretor.getText());
            pst.setString(3, txtRhNomeGerente.getText());
            pst.setString(4, txtRhLimiteCreditoDiretor.getText());
            pst.setString(5, txtRhLimiteCreditoGerente.getText());
            pst.setString(6, txtRhId.getText());

            if ((txtRhId.getText().isEmpty()) || (txtRhCodigo.getText().isEmpty()) || (txtRhNomeDiretor.getText().isEmpty()) || (txtRhNomeGerente.getText().isEmpty()|| (txtRhLimiteCreditoDiretor.getText().isEmpty()|| (txtRhLimiteCreditoGerente.getText().isEmpty())))) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {

                int adicionado = pst.executeUpdate();
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do usuário RH alterados com sucesso");
                    txtRhId.setText(null);
                    txtRhCodigo.setText(null);
                    txtRhNomeDiretor.setText(null);
                    txtRhNomeGerente.setText(null);
                    txtRhLimiteCreditoDiretor.setText(null);
                    txtRhLimiteCreditoGerente.setText(null);
                    
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário RH", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM rh WHERE id_rh=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtRhId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário RH removido com sucesso");

                    txtRhId.setText(null);
                    txtRhCodigo.setText(null);
                    txtRhNomeDiretor.setText(null);
                    txtRhNomeGerente.setText(null);
                    txtRhLimiteCreditoDiretor.setText(null);
                    txtRhLimiteCreditoGerente.setText(null);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void pesquisar() {
        String sql = "SELECT * FROM rh WHERE nome_diretor LIKE ?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtRhPesquisar.getText() + "%");
            rs = pst.executeQuery();
            
            tblRh.setModel(DbUtils.resultSetToTableModel(rs)); 
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
        
        
    }
    
    public void setar_campos() {
        int setar = tblRh.getSelectedRow();
        txtRhId.setText(tblRh.getModel().getValueAt(setar, 0).toString());
        txtRhCodigo.setText(tblRh.getModel().getValueAt(setar, 1).toString());
        txtRhNomeDiretor.setText(tblRh.getModel().getValueAt(setar, 2).toString());
        txtRhNomeGerente.setText(tblRh.getModel().getValueAt(setar, 3).toString());
        txtRhLimiteCreditoDiretor.setText(tblRh.getModel().getValueAt(setar, 4).toString());
        txtRhLimiteCreditoGerente.setText(tblRh.getModel().getValueAt(setar, 5).toString());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRhPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtRhNomeGerente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtRhLimiteCreditoGerente = new javax.swing.JTextField();
        btnRhAdicionar = new javax.swing.JButton();
        btnRhAlterar = new javax.swing.JButton();
        btnRhRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRh = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtRhLimiteCreditoDiretor = new javax.swing.JTextField();
        txtRhNomeDiretor = new javax.swing.JTextField();
        txtRhCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRhId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Recursos Humanos");
        setPreferredSize(new java.awt.Dimension(759, 0));

        txtRhPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRhPesquisarKeyReleased(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/icones/pesquisar.png"))); // NOI18N

        jLabel2.setText("* Código");

        jLabel3.setText("* Nome Diretor");

        jLabel4.setText("* Nome Gerente");

        jLabel5.setText("* Limite de Crédito Gerente");

        btnRhAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/icones/create.png"))); // NOI18N
        btnRhAdicionar.setToolTipText("Adicionar");
        btnRhAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRhAdicionar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnRhAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRhAdicionarActionPerformed(evt);
            }
        });

        btnRhAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/icones/update.png"))); // NOI18N
        btnRhAlterar.setToolTipText("Alterar");
        btnRhAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRhAlterar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnRhAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRhAlterarActionPerformed(evt);
            }
        });

        btnRhRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/icones/delete.png"))); // NOI18N
        btnRhRemover.setToolTipText("Remover");
        btnRhRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRhRemover.setPreferredSize(new java.awt.Dimension(80, 80));
        btnRhRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRhRemoverActionPerformed(evt);
            }
        });

        tblRh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblRh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRh);

        jLabel6.setText("* Limite de Crédito Diretor");

        jLabel7.setText("Id Rh");

        txtRhId.setEnabled(false);

        jLabel8.setText("* Campos Obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(71, 71, 71))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(101, 101, 101)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRhNomeDiretor)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtRhCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtRhId, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtRhLimiteCreditoDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRhNomeGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRhLimiteCreditoGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(338, 338, 338))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(174, 174, 174)
                            .addComponent(btnRhAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(68, 68, 68)
                            .addComponent(btnRhAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(75, 75, 75)
                            .addComponent(btnRhRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(txtRhPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel1)
                            .addGap(98, 98, 98)
                            .addComponent(jLabel8))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtRhPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtRhCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtRhId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtRhNomeDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtRhLimiteCreditoDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtRhNomeGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtRhLimiteCreditoGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRhAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRhAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRhRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        setBounds(0, 0, 759, 518);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRhAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRhAdicionarActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnRhAdicionarActionPerformed

    private void btnRhAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRhAlterarActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_btnRhAlterarActionPerformed

    private void btnRhRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRhRemoverActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_btnRhRemoverActionPerformed

    private void txtRhPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRhPesquisarKeyReleased
        // TODO add your handling code here:
        pesquisar();
    }//GEN-LAST:event_txtRhPesquisarKeyReleased

    private void tblRhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRhMouseClicked
        // TODO add your handling code here:
        setar_campos();
    }//GEN-LAST:event_tblRhMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRhAdicionar;
    private javax.swing.JButton btnRhAlterar;
    private javax.swing.JButton btnRhRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRh;
    private javax.swing.JTextField txtRhCodigo;
    private javax.swing.JTextField txtRhId;
    private javax.swing.JTextField txtRhLimiteCreditoDiretor;
    private javax.swing.JTextField txtRhLimiteCreditoGerente;
    private javax.swing.JTextField txtRhNomeDiretor;
    private javax.swing.JTextField txtRhNomeGerente;
    private javax.swing.JTextField txtRhPesquisar;
    // End of variables declaration//GEN-END:variables
}
