package com.example.votegr.ui.statement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.votegr.PartyActivity;
import com.example.votegr.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;


public class StatementFragment extends Fragment {

    private StatementViewModel statementViewModel;
    private Context mContext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        statementViewModel =
                new ViewModelProvider(this).get(StatementViewModel.class);
        View root = inflater.inflate(R.layout.party_fragment_statement, container, false);

        this.mContext = getContext();

        TextInputEditText textView = root.findViewById(R.id.party_view);
        Button button = root.findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                RequestQueue queue =  Volley.newRequestQueue(getActivity().getApplicationContext());

                String url = "http://192.168.2.4/VoteGR/postView.php";
                StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // response
                                Log.d("Response", response);
                                Intent intent = new Intent(getActivity(), PartyActivity.class);
                                startActivity(intent);
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("Error.Response", error.toString());
                                Intent intent = new Intent(getActivity(), PartyActivity.class);
                                startActivity(intent);
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        SharedPreferences sharedPref = mContext.getSharedPreferences("user_data", Context.MODE_PRIVATE);
                        String user_detail = sharedPref.getString("user_detail", "Not Found");

                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("username", user_detail);
                        params.put("party_opinion", textView.getText().toString());

                        return params;
                    }
                };
                queue.add(postRequest);
            }
        });


        return root;
    }

}
