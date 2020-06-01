package ec.edu.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import interfaces.Calculadora;
import presenter.CalculadoraPresenter;

public class MainActivity extends AppCompatActivity implements Calculadora.View
{
    private Button btnMultiplicar,btnSumar,btnRestar,btnDividir;
    private EditText txtValor1,txtValor2,txtResultado;

    private CalculadoraPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtValor1=(EditText)findViewById(R.id.txtValor1);
        txtValor2=(EditText)findViewById(R.id.txtValor2);
        txtResultado=(EditText)findViewById(R.id.txtResultado);
        presenter = new CalculadoraPresenter(this);
    }

    public void calcular (View view){
        presenter.calcular(txtValor1.getText().toString());
        Toast toast = Toast.makeText(this, txtValor1.getText().toString(), Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showResult(String result) {
        txtResultado.setText(result);
    }

    @Override
    public void showError(String error) {
        txtResultado.setText(error);
    }

    /*private void init(){
        //Modelo modelo = new Modelo();
        //Controlador control;
        //control = new Controlador(modelo);
        //control.iniciar();
        txtValor1=(EditText)findViewById(R.id.txtValor1);
        txtValor2=(EditText)findViewById(R.id.txtValor2);
        txtResultado=(EditText)findViewById(R.id.txtResultado);
        btnSumar=(Button)findViewById(R.id.btnSumar);
        //btnRestar=(Button)findViewById(R.id.btnRestar);
        //btnMultiplicar=(Button)findViewById(R.id.btnMultiplicar);
        //btnDividir=(Button)findViewById(R.id.btnDividir);
        //btnSumar.setOnClickListener(this);
        //btnRestar.setOnClickListener(this);
        //btnMultiplicar.setOnClickListener(this);
        //btnDividir.setOnClickListener(this);

        Modelo modelo = new Modelo();
        modelo.setValor1((EditText)findViewById(R.id.txtValor1));
        modelo.setValor2((EditText)findViewById(R.id.txtValor2));
        modelo.setResultado((EditText)findViewById(R.id.txtResultado));
        modelo.setSumar((Button)findViewById(R.id.btnSumar));
        Controlador control= new Controlador(modelo);
    }*/
    /*@Override
    public void onClick(View v) {
        int val1=Integer.parseInt(txtValor1.getText().toString());
        int val2=Integer.parseInt(txtValor2.getText().toString());
        int res;

        switch (v.getId())
        {
            case R.id.btnSumar:
                res=val1+val2;
                txtResultado.setText(String.valueOf(res));
                break;
            case R.id.btnRestar:
                res=val1-val2;
                txtResultado.setText(String.valueOf(res));
                break;
            case R.id.btnMultiplicar:
                res=val1*val2;
                txtResultado.setText(String.valueOf(res));
                break;
            case R.id.btnDividir:
                res=val1/val2;
                txtResultado.setText(String.valueOf(res));
                break;
        }
    }*/
}
