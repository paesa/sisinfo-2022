public class CuentaFacade {
    
    //Constructor
    public CuentaFacade() {
    }

    public CuentaVO validarCuenta(String login, String clave, boolean encriptada) throws InvalidUserException, InvalidPasswordException{
        if(login=="" || login==null){
            throw new InvalidUserException();
        }
        if(clave=="" || clave==null){
            throw new InvalidPasswordException();
        }
        return
    }
}