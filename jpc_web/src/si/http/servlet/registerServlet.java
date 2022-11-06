import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.si.model.PlainModelFacade;

import java.util.HashMap; // import the HashMap class
import java.util.*;

public class RegisterServlet extends HttpServlet{
    public void doPost (HttpServletRequest request, HttpServletRespond response) throws
        CorreoYaRegistrado, InternalErrorException{
        Map<String, String> errors = new HashMap <String, String>();

        String apodo = request.getParameter("apodo");
        String correo = request.getParameter("correo");
        String contrasegna = request.getParameter("contrasegna");
        String repContrasegna = request.getParameter("repContrasegna");

        if ((apodo == null) || (apodo.trim().equals(""))) errors.add("apodo", "Campo obligatorio");
        if ((correo == null) || (correo.trim().equals(""))) errors.add("correo", "Campo obligatorio");
        int indiceArroba = correo.indexOf("@");
        int indicePunto = correo.indexOf(".");          
        if ((indiceArroba < 1) || (indicePunto == correo.length() - 1) || (indiceArroba < indicePunto)) {
                errors.add("correo", "Formato de correo inválido");
        }
        if ((contrasegna == null) || (contrasegna.trim().equals(""))) errors.add("contrasegna", "Campo obligatorio");
        if ((repContrasegna == null) || (repContrasegna.trim().equals(""))) errors.add("repContrasegna", "Campo obligatorio");
        if (repContrasegna != contrasegna) errors.add("repContrasegna", "Deben de coincidir ambas contraseñas");


        if (!errors.isEmpty()){ //Forward a register.jsp con el mapa de errores /*Errores*/
            request.setAttribute("errores", errors);
            RequestDispatcher dispatcher=request.getRequestDistpatcher("register.jsp");
            dispatcher.forwardTo(request, response);
        }else{//Procesamiento del proceso de autenticación /*Lógica negocio*/
            CuentaVO cuentaVO = new CuentaVO(apodo, correo, contrasegna);
            boolean error = false;
            try{
                PlainModelFacade plainModelFacade = new PlainModelFacade();
                System.out.println("Voy a registrar el usuario en la base de datos................................");
				plainModelFacade.registrarCuenta(cuentaVO);
				System.out.println("He registrado al usuario en la base de datos..................correctamente..............");
                
            }catch (Exception e) {
				error = true;
			}	
    		if (error) {
    			response.sendRedirect("errorInterno.html");
    		}else {
                HttpSession s = request.getSession(); s.setAttribute("apodo", cuentaVO.obtenerApodo());
                response.sendRedirect("bienvenida.jsp");
    		}
        }
    }
}