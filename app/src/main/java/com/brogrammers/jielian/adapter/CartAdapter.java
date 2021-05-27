package com.brogrammers.jielian.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brogrammers.jielian.R;
import com.brogrammers.jielian.model.OrderItem;
import com.brogrammers.jielian.utility.StringUtility;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private final List<OrderItem> orderItems;

    public CartAdapter(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cart_item_layout, parent, false);
        return new CartAdapter.CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {
        holder.foodItemName.setText(orderItems.get(position).getItemName());
        holder.foodItemPrice.setText(StringUtility.getFormattedString(orderItems.get(position).getItemPrice()));
        holder.foodItemQuantity.setText("" + orderItems.get(position).getItemQuantity());
    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {

        private TextView foodItemName, foodItemPrice, foodItemQuantity;

        public CartViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            foodItemName = itemView.findViewById(R.id.food_item_name);
            foodItemPrice = itemView.findViewById(R.id.food_item_price);
            foodItemQuantity = itemView.findViewById(R.id.food_item_quantity);
        }
    }
}
