package com.brogrammers.jielian.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.brogrammers.jielian.model.CategoryItem;
import com.brogrammers.jielian.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<Integer> totalQuantity = new MutableLiveData<>();

    public MainActivityViewModel() {
        totalQuantity.setValue(1);
        orderItemLiveData.setValue(new ArrayList<>());
    }

    private final MutableLiveData<CategoryItem> categoryItemMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<CategoryItem> getCategoryItemMutableLiveData() {
        return categoryItemMutableLiveData;
    }

    public void increaseQuantity() {
        int currentValue = totalQuantity.getValue();

        if (currentValue != 5) {

            totalQuantity.setValue(
                    currentValue + 1
            );

        }

    }

    public void decreaseQuantity() {
        int currentValue = totalQuantity.getValue();

        if (currentValue != 0) {

            totalQuantity.setValue(
                    currentValue - 1
            );

        }
    }

    public MutableLiveData<Integer> getTotalQuantity() {
        return totalQuantity;
    }

    private MutableLiveData<List<OrderItem>> orderItemLiveData = new MutableLiveData<>();

    public MutableLiveData<List<OrderItem>> getOrderItemLiveData() {
        return orderItemLiveData;
    }
}
