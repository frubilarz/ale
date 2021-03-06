/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.boaboa.vistas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang.StringUtils;
import org.boaboa.modelos.Boleta;
import org.boaboa.modelos.CarroVenta;
import org.boaboa.modelos.Cliente;
import org.boaboa.modelos.Producto;
import org.boaboa.modelos.Usuario;
import org.boaboa.servicio.ServicioDB;
import org.boaboa.utils.NumberUtils;
import org.boaboa.utils.RutUtils;
import org.boaboa.utils.TecladoUtils;

/**
 *
 * @author frubilar
 */
public class FormularioVenta extends javax.swing.JFrame {

    /**
     * Creates new form FormularioVenta
     */
    public void Nletras(JTextField a) {
        a.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }
    Integer suma = 0;
    String sumaString;
    Integer cantidad = 0;
    Integer idProducto;
    String nombreProducto;
    DefaultTableModel defaultTableModel;
    Usuario session = new Usuario();
    Producto consultaProducto = new Producto();
    List<CarroVenta> carros = new ArrayList<CarroVenta>();
    Cliente clienteFiado = null;

    public FormularioVenta(Usuario usuario) {
        this.session = usuario;
        initComponents();
        String cabecera[] = {"Producto", "Cantidad", "Precio Unitario", "Precio Total"};
        String dats[][] = {};
        defaultTableModel = new DefaultTableModel(dats, cabecera);
        jTable.setModel(defaultTableModel);

    }

    public FormularioVenta(Usuario usuario, Cliente cliente) {
        this.session = usuario;
        this.clienteFiado = cliente;
        initComponents();
        String cabecera[] = {"Producto", "Cantidad", "Precio Unitario", "Precio Total"};
        String dats[][] = {};
        defaultTableModel = new DefaultTableModel(dats, cabecera);
        jTable.setModel(defaultTableModel);
    }

    public FormularioVenta() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        codigoProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cantidadProductos = new javax.swing.JTextField();
        buscarButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        precioProducto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        totalLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        ingresarButton = new javax.swing.JButton();
        productoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Boleta");

        jLabel2.setText("Codigo Producto");

        codigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoProductoKeyTyped(evt);
            }
        });

        jLabel3.setText("Cantidad");

        cantidadProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadProductosKeyTyped(evt);
            }
        });

        buscarButton.setText("Buscar");
        buscarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarButtonMouseClicked(evt);
            }
        });

        jLabel4.setText("Precio Unidad");

        precioProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioProductoKeyTyped(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Cantidad", "Precio Unitario", "Precio Total"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        totalLabel.setText("0");

        jLabel6.setText("TOTAL");

        jButton2.setText("GUARDAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("ATRAS");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ingresarButton.setText("Ingresar");
        ingresarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarButtonActionPerformed(evt);
            }
        });

        productoLabel.setText("NOMBRE PRODUCTO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 374, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(42, 42, 42)
                                .addComponent(totalLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(productoLabel))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cantidadProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(codigoProducto))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(precioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ingresarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(codigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cantidadProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productoLabel)
                            .addComponent(ingresarButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(precioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalLabel)
                            .addComponent(jLabel6))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarButtonMouseClicked

        String codigoProducto = this.codigoProducto.getText();
        if (StringUtils.isNotEmpty(codigoProducto)) {
            ServicioDB servicioDB = new ServicioDB();
            Producto producto = servicioDB.getProducto(codigoProducto);
            this.consultaProducto = producto;
            if (producto != null) {
                this.productoLabel.setText(producto.getNombre());
                this.precioProducto.setText(producto.getValor().toString());
                this.cantidadProductos.setText(NumberUtils.numberToString(producto.getStock()));
                this.cantidad = producto.getStock();

                this.idProducto = producto.getId();
                this.nombreProducto = producto.getNombre();
            } else {
                JOptionPane.showMessageDialog(precioProducto, "Codigo no cohincide con ningún producto");
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarButtonMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

        MenuPrincipal menuPrincipal = new MenuPrincipal();
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void ingresarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarButtonActionPerformed

        Integer stock = consultaProducto.getStock();
        Integer cantidadCompra = NumberUtils.NumberUtils(this.cantidadProductos.getText());
        Float valorProducto = NumberUtils.numberFloat(this.precioProducto.getText());
        Integer valorInteger = Math.round(valorProducto);
        if (cantidadCompra != null) {
            if (valorProducto != null) {
                if (stock >= cantidadCompra) {
                    CarroVenta carroVenta = new CarroVenta();
                    carroVenta.setCantidadProducto(cantidadCompra);
                    carroVenta.setProducto_id(consultaProducto.getId());
                    carroVenta.setValor(valorInteger);
                    this.carros.add(carroVenta);
                    Integer resultado = cantidadCompra * valorInteger;
                    String total = NumberUtils.numberToString(resultado);
                    if (total != null) {
                        Object fila[] = {consultaProducto.getNombre(), cantidadProductos.getText(), precioProducto.getText(), total};
                        defaultTableModel.addRow(fila);
                        suma = NumberUtils.NumberUtils(this.totalLabel.getText());
                        suma += resultado;
                        sumaString = NumberUtils.numberToString(suma);
                        this.totalLabel.setText(sumaString);
                    }
                } else {
                    JOptionPane.showMessageDialog(precioProducto, "El stock es de " + consultaProducto.getStock().toString() + " Para este producto");
                }
            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_ingresarButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //guardar(lista)

        Double total = NumberUtils.numberDouble(this.totalLabel.getText());
        if (total != null) {
            Boleta boleta = new Boleta();
            Date fecha = new Date();
            boleta.setFecha(fecha);
            boleta.setMonto(total);
            boleta.setUsuario_id(session.getId());
            ServicioDB servicioDB = new ServicioDB();
            boolean salida = servicioDB.guardar(carros, boleta, this.clienteFiado);
            if (salida == true) {
                if (this.clienteFiado == null) {
                    MenuPrincipal menuPrincipal = new MenuPrincipal(this.session);
                    menuPrincipal.setVisible(true);
                    menuPrincipal.setLocationRelativeTo(null);
                    this.dispose();
                } else {
                    AbonoCliente abonoCliente = new AbonoCliente(session, clienteFiado);
                    abonoCliente.setVisible(true);
                    abonoCliente.setLocationRelativeTo(null);
                    this.dispose();
                }
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        MenuPrincipal menuPrincipal = new MenuPrincipal(this.session);
        menuPrincipal.setVisible(true);
        menuPrincipal.setLocationRelativeTo(null);
        this.dispose();

// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cantidadProductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadProductosKeyTyped

        Nletras(codigoProducto);
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadProductosKeyTyped

    private void precioProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioProductoKeyTyped

        Nletras(codigoProducto);
        // TODO add your handling code here:
    }//GEN-LAST:event_precioProductoKeyTyped

    private void codigoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoProductoKeyTyped

// TODO add your handling code here:
    }//GEN-LAST:event_codigoProductoKeyTyped

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
            java.util.logging.Logger.getLogger(FormularioVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarButton;
    private javax.swing.JTextField cantidadProductos;
    private javax.swing.JTextField codigoProducto;
    private javax.swing.JButton ingresarButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField precioProducto;
    private javax.swing.JLabel productoLabel;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
