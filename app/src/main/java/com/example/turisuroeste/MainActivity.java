package com.example.turisuroeste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {



    //Atributos(Variables)
    FirebaseFirestore baseDatos = FirebaseFirestore.getInstance();
    Map<String, Object> usuario = new HashMap<>();
    Turismo turismo;
    ImageView fotoAtractivoTuristico;
    TextView nombre;
    TextView descripcion;

    //Metodos(funciones)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario.put("fotoAtractivoTuristico",fotoAtractivoTuristico);
        usuario.put("nombre",nombre);
        usuario.put("descripcion",descripcion);

        envioDatos();

        //asociar los atributos a los layout del Activity_main.xml
        fotoAtractivoTuristico=findViewById(R.id.fotoTurismo);
        nombre=findViewById(R.id.nombreActividadTuristica);
        descripcion=findViewById(R.id.descripcionActividad);

        //enlazar el atributo turismo con los datos que llegan del adaptador
        turismo =(Turismo) getIntent().getSerializableExtra("datosTurismo");

        //utilizar los datos del turismo para crear los recursos graficos de la actividad

        //fotoAtractivoTuristico.setImageResource(turismo.getFotoActividad());
        nombre.setText(turismo.getNombreActividad());
        descripcion.setText(turismo.getDescription());

    }
    public void envioDatos(){
        baseDatos.collection("usuarios")
                .add(usuario)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(MainActivity.this, "extio en el registro", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "error"+e, Toast.LENGTH_SHORT).show();

                    }
                });
    }
}