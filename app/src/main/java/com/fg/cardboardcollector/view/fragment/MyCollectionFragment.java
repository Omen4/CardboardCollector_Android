package com.fg.cardboardcollector.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.controller.CardController;
import com.fg.cardboardcollector.view.adapter.CardDatabaseAdapter;
import com.fg.cardboardcollector.view.adapter.MyCollectionAdapter;

public class MyCollectionFragment extends Fragment {

    public MyCollectionFragment(){}

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_central_mycollection, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_mycollection);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        CardController.getInstance().getCardsFromUser(this.getActivity(),(cardList)->{
            recyclerView.setAdapter(
                    new MyCollectionAdapter(
                            this.getActivity(),
                            cardList,
                            (card)->{}
                    )
            );
        });

        return view;
    }
}
//    NoteAdaptater.NoteViewHolder noteViewHolder = (NoteAdaptater.NoteViewHolder) viewHolder;
//    NoteAdaptater adapter = (NoteAdaptater) recyclerView.getAdapter();
//    int itemId = noteViewHolder.getAdapterPosition();

//CardController.getInstance().
//        AddCardToCollection(
//        mContext,
//        (cacarde) -> {},
//        mData.get(position)
//        );
