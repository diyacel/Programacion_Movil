package ec.edu.calculadora.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ec.edu.calculadora.R;
import ec.edu.calculadora.interfaces.Calculadora;
import ec.edu.calculadora.presenter.CalculadoraPresenter;

public class CalculadoraView extends AppCompatActivity implements Calculadora.View, View.OnClickListener{

    private TextView operaciones;
    private TextView numero;

    private Calculadora.Presenter presenter;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button btnDividir;
    Button btnSumar;
    Button btnRestar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operaciones=(TextView)findViewById(R.id.tvAlCuadrado);
        numero=(TextView)findViewById(R.id.edAlCuadrado);
        presenter = new CalculadoraPresenter(this);
        btn1=(Button) findViewById(R.id._1);
        btn2=(Button) findViewById(R.id._2);
        btn3=(Button) findViewById(R.id._3);
        btn4=(Button) findViewById(R.id._4);
        btn5=(Button) findViewById(R.id._5);
        btn6=(Button) findViewById(R.id._6);
        btn7=(Button) findViewById(R.id._7);
        btn8=(Button) findViewById(R.id._8);
        btn9=(Button) findViewById(R.id._9);
        btn0=(Button) findViewById(R.id._0);
        btnDividir=(Button) findViewById(R.id.btnDividir);
        btnSumar=(Button) findViewById(R.id.btnSumar);
        btnRestar=(Button) findViewById(R.id.btnRestar);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnDividir.setOnClickListener(this);
        btnSumar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
    }

    public void calcular(View view){
        presenter.calculadora(numero.getText().toString());
    }

    public void operacion(View view){
        presenter.operacion(view, numero.getText().toString());
    }

    public void number(View view){
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

    @Override
    public void onClick(View v)
    {
        number(v);
        operacion(v);
    }
}
