package com.example.votegr.ui.remove_party;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RemovePartyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RemovePartyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}