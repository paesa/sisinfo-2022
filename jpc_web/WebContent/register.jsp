<html lang="es">
<head>
    <meta charset="UTF-8"/>
    <title>Registro de usuarios</title>

    </title>
</head>
<body>
    <h1>Formulario de registro de nuevos usuarios</h1>
    <form name="register"
        action=""
        method="post">

        <!--Campos capturar entrada cliente-->
        <!--Fundamentalmente input-->
        <label for="idApodo">Apodo de usuario*</label>:<input type="text" name="apodo"< id="idApodo"/><br/><br/>
        <label for="idCorreo">Correo*</label>:<input type="text" name="correo"< id="idCorreo"/><br/><br/>
        <label for="idContrasegna">Contraseña*</label>:<input type="text" name="contrasegna"< id="idContrasegna"/><br/><br/>
        <label for="idRepContrasegna">Repita contraseña*</label>:<input type="text" name="repContrasegna"< id="idRepContrasegna"/><br/><br/>

        <p>Los campos marcados con un asterisco deben rellenarse de forma obligatoria</p>
        <input type="submit" name="Registrarse"><input type="reset" name="Reiniciar valores"><br/>
    </form>
</body>

</html>