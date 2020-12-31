package com.calzateu.tareacalificada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasMain);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Catty", R.drawable.mascota1, 5));
        mascotas.add(new Mascota("Ronny", R.drawable.mascota1, 3));
        mascotas.add(new Mascota("Ronny", R.drawable.mascota1, 7));
        mascotas.add(new Mascota("Ronny", R.drawable.mascota1, 2));
        mascotas.add(new Mascota("Ronny", R.drawable.mascota1, 10));
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    //Metodo para mostrar y ocultar el menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuoverflow, menu);
        return true;
    }

    //Metodo para signar las funciones correspondientes a las opciones
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.itemConfiguracion){
            Toast.makeText(this, "La configuración no está disponible en este momento", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.actionButtonFavorito){
            //Toast.makeText(this, "Añadido a fovoritos", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Favoritos.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}