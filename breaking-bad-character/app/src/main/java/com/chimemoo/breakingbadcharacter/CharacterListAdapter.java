package com.chimemoo.breakingbadcharacter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.io.Serializable;
import java.util.List;

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.GridViewHolder> {
    private List<CharacterModel> listCharacter;
    public final static String CHARACTER_DATA = "CHARACTER_DATA";

    public CharacterListAdapter(List<CharacterModel> listCharacter) {
        this.listCharacter = listCharacter;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_character, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listCharacter.get(position).getImg())
                .apply(new RequestOptions().override(350,555))
                .into(holder.imgPhoto);

        CharacterModel characterData = listCharacter.get(position);

        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailCharacter.class);
                intent.putExtra("NAME", characterData.getName());
                intent.putExtra("PICTURE", characterData.getImg());
                intent.putExtra("BIRTHDAY", characterData.getBirthday());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCharacter.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
