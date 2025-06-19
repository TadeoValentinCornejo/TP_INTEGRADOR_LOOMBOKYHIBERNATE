package org.example;

import org.example.DAO.ClienteDAO;
import org.example.Entities.Cliente;
import org.example.Entities.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String usuario = "root";
        String clave = "";
        try (Connection conexion = DriverManager.getConnection(url, usuario, clave)) {

            Cliente cliente = Cliente.builder()
                    .id(2L)
                    .nombre("Marcos")
                    .apellido("Vega")
                    .email("marcos@example.com")
                    .telefono("532154251").
                    fechaNacimiento(LocalDate.of(2000, 2, 12))
                    .build();

            ClienteDAO clienteDAO = new ClienteDAO();
            // clienteDAO.save(conexion, cliente);
            // clienteDAO.delete(conexion,1L);
            Cliente cliente2 = clienteDAO.getById(conexion, cliente.getId());
            System.out.println(cliente2);

        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a la base de datos.");
            e.printStackTrace();
    }
}
}