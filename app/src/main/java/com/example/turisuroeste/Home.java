package com.example.turisuroeste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    //atributos
    ArrayList<Turismo> listadeActividades= new ArrayList<>();
    RecyclerView listadoGrafico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //traemos el listado del layout activity_home
        listadoGrafico=findViewById(R.id.listado);
        //definimos como quiero que pinte la lista en este caso una linea vertical
        listadoGrafico.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        crearLista();
        ListaAdaptador adaptador= new ListaAdaptador(listadeActividades);
        listadoGrafico.setAdapter(adaptador);
    }

    //metodo encargado de pintar el menu

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return (true);
    }



    private void crearLista(){
        listadeActividades.add(new Turismo("Reseña Historica",R.drawable.foto7));
        listadeActividades.add(new Turismo("Gastronomia",R.drawable.foto6));
        listadeActividades.add(new Turismo("Turismo",R.drawable.foto2));
        listadeActividades.add(new Turismo("Hoteleria",R.drawable.angelopolis));
    }
}