package com.example.turisuroeste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Atributos(Variables)
    Turismo turismo;
    ImageView fotoAtractivoTuristico;
    TextView nombre;

    //Metodos(funciones)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asociar los atributos a los layout
        fotoAtractivoTuristico=findViewById(R.id.fotoTurismo);
        nombre=findViewById(R.id.nombreActividadTuristica);

        //enlazar el atributo trabajador con los datos que llegan del adaptador
        turismo =(Turismo) getIntent().getSerializableExtra("datosTurismo");

        //utilizar los datos del trabajador para crear los recursos graficos de la actividad
        fotoAtractivoTuristico.setImageResource(turismo.getFotoActividad());
        nombre.setText(turismo.getNombreActividad());

    }
}