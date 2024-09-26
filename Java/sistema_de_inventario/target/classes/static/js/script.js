document.addEventListener('DOMContentLoaded', function () {
    const productoForm = document.getElementById('productoForm');
    const btnGuardar = document.getElementById('btnGuardar');
    const btnLimpiar = document.getElementById('btnLimpiar');
    const productosTable = document.getElementById('productosTable').getElementsByTagName('tbody')[0];

    // Cargar productos al inicio
    cargarProductos();

    // Manejar el evento de envío del formulario
    productoForm.addEventListener('submit', function (e) {
        e.preventDefault();
        const idProducto = document.getElementById('idProducto').value;
        if (idProducto) {
            modificarProducto(idProducto);
        } else {
            agregarProducto();
        }
    });

    // Limpiar formulario
    btnLimpiar.addEventListener('click', function () {
        limpiarFormulario();
    });

    // Función para cargar productos desde el API
    function cargarProductos() {
        fetch('/api/productos')
            .then(response => response.json())
            .then(data => {
                productosTable.innerHTML = '';
                data.forEach(producto => {
                    const row = productosTable.insertRow();
                    row.innerHTML = `
                        <td>${producto.id}</td>
                        <td>${producto.nombre}</td>
                        <td>${producto.descripcion}</td>
                        <td>${producto.cantidad}</td>
                        <td>${producto.precio}</td>
                        <td>${producto.categoria}</td>
                        <td class="actions">
                            <button onclick="editarProducto(${producto.id})">Editar</button>
                            <button class="eliminar" onclick="eliminarProducto(${producto.id})">Eliminar</button>
                        </td>
                    `;
                });
            })
            .catch(error => console.error('Error al cargar productos:', error));
    }

    // Función para agregar un producto
    function agregarProducto() {
        const nuevoProducto = obtenerDatosFormulario();
        fetch('/api/productos', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(nuevoProducto)
        })
            .then(response => response.json())
            .then(() => {
                limpiarFormulario();
                cargarProductos();
            })
            .catch(error => console.error('Error al agregar producto:', error));
    }

    // Función para modificar un producto
    function modificarProducto(id) {
        const productoModificado = obtenerDatosFormulario();
        fetch(`/api/productos/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(productoModificado)
        })
            .then(() => {
                limpiarFormulario();
                cargarProductos();
            })
            .catch(error => console.error('Error al modificar producto:', error));
    }

    // Función para eliminar un producto
    window.eliminarProducto = function (id) {
        fetch(`/api/productos/${id}`, { method: 'DELETE' })
            .then(() => cargarProductos())
            .catch(error => console.error('Error al eliminar producto:', error));
    };

    // Función para editar un producto (rellena el formulario)
    window.editarProducto = function (id) {
        fetch(`/api/productos/${id}`)
            .then(response => response.json())
            .then(producto => {
                document.getElementById('idProducto').value = producto.id;
                document.getElementById('nombre').value = producto.nombre;
                document.getElementById('descripcion').value = producto.descripcion;
                document.getElementById('cantidad').value = producto.cantidad;
                document.getElementById('precio').value = producto.precio;
                document.getElementById('categoria').value = producto.categoria;
            })
            .catch(error => console.error('Error al cargar producto para editar:', error));
    };

    // Función para obtener los datos del formulario
    function obtenerDatosFormulario() {
        return {
            nombre: document.getElementById('nombre').value,
            descripcion: document.getElementById('descripcion').value,
            cantidad: document.getElementById('cantidad').value,
            precio: document.getElementById('precio').value,
            categoria: document.getElementById('categoria').value
        };
    }

    // Función para limpiar el formulario
    function limpiarFormulario() {
        document.getElementById('idProducto').value = '';
        document.getElementById('productoForm').reset();
    }
});
