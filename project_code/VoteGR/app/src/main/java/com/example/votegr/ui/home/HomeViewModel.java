package com.example.votegr.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> msg;
    private MutableLiveData<String> name;
    private MutableLiveData<String> afm;

    public HomeViewModel() {
        msg = new MutableLiveData<>();
        name = new MutableLiveData<>();
        afm = new MutableLiveData<>();
        msg.setValue("Καλωσήρθες!");
        name.setValue("Όνομα: Αγησίλαος Κουνέλης");
        afm.setValue("ΑΦΜ: 1059637");
    }

    public LiveData<String> getMessage() {
        return msg;
    }
    public LiveData<String> getName() {
        return name;
    }
    public LiveData<String> getAfm() {
        return afm;
    }
}