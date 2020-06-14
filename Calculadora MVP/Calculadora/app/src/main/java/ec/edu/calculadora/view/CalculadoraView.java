package ec.edu.calculadora.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ec.edu.calculadora.R;
import ec.edu.calculadora.interfaces.Calculadora;
import ec.edu.calculadora.model.CalculadoraDTO;
import ec.edu.calculadora.presenter.CalculadoraPresenter;

public class CalculadoraView extends AppCompatActivity implements Calculadora.View  {

    private TextView operaciones;
    private TextView numero;

    private Calculadora.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operaciones=(TextView)findViewById(R.id.tvAlCuadrado);
        numero=(TextView)findViewById(R.id.edAlCuadrado);
        presenter = new CalculadoraPresenter(this);
    }

    public void calcular (View view){
        presenter.calculadora(numero.getText().toString());
    }

    public void operacion (View view){
        presenter.operacion(view, numero.getText().toString());
    }

    public void number (View view){
        //numero.setText("1");
        presenter.setNumber(view, numero.getText().toString());
    }

    public void clearResults(View view){
        presenter.clearResults();
    }

    public void clearOperations(View view){
        presenter.clearOperations();
    }

    @Override
    public void showResult(String result) {
        numero.setText(result);
    }

    @Override
    public void showDeleteChar(String result) {
        numero.setText(result);
    }

    @Override
    public void showOperations(String operations) {
        operaciones.setText(operations);
    }

}
