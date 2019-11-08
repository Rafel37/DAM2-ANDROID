package com.example.joseg.ejemplo.Elementos.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.joseg.ejemplo.Intents.Util.DataSetCard;
import com.example.joseg.ejemplo.Intents.Util.Juego;
import com.example.joseg.ejemplo.R;

import java.util.List;

public class AdaptadorRecyclerCards extends RecyclerView.Adapter<AdaptadorRecyclerCards.Holder> {

    OnCardRecycler onCardRecycler;
    private List lista;
    private Context context;

    public AdaptadorRecyclerCards(Context context) {
        this.lista = lista;
        this.context = context;
        onCardRecycler = (OnCardRecycler) context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false);
        Holder holder = new Holder(view);
        lista = DataSetCard.newInstance().darJuegos();
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final Juego J = (Juego) lista.get(position);
        holder.getImageView().setImageResource(J.getImagen());
        holder.getTextView().setText(J.getTexto());
        holder.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCardRecycler.onJuegoListener(J);
            }
        });
        holder.getBotonborrar().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista.remove(J);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        ImageView imageView;
        TextView textView;
        Button button, botonborrar;

        public Holder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.LLItemCard);
            imageView = itemView.findViewById(R.id.imagenRVcards);
            textView = itemView.findViewById(R.id.textoRVcards);
            button = itemView.findViewById(R.id.btnRVcard);
            botonborrar = itemView.findViewById(R.id.btnRVcardborrar);
        }

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }

        public ImageView getImageView() {
            return imageView;
        }

        public TextView getTextView() {
            return textView;
        }

        public Button getButton() {
            return button;
        }

        public Button getBotonborrar() {
            return botonborrar;
        }
    }

    public interface OnCardRecycler {
        public void onJuegoListener(Juego j);
    }

}
