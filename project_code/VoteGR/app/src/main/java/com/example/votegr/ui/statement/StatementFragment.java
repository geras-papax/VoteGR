package com.example.votegr.ui.statement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.votegr.R;
import com.example.votegr.ui.vote.VoteViewModel;


public class StatementFragment extends Fragment {

    private StatementViewModel statementViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        statementViewModel =
                new ViewModelProvider(this).get(StatementViewModel.class);
        View root = inflater.inflate(R.layout.party_fragment_statement, container, false);
        /*final TextView textView = root.findViewById(R.id.text_vote_question);
        voteViewModel.getVoteQuestion().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

}
