package controlador;

public class ControlLogin {

    public boolean validarCredenciales(String login, String password) {
        return login.equals("root") && password.equals("123456");
    }
}
