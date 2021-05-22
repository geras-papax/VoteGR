package com.example.votegr.ui.select;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.votegr.R;


public class SelectFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //HistoryViewModel historyViewModel =  new ViewModelProvider(this).get(HistoryViewModel.class);
        View root = inflater.inflate(R.layout.citizen_fragment_history, container, false);
        /*final TextView textView = root.findViewById(R.id.TEXT_STATUS_ID);
        Spinner dropdown = root.findViewById(R.id.spinner);

        String[] items = new String[]{"Δημοψήφισμα 27/06/2017",
                "Δημοψήφισμα 20/03/2014",
                "Δημοψήφισμα 24/11/2012",
                "Δημοψήφισμα 02/04/2010",
                "Δημοψήφισμα 05/09/2008"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                Object item = adapterView.getItemAtPosition(position);
                textView.setText("Στατιστικά για: " + item.toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub
            }
        });*/


        return root;
    }

}
