package org.example.DAO;

import org.example.Entities.Cliente;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public Cliente getById(Connection conex, Long id) throws SQLException {
        String sqlSelect = "SELECT * FROM cliente WHERE id = ?";
        try (PreparedStatement psSelect = conex.prepareStatement(sqlSelect)) {
            psSelect.setLong(1, id);
            try (ResultSet rs = psSelect.executeQuery()) {
                if (rs.next()) {
                    return Cliente.builder()
                            .id(rs.getLong("id"))
                            .nombre(rs.getString("nombre"))
                            .apellido(rs.getString("apellido"))
                            .telefono(rs.getString("telefono"))
                            .email(rs.getString("email"))
                            .fechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate())
                            .build();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    public List<Cliente> getAll(Connection conex) throws SQLException {
        String sqlSelectAll = "SELECT * FROM cliente";
        List<Cliente> listaClientes = new ArrayList<>();

        try (PreparedStatement psSelectAll = conex.prepareStatement(sqlSelectAll);
             ResultSet rs = psSelectAll.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = Cliente.builder()
                        .id(rs.getLong("id"))
                        .nombre(rs.getString("nombre"))
                        .apellido(rs.getString("apellido"))
                        .telefono(rs.getString("telefono"))
                        .email(rs.getString("email"))
                        .fechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate())
                        .build();
                listaClientes.add(cliente);
            }
        }

        return listaClientes;
    }

    public void save(Connection conex, Cliente cliente) throws SQLException {
        String sqlInsert = "INSERT INTO cliente (nombre, apellido, telefono, email, fecha_nacimiento) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement psInsert = conex.prepareStatement(sqlInsert)) {
            psInsert.setString(1, cliente.getNombre());
            psInsert.setString(2, cliente.getApellido());
            psInsert.setString(3, cliente.getTelefono());
            psInsert.setString(4, cliente.getEmail());
            psInsert.setDate(5, Date.valueOf(cliente.getFechaNacimiento()));
            int filasInsertadas = psInsert.executeUpdate();
            System.out.println("🔵 Filas insertadas: " + filasInsertadas);
        }
    }

    public void update(Connection conex, Cliente cliente) throws SQLException {
        String sqlUpdate = "UPDATE cliente SET nombre = ?, apellido = ?, telefono = ?, email = ?, fecha_nacimiento = ? WHERE id = ?";

        try (PreparedStatement psUpdate = conex.prepareStatement(sqlUpdate)) {
            psUpdate.setString(1, cliente.getNombre());
            psUpdate.setString(2, cliente.getApellido());
            psUpdate.setString(3, cliente.getTelefono());
            psUpdate.setString(4, cliente.getEmail());
            psUpdate.setDate(5, Date.valueOf(cliente.getFechaNacimiento()));
            psUpdate.setLong(6, cliente.getId());
            int filasActualizadas = psUpdate.executeUpdate();
            System.out.println("🟡 Filas actualizadas: " + filasActualizadas);
        }
    }

    public void delete(Connection conex, Long id) throws SQLException {
        String sqlDelete = "DELETE FROM cliente WHERE id = ?";

        try (PreparedStatement psDelete = conex.prepareStatement(sqlDelete)) {
            psDelete.setLong(1, id);
            int filasEliminadas = psDelete.executeUpdate();
            System.out.println("🔴 Filas eliminadas: " + filasEliminadas);
        }
    }
}
