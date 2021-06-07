package com.brogrammers.jielian.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brogrammers.jielian.R;

import org.jetbrains.annotations.NotNull;

public class StatusViewHolder extends RecyclerView.ViewHolder {
    public ImageView statusIcon;
    public TextView statusTitle;
    public StatusViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        statusIcon = itemView.findViewById(R.id.mark);
        statusTitle = itemView.findViewById(R.id.status_title);
    }
}
