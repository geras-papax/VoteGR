package com.example.votegr.ui.parties;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class PartiesViewModel extends ViewModel {

    List<String> parties;
    List<String> votings;


    public PartiesViewModel() {
        parties = new ArrayList<>();
        votings = new ArrayList<>();
    }

    public List<String> getParties() {
        return parties;
    }
    public void setParties(List<String> parties) {
        this.parties = parties;
    }

    public List<String> getVotings() {
        return votings;
    }
    public void setVotings(List<String> votings) {
        this.votings = votings;
    }
}