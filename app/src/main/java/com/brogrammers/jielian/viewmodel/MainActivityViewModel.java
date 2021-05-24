package com.brogrammers.jielian.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<String> selectedItemTitleLiveData = new MutableLiveData<>();

    public MutableLiveData<String> getSelectedItemTitleLiveData() {
        return selectedItemTitleLiveData;
    }
}
