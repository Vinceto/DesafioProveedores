<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.desafioproveedores.models.Proveedor" %>
<%@ page import="java.util.List" %>
<%@ include file="head.jsp" %>
<body>
    <div class="container">
        <h1 class="mt-5">Lista de Proveedores</h1>
        <div class="mb-3">
            <a href="ProveedorServlet?action=nuevo" class="btn btn-primary">
                <i class="bi bi-plus-circle"></i> Agregar Proveedor
            </a>
        </div>

        <% List<Proveedor> listaProveedores = (List<Proveedor>) request.getAttribute("listaProveedores"); %>
        <% if (listaProveedores == null || listaProveedores.isEmpty()) { %>
        <div class="alert alert-info" role="alert">
            No hay proveedores registrados.
        </div>
        <% } else { %>
        <div class="table-responsive">
            <table id="proveedoresTable" class="table table-dark table-hover display">
                <thead>
                <tr>
                    <th scope="col">Nombre</th>
                    <th scope="col">RUT</th>
                    <th scope="col">Dirección</th>
                    <th scope="col">Correo</th>
                    <th scope="col">Teléfono</th>
                    <th scope="col">Contacto</th>
                    <th scope="col">Teléfono Contacto</th>
                    <th scope="col">Acciones</th>
                </tr>
                </thead>
                <tbody>
                <% for (Proveedor proveedor : listaProveedores) { %>
                <tr>
                    <td><%= proveedor.getNombre() %></td>
                    <td><%= proveedor.getRut() %></td>
                    <td><%= proveedor.getDireccion() %></td>
                    <td><%= proveedor.getCorreo() %></td>
                    <td><%= proveedor.getTelefono() %></td>
                    <td><%= proveedor.getContacto() %></td>
                    <td><%= proveedor.getTelefonoContacto() %></td>
                    <td>
                        <a href="ProveedorServlet?action=editar&id=<%= proveedor.getId() %>" class="btn btn-warning btn-sm">
                            <i class="bi bi-pencil-square"></i>
                        </a>
                        <a href="ProveedorServlet?action=eliminar&id=<%= proveedor.getId() %>" class="btn btn-danger btn-sm">
                            <i class="bi bi-trash"></i>
                        </a>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
        <% } %>
    </div>
    <%@ include file="footer.jsp" %>
    <script><%@ include file="assets/js/scripts.js" %></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <!-- DataTables JS -->
    <script src="https://cdn.datatables.net/2.0.8/js/dataTables.js"></script>
</body>