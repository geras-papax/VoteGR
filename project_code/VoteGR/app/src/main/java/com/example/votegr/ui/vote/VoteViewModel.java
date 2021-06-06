package com.example.votegr.ui.vote;
import androidx.lifecycle.ViewModel;


public class VoteViewModel extends ViewModel {

    private String vote_question;

    public VoteViewModel() {}

    public String getVoteQuestion() {
        return vote_question;
    }
    public void setVoteQuestion(String str) {
        vote_question = str;
    }
}