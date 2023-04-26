package com.example.dosgame.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;

import com.example.dosgame.R;
import com.example.dosgame.button.MyImageButton;


public class GameFragment extends Fragment {

    private MyImageButton[][] cards;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_game, container, false);

        cards = new MyImageButton[4][9];
        HideLis hideLis = new HideLis();
        int startId = R.id.ib_card_00;

        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                cards[i][j] = view.findViewById(startId + i * 9 + j);
                cards[i][j].setOnClickListener(hideLis);
                cards[i][j].setImageDrawable(
                        AppCompatResources.getDrawable(
                                getActivity(),
                                R.drawable.ic_launcher_background)
                );
            }
        }


        return view;
    }

    private class HideLis implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            ((MyImageButton)view).setClicked(true);
            ((MyImageButton)view).setVisibility(View.INVISIBLE);
        }
    }

    public void reset(){
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                cards[i][j].setVisibility(View.VISIBLE);
                cards[i][j].setClicked(false);
            }
        }
    }
}

