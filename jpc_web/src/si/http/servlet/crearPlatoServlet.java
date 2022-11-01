import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap; // import the HashMap class
import java.util.*; 

public class CrearPlatoServlet extends HttpServlet{
    public void doPost (HttpServletRequest request, HttpServletRespond response) throws
    ContrasegnaInvalida, CorreoInvalido,CorreoYaRegistrado,ErrorInterno{
        Map<String, String> errors = new HashMap <String, String>();

        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String precio = request.getParameter("precio");
        String tipo = request.getParameter("tipo");
        String alergeno = request.getParameter("alergeno");

        if ((nombre == null) || (nombre.trim().equals(""))) errors.add("Nombre", "Campo obligatorio");
        if ((descripcion == null) || (descripcion.trim().equals(""))) errors.add("Descripcion", "Campo obligatorio");
        if ((precio == null) || (precio.trim().equals(""))) errors.add("Precio", "Campo obligatorio");
        if ((tipo == null) || (tipo.trim().equals(""))) errors.add("Tipo", "Campo obligatorio");
        if ((alergeno == null) || (alergeno.trim().equals(""))) errors.add("Alergeno", "Campo obligatorio");
        if (Integer.valueOf(precio) < 0) errors.add("Precio", "Campo obligatorio");

        if (!errors.isEmpty()){ //Forward a crearPlato.jsp con el mapa de errores /*Errores*/
            request.setAttribute("errores", errors);
            RequestDispatcher dispatcher=request.getRequestDistpatcher("crearPlato.jsp");
            dispatcher.forwardTo(request, response);
        }
    }
}