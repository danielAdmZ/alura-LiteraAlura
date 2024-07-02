<h1 style="text-align:center">Reto Alura de Libreria</h1>
<hr>
<h2 style="text-align:center" >Daniel Jesus Vadillo Cocom</h2>
<hr>
<p>Este proyecto se creó con la finalidad de poder dar continudad a mis estudios como desarrollador Java, en este caso se está utilizando el framework de Spring para lograr crear una libreria virtual establecida principalmente en vista de consola.</p>
<h3>Menu del programa</h3>
<img src="menu-consola.png">
<h4>Funcionalidades del programa</h4>
<ul>
    <li>
    <h5>Buscar libro</h5>
    <p>Basado en un sistema de consulta a una API, la cual nos devuelve un JSON con la información de varios libros, las cuales van a ser listados para el usuario pueda selecionar alguno con su ID, para guardarlo.</p>
    <img src="buscar-libro.png">
    </li>
    <li>
    <h5>Listar Libro Registrado</h5>
    <p>Una vez almacenado en la base de datos el usuario puede ver un registro de los libros guardados mediante una consulta usando el complemento de JPA en Java y haciendo una consulta a la base de datos PostgreSQL</p>
    <img src="listar-libros.png" style="width:600px">
    </li>
     <li>
    <h5>Listar Autores Registrados</h5>
    <p>Cuando un libro se guarda este también guarda el autor un momento después, esto es debido a la relación que se tiene con la base de datos, por lo cual la persona también puede consultar a los autores guardados.</p>
    <img src="listar-autores.png" style="width:600px">
    </li>
     <li>
    <h5>Listar autores por año vivo</h5>
    <p>Como parte de crear un filtro de busquedas el usuario puede solicitar buscar a autores de acuerdo al año en que el aun vivian.</p>
    <img src="listar-por-anio.png" style="width:600px" >
    </li>
     <li>
    <h5>Listar Libro por Idioma</h5>
    <p>Otra forma de filtrar información es con base a los idiomas que puedan contener los libros, para esta caso los libros pueden almacenar 2 idiomas, en caso de que no disponga de uno de ellos en la base de datos el campo se llena con "Sin lenguaje".</p>
    <img src="listar-por-idioma.png">
    </li>
    
</ul>
<hr>
<h3>La API de los libros la pueden obtener <a href="https://gutendex.com/">aqui</a></h3>