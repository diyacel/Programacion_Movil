package ec.com.chat.Model;

import android.widget.ImageView;

public class Chat {

    private String sender;
    private String receiver;
    private String message;
    private boolean isseen;
    private String UriPhoto;
    private boolean isPhoto;

    public Chat(String sender, String receiver, String message, boolean isseen, String UriPhoto, boolean isPhoto) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.isseen = isseen;
        this.UriPhoto = UriPhoto;
        this.isPhoto = isPhoto;
    }

    public Chat() {
    }

    /**
     * Métodos getter y setter de quien envia
     * @return
     */
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * Métodos getter y setter de quien recibe
     * @return
     */
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * Métodos getter y setter del mensaje
     * @return
     */
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Métodos getter y setter de la notificación si fue visto el mensaje
     * @return
     */
    public boolean isIsseen() {
        return isseen;
    }
    public void setIsseen(boolean isseen) {
        this.isseen = isseen;
    }

    /**
     * Métodos getter y setter de la foto de perfil
     * @return
     */
    public String getUriPhoto() {
        return UriPhoto;
    }
    public void setUriPhoto(String uriPhoto) {
        UriPhoto = uriPhoto;
    }

    /**
     * Métodos getter y setter que comprueban si es foto o no
     * @return
     */
    public boolean isPhoto() {
        return isPhoto;
    }

    public void setPhoto(boolean photo) {
        isPhoto = photo;
    }
}
