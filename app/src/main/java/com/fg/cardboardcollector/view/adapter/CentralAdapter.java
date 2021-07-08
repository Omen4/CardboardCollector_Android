package com.fg.cardboardcollector.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.model.Card;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CentralAdapter extends RecyclerView.Adapter<CentralAdapter.MyViewHolder> {

    private Context context;
    private List<Card> cardList;

    public CentralAdapter(Context context, List<Card> cardList) {
        this.context = context;
        this.cardList = cardList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view=inflater.inflate(R.layout.card_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CentralAdapter.MyViewHolder holder, int position) {

        holder.cardid.setText(cardList.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView cardid;
        TextView cardname;
        ImageView cardimage;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cardid = itemView.findViewById(R.id.textView_cardid);
            cardname = itemView.findViewById(R.id.textView_name);
            cardimage = itemView.findViewById(R.id.imageView_cardimage);

        }
    }
}
