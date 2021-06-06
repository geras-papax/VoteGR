package com.example.votegr.ui.vote;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.votegr.R;

import org.json.JSONException;
import org.json.JSONObject;


public class VoteFragment extends Fragment {

    private VoteViewModel voteViewModel;

    void getVoting(TextView textView) {
        RequestQueue queue =  Volley.newRequestQueue(getActivity().getApplicationContext());
        String url ="http://192.168.2.4/VoteGR/getVote.php";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject voting = new JSONObject(response);
                            String subject = voting.getString("subject");
                            voteViewModel.setVoteQuestion(subject);
                            textView.setText(subject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("my_debug", error.toString());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }



    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        voteViewModel =
                new ViewModelProvider(this).get(VoteViewModel.class);
        View root = inflater.inflate(R.layout.citizen_fragment_vote, container, false);
        final TextView textView = root.findViewById(R.id.text_vote_question);

        getVoting(textView);

        return root;
    }
}