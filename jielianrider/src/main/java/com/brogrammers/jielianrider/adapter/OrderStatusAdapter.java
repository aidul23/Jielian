package com.brogrammers.jielianrider.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brogrammers.jielianrider.R;
import com.brogrammers.jielianrider.clicklistener.StatusClickListener;

import org.jetbrains.annotations.NotNull;

public class OrderStatusAdapter extends RecyclerView.Adapter<OrderStatusAdapter.OrderStatusViewHolder> {

    private final String[] status = {
            "Order Received",
            "Package handed over from restaurant",
            "Rider Coming",
            "Rider has reached the destination"
    };

    private StatusClickListener statusClickListener;

    public void setStatusClickListener(StatusClickListener statusClickListener) {
        this.statusClickListener = statusClickListener;
    }

    @NonNull
    @Override
    public OrderStatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.order_status_layout, parent, false);
        return new OrderStatusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderStatusViewHolder holder, int position) {
        holder.orderStatusTitle.setText(status[position]);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    statusClickListener.onChecked(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    static class OrderStatusViewHolder extends RecyclerView.ViewHolder {

        private final TextView orderStatusTitle;
        private final CheckBox checkBox;

        public OrderStatusViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            orderStatusTitle = itemView.findViewById(R.id.order_status_title);
            checkBox = itemView.findViewById(R.id.mark);
        }
    }
}
