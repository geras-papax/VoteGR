package com.example.votegr.ui.stats;

import androidx.lifecycle.ViewModel;

public class StatsViewModel extends ViewModel {

    private String stats_text;

    public StatsViewModel() { }

    public String getStatsText() {
        return stats_text;
    }
    public void setStatsText(String str) {
        stats_text = str;
    }

}