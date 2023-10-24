/* Forest Suites es una app hecha en Java para la gestion de
reservas en un hotel, con opciones de crear, modificar y buscar.

Oscar Andres Hernandez Pineda - 2264488
Camilo Andres Garcia - 2264484
Alejandro Cuenca - 22644755

Ult. fecha modificacion: 20/10/2023
Version 2.0

https://github.com/camilo-grc/Laboratory_3
*/

package model;

public class ModelLogin {
    String username, password;
    
    public ModelLogin () {
        username = "root";
        password = "123456";
    }
    
    public boolean verification (String _username, String _password) {
        return _username.equals(username) && _password.equals(password);
    }
}
