package com.fg.cardboardcollector.view.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.model.Card;

import java.util.List;

public class CentralAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Card> mData;
    private Context mContext;
    private ClickListener clickListener;

    public  interface ClickListener{
        void onClickListener(Card card);
    }

    public CentralAdapter( Context mContext, List<Card> mData, ClickListener clickListener) {
        this.mContext = mContext;
        this.mData = mData;
        this.clickListener = clickListener;
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder{

        protected TextView id;
        protected TextView name;
        protected ImageView img;
        protected ConstraintLayout layout;

         public CardViewHolder(@NonNull View itemView){
             super(itemView);
             id = itemView.findViewById(R.id.textView_cardid);
             name = itemView.findViewById(R.id.textView_cardname);
             img = itemView.findViewById(R.id.imageView_cardimage);
             layout = itemView.findViewById(R.id.layout_item_card);
         }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater
                .from(parent.getContext() )
                .inflate(R.layout.card_item, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        CardViewHolder cardViewHolder = (CardViewHolder) holder;
        cardViewHolder.id.setText(mData.get(position).getCardId().toString());
        cardViewHolder.name.setText(mData.get(position).getCardName());
        Card card = mData.get(position);
        cardViewHolder.layout.setOnClickListener(v -> {clickListener.onClickListener(card);}); //selection du "sur quoi cliquer", renvoyé à la lambda dans le fragment

        //Glide for image display
        Glide.with(mContext)
                .load(mData.get(position).getImage_url())
                .into(cardViewHolder.img);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

}
