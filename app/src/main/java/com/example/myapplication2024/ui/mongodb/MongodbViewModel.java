package com.example.myapplication2024.ui.mongodb;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MongodbViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MongodbViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is mongodb fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}