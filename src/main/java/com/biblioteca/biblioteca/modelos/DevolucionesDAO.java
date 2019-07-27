package com.biblioteca.biblioteca.modelos;

import com.biblioteca.biblioteca.modelos.entidades.Devoluciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author msalazar02
 */
public class DevolucionesDAO {

    private Conexion conexion = new Conexion();

    public Integer saveDevolucion(Devoluciones devolucion) throws SQLException {
        conexion.connect();
        Connection connection = conexion.getConnection();
        String query = "INSERT INTO `Devoluciones`(`fk_prestamo`, `multa`) VALUES (?, ?)";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setInt(1, devolucion.getFk_prestamo());
        ps.setDouble(2, devolucion.getMulta());
        //ps.setDate(3, devolucion.getFechaDevolucion());

        int insert = ps.executeUpdate();
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
        String query = "SELECT * FROM `Devoluciones`";
        ResultSet rs = connection.prepareStatement(query).executeQuery();

        List<Devoluciones> listDevoluciones = new ArrayList<>();

        while (rs.next()) {
            Devoluciones devolucion = new Devoluciones(
                    rs.getInt("id"),
                    rs.getDate("fecha"),
                    rs.getDouble("multa"),
                    rs.getInt("fk_prestamo")
            );

            listDevoluciones.add(devolucion);

        }
        conexion.closeConnection();
        return listDevoluciones;
    }

}
