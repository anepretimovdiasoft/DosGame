package com.example.dosgame.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dosgame.R;
import com.example.dosgame.domain.Result;
import com.example.dosgame.recycler.ResultAdapter;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {

    private ResultAdapter resultAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        resultAdapter = new ResultAdapter();
        RecyclerView recyclerView = view.findViewById(R.id.rv_top_list);
        recyclerView.setAdapter(resultAdapter);

        List<Result> resultList = new ArrayList<>();
        resultList.add(new Result(1, "Иван 1", "00:00"));
        resultList.add(new Result(2, "Иван 2", "00:00"));
        resultList.add(new Result(3, "Иван 3", "00:00"));
        resultList.add(new Result(4, "Иван 4", "00:00"));
        resultAdapter.setResultList(resultList);

        return view;
    }
}
