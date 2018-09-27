package com.joseluis0218.pginasamarillasapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.joseluis0218.pginasamarillasapp.R;
import com.joseluis0218.pginasamarillasapp.activities.DetailActivity;
import com.joseluis0218.pginasamarillasapp.activities.SearchResultActivity;
import com.joseluis0218.pginasamarillasapp.models.Lugar;

import java.util.ArrayList;
import java.util.List;

public class LugarAdapter extends RecyclerView.Adapter<LugarAdapter.ViewHolder>{

    private List<Lugar> places;
    Context context;
    public LugarAdapter(List<Lugar> places, Context context){
    this.context = context;this.places = new ArrayList<>();
    }
    public void setPlaces(List<Lugar> places){
        this.places = places;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resultado_list,parent,false);
        final ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.cardView_id.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v){
            Intent i = new Intent(context, DetailActivity.class);
            i.putExtra("fullname_text"     , places.get(viewHolder.getAdapterPosition()).getNombre());
            i.putExtra("category_text", places.get(viewHolder.getAdapterPosition()).getCategoria());
            i.putExtra("address_text", places.get(viewHolder.getAdapterPosition()).getDireccion());
            i.putExtra("phone_text", places.get(viewHolder.getAdapterPosition()).getTelefono());
            i.putExtra("email_text", places.get(viewHolder.getAdapterPosition()).getCorreo());
            i.putExtra("url_text", places.get(viewHolder.getAdapterPosition()).getUrl());
            i.putExtra("picture_image", places.get(viewHolder.getAdapterPosition()).getLogo());
            i.putExtra("info_text", places.get(viewHolder.getAdapterPosition()).getInfo());

            context.startActivity(i);
        }
    });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Lugar lugar = this.places.get(position);
        holder.fullnameText.setText(lugar.getNombre());
        holder.addressText.setText(lugar.getDireccion());
        holder.phoneText.setText(lugar.getTelefono());
        holder.emailText.setText(lugar.getCorreo());
        holder.categoryText.setText(lugar.getCategoria());
        Context context = holder.itemView.getContext();
        int idRes = context.getResources().getIdentifier(lugar.getLogo(),"drawable",context.getPackageName());
        holder.pictureImage.setImageResource(idRes);
    }

    @Override
    public int getItemCount() { //con este metodo decimos cuantos metodos vamos a adjuntar a la vista
        return places.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView pictureImage;
        TextView fullnameText;
        TextView addressText;
        TextView phoneText;
        TextView emailText;
        TextView categoryText;
        CardView cardView_id;

            ViewHolder(View itemView) {
            super(itemView);
            pictureImage = itemView.findViewById(R.id.picture_image);
            fullnameText = itemView.findViewById(R.id.fullname_text);
            addressText = itemView.findViewById(R.id.address_text);
            phoneText = itemView.findViewById(R.id.phone_text);
            emailText = itemView.findViewById(R.id.email_text);
            categoryText = itemView.findViewById(R.id.category_text);
            cardView_id = itemView.findViewById(R.id.card_view_item);
        }
    }
    public void setfilter(List<Lugar> lugarItem){
        places = new ArrayList<>();
        places.addAll(lugarItem);
        notifyDataSetChanged();

    }



}
