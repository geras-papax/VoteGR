package com.example.votegr.ui.history;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
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
import com.example.votegr.ui.parties.PartiesViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {

    private HistoryViewModel historyViewModel;
    private JSONArray history_votes;
    private Spinner votings_dropdown;
    private String voting_selected = "";
    private TextView textYes;
    private TextView textNo;
    private TextView textWhite;
    private TextView textSubject;


    void populateDropdowns() {
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url1 = "http://192.168.2.4/VoteGR/getDropDown.php";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json = new JSONObject(response);

                            JSONArray votings = json.getJSONArray("votings");
                            List<String> list = new ArrayList<>();
                            list.add("- Επιλογή Δημοψηφίσματος -");

                            for (int i = 0; i < votings.length(); i++) {
                                list.add(votings.getJSONArray(i).getString(0));
                            }

                            ArrayAdapter<String> votings_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, list);
                            votings_dropdown.setAdapter(votings_adapter);
                            votings_dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view,
                                                           int position, long id) {
                                    Object item = adapterView.getItemAtPosition(position);
                                    voting_selected = item.toString();
                                    try {
                                        refreshText();
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                    // TODO Auto-generated method stub
                                }
                            });



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

        queue.add(stringRequest);
    }


    void populateViews() {
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        String url1 = "http://192.168.2.4/VoteGR/getHistory.php";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            history_votes = new JSONArray(response);
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

        queue.add(stringRequest);
    }




    private void refreshText() throws JSONException {

        for (int i = 0; i < history_votes.length(); i++) {

            JSONObject x = history_votes.getJSONObject(i);
            if(voting_selected.equals(x.getString("starting_date"))) {
                textYes.setText("Ναι: " + x.getInt("yes"));
                textNo.setText("Όχι: " + x.getInt("no"));
                textWhite.setText("Λευκό: " + x.getInt("white"));
                textSubject.setText("Θέμα Δημοψηφίσματος: " + x.getString("subject"));
                return;
            }
        }
        textYes.setText("");
        textNo.setText("");
        textWhite.setText("");
        textSubject.setText("");
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HistoryViewModel historyViewModel =  new ViewModelProvider(this).get(HistoryViewModel.class);
        View root = inflater.inflate(R.layout.citizen_fragment_history, container, false);

        votings_dropdown = root.findViewById(R.id.spinner);
        textYes = root.findViewById(R.id.yes);
        textNo = root.findViewById(R.id.no);
        textWhite = root.findViewById(R.id.white);
        textSubject = root.findViewById(R.id.subject);

        populateViews();
        populateDropdowns();

        return root;
    }
}
