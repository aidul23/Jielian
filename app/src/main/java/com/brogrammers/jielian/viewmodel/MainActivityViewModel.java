package com.brogrammers.jielian.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.brogrammers.jielian.model.CategoryItem;
import com.brogrammers.jielian.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {

    // total quantity of individual item
    private MutableLiveData<Integer> totalQuantity = new MutableLiveData<>();

    // total cost
    private MutableLiveData<Integer> totalCost = new MutableLiveData<>();

    // selected item
    private final MutableLiveData<CategoryItem> categoryItemMutableLiveData = new MutableLiveData<>();

    // selected item from cart
    private final MutableLiveData<OrderItem> orderItemMutableLiveData = new MutableLiveData<>();

    // ordered item list
    private MutableLiveData<List<OrderItem>> orderItemLiveData = new MutableLiveData<>();

    public MainActivityViewModel() {
        totalCost.setValue(0);
        totalQuantity.setValue(1);
        orderItemLiveData.setValue(new ArrayList<>());
    }

    public MutableLiveData<CategoryItem> getCategoryItemMutableLiveData() {
        return categoryItemMutableLiveData;
    }

    public MutableLiveData<OrderItem> getOrderItemMutableLiveData() {
        return orderItemMutableLiveData;
    }

    public void increaseQuantity() {

        int currentValue = totalQuantity.getValue();
        int currentCost = totalCost.getValue();

        if (currentValue != 5) {

            currentValue += 1;

            totalQuantity.setValue(currentValue);

//            currentCost += (categoryItemMutableLiveData.getValue().getPrice() * currentValue);
//
//            totalCost.setValue(currentCost);

        }

    }

    public void decreaseQuantity() {
        int currentValue = totalQuantity.getValue();

        int currentCost = totalCost.getValue();

        if (currentValue != 0) {

            currentValue -= 1;

            totalQuantity.setValue(currentValue);

//            currentCost -= (categoryItemMutableLiveData.getValue().getPrice() * currentValue);
//
//            totalCost.setValue(currentCost);
        }
    }

    public void increaseCost(int cost) {

        int currentCost = totalCost.getValue();

        totalCost.postValue(
                currentCost + cost
        );
    }

    public void decreaseCost(int cost) {

        int currentCost = totalCost.getValue();

        totalCost.postValue(
                currentCost - cost
        );
    }

    public MutableLiveData<Integer> getTotalQuantity() {
        return totalQuantity;
    }

    public MutableLiveData<List<OrderItem>> getOrderItemLiveData() {
        return orderItemLiveData;
    }

    public MutableLiveData<Integer> getTotalCost() {
        return totalCost;
    }
}
