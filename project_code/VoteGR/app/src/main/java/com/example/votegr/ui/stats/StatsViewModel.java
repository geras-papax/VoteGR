package com.example.votegr.ui.stats;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StatsViewModel extends ViewModel {

    private MutableLiveData<String> stats_text;

    public StatsViewModel() {
        stats_text = new MutableLiveData<>();
        stats_text.setValue("Έχουν ψηφίσει: 4.012.717 / 9.984.934");
    }

    public LiveData<String> getStats() {
        return stats_text;
    }
}