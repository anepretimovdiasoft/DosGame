package com.example.dosgame.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dosgame.R;
import com.example.dosgame.domain.Result;

import java.util.ArrayList;
import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultViewHolder> {

    private List<Result> resultList = new ArrayList<>();

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result, parent, false);
        return new ResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        holder.bind(resultList.get(position));
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = new ArrayList<>(resultList);
        notifyDataSetChanged();
    }
}
