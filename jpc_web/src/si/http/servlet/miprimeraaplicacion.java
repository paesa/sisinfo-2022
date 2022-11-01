//package miprimeraaplicacion;
public class RegistrarUsuarioServlet extends HttpServlet{
    public void doPost (HttpServletRequest request, HttpServletRespond response) throws
    IOException, ServletException{
        Map<String, String> errors = new HashMap <String, String>();

        String idCuenta = request.getParameter("idCuenta");
        String apodo = request.getParameter("apodo");
        String correo = request.getParameter("correo");
        String contrasegna = request.getParameter("contrasegna");
        String repContrasegna = request.getParameter("repCon");

        if ((apodo == null) || (apodo.trim().equals(""))) errors.add("Apodo", "Campo obligatorio");
        if ((correo == null) || (correo.trim().equals(""))) errors.add("Correo", "Campo obligatorio");
        if ((contrasegna == null) || (contrasegna.trim().equals(""))) errors.add("Contraseña", "Campo obligatorio");
        if ((repContrasegna == null) || (repContrasegna.trim().equals(""))) errors.add("RepetirContraseña", "Campo obligatorio");
        if (repContrasegna != contrasegna) errors.add("DistintaContraseña", "Deben de coincidir ambas contraseñas");
        // CORREO CORRECTO

        if (!errors.isEmpty()){ //Forward a Login.jsp con el mapa de errores /*Errores*/
            request.setAttribute("errores", errors);
            RequestDispatcher dispatcher=request.getRequestDistpatcher("register.jsp");
            dispatcher.forwardTo(request, response);
        }else{//Procesamiento del proceso de autenticación /*Lógica negocio*/
            CuentaFacade f = new CuentaFacade();
            try{ CuentaVO r = f.validarCuenta(idCuenta, apodo, correo, contrasegna);
                if (r == null) { response.sendRedirect("errorInterno.html");}
                else{ HttpSession s = request.getSession(); s.setAttribute ("nombre", r.getNombre());
                    response.sendRedirect("bienvenida.jsp");}
            } catch (InvalidPasswordException e) {
                errors.add("Clave", "Clave de acceso errónea"); //Forward a Login.jsp
            } catch (InvalidUserException e) {
                errors.add("Login", "El usuario no se encuentra registrado"); //Forward a Login.jsp
            }
        }
    }
}