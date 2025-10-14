package interfaces;

public interface IPersona {



    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Devuelve el DNI de la persona
     * Pre: la persona debe haber sido creada previamente
     * Post: devuelve el DNI actual de la persona y no debe ser nulo ni vacio
     */

    String getDni();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Asigna un nuevo DNI a la persona
     * Pre: la persona debe haber sido creada previamente y el DNI no debe ser nulo ni vacio
     * Post: el DNI de la persona queda actualizado con el valor recibido
     */

    void setDni(String dni);

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Devuelve el nombre de la persona
     * Pre: la persona debe haber sido creada previamente
     * Post: devuelve el nombre actual y no debe ser nulo ni vacio
     */

    String getNombre();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Asigna un nuevo nombre a la persona
     * Pre: la persona debe haber sido creada previamente y el nombre no debe ser nulo ni vacio
     * Post: el nombre de la persona queda actualizado con el valor recibido
     */

    void setNombre(String nombre);

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Devuelve el apellido de la persona
     * Pre: la persona debe haber sido creada previamente
     * Post: devuelve el apellido actual y no debe ser nulo ni vacio
     */

    String getApellido();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Asigna un nuevo apellido a la persona
     * Pre: la persona debe haber sido creada previamente Y el apellido no debe ser nulo ni vacio
     * Post: el apellido de la persona queda actualizado con el valor recibido
     */

    void setApellido(String apellido);

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Devuelve la edad de la persona
     * Pre: la persona debe haber sido creada previamente
     * Post: devuelve la edad actual, la cual debe ser mayor o igual a 0
     */

    int getEdad();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Asigna una nueva edad a la persona
     * Pre: la persona debe haber sido creada previamente y debe ser mayor o igual a 0
     * Post: la edad de la persona queda actualizada con el valor recibido
     */

    void setEdad(int edad);

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/

    /**
     * Devuelve el nombre completo de la persona
     * Pre: la persona debe tener nombre y apellido cargados
     * Post: devuelve una cadena con el formato nombre y apellido
     */

    String obtenerNombreCompleto();

    /*-------------------------------------------------*/
    /*-------------------------------------------------*/
}

