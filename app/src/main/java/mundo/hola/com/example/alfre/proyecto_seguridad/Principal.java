package mundo.hola.com.example.alfre.proyecto_seguridad;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.makeText;

public class Principal extends AppCompatActivity implements View.OnTouchListener{
    LinearLayout linearLayout;
    ImageView circle;
    Button btnNuevo, btnEditar;
    ToggleButton tbEncender;
    boolean estadoOnOff=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        //ToggleButton
        tbEncender = (ToggleButton) findViewById(R.id.tbEncender);

        tbEncender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    //APLICACION ACTIVADA
                    //activar botones si existe un ritmo
                    btnNuevo.setEnabled(true);
                    btnEditar.setEnabled(true);
                    estadoOnOff = true;
                    //guardar estado en la base de datos
                    //llevarte directamente a crear un tono si no lo tienes o que te muestre un mensaje
                }else{
                    //APLICACION DESACTIVADA
                    btnNuevo.setEnabled(false);
                    btnEditar.setEnabled(false);
                    estadoOnOff = false;
                    //guardar estado en la base de datos
                }
            }
        });

        //Boton Nuevo
        btnNuevo = (Button) findViewById(R.id.btnNuevo);
        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Create.class);
                startActivity(intent);
            }
        });

        //Boton Editar
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Edit.class);
                startActivity(intent);
            }
        });
        if(estadoOnOff){
            tbEncender.setChecked(true);
        }else{
            tbEncender.setChecked(false);
            btnNuevo.setEnabled(false);
            btnEditar.setEnabled(false);
        }
        linearLayout = (LinearLayout) findViewById(R.id.relative_principal);
        linearLayout.setOnTouchListener(this);

        circle = (ImageView) findViewById(R.id.circle);
        ShapeDrawable d = new ShapeDrawable (new OvalShape());
        d.setIntrinsicHeight(100);
        d.setIntrinsicWidth(100);
        d.getPaint().setColor(Color.rgb(0, 250, 154));
        circle.setBackgroundDrawable(d);

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

        return true;
    }
}
