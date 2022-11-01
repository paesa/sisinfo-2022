<html lang="es">
<head>
    <meta charset="UTF-8"/>
    <title>Inicio de sesión de usuarios</title>

    </title>
</head>
<body>
    <h1>Formulario de inicio de sesion de usuarios</h1>
    <form name="login"
        action=""
        method="post">

        <!--Campos capturar entrada cliente-->
        <!--Fundamentalmente input-->
        <label for="idCorreo">Correo*</label>:<input type="text" name="correo"< id="idCorreo"/><br/><br/>
        <label for="idContrasegna">Contraseña*</label>:<input type="text" name="contrasegna"< id="idContrasegna"/><br/><br/>

        <p>Los campos marcados con un asterisco deben rellenarse de forma obligatoria</p>
        <input type="submit" name="Iniciar sesion"><input type="reset" name="Reiniciar valores"><br/>
    </form>
</body>

</html>