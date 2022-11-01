<html lang="es">
<head>
    <meta charset="UTF-8"/>
    <title>Creacion de comanda</title>

    </title>
</head>
<body>
    <h1>Formulario de creacion de comanda</h1>
    <form name="crearComanda"
        action=""
        method="post">

        <!--Campos capturar entrada cliente-->
        <!--Fundamentalmente input-->
        <label for="idEntrante">Entrante</label>:<input type="text" name="entrante"< id="idEntrante"/><br/><br/>
        <label for="idPrincipal">Principal</label>:<input type="text" name="principal"< id="idPrincipal"/><br/><br/>
        <label for="idPostre">Postre</label>:<input type="text" name="postre"< id="idPostre"/><br/><br/>
        <label for="idBebida">Bebida</label>:<input type="text" name="bebida"< id="idBebida"/><br/><br/>
        <label for="idComentario">Comentario</label>:<input type="text" name="comentario"< id="idComentario"/><br/><br/>
        <!--AÑADIR BOTON DE CANTIDAD ------------------------------------------------------------------------->

        <p>Los campos marcados con un asterisco deben rellenarse de forma obligatoria</p>
        <input type="submit" name="Crear comanda"><input type="reset" name="Reiniciar valores"><br/>
    </form>
</body>

</html>