package com.example.votegr.ui.vote;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.example.votegr.R;

public class VoteFragment extends Fragment {

    private VoteViewModel voteViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        voteViewModel =
                new ViewModelProvider(this).get(VoteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_vote, container, false);
        final TextView textView = root.findViewById(R.id.text_vote_question);
        voteViewModel.getVoteQuestion().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}