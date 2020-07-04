package com.desarrollo.autores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.LibroViewHolder> {

    List<Libro> libros;
    Context context;

    RVAdapter(List<Libro> libros, Context context){
        this.libros = libros;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

    @NonNull
    @Override
    public LibroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.libro,parent,false);

        LibroViewHolder lvh = new LibroViewHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull LibroViewHolder holder, int position) {
        holder.tituloLibro.setText(libros.get(position).titulo);
        holder.autorLibro.setText(libros.get(position).autor);
    }

    @Override
    public int getItemCount() {
        return libros.size();
    }

    public static class LibroViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView tituloLibro;
        TextView autorLibro;

        LibroViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            tituloLibro = (TextView)itemView.findViewById(R.id.titulo);
            autorLibro = (TextView)itemView.findViewById(R.id.autorLibro);
        }
    }
}
