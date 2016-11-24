package mundo.hola.com.example.alfre.proyecto_seguridad;

import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Edit extends AppCompatActivity {
    Button btnCreador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
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
        final LinearLayout lm = (LinearLayout) findViewById(R.id.linearMain);
        final RadioGroup rg = new RadioGroup(getApplicationContext());
        rg.setId(1+2);
        lm.addView(rg);

        btnCreador = (Button) findViewById(R.id.btnCreador);
        btnCreador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                params.setMargins(55, 2, 0, 0);

                LinearLayout.LayoutParams paramsbtn = new LinearLayout.LayoutParams(
                        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                paramsbtn.setMargins(0,2,0,0);

                int j = 0;
                //LinearLayout
                LinearLayout ll = new LinearLayout(getApplicationContext());
                ll.setOrientation(LinearLayout.HORIZONTAL);


                // TextView Nombre de Ritmo
                TextView nombre_ritmo = new TextView(getApplicationContext());
                nombre_ritmo.setText("Ritmo 01");
                nombre_ritmo.setTextColor(getResources().getColor(R.color.negro));
                nombre_ritmo.setWidth(250);
                nombre_ritmo.setHeight(96);
                nombre_ritmo.setGravity(20);
                nombre_ritmo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                nombre_ritmo.setBackgroundColor(getResources().getColor(R.color.nombre_ritmo));
                ll.addView(nombre_ritmo, params);

                //RadioButton

                final RadioButton rb = new RadioButton(getApplicationContext());



                //Button Escuchar
                final Button btnE = new Button(getApplicationContext());
                // Give button an ID
                btnE.setId(j + 1);
                btnE.setText("Es");
                btnE.setWidth(50);
                btnE.setBackgroundColor(getResources().getColor(R.color.btn_escuchar));
                // set the layoutParams on the button
                btnE.setLayoutParams(paramsbtn);
                /*
                //Button Activar
                final Button btnA = new Button(getApplicationContext());
                // Give button an ID
                btnA.setId(j+1);
                btnA.setText("Ac");
                btnA.setWidth(50);
                btnA.setBackgroundColor(getResources().getColor(R.color.btn_activar));
                // set the layoutParams on the button
                btnA.setLayoutParams(paramsbtn);
                */
                // Button Eliminar
                final Button btnD = new Button(getApplicationContext());
                // Give button an ID
                btnD.setId(j+1);
                btnD.setText("El");
                btnD.setWidth(50);
                btnD.setBackgroundColor(getResources().getColor(R.color.btn_eliminar));
                // set the layoutParams on the button
                btnD.setLayoutParams(paramsbtn);

                final int index = j;
                // Set click listener for button
                btnE.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Log.i("TAG", "index :" + index);
                        Toast.makeText(Edit.this, "Editar", Toast.LENGTH_SHORT).show();
                    }
                });

                btnD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Edit.this, "Eliminar", Toast.LENGTH_SHORT).show();
                    }
                });

                //Add button to LinearLayout
                //ll.addView(btnA);
                rg.addView(rb);
                ll.addView(btnE);
                ll.addView(btnD);


                //Add button to LinearLayout defined in XML
                rg.addView(ll);
            }
        });
    }

}
