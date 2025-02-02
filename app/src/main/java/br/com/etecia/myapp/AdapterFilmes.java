package br.com.etecia.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterFilmes extends RecyclerView.Adapter<AdapterFilmes.ViewHolder> {
    private Context context;
    private List<Filmes> lstFilmes;

    public AdapterFilmes(Context context, List<Filmes> lstFilmes) {
        this.context = context;
        this.lstFilmes = lstFilmes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.modelo_filmes, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTituloFilmes.setText(lstFilmes.get(position).getTitulo());
        holder.imgFilmes.setImageResource(lstFilmes.get(position).getImgFilmes());

    }

    @Override
    public int getItemCount() {
        return lstFilmes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFilmes;
        TextView txtTituloFilmes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFilmes = itemView.findViewById(R.id.imgFilmes);
            txtTituloFilmes = itemView.findViewById(R.id.txtTituloFilmes);
        }
    }


}
