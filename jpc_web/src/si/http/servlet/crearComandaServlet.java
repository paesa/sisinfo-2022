package src.si.http.servlet;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrearComandaServlet extends HttpServlet{
    public void doPost (HttpServletRequest request, HttpServletRespond response) throws
    IOException, ServletException{
        Map<String, String> errors = new HashMap <String, String>();

        String entrante = request.getParameter("entrante");
        String principal = request.getParameter("principal");
        String postre = request.getParameter("postre");
        String bebida = request.getParameter("bebida");
        String comentario = request.getParameter("comentario");

        if ((entrante == null) || (entrante.trim().equals("")) &&
        ((principal == null) || (principal.trim().equals(""))) &&
        ((postre == null) || (postre.trim().equals(""))) &&
        ((bebida == null) || (bebida.trim().equals(""))) &&
        ((comentario == null) || (comentario.trim().equals("")))) errors.add("Comanda", "Debe haber al menos un campo no vacío");

        if (!errors.isEmpty()){ //Forward a crearComanda.jsp con el mapa de errores /*Errores*/
            request.setAttribute("errores", errors);
            RequestDispatcher dispatcher=request.getRequestDistpatcher("crearComanda.jsp");
            dispatcher.forwardTo(request, response);
        }
    }
}