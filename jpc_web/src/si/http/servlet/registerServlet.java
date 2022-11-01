import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap; // import the HashMap class
import java.util.*; 
public class RegisterServlet extends HttpServlet{
    public void doPost (HttpServletRequest request, HttpServletRespond response) throws
    ContrasegnaInvalida, CorreoInvalido,CorreoYaRegistrado,ErrorInterno{
        Map<String, String> errors = new HashMap <String, String>();

        String apodo = request.getParameter("apodo");
        String correo = request.getParameter("correo");
        String contrasegna = request.getParameter("contrasegna");
        String repContrasegna = request.getParameter("repContrasegna");

        if ((apodo == null) || (apodo.trim().equals(""))) errors.add("Apodo", "Campo obligatorio");
        if ((correo == null) || (correo.trim().equals(""))) errors.add("Correo", "Campo obligatorio");
        if ((contrasegna == null) || (contrasegna.trim().equals(""))) errors.add("Contraseña", "Campo obligatorio");
        if ((repContrasegna == null) || (repContrasegna.trim().equals(""))) errors.add("RepetirContraseña", "Campo obligatorio");
        if (repContrasegna != contrasegna) errors.add("DistintaContraseña", "Deben de coincidir ambas contraseñas");
        // ---------------------------------------------------------------------------------------------AÑADIR CORREO EN FORMATO CORRECTO

        if (!errors.isEmpty()){ //Forward a register.jsp con el mapa de errores /*Errores*/
            request.setAttribute("errores", errors);
            RequestDispatcher dispatcher=request.getRequestDistpatcher("register.jsp");
            dispatcher.forwardTo(request, response);
        }else{//Procesamiento del proceso de autenticación /*Lógica negocio*/
            CuentaFacade f = new CuentaFacade(); //----------------------------------------------------------------------------------
            try{ CuentaVO r = f.registrarCuenta(apodo,correo,contrasegna);
                if (r == null) { response.sendRedirect("errorInterno.html");}
                else{ HttpSession s = request.getSession(); s.setAttribute ("nombre", r.getNombre());
                    response.sendRedirect("bienvenida.jsp");}
            } catch (CorreoYaRegistrado e) {
                errors.add("Correo", "Correo ya registrado"); //Forward a register.jsp
            }
        }
    }
}