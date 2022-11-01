<html lang="es">
<head>
    <meta charset="UTF-8"/>
    <title>Creacion de plato</title>

    </title>
</head>
<body>
    <h1>Formulario de creacion de platos</h1>
    <form name="crearPlato"
        action=""
        method="post">

        <!--Campos capturar entrada cliente-->
        <!--Fundamentalmente input-->
        <label for="idNombre">Nombre*</label>:<input type="text" name="nombre"< id="idNombre"/><br/><br/>
        <label for="idDescripcion">Descripcion*</label>:<input type="text" name="descripcion"< id="idDescripcion"/><br/><br/>
        <label for="idPrecio">Precio*</label>:<input type="text" name="precio"< id="idPrecio"/><br/><br/>
        <label for="idTipo">Tipo*</label>:<input type="text" name="tipo"< id="idTipo"/><br/><br/>
        <form:select path="cityTo">  
        <form:option value="Entrante" label="Entrante"/>  
        <form:option value="Principal" label="Principal"/>  
        <form:option value="Postre" label="Postre"/>  
        <form:option value="Bebida" label="Bebida"/>  
        </form:select>

        <label for="idVegano"></label>:<input type="checkbox" name="vegano" value="Vegano"/>Vegano < id="idAlergeno"/><br/><br/>

        <p>Los campos marcados con un asterisco deben rellenarse de forma obligatoria</p>
        <input type="submit" name="Crear plato"><input type="reset" name="Reiniciar valores"><br/>
    </form>
</body>

</html>