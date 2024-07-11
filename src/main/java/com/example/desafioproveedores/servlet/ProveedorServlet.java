package com.example.desafioproveedores.servlet;

import com.example.desafioproveedores.dao.ProveedorDAO;
import com.example.desafioproveedores.models.Proveedor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProveedorServlet")
public class ProveedorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProveedorDAO proveedorDAO;

    public ProveedorServlet() {
        super();
        proveedorDAO = new ProveedorDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.isEmpty() || action.equals("listar")) {
            listarProveedores(request, response);
        } else {
            switch (action) {
                case "nuevo":
                    mostrarFormularioNuevo(request, response);
                    break;
                case "editar":
                    mostrarFormularioEdicion(request, response);
                    break;
                case "eliminar":
                    eliminarProveedor(request, response);
                    break;
                default:
                    listarProveedores(request, response); // En caso de acción desconocida, listar proveedores por defecto
                    break;
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("insertar".equals(action)) {
            insertarProveedor(request, response);
        } else if ("actualizar".equals(action)) {
            actualizarProveedor(request, response);
        } else {
            response.sendRedirect("ProveedorServlet?action=listar");
        }
    }

    private void listarProveedores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Proveedor> listaProveedores = proveedorDAO.seleccionarTodos();
        request.setAttribute("listaProveedores", listaProveedores);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void mostrarFormularioNuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("proveedor_form.jsp").forward(request, response);
    }

    private void insertarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String contacto = request.getParameter("contacto");
        String telefonoContacto = request.getParameter("telefono_contacto");

        Proveedor proveedor = new Proveedor(nombre, rut, direccion, correo, telefono, contacto, telefonoContacto);
        proveedorDAO.insertar(proveedor);
        response.sendRedirect("ProveedorServlet?action=listar");
    }

    private void mostrarFormularioEdicion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Proveedor proveedorExistente = proveedorDAO.seleccionarPorId(id);
        request.setAttribute("proveedor", proveedorExistente);
        request.getRequestDispatcher("editar.jsp").forward(request, response);
    }

    private void actualizarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String contacto = request.getParameter("contacto");
        String telefonoContacto = request.getParameter("telefono_contacto");

        Proveedor proveedorActualizado = new Proveedor(id, nombre, rut, direccion, correo, telefono, contacto, telefonoContacto);
        proveedorDAO.actualizar(proveedorActualizado);
        response.sendRedirect("ProveedorServlet?action=listar");
    }

    private void eliminarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        proveedorDAO.eliminar(id);
        response.sendRedirect("ProveedorServlet?action=listar");
    }
}