package ec.edu.calculadora.view;

/**
 * @author Eduardo Vera
 * @author Diego Yacelga
 */

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.jjoe64.graphview.GraphView;
import ec.edu.calculadora.R;
import ec.edu.calculadora.model.Operaciones;

/**
 * Clase que grafica las operaciones seno y coseno
 */
public class GraphicDisplay extends AppCompatActivity {
    private GraphView function;
    private Operaciones operaciones = new Operaciones();

    /**
     * Método que crea la actividad que grafica las funciones
     * @param savedInstanceState     Clase que guarda el estado de la Actividad.
     */
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