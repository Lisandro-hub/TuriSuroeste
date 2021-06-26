package com.example.turisuroeste;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Locale;

public class Home extends AppCompatActivity {
    //atributos
    ArrayList<Turismo> listadeActividades= new ArrayList<>();
    RecyclerView listadoGrafico;

    FirebaseFirestore baseDatos = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //traemos el listado del layout activity_home
        listadoGrafico=findViewById(R.id.listado);
        //definimos como quiero que pinte la lista en este caso una linea vertical
        listadoGrafico.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        crearLista();

    }

    //metodo que se encarga de cambiar la configuracion del idioma del telefono
    public void cambioIdioma(String lenguaje){
        Locale idioma=new Locale(lenguaje);//tipo de dato que recibe el idioma a configurar en el telefono
        Locale.setDefault(idioma);//se establece el lenguaje del telefono

        Configuration configuracionTelefono=getResources().getConfiguration();
        configuracionTelefono.locale=idioma;
        getBaseContext().getResources().updateConfiguration(configuracionTelefono, getBaseContext().getResources().getDisplayMetrics());
    }
    //metodo encargado de pintar el menu

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return (true);
    }

    public boolean onOptionsItemSelected(MenuItem item){

        int id=item.getItemId();
        switch (id){

            case R.id.opcion1:
                Intent intent=new Intent(Home.this,Acercade.class);
                startActivity(intent);
                break;

            case R.id.opcion2:
                this.cambioIdioma("en");
                Intent intent2=new Intent(Home.this,Home.class);
                startActivity(intent2);
                break;

            case R.id.opcion3:
                this.cambioIdioma("es");
                Intent intent3=new Intent(Home.this,Home.class);
                startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void crearLista(){
        baseDatos.collection("turismo")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                String nombreActividad=document.get("nombre").toString();
                                String descripcion=document.get("descripcion").toString();
                                String fotoActividad=document.get("foto").toString();

                                listadeActividades.add(new Turismo(nombreActividad,descripcion,fotoActividad));
                            }
                            ListaAdaptador adaptador= new ListaAdaptador(listadeActividades);
                            listadoGrafico.setAdapter(adaptador);
                        }else{
                            Toast.makeText(Home.this, "Error en la consulta", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}