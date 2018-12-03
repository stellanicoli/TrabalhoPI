/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistema.telas;
import java.sql.*;
import br.com.sistema.dal.Conexao;
import static br.com.sistema.telas.TelaUsuario.txtUsuId;
import javax.swing.JOptionPane;

/**
 *
 * @author Petrônio Santos
 */
public class TelaCartaoCorporativo extends javax.swing.JInternalFrame {
    
     Connection conexao = null;
     PreparedStatement pst = null;
     ResultSet rs = null;

    /**
     * Creates new form TelaCartaoCorporativo
     */
    public TelaCartaoCorporativo() {
        initComponents();
        conexao = Conexao.conector();
    }
    
    private void adicionar() {
        String sql = "INSERT INTO cartaocorporativo(id_rh, numero, data_vencimento, bandeira, instituicao, codigo_seguranca, limite_credito) VALUES(?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtCarIdRh.getText());
            pst.setString(2, txtCarNumero.getText());
            pst.setString(3, txtCarDataVenc.getText());
            pst.setString(4, txtCarBandeira.getText());
            pst.setString(5, txtCarInstituicao.getText());
            pst.setString(6, txtCarCodSeg.getText());
            pst.setString(7, txtCarLimCre.getText());

            if ((txtCarNumero.getText().isEmpty()) || (txtCarDataVenc.getText().isEmpty()) || (txtCarCodSeg.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
            } else {

                int adicionado = pst.executeUpdate();
                //System.out.println(adicionado);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cartão adicionado com sucesso");
                    txtCarIdRh.setText(null);
                    txtCarNumero.setText(null);
                    txtCarDataVenc.setText(null);
                    txtCarBandeira.setText(null);
                    txtCarInstituicao.setText(null);
                    txtCarCodSeg.setText(null);
                    txtCarLimCre.setText(null);
                    
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCarIdCarCor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCarIdRh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCarNumero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCarDataVenc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCarBandeira = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCarInstituicao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCarCodSeg = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCarLimCre = new javax.swing.JTextField();
        btnCarAdicionar = new javax.swing.JButton();
        btnCarAlterar = new javax.swing.JButton();
        btnCarRemover = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cartão Corporativo");

        jLabel1.setText("Id Cartão Corporativo");

        jLabel2.setText("Id Rh");

        jLabel3.setText("* Número");

        jLabel4.setText("* Data Vencimento");

        jLabel5.setText("Bandeira");

        jLabel6.setText("Instituição");

        jLabel7.setText("* Codigo Segurança");

        jLabel8.setText("Limite Crédito");

        btnCarAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/icones/create.png"))); // NOI18N
        btnCarAdicionar.setToolTipText("Adicionar");
        btnCarAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCarAdicionar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCarAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarAdicionarActionPerformed(evt);
            }
        });

        btnCarAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/icones/update.png"))); // NOI18N
        btnCarAlterar.setToolTipText("Alterar");
        btnCarAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCarAlterar.setPreferredSize(new java.awt.Dimension(80, 80));

        btnCarRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sistema/icones/delete.png"))); // NOI18N
        btnCarRemover.setToolTipText("Remover");
        btnCarRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCarRemover.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel9.setText("* Campos Obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCarAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(btnCarAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(302, 302, 302)
                                .addComponent(btnCarRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(190, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCarNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(txtCarDataVenc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCarCodSeg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCarLimCre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCarIdRh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCarBandeira, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCarInstituicao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCarIdCarCor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCarIdCarCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCarIdRh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCarNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCarDataVenc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCarBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCarInstituicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCarCodSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCarLimCre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCarAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCarAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCarRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        setBounds(0, 0, 759, 518);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCarAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarAdicionarActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnCarAdicionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarAdicionar;
    private javax.swing.JButton btnCarAlterar;
    private javax.swing.JButton btnCarRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCarBandeira;
    private javax.swing.JTextField txtCarCodSeg;
    private javax.swing.JTextField txtCarDataVenc;
    private javax.swing.JTextField txtCarIdCarCor;
    private javax.swing.JTextField txtCarIdRh;
    private javax.swing.JTextField txtCarInstituicao;
    private javax.swing.JTextField txtCarLimCre;
    private javax.swing.JTextField txtCarNumero;
    // End of variables declaration//GEN-END:variables
}
