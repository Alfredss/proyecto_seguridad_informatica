package mundo.hola.com.example.alfre.proyecto_seguridad;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{
    LinearLayout linearLayout;
    TextView textView;
    Button btnTiempos;

    //EJEMPLO 01

    private long pressTime = -1l;
    private long releaseTime = 1l;
    private long duration = -1l;




    private List<Long> durations = new ArrayList<Long>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        linearLayout = (LinearLayout) findViewById(R.id.linearPrincipal);
        linearLayout.setOnTouchListener(this);

        textView = (TextView) findViewById(R.id.textview);

        btnTiempos = (Button) findViewById(R.id.btnTiempos);
        btnTiempos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnTiempos:
                        for (Long tiempos : durations){
                            Toast.makeText(MainActivity.this, "tiempo " + tiempos, Toast.LENGTH_SHORT).show();

                        }
                        durations.clear();
                        break;
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
        //Toast.makeText(MainActivity.this, "Tocaste la pantalla",Toast.LENGTH_SHORT).show();
        return true;

    }
}
