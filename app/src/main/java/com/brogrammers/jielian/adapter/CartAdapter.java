package com.brogrammers.jielian.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brogrammers.jielian.R;
import com.brogrammers.jielian.clicklisteners.CartItemClickListener;
import com.brogrammers.jielian.constants.Constant;
import com.brogrammers.jielian.model.OrderItem;
import com.brogrammers.jielian.utility.StringUtility;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private static final String TAG = "CartAdapter";

    private final List<OrderItem> orderItems;

    private String type;

    public CartAdapter(List<OrderItem> orderItems, String type) {
        this.orderItems = orderItems;
        this.type = type;
    }

    private CartItemClickListener cartItemClickListener;

    public void setCartItemClickListener(CartItemClickListener cartItemClickListener) {
        this.cartItemClickListener = cartItemClickListener;
    }

    @NonNull
    @Override
    public CartAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case 0:
                View view = inflater.inflate(R.layout.cart_item_layout, parent, false);
                return new CartAdapter.CartViewHolder(view);

            default:
                View orderDetailLayout = inflater.inflate(R.layout.order_detail_item_layout, parent, false);
                return new CartAdapter.CartViewHolder(orderDetailLayout);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHolder holder, int position) {

        if (type.equals(Constant.LAYOUT_TYPE_ORDER_DETAIL)) {

            holder.foodItemName.setText(
                    String.format("%s\n%d x %d", orderItems.get(position).getItemName(), orderItems.get(position).getItemQuantity(), orderItems.get(position).getItemPrice())
            );

            holder.foodItemPrice.setText(
                    StringUtility.getFormattedString(
                            orderItems.get(position).getItemPrice() * orderItems.get(position).getItemQuantity()
                    )
            );

        } else {
            holder.foodItemName.setText(orderItems.get(position).getItemName());
            holder.foodItemPrice.setText(StringUtility.getFormattedString(orderItems.get(position).getItemPrice()));
            holder.foodItemQuantity.setText("" + orderItems.get(position).getItemQuantity());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cartItemClickListener.onClick(orderItems.get(position));
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (type.equals(Constant.LAYOUT_TYPE_ORDER)) {
            return 0;
        } else if (type.equals(Constant.LAYOUT_TYPE_ORDER_DETAIL)) {
            return 1;
        }

        return -1;
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
