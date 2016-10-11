/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.boaboa.vistas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.boaboa.modelos.Usuario;
import org.boaboa.servicio.ServicioDB;
import org.boaboa.utils.RutUtils;
import org.boaboa.utils.SecurityUtils;

/**
 *
 * @author Alexandra Olivares Solis
 */
public class Login extends javax.swing.JFrame {


    /**
     * Creates new form Login
     */
    public Login() {
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

        accesoLabel = new javax.swing.JLabel();
        rutLabel = new javax.swing.JLabel();
        claveLabel = new javax.swing.JLabel();
        rutField = new javax.swing.JTextField();
        clavePassword = new javax.swing.JPasswordField();
        ingresarBoton = new javax.swing.JButton();
        cancelarBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        accesoLabel.setText("ACCESO");

        rutLabel.setText("RUT");

        claveLabel.setText("Clave");

        rutField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutFieldActionPerformed(evt);
            }
        });
        rutField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rutFieldKeyTyped(evt);
            }
        });

        ingresarBoton.setText("INGRESAR");
        ingresarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarBotonActionPerformed(evt);
            }
        });

        cancelarBoton.setText("CANCELAR");
        cancelarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(accesoLabel)
                        .addGap(0, 201, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rutLabel)
                            .addComponent(claveLabel))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rutField)
                            .addComponent(clavePassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ingresarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(accesoLabel)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutLabel)
                    .addComponent(rutField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(claveLabel)
                    .addComponent(clavePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 155, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingresarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rutFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rutFieldActionPerformed

    private void ingresarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarBotonActionPerformed

        String rut = this.rutField.getText();
        Integer rutInteger = RutUtils.parseRut(rut);
        char[] palabra;
        palabra = this.clavePassword.getPassword();
        String clave = new String(palabra);
        if (clave.length() * rut.length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "No escribiste nada");
        } else {
            if (rutInteger != null) {
                ServicioDB servicioDB = new ServicioDB();
                Usuario usuario = new Usuario();
                usuario = servicioDB.getUsuario(rutInteger);
                if (usuario != null) {
                    if (usuario.getClave().equals(SecurityUtils.sha256(clave))) {
                        MenuPrincipal menuPrincipal = new MenuPrincipal(usuario);
                        menuPrincipal.setVisible(true);
                        menuPrincipal.setLocationRelativeTo(null);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Clave no cohincide");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "RUT ingresado no es valido");
            }
        }

    }//GEN-LAST:event_ingresarBotonActionPerformed

    private void cancelarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBotonActionPerformed

        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarBotonActionPerformed

    private void rutFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rutFieldKeyTyped
        
// TODO add your handling code here:
    }//GEN-LAST:event_rutFieldKeyTyped

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accesoLabel;
    private javax.swing.JButton cancelarBoton;
    private javax.swing.JLabel claveLabel;
    private javax.swing.JPasswordField clavePassword;
    private javax.swing.JButton ingresarBoton;
    private javax.swing.JTextField rutField;
    private javax.swing.JLabel rutLabel;
    // End of variables declaration//GEN-END:variables
}
