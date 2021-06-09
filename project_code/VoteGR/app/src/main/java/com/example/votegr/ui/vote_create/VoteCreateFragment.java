package com.example.votegr.ui.vote_create;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.votegr.AdminActivity;
import com.example.votegr.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;


public class VoteCreateFragment extends Fragment {

    private VoteCreateViewModel voteCreateViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        voteCreateViewModel = new ViewModelProvider(this).get(VoteCreateViewModel.class);
        View root = inflater.inflate(R.layout.admin_fragment_vote_create, container, false);
        final TextInputEditText textView = root.findViewById(R.id.vote_subject);
        final TextInputEditText startDateView = root.findViewById(R.id.vote_start_date);
        final TextInputEditText endDateView = root.findViewById(R.id.vote_end_date);
        final Button buttonSubmit = root.findViewById(R.id.button_submit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                RequestQueue queue =  Volley.newRequestQueue(getActivity().getApplicationContext());

                String url = "http://192.168.2.4/VoteGR/postVote.php";
                StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // response
                                Log.d("Response", response);
                                Intent intent = new Intent(getActivity(), AdminActivity.class);
                                startActivity(intent);
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("Error.Response", error.toString());
                                Intent intent = new Intent(getActivity(), AdminActivity.class);
                                startActivity(intent);
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("subject", textView.getText().toString());
                        params.put("starting_date", startDateView.getText().toString());
                        params.put("ending_date", endDateView.getText().toString());

                        return params;
                    }
                };
                queue.add(postRequest);
            }
        });

        return root;
    }

}
