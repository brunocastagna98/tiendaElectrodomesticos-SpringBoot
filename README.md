<h1 align="center">🛒 Tienda de Electrodomésticos - Proyecto de Microservicios</h1>

<p align="center">
  <b>Proyecto integrador con arquitectura de microservicios desarrollado con Java Spring Boot</b><br>
  <i>Productos · Carrito · Ventas · Eureka · API Gateway · Load Balancer · Circuit Breaker · Docker</i>
</p>

<hr>

<h2>Dispone de los siguientes Microservicios: </h2>

<ul>
  <li><b>Microservicio de Productos:</b> Gestiona los electrodomésticos disponibles. Permite listar, buscar por ID y agregar nuevos productos (código, nombre, marca, precio).</li>
  <li><b>Microservicio de Carrito de Compras:</b> Administra los carritos de los usuarios. Cada carrito tiene un <code>id</code> único y un <b>precio total</b> calculado a partir de sus productos.</li>
  <li><b>Microservicio de Ventas:</b> Registra las ventas, asociadas a un carrito existente. Cada venta incluye su <b>fecha, monto total y lista de productos</b>.</li>
</ul>

<hr>

<h2>Requerimientos Técnicos</h2>
<ol>
  <li>Configurar un <b>servidor Eureka</b> para el registro de servicios.</li>
  <li>Implementar <b>Spring Cloud Load Balancer</b> para distribuir peticiones entre instancias.</li>
  <li>Agregar <b>Resilience4J (Circuit Breaker + Retry)</b> para tolerancia a fallos.</li>
  <li>Configurar un <b>API Gateway</b> como punto de entrada para clientes externos.</li>
  <li><b>Dockerización completa:</b>
    <ul>
      <li>Dockerfile por servicio.</li>
      <li>Archivo <code>docker-compose.yml</code> para despliegue orquestado.</li>
      <li>Pruebas con Postman dentro del entorno Docker.</li>
    </ul>
  </li>
</ol>

<hr>

<h2>Endpoints principales</h2>

<h3>Microservicio de Productos (puerto 8081)</h3>

<ul>
  <li><b>Crear producto (POST)</b>  
    <code>http://localhost:8081/productos/crear</code>
  </li>
</ul>

<pre>
{
  "codigoProducto": 1003,
  "nombre": "Switch 2",
  "marca": "Nintendo",
  "precioUnitario": "1600000.00"
}
</pre>

<ul>
  <li><b>Buscar por ID (GET)</b>  
    <code>http://localhost:8081/productos/{id}</code>
  </li>
  <li><b>Listar todos (GET)</b>  
    <code>http://localhost:8081/productos/todos</code>
  </li>
  <li><b>Eliminar por ID (DELETE)</b>  
    <code>http://localhost:8081/productos/eliminar/{id}</code>
  </li>
  <li><b>Editar por ID (PUT)</b>  
    <code>http://localhost:8081/productos/editar/{id}</code>
  </li>
</ul>

<hr>

<h3>Microservicio de Carrito (puerto 8082)</h3>

<ul>
  <li><b>Crear carrito (POST)</b>  
    <code>http://localhost:8082/carrito/crear</code>
  </li>
</ul>

<p><i>Es necesario enviar la siguiente estructura, de lo contrario el carrito no se creará correctamente:</i></p>

<pre>
{
  "listaItems": [],
  "total": "0.00"
}
</pre>

<ul>
  <li><b>Traer carrito (GET)</b>  
    <code>http://localhost:8082/carrito/{id}</code>
  </li>
  <li><b>Traer carrito DTO (GET)</b>  
    <code>http://localhost:8082/carrito/{id}/dto</code>
  </li>
</ul>

<p><b>Carrito</b> → control total, pero expone todo.<br>
<b>CarritoDTO</b> → control limitado, más seguro y mantenible.</p>

<h4>Agregar productos a carrito</h4>

<p>Se agrega indicando el ID del carrito, el ID del producto y la cantidad:</p>
<code>http://localhost:8082/carrito/1/agregar/2?cantidad=3</code>

<pre>
{
  "idCarrito": 1,
  "listaItems": [
    {
      "idItem": 1,
      "idProducto": 2,
      "cantidad": 3,
      "subTotal": 4500000.00
    }
  ],
  "total": 4500000.00
}
</pre>

<p>Si luego agregamos otro producto:</p>

<code>http://localhost:8082/carrito/1/agregar/1?cantidad=1</code>

<pre>
{
  "idCarrito": 1,
  "listaItems": [
    {
      "idItem": 1,
      "idProducto": 2,
      "cantidad": 3,
      "subTotal": 4500000.00
    },
    {
      "idItem": 2,
      "idProducto": 1,
      "cantidad": 1,
      "subTotal": 250000.00
    }
  ],
  "total": 4750000.00
}
</pre>

<ul>
  <li><b>Eliminar carrito (DELETE)</b>  
    <code>http://localhost:8082/carrito/borrar/{id}</code>
  </li>
</ul>

<hr>

<h3>Microservicio de Ventas (puerto 8083)</h3>

<ul>
  <li><b>Crear venta desde carrito existente (POST)</b>  
    <code>http://localhost:8083/venta/crear?idCarrito={idCarrito}</code>
  </li>
  <li><b>Obtener venta (GET)</b>  
    <code>http://localhost:8083/venta/{idVenta}</code>
  </li>
</ul>

<hr>

<h2>Tecnologías Implementadas</h2>

<ul>
  <li>Java 17 · Spring Boot 3</li>
  <li>Spring Cloud (Eureka, Config, Gateway, Load Balancer, Resilience4J)</li>
  <li>JPA / Hibernate · MySQL</li>
  <li>Postman (para testing de endpoints)</li>
  <li>Docker & Docker Compose</li>
</ul>

<hr>

<h2>Arquitectura General</h2>
<p align="center">
  <i>API Gateway ➜ Eureka ➜ Productos / Carrito / Ventas</i><br>
  Comunicación mediante Feign Clients y balanceo automático entre instancias.
</p>

<hr>

<h2>Autor</h2>

<p>
  <b>Bruno Castagna</b><br>
  <i>Desarrollador Backend - Arquitecturas monolíticas y de microservicios</i><br>
  <a href="https://www.linkedin.com/in/brunocastagna98" target="_blank">💼 LinkedIn</a>
</p>
