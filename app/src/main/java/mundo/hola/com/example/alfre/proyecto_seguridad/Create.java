package mundo.hola.com.example.alfre.proyecto_seguridad;

import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Create extends AppCompatActivity implements View.OnTouchListener{
    ImageView imgCircle;
    Button btn;

    //varaiables de tiempos
    private long pressTime = -1l;
    private long releaseTime = 1l;
    private long duration = -1l;
    private List<Long> durations = new ArrayList<Long>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //Imagen Circulo
        imgCircle = (ImageView) findViewById(R.id.imgCircle);
        imgCircle.setOnTouchListener(this);
        ShapeDrawable d = new ShapeDrawable (new OvalShape());
        d.setIntrinsicHeight(500);
        d.setIntrinsicWidth(500);
        d.getPaint().setColor(Color.rgb(0, 250, 154));
        imgCircle.setBackgroundDrawable(d);


        btn = (Button) findViewById(R.id.btnTimes);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnTimes:
                        for (Long tiempos : durations) {
                            Toast.makeText(Create.this, "tiempo " + tiempos, Toast.LENGTH_SHORT).show();
                        }
                        durations.clear();
                        break;
                }
            }
        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:
                pressTime = System.currentTimeMillis();
                if(releaseTime != -1l) duration = pressTime - releaseTime;

                break;
            case MotionEvent.ACTION_UP:
                releaseTime = System.currentTimeMillis();
                duration = System.currentTimeMillis() - pressTime;
                durations.add(duration);
                break;
            default:
                break;
        }
        return true;
    }
}
