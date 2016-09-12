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
import org.boaboa.utils.SecurityUtils;

/**
 *
 * @author Alexandra Olivares Solis
 */
public class Main {

    public static void main(String[] args) {
        
//        Usuario usuario = new Usuario();
//        usuario.setNombre("Alexandra Olivares");
//        usuario.setRut(18942377);
//        usuario.setClave(SecurityUtils.sha256("password"));
//        usuario.setRol("admin");
//        
//        Usuario piza = new Usuario();
//        piza.setClave(SecurityUtils.sha256("password"));
//        piza.setNombre("Fernando rubilar");
//        piza.setRut(17708487);
//        piza.setRol("admin");
//        
//        ServicioDB servicioDB = new  ServicioDB();
//        boolean ale = servicioDB.guardar(usuario);
//        boolean yo = servicioDB.guardar(piza);   
//        if(ale){
//            JOptionPane.showMessageDialog(null,"guardo ale");
//        }else{
//           JOptionPane.showConfirmDialog(null, "no guardo ale");
//        }
//        if(yo){
//            JOptionPane.showConfirmDialog(null, "guardo yo");
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "no guardo piza");
//        }
//        

        Login form = new Login();
        form.setVisible(true);
        form.setLocationRelativeTo(null);

        
        
 
    }

}
