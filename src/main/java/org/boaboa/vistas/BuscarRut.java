/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.boaboa.vistas;

import javax.swing.JOptionPane;
import org.boaboa.modelos.Cliente;
import org.boaboa.modelos.Usuario;
import org.boaboa.servicio.ServicioDB;
import org.boaboa.utils.RutUtils;

/**
 *
 * @author Alexandra Olivares Solis
 */
public class BuscarRut extends javax.swing.JFrame {

    /**
     * Creates new form BuscarRut
     */
    Usuario usuarioBuscarRut = new Usuario();
 
    
    public BuscarRut() {
        initComponents();
    }

        
    public BuscarRut(Usuario usuario) {
        usuarioBuscarRut = usuario;
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

        buscarButon = new javax.swing.JButton();
        rutField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        atrasBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buscarButon.setText("Buscar");
        buscarButon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarButonMouseClicked(evt);
            }
        });
        buscarButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButonActionPerformed(evt);
            }
        });

        rutField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("RUT");

        jLabel2.setText("BUSCAR CLIENTE");

        atrasBoton.setText("ATRAS");
        atrasBoton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasBotonMouseClicked(evt);
            }
        });
        atrasBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel2)
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(rutField1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(atrasBoton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscarButon, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarButon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rutField1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(atrasBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rutField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rutField1ActionPerformed

    private void buscarButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButonActionPerformed
        String rutString = this.rutField1.getText();
        boolean rutBoolean = RutUtils.isRut(rutString);
        if (rutBoolean) {
            Integer rut = RutUtils.parseRut(rutString);
            ServicioDB servicioDB = new ServicioDB();
            Cliente cliente = servicioDB.getClientePorRut(rut);
            if(cliente!=null){
                ClienteMostrar clienteMostrar = new ClienteMostrar(cliente,this.usuarioBuscarRut);
                clienteMostrar.setVisible(true);
                clienteMostrar.setLocationRelativeTo(null);
                this.dispose();
                
            }else{
                JOptionPane.showMessageDialog(rootPane, "no se ha encontrado ningun cliente con ese rut");
            
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "ingreso un rut no valido");
        }

// TODO add your handling code here:
    }//GEN-LAST:event_buscarButonActionPerformed

    private void atrasBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBotonActionPerformed
        MenuPrincipal menuPrincipal = new MenuPrincipal(this.usuarioBuscarRut);
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_atrasBotonActionPerformed

    private void buscarButonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarButonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarButonMouseClicked

    private void atrasBotonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasBotonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_atrasBotonMouseClicked

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
            java.util.logging.Logger.getLogger(BuscarRut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarRut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarRut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarRut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarRut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrasBoton;
    private javax.swing.JButton buscarButon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField rutField1;
    // End of variables declaration//GEN-END:variables
}
