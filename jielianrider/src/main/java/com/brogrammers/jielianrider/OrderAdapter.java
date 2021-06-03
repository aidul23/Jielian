package com.brogrammers.jielianrider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private final List<Order> orderList;

    private OrderItemClickListener orderItemClickListener;

    public void setOrderItemClickListener(OrderItemClickListener orderItemClickListener) {
        this.orderItemClickListener = orderItemClickListener;
    }

    public OrderAdapter(List<Order> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.order_item_layout, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        holder.orderTotalCost.setText(StringUtility.getFormattedString(orderList.get(position).getOrderTotalCost()));
        holder.orderDateTime.setText(orderList.get(position).getOrderDateTime());
        holder.orderId.setText(orderList.get(position).getOrderId());
        holder.deliveryStatus.setText(orderList.get(position).getOrderStatus());
        holder.pickupAddress.setText(orderList.get(position).getPickupAddress());
        holder.destinationAddress.setText(orderList.get(position).getDestinationAddress());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderItemClickListener.onClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {

        private final TextView orderId, orderDateTime, orderTotalCost, pickupAddress, destinationAddress, deliveryStatus;

        public OrderViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            orderId = itemView.findViewById(R.id.order_id);
            orderDateTime = itemView.findViewById(R.id.order_date_time);
            orderTotalCost = itemView.findViewById(R.id.order_total_cost);

            pickupAddress = itemView.findViewById(R.id.pickup_point_address);
            destinationAddress = itemView.findViewById(R.id.destination_address);
            deliveryStatus = itemView.findViewById(R.id.delivery_status);
        }
    }
}
