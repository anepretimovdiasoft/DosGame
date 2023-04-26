package com.example.dosgame.fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
                                R.drawable.notright)
                );
                cards[i][j].setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }

        initCardFirstPattern();

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

    public boolean checkResult(){
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards[i].length; j++) {
                if (cards[i][j].isRight() && cards[i][j].isClicked() ||  !cards[i][j].isRight() && !cards[i][j].isClicked()) return false;
            }
        }
        return true;
    }

    private void initCardFirstPattern(){
        cards[0][1].setImageDrawable(
                AppCompatResources.getDrawable(
                        getActivity(),
                        R.drawable.right)
        );
        cards[0][1].setRight(true);

        cards[2][4].setImageDrawable(
                AppCompatResources.getDrawable(
                        getActivity(),
                        R.drawable.right)
        );
        cards[2][4].setRight(true);

        cards[1][1].setImageDrawable(
                AppCompatResources.getDrawable(
                        getActivity(),
                        R.drawable.right)
        );
        cards[1][1].setRight(true);

        cards[3][5].setImageDrawable(
                AppCompatResources.getDrawable(
                        getActivity(),
                        R.drawable.right)
        );
        cards[3][5].setRight(true);
    }

}

