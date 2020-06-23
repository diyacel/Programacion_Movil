package ec.edu.calculadora.view;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ec.edu.calculadora.R;
import ec.edu.calculadora.interfaces.Calculadora;
import ec.edu.calculadora.presenter.CalculadoraPresenter;

public class CalculadoraView extends AppCompatActivity implements Calculadora.View, View.OnClickListener{

    private TextView operaciones;
    private TextView numero;

    private Calculadora.Presenter presenter;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    Button btnDividir, btnSumar, btnRestar, btnMultiplicar,btnElevar,btnRaiz,btnFactorial,btnMod;
    Button btnBinario,btnOctal,btnHexadecimal;
    Button btnIgual,btnC,btnAC,btnBorrar,btnPunto,btnSigno;
    Button btnMC,btnMR,btnMas,btnMenos;
    Button btnSeno,btnCoseno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operaciones=(TextView)findViewById(R.id.tvOperacion);
        numero=(TextView)findViewById(R.id.tvNumero);
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
        btnMultiplicar=(Button) findViewById(R.id.btnMultiplicar);
        btnFactorial=(Button) findViewById(R.id.btnFactorial);
        btnMod=(Button) findViewById(R.id.btnMod);
        btnIgual=(Button) findViewById(R.id.btnIgual);
        btnC=(Button) findViewById(R.id.btnC);
        btnAC=(Button) findViewById(R.id.btnAC);
        btnBorrar=(Button) findViewById(R.id.delChar);
        btnSigno=(Button) findViewById(R.id.btnNeg);
        btnPunto=(Button) findViewById(R.id.dot);
        btnElevar=(Button) findViewById(R.id.btnExponencial);
        btnBinario=(Button) findViewById(R.id.btnBinario);
        btnOctal=(Button) findViewById(R.id.btnOctal);
        btnHexadecimal=(Button) findViewById(R.id.btnHexadecimal);
        btnSeno=(Button) findViewById(R.id.btnSeno);
        btnCoseno=(Button) findViewById(R.id.btnCos);
        btnRaiz=(Button) findViewById(R.id.btnRaiz);
        btnMas=(Button) findViewById(R.id.btnMPlus);
        btnMenos=(Button) findViewById(R.id.btnMLess);
        btnMR=(Button) findViewById(R.id.btnMR);
        btnMC=(Button) findViewById(R.id.btnMC);
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
        btnMultiplicar.setOnClickListener(this);
        btnElevar.setOnClickListener(this);
        btnFactorial.setOnClickListener(this);
        btnBinario.setOnClickListener(this);
        btnOctal.setOnClickListener(this);
        btnHexadecimal.setOnClickListener(this);
        btnSeno.setOnClickListener(this);
        btnCoseno.setOnClickListener(this);
        btnMod.setOnClickListener(this);
        btnRaiz.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
        btnMenos.setOnClickListener(this);
        btnMas.setOnClickListener(this);
        btnMC.setOnClickListener(this);
        btnMR.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);
        btnPunto.setOnClickListener(this);
        btnSigno.setOnClickListener(this);
    }

    public void calcular(View view){
        presenter.calculadora(numero.getText().toString());
    }

    public void operacion(View view){ presenter.operacion(view, numero.getText().toString()); }

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
    public void validar(String data) {
        Toast toast=Toast.makeText(getBaseContext(),data,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id._0:
                number(v);

                break;
            case R.id._1:
                number(v);
                break;
            case R.id._2:
                number(v);
                break;
            case R.id._3:
                number(v);
                break;
            case R.id._4:
                number(v);
                break;
            case R.id._5:
                number(v);
                break;
            case R.id._6:
                number(v);
                break;
            case R.id._7:
                number(v);
                break;
            case R.id._8:
                number(v);
                break;
            case R.id._9:
                number(v);
                break;
            case R.id.btnSumar:
                operacion(v);
                break;
            case R.id.btnRestar:
                operacion(v);
                break;
            case R.id.btnMultiplicar:
                operacion(v);
                break;
            case R.id.btnDividir:
                operacion(v);
                break;
            case R.id.btnExponencial:
                operacion(v);
                break;
            case R.id.btnFactorial:
                operacion(v);
                break;
            case R.id.btnRaiz:
                operacion(v);
                break;
            case R.id.btnMod:
                operacion(v);
                break;
            case R.id.dot:
                number(v);
                break;
            case R.id.btnNeg:
                number(v);
            case R.id.btnBinario:
                number(v);
                break;
            case R.id.btnOctal:
                number(v);
                break;
            case R.id.btnHexadecimal:
                number(v);
                break;
            case R.id.btnSeno:
                operacion(v);
                break;
            case R.id.btnCos:
                operacion(v);
                break;
            case R.id.btnAC:
                clearOperations(v);
                break;
            case R.id.btnC:
                clearResults(v);
                break;
            case R.id.btnMC:
                number(v);
                break;
            case R.id.btnMPlus:
                number(v);
                break;
            case R.id.btnMLess:
                number(v);
                break;
            case R.id.btnMR:
                number(v);
                break;
            case R.id.btnIgual:
                calcular(v);
                break;
                case R.id.delChar:
                number(v);
                break;

        }

    }
}
