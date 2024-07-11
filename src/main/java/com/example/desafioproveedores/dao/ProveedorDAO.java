package com.example.desafioproveedores.dao;
import com.example.desafioproveedores.models.Proveedor;
import com.example.desafioproveedores.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    private Connection connection;

    public ProveedorDAO() {
        connection = ConexionDB.getConnection();
    }

    // Métodos CRUD
    public void insertar(Proveedor proveedor) {
        String sql = "INSERT INTO proveedores (nombre, rut, direccion, correo, telefono, contacto, telefono_contacto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, proveedor.getNombre());
            statement.setString(2, proveedor.getRut());
            statement.setString(3, proveedor.getDireccion());
            statement.setString(4, proveedor.getCorreo());
            statement.setString(5, proveedor.getTelefono());
            statement.setString(6, proveedor.getContacto());
            statement.setString(7, proveedor.getTelefonoContacto());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Proveedor proveedor) {
        String sql = "UPDATE proveedores SET nombre=?, rut=?, direccion=?, correo=?, telefono=?, contacto=?, telefono_contacto=? WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, proveedor.getNombre());
            statement.setString(2, proveedor.getRut());
            statement.setString(3, proveedor.getDireccion());
            statement.setString(4, proveedor.getCorreo());
            statement.setString(5, proveedor.getTelefono());
            statement.setString(6, proveedor.getContacto());
            statement.setString(7, proveedor.getTelefonoContacto());
            statement.setInt(8, proveedor.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM proveedores WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Proveedor seleccionarPorId(int id) {
        Proveedor proveedor = null;
        String sql = "SELECT * FROM proveedores WHERE id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                proveedor = new Proveedor(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("rut"),
                        resultSet.getString("direccion"),
                        resultSet.getString("correo"),
                        resultSet.getString("telefono"),
                        resultSet.getString("contacto"),
                        resultSet.getString("telefono_contacto")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedor;
    }

    public List<Proveedor> seleccionarTodos() {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Proveedor proveedor = new Proveedor(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("rut"),
                        resultSet.getString("direccion"),
                        resultSet.getString("correo"),
                        resultSet.getString("telefono"),
                        resultSet.getString("contacto"),
                        resultSet.getString("telefono_contacto")
                );
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedores;
    }
}