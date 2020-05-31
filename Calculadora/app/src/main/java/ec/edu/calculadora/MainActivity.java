package ec.edu.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button btnMultiplicar,btnSumar,btnRestar,btnDividir;
    private EditText txtValor1,txtValor2,txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        txtValor1=(EditText)findViewById(R.id.txtValor1);
        txtValor2=(EditText)findViewById(R.id.txtValor2);
        txtResultado=(EditText)findViewById(R.id.txtResultado);
        btnSumar=(Button)findViewById(R.id.btnSumar);
        btnRestar=(Button)findViewById(R.id.btnRestar);
        btnMultiplicar=(Button)findViewById(R.id.btnMultiplicar);
        btnDividir=(Button)findViewById(R.id.btnDividir);
        btnSumar.setOnClickListener(this);
        btnRestar.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnDividir.setOnClickListener(this);

    }
    @Override
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
        }
    }
}
