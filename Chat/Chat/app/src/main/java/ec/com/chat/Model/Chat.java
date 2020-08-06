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

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIsseen() {
        return isseen;
    }

    public void setIsseen(boolean isseen) {
        this.isseen = isseen;
    }

    public String getUriPhoto() {
        return UriPhoto;
    }

    public void setUriPhoto(String uriPhoto) {
        UriPhoto = uriPhoto;
    }

    public boolean isPhoto() {
        return isPhoto;
    }

    public void setPhoto(boolean photo) {
        isPhoto = photo;
    }
}
