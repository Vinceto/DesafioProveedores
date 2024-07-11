<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ page import="com.example.desafioproveedores.models.Proveedor" %>

<div class="container">
    <h1 class="mt-5">Editar Proveedor</h1>
    <form action="ProveedorServlet?action=actualizar" method="post">
        <input type="hidden" name="id" value="<%= ((Proveedor) request.getAttribute("proveedor")).getId() %>">
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombre" value="<%= ((Proveedor) request.getAttribute("proveedor")).getNombre() %>" required>
        </div>
        <div class="mb-3">
            <label for="rut" class="form-label">RUT</label>
            <input type="text" class="form-control" id="rut" name="rut" value="<%= ((Proveedor) request.getAttribute("proveedor")).getRut() %>" required>
        </div>
        <div class="mb-3">
            <label for="direccion" class="form-label">Dirección</label>
            <input type="text" class="form-control" id="direccion" name="direccion" value="<%= ((Proveedor) request.getAttribute("proveedor")).getDireccion() %>" required>
        </div>
        <div class="mb-3">
            <label for="correo" class="form-label">Correo</label>
            <input type="email" class="form-control" id="correo" name="correo" value="<%= ((Proveedor) request.getAttribute("proveedor")).getCorreo() %>" required>
        </div>
        <div class="mb-3">
            <label for="telefono" class="form-label">Teléfono</label>
            <input type="tel" class="form-control" id="telefono" name="telefono" value="<%= ((Proveedor) request.getAttribute("proveedor")).getTelefono() %>" required>
        </div>
        <div class="mb-3">
            <label for="contacto" class="form-label">Contacto</label>
            <input type="text" class="form-control" id="contacto" name="contacto" value="<%= ((Proveedor) request.getAttribute("proveedor")).getContacto() %>" required>
        </div>
        <div class="mb-3">
            <label for="telefono_contacto" class="form-label">Teléfono Contacto</label>
            <input type="tel" class="form-control" id="telefono_contacto" name="telefono_contacto" value="<%= ((Proveedor) request.getAttribute("proveedor")).getTelefonoContacto() %>" required>
        </div>
        <button type="submit" class="btn btn-primary">Actualizar</button>
    </form>
</div>

<%@ include file="footer.jsp" %>