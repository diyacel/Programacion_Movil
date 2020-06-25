package ec.edu.calculadora.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;

import ec.edu.calculadora.R;
import ec.edu.calculadora.model.Operaciones;

public class GraphicDisplay extends AppCompatActivity {
    private GraphView function;
    private Operaciones operaciones = new Operaciones();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic_display);
        function = findViewById(R.id.vistaFuncion);

        String grados=getIntent().getStringExtra("grados");
        String ope=getIntent().getStringExtra("ope");

        function.addSeries(operaciones.graficar(function, grados,ope));
    }
}