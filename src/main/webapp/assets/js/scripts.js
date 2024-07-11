$('#proveedoresTable').DataTable({
    "paging": true,
    "pageLength": 10,
    "lengthMenu": [10, 25, 50, 75, 100],  // Opcional: permite seleccionar diferentes cantidades por página
    "language": {
        "emptyTable": "No se encontraron proveedores",
        "info": "Mostrando _START_ a _END_ de _TOTAL_ proveedores",
        "infoEmpty": "Mostrando 0 a 0 de 0 proveedores",
        "infoFiltered": "(filtrado de _MAX_ proveedores en total)",
        "zeroRecords": "No se encontraron proveedores coincidentes",
        "paginate": {
            "first": "Primero",
            "last": "Último",
            "next": "Siguiente",
            "previous": "Anterior"
        }
    }
});