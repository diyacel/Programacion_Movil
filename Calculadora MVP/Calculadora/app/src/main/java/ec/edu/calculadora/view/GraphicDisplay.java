package ec.edu.calculadora.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import ec.edu.calculadora.R;
import ec.edu.calculadora.interfaces.Calculadora;
import ec.edu.calculadora.presenter.CalculadoraPresenter;

public class GraphicDisplay extends AppCompatActivity implements Calculadora.Graphics {

    private LineGraphSeries<DataPoint> series;
    private GraphView function;
    private static int valor;
    private Calculadora.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic_display);
        function = findViewById(R.id.vistaFuncion);
        presenter = new CalculadoraPresenter(this);
       /* String grados=getIntent().getStringExtra("grados");
        double x, y;
        x = 0;


        function.getViewport().setScrollable(true);
        function.getViewport().setScrollableY(true);

        function.getViewport().setScalable(false);
        function.getViewport().setScalableY(true);

        function.getViewport().setXAxisBoundsManual(true);
        function.getViewport().setMinX(-2*Math.PI);
        function.getViewport().setMaxX(2*Math.PI);
        function.getViewport().setMaxY(1);
        function.getViewport().setMaxY(-1);
        series = new LineGraphSeries<DataPoint>();*/

       /* for(double i=0.01; i<Math.toRadians(90);i+=0.01){

            y=seno(x);
            x+=0.01;
            series.appendData(new DataPoint(x,y),true,1000);
        }*/

    }



    @Override
    public void graficar(GraphView grafico) {
        function=grafico;

    }
}