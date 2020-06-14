package ec.edu.calculadora.interfaces;

import android.view.View;

/**
 * Created by albertopalomarrobledo on 7/7/17.
 */

public interface Calculadora {

    interface View{
        void showResult(String result);
        void showDeleteChar(String result);
        void showOperations(String result);
    }

    interface Presenter{
        void showResult(String result);
        void calculadora(String data);
        void operacion(android.view.View operacion,String data);
        void setNumber(android.view.View number,String data);
        void showOperations(String result);
        void showDeleteChar(String result);
        void clearResults();
        void clearOperations();
    }

    interface Model{
        void calculadora(String data);
        void operacion(android.view.View operacion, String data);
        void setNumber(android.view.View number,String data);
        void clearResults();
        void clearOperations();
    }
}
