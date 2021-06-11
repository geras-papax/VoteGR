package com.example.votegr.ui.remove_party;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RemovePartyFragment extends Fragment {

    private String party_selected = "";
    private View root;
    private Spinner parties_dropdown;

    void populateParties() {
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

                            ArrayAdapter<String> parties_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, list);
                            parties_dropdown.setAdapter(parties_adapter);

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
        RemovePartyViewModel partiesViewModel =  new ViewModelProvider(this).get(RemovePartyViewModel.class);

        root = inflater.inflate(R.layout.admin_fragment_remove_party, container, false);
        parties_dropdown = root.findViewById(R.id.spinnerparties);

        populateParties();
        Button buttonSubmit = root.findViewById(R.id.button);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());

                String url = "http://192.168.2.4/VoteGR/removeParty.php";
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
                        params.put("title", parties_dropdown.getSelectedItem().toString());

                        return params;
                    }
                };
                queue.add(postRequest);
            }
        });

        return root;
    }

}
