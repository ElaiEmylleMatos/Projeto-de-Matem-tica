package example.emyllematos.functioneasy;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class MainActivity extends AppCompatActivity {

    EditText a, b, c; // id dos campos de texto
    Button calcular, grafico;
    TextView resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void inserir_quad(View view) {
        setContentView(R.layout.inserir_quad);
    }

    public void voltar(View view) {
        setContentView(R.layout.activity_main);
    }

    double AA,BB,XV,YV,AQ,BQ,CQ,DQ,X1,X2;

    public void calcular_quad(View view) {
        a = (EditText) findViewById(R.id.a);
        b = (EditText) findViewById(R.id.b);
        c = (EditText) findViewById(R.id.c);
        calcular = (Button) findViewById(R.id.calcular);
        resultados = (TextView) findViewById(R.id.resultados);

        calcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {

                double A, B = 0, C = 0;
                double d = 0, x1 = 0, x2 = 0, xv, yv, rd;

                if (!a.getText().toString().equals("")&&!a.getText().toString().equals("0")) {

                    A = Double.parseDouble(a.getText().toString());
                    AQ = A;

                    if (b.getText().toString().equals("")) {
                        B = 0;
                        BQ = B;
                    } else {
                        B = Double.parseDouble(b.getText().toString());
                        BQ = B;
                    }
                    if (c.getText().toString().equals("")) {
                        C = 0;
                        CQ = C;
                    } else {
                        C = Double.parseDouble(c.getText().toString());
                        CQ = C;
                    }

                    d = (-4 * A * C) + (B * B);
                    DQ = d;
                    xv = -B / (2 * A);
                    XV = xv;
                    yv = -d / (4 * A);
                    YV = yv;
                    rd = Math.sqrt(d);

                    if(d == 0){
                        x1 = -B / (2 * A);
                        X1 = x1;

                        resultados.setText("Discriminante: " + (float) d + "\n\nRaízes: " + (float) x1 + " e " + (float) x1 + "\n\nVértice: (" + (float) xv + ", " + (float) yv + ")");
                    } else if (d > 0) {
                        x1 = (-B + rd) / (2 * A);
                        x2 = (-B - rd) / (2 * A);
                        X1 = x1;
                        X2 = x2;

                        resultados.setText("Discriminante: " + (float) d + "\n\nRaízes: " + (float) x1 + " e " + (float) x2 + "\n\nVértice: (" + (float) xv + ", " + (float) yv + ")");

                    } else {
                        d = d * (-1);
                        rd = Math.sqrt(d);
                        double i = -B / (2 * A);

                        if (i == 0) {
                            resultados.setText("Discriminante: " + (float) (d * (-1)) + "\n\nRaízes: " + (float) rd / (2 * A) + "i" + " e " + (float) rd / (2 * A) + "i" + "\n\nVértice: (" + (float) xv + ", " + (float) yv + ")");
                        } else {
                            resultados.setText("Discriminante: " + (float) (d * (-1)) + "\n\nRaízes: " + (float) (-B / (2 * A)) + " + " + (float) rd / (2 * A) + "i" + " e " + (float) (-B / (2 * A)) + " - " + (float) rd / (2 * A) + "i" + "\n\nVértice: (" + (float) xv + ", " + (float) yv + ")");
                        }
                    }

                } else {
                    a.setError("Digite o valor de A");
                }

            }
        });
    }

    public void voltarg_quad(View view) {
        setContentView(R.layout.inserir_quad);
        if (!(AQ==0&&BQ==0&&CQ==0)) {
            a = (EditText) findViewById(R.id.a);
            b = (EditText) findViewById(R.id.b);
            c = (EditText) findViewById(R.id.c);
            resultados = (TextView) findViewById(R.id.resultados);

            a.setText(AQ + "");
            b.setText(BQ + "");
            c.setText(CQ + "");

            if (DQ == 0) {
                resultados.setText("Discriminante: " + (float) DQ + "\n\nRaízes: " + (float) X1 + " e " + (float) X1 + "\n\nVértice: (" + (float) XV + "," + (float) YV + ")");
            } else if (DQ > 0) {
                resultados.setText("Discriminante: " + (float) DQ + "\n\nRaízes: " + (float) X1 + " e " + (float) X2 + "\n\nVértice: (" + (float) XV + "," + (float) YV + ")");
            } else {
                if (-BQ / (2 * AQ) == 0) {
                    resultados.setText("Discriminante: " + (float) (DQ * (-1)) + "\n\nRaízes: " + (float) Math.sqrt(DQ) / (2 * AQ) + "i" + " e " + (float) -(Math.sqrt(DQ) / (2 * AQ)) + "i" + "\n\nVértice: (" + (float) XV + "," + (float) YV + ")");
                } else {
                    resultados.setText("Discriminante: " + (float) (DQ * (-1)) + "\n\nRaízes: " + (float) (-BQ / (2 * AQ)) + " + " + (float) Math.sqrt(DQ) / (2 * AQ) + "i" + " e " + (float) (-BQ / (2 * AQ)) + " - " + (float) Math.sqrt(DQ) / (2 * AQ) + "i" + "\n\nVértice: (" + (float) XV + "," + (float) YV + ")");
                }
            }
        }
    }

    public void calcular_afim(View view) {
        a = (EditText) findViewById(R.id.a);
        b = (EditText) findViewById(R.id.b);
        calcular = (Button) findViewById(R.id.calcular);
        resultados = (TextView) findViewById(R.id.resultados);
        grafico = (Button) findViewById(R.id.grafico);

        calcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                double B;

                if (!a.getText().toString().equals("") && !a.getText().toString().equals("0")) {
                    double A = Double.parseDouble(a.getText().toString());
                    AA = A;
                    if (b.getText().toString().equals("")) {
                        B = 0;
                        BB = 0;
                    } else {
                        B = Double.parseDouble(b.getText().toString());
                        BB = B;
                    }
                    double r;
                    double ag;

                    r = -(B / A);
                    ag = Math.toDegrees(Math.atan(A));

                    resultados.setText("Raiz: " + (float) r + "\n\nÂngulo de inclinação: " + (float) ag + "º");
                } else {
                    a.setError("Digite o valor de A");
                }
            }
        });

    }

    public void inserir_afim(View view) {
        setContentView(R.layout.inserir_afim);
    }

    public void limpar_a(View view) {
        if (!(a.getText() == null && b.getText() == null)) {
            a.setText("");
            b.setText("");
            resultados.setText("");
        }
    }

    public void limpar_quad(View view) {
        a.setText("");
        b.setText("");
        c.setText("");
        resultados.setText("");
    }

    public void graph_quad(View view) {
        setContentView(R.layout.graph_quad);
        LineGraphSeries<DataPoint> series;
        double x = -100.0;
        double y;

        GraphView graph;

        graph = findViewById(R.id.graph_q);
        series = new LineGraphSeries<DataPoint>();

        for (int i = 0; i < 5000; i++) {
            x = x + 0.1;
            y = AQ * x * x + BQ * x + CQ;
            series.appendData(new DataPoint(x, y), true, 5000);
        }
        graph.addSeries(series);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(-5.0);
        graph.getViewport().setMaxX(5.0);
        // max y = yv + 10
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(-15.0);
        graph.getViewport().setMaxY(15.0);

        graph.getViewport().setScrollable(true);
        graph.getViewport().setScalable(true);
    }

    public void graph_afim(View view) {
        setContentView(R.layout.graph_afim);
        LineGraphSeries<DataPoint> series;
        double x = -100.0;
        double y;
        GraphView graph;

        graph = findViewById(R.id.graph_a);
        series = new LineGraphSeries<DataPoint>();

        for (int i = 0; i < 50000; i++) {
            x = x + 0.1;
            y = AA * x + BB;
            series.appendData(new DataPoint(x, y), true, 50000);
        }
        graph.addSeries(series);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(-5.0);
        graph.getViewport().setMaxX(5.0);
        // max y = yv + 10
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(-15.0);
        graph.getViewport().setMaxY(15.0);

        graph.getViewport().setScrollable(true);
        graph.getViewport().setScalable(true);
    }

    public void voltarg_afim(View view) {
        setContentView(R.layout.inserir_afim);
        if (!(AA==0&&BB==0)) {
            a = (EditText) findViewById(R.id.a);
            b = (EditText) findViewById(R.id.b);
            resultados = (TextView) findViewById(R.id.resultados);

            double r;
            double ag;

            r = (-BB / AA);
            ag = Math.toDegrees(Math.atan(AA));

            a.setText(AA + "");
            b.setText(BB + "");
            resultados.setText("Raiz: " + (float) r + "\n\nÂngulo de inclinação: " + (float) ag + "º");
        }
    }
}
