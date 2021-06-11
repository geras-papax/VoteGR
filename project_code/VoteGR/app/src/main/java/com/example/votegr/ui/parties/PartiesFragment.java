package com.example.votegr.ui.parties;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class PartiesFragment extends Fragment {

    private String party_selected = "";
    private String voting_selected = "";
    View root;
    TextView textSubject;
    TextView textOpinion;

    private PartiesViewModel partiesViewModel;
    private Spinner parties_dropdown;
    private Spinner votings_dropdown;
    private JSONArray parties_views;

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

                            JSONArray parties = json.getJSONArray("parties");

                            List<String> list = new ArrayList<>();
                            list.add("- Επιλογή Κόμματος -");

                            for (int i = 0; i < parties.length(); i++) {
                                list.add(parties.getJSONArray(i).getString(0));
                            }

                            partiesViewModel.setParties(list);


                            ArrayAdapter<String> parties_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, list);
                            parties_dropdown.setAdapter(parties_adapter);
                            parties_dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view,
                                                           int position, long id) {
                                    Object item = adapterView.getItemAtPosition(position);
                                    party_selected = item.toString();
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


                            JSONArray votings = json.getJSONArray("votings");
                            list = new ArrayList<>();
                            list.add("- Επιλογή Δημοψηφίσματος -");

                            for (int i = 0; i < votings.length(); i++) {
                                list.add(votings.getJSONArray(i).getString(0));
                            }

                            partiesViewModel.setVotings(list);


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
        String url1 = "http://192.168.2.4/VoteGR/getPartiesViews.php";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            parties_views = new JSONArray(response);
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

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        partiesViewModel =  new ViewModelProvider(this).get(PartiesViewModel.class);

        root = inflater.inflate(R.layout.citizen_fragment_parties, container, false);
        textSubject = root.findViewById(R.id.text_subject);
        textOpinion = root.findViewById(R.id.text_opinion);

        parties_dropdown = root.findViewById(R.id.spinnerparties);
        votings_dropdown = root.findViewById(R.id.spinnervotings);

        populateDropdowns();
        populateViews();

        return root;
    }

    private void refreshText() throws JSONException {

        for (int i = 0; i < parties_views.length(); i++) {

            JSONObject x = parties_views.getJSONObject(i);
            if(party_selected.equals(x.getString("title")) && voting_selected.equals(x.getString("starting_date"))) {
                textOpinion.setText("Επίσημη Θέση: " + x.getString("party_opinion"));
                textSubject.setText("Θέμα Δημοψηφίσματος: " + x.getString("subject"));
                return;
            }
        }
        textSubject.setText("");
        textOpinion.setText("Δεν βρέθηκε κάποια επίσημη θέση");
    }

}
