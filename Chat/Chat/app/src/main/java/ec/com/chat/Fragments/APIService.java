package ec.com.chat.Fragments;

import ec.com.chat.Notifications.MyResponse;
import ec.com.chat.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=ADD HERE YOUR KEY FROM FIREBASE PROJECT"
            }
    )
    /**
     * Llama al fragment y le envia la notificación
     */
    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
