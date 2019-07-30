package com.biblioteca.biblioteca.modelos;

import com.biblioteca.biblioteca.modelos.entidades.Devoluciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author msalazar02
 */
public class DevolucionesDAO {

    private Conexion conexion = new Conexion();

    public Integer saveDevolucion(Devoluciones devolucion) {
        int insert = 0;
        try {
            conexion.connect();
            Connection connection = conexion.getConnection();
            String query = "INSERT INTO `Devoluciones`(`fecha`, `multa`, `fk_prestamo`) VALUES (?,?,?)";

            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, devolucion.getFechaDevolucion());
            ps.setDouble(2, devolucion.getMulta());
            ps.setInt(3, devolucion.getFk_prestamo());

            insert = ps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "**" + ex.getMessage() + "**");
        }
        conexion.closeConnection();
        return insert;
    }

    public Integer deleteDevolucion(int id) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "DELETE FROM `Devoluciones` WHERE `id` =?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        int delete = ps.executeUpdate();
        conexion.closeConnection();
        return delete;
    }

    public List<Devoluciones> findAllDevoluciones() throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT `id`, p.fecha_hora_devolucion as 'fechaPropuesta', `fecha`, `multa`, `fk_prestamo` "
                + "FROM Devoluciones d, Prestamos p WHERE fk_prestamo = p.id_prestamo";
        ResultSet rs = connection.prepareStatement(query).executeQuery();

        List<Devoluciones> listDevoluciones = new ArrayList<>();

        while (rs.next()) {

            Devoluciones devolucion = new Devoluciones(
                    rs.getInt("id"),
                    rs.getString("fechaPropuesta"),
                    rs.getString("fecha"),
                    rs.getDouble("multa"),
                    rs.getInt("fk_prestamo")
            );

            listDevoluciones.add(devolucion);

        }

        conexion.closeConnection();
        return listDevoluciones;
    }

    public boolean devoluciónExiste(int idPrestamo) throws SQLException {
        boolean result = false;
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "SELECT `fk_prestamo` "
                + "FROM Devoluciones d, Prestamos p WHERE fk_prestamo = p.id_prestamo and fk_prestamo= ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, idPrestamo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            result = true;
        }
        return result;
    }

    public void updateDevolucion(Devoluciones dev) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "UPDATE `Devoluciones` SET `fecha`=?,`multa`=? WHERE `id` =?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, dev.getFechaDevolucion());
        ps.setDouble(2, dev.getMulta());
        ps.setInt(3, dev.getId());
        ps.executeUpdate();
        conexion.closeConnection();
    }

    public void deleteDevolucion(Devoluciones dev) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();

        String query = "DELETE FROM `Devoluciones` WHERE `id` =?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, dev.getId());
        ps.executeUpdate();
        conexion.closeConnection();
    }
}
