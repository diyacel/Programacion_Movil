package interfaces;

import android.view.View;

public interface Calculadora {

    interface View {
        void showResult(String result);
        void showError(String error);
    }

    interface Presenter{
        void showResult(String result);
        void calcular(String data);
        void showError(String error);
    }

    interface Model{
        void calcular(String data);
    }

}
