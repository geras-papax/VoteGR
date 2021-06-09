package com.example.votegr.ui.stats;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
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

public class StatsFragment extends Fragment {

    private StatsViewModel statsViewModel;

    void getStats(TextView textView) {
        RequestQueue queue =  Volley.newRequestQueue(getActivity().getApplicationContext());
        String url ="http://192.168.2.4/VoteGR/getStats.php";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject voting = new JSONObject(response);
                            String stats = "Έχουν ψηφίσει: " + voting.getString("votes");
                            statsViewModel.setStatsText(stats);
                            textView.setText(stats);
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
        statsViewModel =
                new ViewModelProvider(this).get(StatsViewModel.class);
        View root = inflater.inflate(R.layout.citizen_fragment_stats, container, false);
        final TextView textView = root.findViewById(R.id.text_stats);

        getStats(textView);

        return root;

    }
}