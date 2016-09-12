/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.boaboa.vistas;

import javax.swing.JOptionPane;
import org.boaboa.modelos.Usuario;
import org.boaboa.servicio.ServicioDB;
import org.boaboa.utils.RutUtils;
import org.boaboa.utils.SecurityUtils;

/**
 *
 * @author frubilar
 */
public class FormularioUsuario extends javax.swing.JFrame {

    Usuario usuarioFormulario = null;
    Usuario usuarioPersistir = new Usuario();

    /**
     * Creates new form formularioUsuario
     */
    public FormularioUsuario() {
        initComponents();
    }

    FormularioUsuario(Integer rut,Usuario usuario, Usuario secion) {
        initComponents();
        this.usuarioPersistir=secion;
        if (usuario != null) {
            this.usuarioFormulario = usuario;
            usuarioFormulario = usuario;
            this.nombreField.setText(usuarioFormulario.getNombre().toString());
            if (usuarioFormulario.getRut() != null) {
                this.rutField.setText(RutUtils.formatear(usuarioFormulario.getRut()));
            }
        }else{
            this.rutField.setText(RutUtils.formatear(rut));
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

        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        confirmacionPassword = new javax.swing.JPasswordField();
        rolBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        guardarButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        atrasButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rutField = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("CONFIRMACION");

        jLabel7.setText("DE CLAVE");

        rolBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vendedor", "Administrador" }));

        jLabel1.setText("USUARIO");

        jLabel2.setText("NOMBRE");

        guardarButton.setText("GUARDAR");
        guardarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarButtonMouseClicked(evt);
            }
        });
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("RUT");

        atrasButton.setText("ATRAS");
        atrasButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atrasButtonMouseClicked(evt);
            }
        });

        jLabel4.setText("ROL");

        jLabel5.setText(" CLAVE");

        rutField.setText("jLabel8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 193, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreField)
                                    .addComponent(confirmacionPassword)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rolBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(Password)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(rutField)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(atrasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rutField))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rolBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(confirmacionPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atrasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atrasButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_atrasButtonMouseClicked

        MenuPrincipal menuPrincipal = new MenuPrincipal(this.usuarioPersistir);
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
        this.dispose();

// TODO add your handling code here:
    }//GEN-LAST:event_atrasButtonMouseClicked

    private void guardarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarButtonMouseClicked

        String nombreString = this.nombreField.getText();
        String rutString = this.rutField.getText();
        String rol = this.rolBox.getSelectedItem().toString();
        char[] palabra, palabra2;
        palabra = this.Password.getPassword();
        palabra2 = this.confirmacionPassword.getPassword();
        String clave = new String(palabra);
        String clave2 = new String(palabra2);
        if (clave.equals(clave2)) {
            if (nombreString.length() * rutString.length() * clave.length() != 0) {
                Integer rutInteger = RutUtils.parseRut(rutString);
                if (rutInteger != null) {

                    this.usuarioFormulario.setNombre(nombreString);
                    if (rol.equals("Administrador")) {
                        rol = "admin";
                    }
                    this.usuarioFormulario.setRol(rol);
                    if (this.usuarioFormulario.getId() == null) {
                        this.usuarioFormulario.setRut(rutInteger);
                    }
                    this.usuarioFormulario.setClave(SecurityUtils.sha256(clave));
                    ServicioDB servicioDB = new ServicioDB();
                    boolean salida = servicioDB.guardar(this.usuarioFormulario);
                    if (salida) {
                        JOptionPane.showMessageDialog(rootPane, "se guardara un usuario nuevo");
                        MenuPrincipal menuPrincipal = new MenuPrincipal(this.usuarioPersistir);
                        menuPrincipal.setVisible(true);
                        menuPrincipal.setLocationRelativeTo(null);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Noo se guardaron los datos del usuario");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "RUT invalido");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Todos los campos son obligatorios");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Las claves no son iguales");
        }

// TODO add your handling code here:
    }//GEN-LAST:event_guardarButtonMouseClicked

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton atrasButton;
    private javax.swing.JPasswordField confirmacionPassword;
    private javax.swing.JButton guardarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nombreField;
    private javax.swing.JComboBox rolBox;
    private javax.swing.JLabel rutField;
    // End of variables declaration//GEN-END:variables
}
