package com.example.suma_dos_numeros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtNumero1,txtNumero2;
    private TextView lblResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblResultado=(TextView)findViewById(R.id.lblResultado);
        txtNumero1=(EditText)findViewById(R.id.txtNumero1);
        txtNumero2=(EditText)findViewById(R.id.txtNumero2);
    }
    public void sumar(View vista)
    {
        int n1,n2,suma;
        n1=Integer.parseInt(txtNumero1.getText().toString());
        n2 = Integer.parseInt(txtNumero2.getText().toString());
        suma=n1+n2;
        lblResultado.setText("Resultado: "+suma);
    }
}
