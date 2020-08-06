package ec.com.chat.Model;

public class User {

    private String id;
    private String username;
    private String name;
    private String lastname;
    private String imageURL;
    private String status;
    private String search;

    public User(String id, String username, String name, String lastname, String imageURL, String status, String search) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.imageURL = imageURL;
        this.status = status;
        this.search = search;
    }

    public User() {

    }

    /**
     * Método getter del id
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Método setter del id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método getter del usuario
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Método setter del usuario
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Método setter del nombre
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Método setter del nombre
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método getter del apellido
     * @return
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Método setter del apellido
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Método getter de la URL de la imagen
     * @return
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * Método setter de la URL de la imagen
     * @param imageURL
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    /**
     * Método getter del estatus
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * Método setter del estatus
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Método getter de la busqueda
     * @return
     */
    public String getSearch() {
        return search;
    }

    /**
     *Método setter de la busqueda
     * @param search
     */
    public void setSearch(String search) {
        this.search = search;
    }
}
