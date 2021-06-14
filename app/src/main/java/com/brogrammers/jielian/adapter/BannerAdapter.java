package com.brogrammers.jielian.adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.brogrammers.jielian.R;
import com.brogrammers.jielian.model.Banner;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerViewHolder> {

    List<Banner> bannerList = new ArrayList();

    public BannerAdapter(List<Banner> bannerList) {
        this.bannerList = bannerList;
    }

    @NonNull
    @Override
    public BannerAdapter.BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.banner_layout, parent, false);
        return new BannerAdapter.BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerAdapter.BannerViewHolder holder, int position) {
        Banner currentItem = bannerList.get(position);
        holder.offerItemImage.setBackgroundResource(currentItem.getImage());
        holder.limitedOffer.setText("Limited offer");
        holder.offerQuantity.setText(currentItem.getOfferQuantity());
        holder.offerLimit.setText(currentItem.getOfferLimit());
    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    static class BannerViewHolder extends RecyclerView.ViewHolder {
        private TextView limitedOffer, offerQuantity, offerLimit;
        private ImageView offerItemImage;

        public BannerViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            limitedOffer = itemView.findViewById(R.id.limited_offer);
            offerQuantity = itemView.findViewById(R.id.offer_quantity);
            offerLimit = itemView.findViewById(R.id.offer_limit);
            offerItemImage = itemView.findViewById(R.id.offer_item_image);
        }
    }
}

