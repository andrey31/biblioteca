/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biblioteca.biblioteca.modelos;

import com.biblioteca.biblioteca.modelos.entidades.Prestamo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author cesar
 */
public class PrestamoDAO extends Conexion {

    Calendar calender1 = Calendar.getInstance();
    java.sql.Date d1e = new java.sql.Date(calender1.getTime().getTime());

    Calendar calender2 = Calendar.getInstance();
    java.sql.Date d1 = new java.sql.Date(calender2.getTime().getTime());

    public boolean registrarPrestamo(Prestamo presta) throws ParseException {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "INSERT INTO Prestamos (id_prestamo,fecha_hora_prestamo,"
                + "fecha_hora_devolucion,fk_estudiante,fk_libro,"
                + "fk_usuario) VALUES (?,?,?,?,?,?)";
        try {

            ps = con.prepareStatement(sql);

            Calendar calender1 = Calendar.getInstance();
            java.sql.Date d1e = new java.sql.Date(calender1.getTime().getTime());

            Calendar calender2 = Calendar.getInstance();
            java.sql.Date d1 = new java.sql.Date(calender2.getTime().getTime());

            ps.setInt(1, presta.getId());
            ps.setDate(2, d1e);
            ps.setDate(3, d1);
            ps.setInt(4, presta.getIdestudiante());
            ps.setInt(5, presta.getISBNlibro());
            ps.setInt(6, presta.getCodigousuario());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }

    public List<Prestamo> getAllPrestamos() throws SQLException {

        PreparedStatement ps = null;
        Connection con = getConnection();

        String query = "SELECT id_prestamo, fecha_hora_prestamo, fecha_hora_devolucion,fk_estudiante, fk_libro,fk_usuario FROM Prestamos ";
//                + "INNER JOIN Libros on Prestamos.fk_libro = Libros.id_libro";

        ResultSet rs = con.prepareStatement(query).executeQuery();

        List<Prestamo> prestamos = new ArrayList<>();

        while (rs.next()) {
            Prestamo prestamo = new Prestamo(
                    rs.getInt("id_prestamo"),
                    rs.getString("fecha_hora_prestamo"),
                    rs.getString("fecha_hora_devolucion"),
                    rs.getInt("fk_estudiante"),
                    rs.getInt("fk_libro"),
                    rs.getInt("fk_usuario"));
            prestamos.add(prestamo);
        }

        con.close();
        return prestamos;
    }

    public boolean modificar(Prestamo presta) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "UPDATE Prestamos SET fecha_hora_prestamo=?, fecha_hora_devolucion=?, fk_estudiante=?, fk_libro=?,fk_usuario=? WHERE id_prestamo= ?";

        try {
            ps = con.prepareStatement(sql);
            Calendar calender1 = Calendar.getInstance();
            java.sql.Date d1e = new java.sql.Date(calender1.getTime().getTime());

            Calendar calender2 = Calendar.getInstance();
            java.sql.Date d1 = new java.sql.Date(calender2.getTime().getTime());

            ps.setDate(1, d1e);
            ps.setDate(2, d1);
            ps.setInt(3, presta.getIdestudiante());
            ps.setInt(4, presta.getISBNlibro());
            ps.setInt(5, presta.getCodigousuario());
            ps.setInt(6, presta.getId());

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean eliminar(Prestamo presta) {
        PreparedStatement ps = null;
        Connection con = getConnection();

        String sql = "DELETE FROM Prestamos WHERE id_prestamo= ? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, presta.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

    }
}
