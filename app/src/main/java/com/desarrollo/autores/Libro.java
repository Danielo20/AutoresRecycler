package com.desarrollo.autores;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Libro {

    private EditText mInputLibro;
    private TextView mTextoTitulo;
    private TextView mTextoAutor;

    String titulo;
    String autor;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public void buscarLibro(View view){
        String cadenaBusqueda = mInputLibro.getText().toString();
        new ConseguirLibro(mTextoTitulo,mTextoAutor).execute(cadenaBusqueda);
    }

    private List<Libro> libros;

    private void initializeData(){
        libros = new ArrayList<>();
        libros.add(new Libro(mTextoTitulo.getText().toString(),mTextoAutor.getText().toString()));
        libros.add(new Libro(mTextoTitulo.getText().toString(),mTextoAutor.getText().toString()));
        libros.add(new Libro(mTextoTitulo.getText().toString(),mTextoAutor.getText().toString()));
    }

}

