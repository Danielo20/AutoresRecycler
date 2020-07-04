package com.desarrollo.autores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public EditText mInputLibro;
    public TextView mTextoTitulo;
    public TextView mTextoAutor;

    public List<Libro> libros;

    public void initializeData(){
        libros = new ArrayList<>();
        libros.add(new Libro("Titulo","Autor"));
        libros.add(new Libro("Titulo","Autor"));
        libros.add(new Libro("Titulo","Autor"));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);

        rv.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getApplicationContext());

        rv.setLayoutManager(linearLayoutManager);

        initializeData();

        RVAdapter rvAdapter = new RVAdapter(libros, this);
        rv.setAdapter(rvAdapter);

        mInputLibro = (EditText)findViewById(R.id.ingresoLibro);
        mTextoTitulo = (TextView)findViewById(R.id.titulo);
        mTextoAutor = (TextView)findViewById(R.id.autorLibro);

    }

    public void buscarLibro(View view){
        String cadenaBusqueda = mInputLibro.getText().toString();
        new ConseguirLibro(mTextoTitulo,mTextoAutor).execute(cadenaBusqueda);
    }


}
