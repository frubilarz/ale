/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.boaboa.servicio;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.boaboa.modelos.Boleta;
import org.boaboa.modelos.CarroVenta;
import org.boaboa.modelos.Cliente;
import org.boaboa.modelos.Producto;
import org.boaboa.modelos.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Alexandra Olivares Solis
 */
public class ServicioDB implements Serializable {

    private boolean conectado = false;
    private Connection conexion = null;
    private static Logger logger = LoggerFactory.getLogger(ServicioDB.class);

    @PostConstruct
    public void iniciar() {
        boolean ok = conectar();
        if (!ok) {
            logger.info("ERROR: no fue posible conectarme a la base de datos");
        }

    }

    boolean conectar() {
        this.conectado = false;
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/buticpatydb?autoReconnect=true&useSSL=false";
            Properties props = new Properties();
            props.setProperty("user", "butic");
            props.setProperty("password", "butic+123");
//            props.setProperty("ssl", "true");
            this.conexion = DriverManager.getConnection(url, props);

            if (conexion != null) {
                this.conectado = true;
            } else {
                this.conectado = false;
            }

            if (!conectado) {
                throw new RuntimeException("No se puede conectar al motor de base de datos.");
            }

        } catch (Exception e) {
            this.conectado = false;
            logger.error(e.toString());
            logger.debug("Error al conectar con Base de datos", e.toString());
        }
        return conectado;
    }

    boolean desconectar() {
        try {
            if (conexion != null) {
                conexion.close();
                conexion = null;
                conectado = false;
            } else {
                conectado = false;
            }
        } catch (Exception e) {
            conexion = null;
            conectado = false;
            logger.error(e.toString());
            logger.debug("Error al conectar con Base de datos", e.toString());
        }
        return conectado;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    @PreDestroy
    public void finalizar() {
        boolean desconectar = desconectar();
        if (desconectar) {
            logger.info("ERROR: conexión aún activa");
        }
    }

    public boolean guardar(Usuario usuario) {
        boolean salida = false;
        try {
            if (usuario != null) {
                if (!isConectado()) {
                    conectar();
                }
                boolean update = false;
                if (usuario.getId() != null) {
                    if (usuario.getId() > 0) {
                        update = true;
                    }
                }
                PreparedStatement st = null;
                String query = "";

                if (update) {
                    query = "UPDATE usuarios SET nombre=?, rut=? ,clave=?, rol=?"
                            + "WHERE id = ?";
                    st = conexion.prepareStatement(query);
                    st.setString(1, usuario.getNombre());
                    st.setInt(2, usuario.getRut());
                    st.setString(3, usuario.getClave());
                    st.setString(4, usuario.getRol());
                    st.setInt(5, usuario.getId());
                } else {
                    query = "INSERT INTO usuarios (nombre, rut, clave,rol)"
                            + " VALUES (?, ?, ?, ?)";
                    st = conexion.prepareStatement(query);

                    st.setString(1, usuario.getNombre());
                    st.setInt(2, usuario.getRut());
                    st.setString(3, usuario.getClave());
                    st.setString(4, usuario.getRol());
                }
                if (st != null) {
                    logger.info(st.toString());
                    st.execute();

                    int updateCount = st.getUpdateCount();
                    if (updateCount > 0) {
                        salida = true;
                    }
                }
            }

        } catch (Exception e) {
            salida = false;
            logger.debug("error : {}", e.toString(), e);
            logger.error("Error : {}", e.toString());
        }
        return salida;
    }

    public boolean eliminar(Cliente cliente) {
        boolean salida = false;
        try {
            if (cliente != null) {
                if (!isConectado()) {
                    conectar();
                }
            }

            PreparedStatement st = null;
            String query = "DELETE FROM clientes WHERE id= ?";
            st = conexion.prepareStatement(query);
            if (st != null) {
                st.setInt(1, cliente.getId());
                st.execute();
                st.close();
                salida = true;
            }

        } catch (Exception e) {
            logger.debug("error : {}", e.toString(), e);
            logger.error("Error : {}", e.toString());
            salida = false;
        }
        return salida;
    }

    public boolean guardar(Cliente cliente) {
        boolean salida = false;
        try {
            if (cliente != null) {
                if (!isConectado()) {
                    conectar();
                }
                boolean update = false;
                if (cliente.getId() != null) {
                    if (cliente.getId() > 0) {
                        update = true;
                    }
                }
                PreparedStatement st = null;
                String query = "";

                if (update) {
                    query = "UPDATE clientes SET nombre=?, rut=? ,telefono=?, correo=?, direccion=? "
                            + "WHERE id = ?";
                    st = conexion.prepareStatement(query);
                    st.setString(1, cliente.getNombre());
                    st.setInt(2, cliente.getRut());
                    st.setInt(3, cliente.getTelefono());
                    st.setString(4, cliente.getCorreo());
                    st.setString(5, cliente.getDireccion());
                    st.setInt(6, cliente.getId());

                } else {

                    query = "INSERT INTO clientes (nombre,rut,telefono,correo,direccion)"
                            + " VALUES (?,?,?,?,?)";
                    st = conexion.prepareStatement(query);

                    st.setString(1, cliente.getNombre());
                    st.setInt(2, cliente.getRut());
                    st.setInt(3, cliente.getTelefono());
                    st.setString(4, cliente.getCorreo());
                    st.setString(5, cliente.getDireccion());
                    Integer uno = 1;
                }
                if (st != null) {
                    logger.info(st.toString());
                    st.execute();

                    int updateCount = st.getUpdateCount();
                    if (updateCount > 0) {
                        salida = true;
                    }
                }
            }

        } catch (Exception e) {
            salida = false;
            logger.debug("error : {}", e.toString(), e);
            logger.error("Error : {}", e.toString());
        }
        return salida;
    }

    public boolean guardar(List<CarroVenta> carroVentas, Boleta boleta) {
        boolean salida = false;
        try {
            if (carroVentas != null) {
                if (boleta != null) {
                    if (!isConectado()) {
                        conectar();
                    }
                    PreparedStatement st = null;
                    String query = "";
                    query = "INSERT INTO boletas (fecha, monto, usuario_id)"
                            + " VALUES (NOW(), ?, ?)";

                    st = conexion.prepareStatement(query, new String[]{"id"});
                    st.setDouble(1, boleta.getMonto());
                    st.setInt(2, boleta.getUsuario_id());
                    if (st != null) {
                        logger.info(st.toString());
                        st.execute();
                        Integer key = -1;
                        ResultSet rs = st.getGeneratedKeys(); // para ver el id generado
                        if (rs != null && rs.next()) {
                            key = rs.getInt(1);
                        }
                        int updateCount = st.getUpdateCount();
                        if (updateCount > 0) {
                            salida = true;
                        }
                        for (CarroVenta carro : carroVentas) {
                            PreparedStatement st2 = null;
                            String query2 = "";
                            query = "INSERT INTO carros_ventas (producto_id, boleta_id, cantidad,valor)"
                                    + " VALUES (?,?, ?, ?)";

                            st = conexion.prepareStatement(query);
                            Producto producto = getProducto(carro.getProducto_id());
                            Integer diferencia= producto.getStock()-carro.getCantidadProducto();
                            producto.setStock(diferencia);
                            guardar(producto);
                            st.setInt(1, carro.getProducto_id());
                            st.setInt(2, key);
                            st.setInt(3, carro.getCantidadProducto());
                            st.setInt(4, carro.getValor());
                            if (st != null) {
                                logger.info(st.toString());
                                st.execute();
                                int updateCount2 = st.getUpdateCount();
                                if (updateCount2 > 0) {
                                    salida = true;
                                }
                            }
                        }
                    }

                }
            }
        } catch (Exception e) {
        }
        return salida;
    }

    public boolean guardar(Producto producto) {
        boolean salida = false;
        try {
            if (producto != null) {
                if (!isConectado()) {
                    conectar();
                }
                boolean update = false;
                if (producto.getId() != null) {
                    if (producto.getId() > 0) {
                        update = true;
                    }
                }
                PreparedStatement st = null;
                String query = "";

                if (update) {
                    query = "UPDATE productos SET nombre=?, codigo=? ,descripcion=?, stock=?, valor=? "
                            + "WHERE id = ?";
                    st = conexion.prepareStatement(query);
                    st.setString(1, producto.getNombre());
                    st.setString(2, producto.getCodigo());
                    st.setString(3, producto.getDescripcion());
                    st.setInt(4, producto.getStock());
                    st.setFloat(5, producto.getValor());
                    st.setInt(6, producto.getId());

                } else {
                    query = "INSERT INTO productos (nombre, codigo, descripcion,stock,valor)"
                            + " VALUES (?, ?, ?, ?,?)";
                    st = conexion.prepareStatement(query);

                    st.setString(1, producto.getNombre());
                    st.setString(2, producto.getCodigo());
                    st.setString(3, producto.getDescripcion());
                    st.setInt(4, producto.getStock());
                    st.setFloat(5, producto.getValor());
                }
                if (st != null) {
                    logger.info(st.toString());
                    st.execute();

                    int updateCount = st.getUpdateCount();
                    if (updateCount > 0) {
                        salida = true;
                    }
                }
            }

        } catch (Exception e) {
            salida = false;
            logger.debug("error : {}", e.toString(), e);
            logger.error("Error : {}", e.toString());
        }
        return salida;
    }

    public Cliente getCliente(Integer id) {
        Cliente cliente = null;
        try {
            if (id != null) {
                if (!isConectado()) {
                    conectar();
                }
                PreparedStatement st = null;
                String query = "SELECT * FROM clientes WHERE id = ?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, id);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            cliente = new Cliente();
                            cliente.setDireccion(rs.getString("direccion"));
                            cliente.setCorreo(rs.getString("correo"));
                            cliente.setTelefono(rs.getInt("telefono"));
                            cliente.setNombre(rs.getString("nombre"));
                            cliente.setRut(rs.getInt("rut"));
                            cliente.setId(rs.getInt("id"));

                        }
                        rs.close();
                    }
                    st.close();
                }

            }
        } catch (Exception e) {
            cliente = null;
            logger.debug("Error al intentar obtener cliente por id : {}", e.toString(), e);
            logger.error("Error al intentar obtener cliente por id : {}", e.toString());
        }
        return cliente;
    }

    public Cliente getClientePorRut(Integer rut) {
        Cliente cliente = null;
        try {
            if (rut != null) {
                if (!isConectado()) {
                    conectar();
                }
                PreparedStatement st = null;
                String query = "SELECT * FROM clientes WHERE rut = ?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, rut);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            cliente = new Cliente();
                            cliente.setDireccion(rs.getString("direccion"));
                            cliente.setCorreo(rs.getString("correo"));
                            cliente.setTelefono(rs.getInt("telefono"));
                            cliente.setNombre(rs.getString("nombre"));
                            cliente.setRut(rs.getInt("rut"));
                            cliente.setId(rs.getInt("id"));

                        }
                        rs.close();
                    }
                    st.close();
                }

            }
        } catch (Exception e) {
            cliente = null;
            logger.debug("Error al intentar obtener cliente por id : {}", e.toString(), e);
            logger.error("Error al intentar obtener cliente por id : {}", e.toString());
        }
        return cliente;
    }

    public Usuario getUsuario(Integer rut) {
        Usuario usuario = null;
        try {
            if (rut != null) {
                if (!isConectado()) {
                    conectar();
                }
                PreparedStatement st = null;
                String query = "SELECT * FROM usuarios WHERE rut = ?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, rut);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            usuario = new Usuario();
                            usuario.setClave(rs.getString("clave"));
                            usuario.setRol(rs.getString("rol"));
                            usuario.setNombre(rs.getString("nombre"));
                            usuario.setRut(rs.getInt("rut"));
                            usuario.setId(rs.getInt("id"));

                        }
                        rs.close();
                    }
                    st.close();
                }

            }
        } catch (Exception e) {
            usuario = null;
            logger.debug("Error al intentar obtener cliente por id : {}", e.toString(), e);
            logger.error("Error al intentar obtener cliente por id : {}", e.toString());
        }
        return usuario;
    }

    public Producto getProducto(String codigo) {
        Producto producto = null;
        try {
            if (codigo != null) {
                if (!isConectado()) {
                    conectar();
                }
                PreparedStatement st = null;
                String query = "SELECT * FROM productos WHERE codigo = ?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setString(1, codigo);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            producto = new Producto();
                            producto.setId(rs.getInt("id"));
                            producto.setNombre(rs.getString("nombre"));
                            producto.setCodigo(rs.getString("codigo"));
                            producto.setDescripcion(rs.getString("descripcion"));
                            producto.setStock(rs.getInt("stock"));
                            producto.setValor(rs.getFloat("valor"));
                        }
                        rs.close();
                    }
                    st.close();
                }

            }
        } catch (Exception e) {
            producto = null;
            logger.debug("Error al intentar obtener cliente por id : {}", e.toString(), e);
            logger.error("Error al intentar obtener cliente por id : {}", e.toString());
        }
        return producto;
    }
    
    
    public Producto getProducto(Integer id) {
        Producto producto = null;
        try {
            if (id != null) {
                if (!isConectado()) {
                    conectar();
                }
                PreparedStatement st = null;
                String query = "SELECT * FROM productos WHERE id = ?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, id);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            producto = new Producto();
                            producto.setId(rs.getInt("id"));
                            producto.setNombre(rs.getString("nombre"));
                            producto.setCodigo(rs.getString("codigo"));
                            producto.setDescripcion(rs.getString("descripcion"));
                            producto.setStock(rs.getInt("stock"));
                            producto.setValor(rs.getFloat("valor"));
                        }
                        rs.close();
                    }
                    st.close();
                }

            }
        } catch (Exception e) {
            producto = null;
            logger.debug("Error al intentar obtener cliente por id : {}", e.toString(), e);
            logger.error("Error al intentar obtener cliente por id : {}", e.toString());
        }
        return producto;
    }

    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            if (!isConectado()) {
                conectar();
            }
            PreparedStatement st = null;
            String query = "SELECT * FROM clientes ";
            st = conexion.prepareStatement(query);
            if (st != null) {
                ResultSet rs = st.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        Cliente cliente = new Cliente();

                        cliente.setId(rs.getInt("id"));
                        cliente.setDireccion(rs.getString("direccion"));
                        cliente.setCorreo(rs.getString("correo"));
                        cliente.setTelefono(rs.getInt("telefono"));
                        cliente.setNombre(rs.getString("nombre"));
                        cliente.setRut(rs.getInt("rut"));

                        clientes.add(cliente);
                    }
                    rs.close();
                }
                st.close();
            }

        } catch (Exception e) {
            clientes = new ArrayList<Cliente>();
            logger.debug("Error al intentar obtener todos los clientes: {}", e.toString(), e);
            logger.error("Error al intentar obtener todos los clientes: {}", e.toString());
        }
        return clientes;
    }

}
