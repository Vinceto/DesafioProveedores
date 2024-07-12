# Configuración del Servidor Tomcat en IntelliJ IDEA

Este proyecto requiere configurar Tomcat en IntelliJ IDEA para acceder a la URL específica para listar los proveedores.

## Requisitos

- IntelliJ IDEA
- Apache Tomcat 9
- PostgreSQL configurado y en funcionamiento

X. **Configurar la URL de Inicio**

   - Selecciona la pestaña `Server`.
   - En el apartado `URL`, especifica la siguiente ruta:

     ```
     http://localhost:8080/ProveedorServlet?action=listar
     ```
