package com.example.votegr.ui.stats;

import androidx.lifecycle.ViewModel;

public class StatsViewModel extends ViewModel {

    private String stats_text;

    public StatsViewModel() {
        stats_text = "Έχουν ψηφίσει: 4.012.717 / 9.984.934";
    }

    public String getStatsText() {
        return stats_text;
    }
    public void setStatsText(String str) {
        stats_text = str;
    }

}