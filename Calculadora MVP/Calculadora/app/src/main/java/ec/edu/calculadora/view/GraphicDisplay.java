package ec.edu.calculadora.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import ec.edu.calculadora.R;

public class GraphicDisplay extends AppCompatActivity {

    private LineGraphSeries<DataPoint> series;
    private GraphView function;
    private static int valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphic_display);

        double x, y;
        x = -50;

        function = findViewById(R.id.vistaFuncion);

        function.getViewport().setScrollable(true);
        function.getViewport().setScrollableY(true);

        function.getViewport().setScalable(false);
        function.getViewport().setScalableY(true);

        function.getViewport().setXAxisBoundsManual(true);
        function.getViewport().setMinX(-50);
        function.getViewport().setMaxX(50);

        series = new LineGraphSeries<DataPoint>();

        for(int i=0; i<500;i++){
            x+=0.1;
            y=f(x);
            series.appendData(new DataPoint(x,y),true,500);
        }
    }

    public double f(double x){
        double f2 = (1*(Math.pow(x,3))) + (0*(Math.pow(x,2))) + (-3*x) + 1;
        return f2;
    }
}