package com.fg.cardboardcollector.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.controller.CardController;
import com.fg.cardboardcollector.model.Card;
import com.fg.cardboardcollector.view.adapter.CardDatabaseAdapter;
import com.fg.cardboardcollector.view.adapter.MyCollectionAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CardDatabaseFragment extends Fragment {

    public CardDatabaseFragment(){}

    private RecyclerView recyclerView;
    private ArrayList<Card> cardList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_central_carddatabase, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_carddatabase);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        CardController.getInstance().getCards(this.getActivity(),(cardList)->{
            recyclerView.setAdapter(
                    new CardDatabaseAdapter(
                            this.getActivity(),
                            cardList,
                            (card)->{CardController.getInstance().AddCardToCollection(
                                    this.getActivity(),
                                    (cacard) ->{
                                        RecyclerView recyclerViewMyCollection = ((Activity)getContext()).findViewById(R.id.recyclerView_mycollection);
                                        MyCollectionAdapter adapter = (MyCollectionAdapter) recyclerViewMyCollection.getAdapter();
                                        if (adapter == null) { return; }
                                        adapter.getmData().add(cacard);
                                        adapter.notifyDataSetChanged();
                                    },
                                    card);
                            }
                    )
            );
        });
        return view;
    }
}

