package com.brogrammers.jielian.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.brogrammers.jielian.R;
import com.brogrammers.jielian.clicklisteners.OnItemClickListener;
import com.brogrammers.jielian.constants.Constant;
import com.brogrammers.jielian.model.CategoryItem;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.CommonViewHolder> {

    private static final int[] categoryImages =
            {R.drawable.biriyani, R.drawable.burger, R.drawable.chicken_fry, R.drawable.french_fries, R.drawable.pizza};

    private final List<CategoryItem> categoryItems;
    private final String type;

    public CommonAdapter(List<CategoryItem> categoryItems, String type) {
        this.categoryItems = categoryItems;
        this.type = type;
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CommonAdapter.CommonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {

            case 0:
                View categoryView = inflater.inflate(R.layout.category_item_layout, parent, false);
                return new CommonAdapter.CommonViewHolder(categoryView);

            case 1:
                View foodItemView = inflater.inflate(R.layout.food_item_layout, parent, false);
                return new CommonAdapter.CommonViewHolder(foodItemView);

            case 2:
                View foodItemViewLarge = inflater.inflate(R.layout.food_item_layout_large, parent, false);
                return new CommonAdapter.CommonViewHolder(foodItemViewLarge);

            default:
                View foodItemViewLarge2 = inflater.inflate(R.layout.food_item_layout_large_2, parent, false);
                return new CommonAdapter.CommonViewHolder(foodItemViewLarge2);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull CommonAdapter.CommonViewHolder holder, int position) {

        holder.foodItemName.setText(categoryItems.get(position).getTitle());
        holder.foodItemImage.setImageDrawable(ContextCompat.getDrawable(holder.itemView.getContext(), categoryImages[position]));
        // TODO: 23/05/2021 set image to foodItemImage with glide

        if (type.equals(Constant.LAYOUT_TYPE_ITEM)) {
            // TODO: 24/05/2021 use currency formatter 
            holder.foodItemPrice.setText(categoryItems.get(position).getPrice());
        } else if (type.equals(Constant.LAYOUT_TYPE_ITEM_LARGE) || type.equals(Constant.LAYOUT_TYPE_ITEM_LARGE2)) {
            holder.foodItemPrice.setText(categoryItems.get(position).getPrice());
            holder.foodItemDescription.setText(categoryItems.get(position).getDescription());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(categoryItems.get(position).getTitle(), type);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryItems.size();
    }

    @Override
    public int getItemViewType(int position) {

        if (type.equals(Constant.LAYOUT_TYPE_CATEGORY)) {
            return 0;
        } else if (type.equals(Constant.LAYOUT_TYPE_ITEM)) {
            return 1;
        } else if (type.equals(Constant.LAYOUT_TYPE_ITEM_LARGE)) {
            return 2;
        } else if (type.equals(Constant.LAYOUT_TYPE_ITEM_LARGE2)) {
            return 3;
        }

        return -1;
    }

    static class CommonViewHolder extends RecyclerView.ViewHolder {

        private final ImageView foodItemImage;
        private final TextView foodItemName, foodItemPrice, foodItemDescription;

        public CommonViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            foodItemImage = itemView.findViewById(R.id.food_item_image);

            foodItemName = itemView.findViewById(R.id.food_item_name);

            foodItemPrice = itemView.findViewById(R.id.food_item_price);

            foodItemDescription = itemView.findViewById(R.id.food_item_description);
        }
    }
}

