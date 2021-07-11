package com.fg.cardboardcollector.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fg.cardboardcollector.R;
import com.fg.cardboardcollector.controller.CardController;
import com.fg.cardboardcollector.controller.ConnexionController;
import com.fg.cardboardcollector.view.CentralActivity;
import com.fg.cardboardcollector.view.adapter.CentralAdapter;

public class CardDatabaseFragment extends Fragment {

    public CardDatabaseFragment(){}

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_central_carddatabase, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_carddatabase);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        CardController.getInstance().getCards(this.getActivity(),(cardList)->{
            recyclerView.setAdapter(
                    new CentralAdapter(
                            this.getActivity(),
                            cardList,
                            (card)->{}
                    )
            );
        });

        return view;
    }
}

