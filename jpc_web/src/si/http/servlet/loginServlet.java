import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import WEB-INF.classes.util.exception;
import classes.util.exception;
import util.exception;
import exception;
import java.util.HashMap; // import the HashMap class
import java.util.*; 

public class LoginServlet extends HttpServlet{
    public void doPost (HttpServletRequest request, HttpServletRespond response) throws
    ContrasegnaInvalida, CorreoInvalido,CorreoYaRegistrado,ErrorInterno{
        Map<String, String> errors = new HashMap <String, String>();

        String correo = request.getParameter("correo");
        String contrasegna = request.getParameter("contrasegna");

        if ((correo == null) || (correo.trim().equals(""))) errors.add("Correo", "Campo obligatorio");
        if ((contrasegna == null) || (contrasegna.trim().equals(""))) errors.add("Contraseña", "Campo obligatorio");

        if (!errors.isEmpty()){ //Forward a login.jsp con el mapa de errores /*Errores*/
            request.setAttribute("errores", errors);
            RequestDispatcher dispatcher=request.getRequestDistpatcher("register.jsp");
            dispatcher.forwardTo(request, response);
        }else{//Procesamiento del proceso de autenticación /*Lógica negocio*/
            CuentaFacade f = new CuentaFacade(); //----------------------------------------------------------------------------------
            try{ CuentaVO r = f.iniciarCuenta(correo, contrasegna);
                if (r == null) { response.sendRedirect("errorInterno.html");}
                else{ HttpSession s = request.getSession(); s.setAttribute ("nombre", r.obtenerApodo());
                    response.sendRedirect("bienvenida.jsp");}
            } catch (CorreoInvalido e) {
                errors.add("Correo", "Correo no registrado"); //Forward a login.jsp
            } catch (ContrasegnaInvalida e) {
                errors.add("Contraseña", "Contraseña incorrecta"); //Forward a login.jsp
            }
        }
    }
}