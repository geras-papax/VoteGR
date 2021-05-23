package com.example.votegr.ui.add_party;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.votegr.R;


public class AddPartyFragment extends Fragment {

    private AddPartyViewModel addPartyViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addPartyViewModel =
                new ViewModelProvider(this).get(AddPartyViewModel.class);
        View root = inflater.inflate(R.layout.admin_fragment_add_party, container, false);
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
