package com.fg.cardboardcollector.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.model.Card;

import java.util.List;

public class MyCollectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Card> mData;
    private Context mContext;
    private ClickListener clickListener;

    public  interface ClickListener{
        void onClickListener(Card card);
    }

    public MyCollectionAdapter(Context mContext, List<Card> mData, ClickListener clickListener) {
        this.mContext = mContext;
        this.mData = mData;
        this.clickListener = clickListener;
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder{

        protected TextView id;
        protected TextView name;
        protected ImageView img;
        protected ConstraintLayout layout;
        protected Button button;

         public CardViewHolder(@NonNull View itemView){
             super(itemView);
             id = itemView.findViewById(R.id.textView_cardid_collection);
             name = itemView.findViewById(R.id.textView_cardname_collection);
             img = itemView.findViewById(R.id.imageView_cardimage_collection);
             layout = itemView.findViewById(R.id.layout_item_card_collection);
             button = itemView.findViewById(R.id.btn_removefromcollection);
         }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater
                .from(parent.getContext() )
                .inflate(R.layout.card_item_collection, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        CardViewHolder cardViewHolder = (CardViewHolder) holder;
        cardViewHolder.id.setText(mData.get(position).getCardId().toString());
        cardViewHolder.name.setText(mData.get(position).getCardName());
        //Glide for image display
        Glide.with(mContext)
                .load(mData.get(position).getImage_url())
                .override(500,500)
                .into(cardViewHolder.img);
        Card card = mData.get(position);
        cardViewHolder.layout.setOnClickListener(v -> {clickListener.onClickListener(card);}); //selection du "sur quoi cliquer", renvoy?? ?? la lambda dans le fragment
        cardViewHolder.button.setOnClickListener(z -> {clickListener.onClickListener(card);});
    }


    public List<Card> getmData() {
        return mData;
    }

    public void setmData(List<Card> mData) {
        this.mData = mData;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

//    private void scaleImage(ImageView view){
//        Drawable drawing = view.getDrawable();
//        if (drawing == null) {
//            return;
//        }
//        Bitmap bitmap = ((BitmapDrawable) drawing).getBitmap();
//
//        int width = bitmap.getWidth();
//        int height = bitmap.getHeight();
//        int xBounding = ((View) view.getParent()).getWidth();//EXPECTED WIDTH
//        int yBounding = ((View) view.getParent()).getHeight();//EXPECTED HEIGHT
//
//        float xScale = ((float) xBounding) / width;
//        float yScale = ((float) yBounding) / height;
//
//        Matrix matrix = new Matrix();
//        matrix.postScale(xScale, yScale);
//
//        Bitmap scaledBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
//        width = scaledBitmap.getWidth();
//        height = scaledBitmap.getHeight();
//        BitmapDrawable result = new BitmapDrawable(mContext.getResources(), scaledBitmap);
//
//        view.setImageDrawable(result);
//
//        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
//        params.width = width;
//        params.height = height;
//        view.setLayoutParams(params);
//    }

}
