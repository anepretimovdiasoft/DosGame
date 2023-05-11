package com.example.dosgame.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dosgame.R;
import com.example.dosgame.domain.Result;

public class ResultViewHolder extends RecyclerView.ViewHolder {

    private View view;

    public ResultViewHolder(View view) {
        super(view);
        this.view = view;
    }

    public void bind(Result result){
        TextView number = view.findViewById(R.id.tv_number);
        number.setText(result.getId()+"");
        TextView name = view.findViewById(R.id.tv_name);
        name.setText(result.getName());
        TextView time = view.findViewById(R.id.tv_time);
        time.setText(result.getTime());
    }
}
