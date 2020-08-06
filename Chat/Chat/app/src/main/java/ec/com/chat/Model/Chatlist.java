package ec.com.chat.Model;

public class Chatlist {
    public String id;

    public Chatlist(String id) {
        this.id = id;
    }

    public Chatlist() {
    }

    /**
     * Método que returna el id
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Método para obtener el id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
}
