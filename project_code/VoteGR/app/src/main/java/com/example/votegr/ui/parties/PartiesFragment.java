package com.example.votegr.ui.parties;

import android.os.Bundle;
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
import com.example.votegr.R;


public class PartiesFragment extends Fragment {

    private String party_selected = "";
    private String voting_selected = "";
    View root;
    TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        PartiesViewModel partiesViewModel =  new ViewModelProvider(this).get(PartiesViewModel.class);

        root = inflater.inflate(R.layout.fragment_parties, container, false);
        textView = root.findViewById(R.id.TEXT_STATUS_ID);


        Spinner parties_dropdown = root.findViewById(R.id.spinnerparties);
        Spinner votings_dropdown = root.findViewById(R.id.spinnervotings);

        String[] parties = new String[]{"Νέα Δημοκρατία",
                                    "ΣΥΝΑΣΠΙΣΜΟΣ ΡΙΖΟΣΠΑΣΤΙΚΗΣ ΑΡΙΣΤΕΡΑΣ",
                                    "ΚΙΝΗΜΑ ΑΛΛΑΓΗΣ",
                                    "Κ.Κ.Ε. - Κομμουνιστικό Κόμμα Ελλάδας",
                                    "ΕΛΛΗΝΙΚΗ ΛΥΣΗ",
                                    "ΜέΡΑ25"
                                    };
        ArrayAdapter<String> parties_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, parties);
        parties_dropdown.setAdapter(parties_adapter);

        parties_dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                Object item = adapterView.getItemAtPosition(position);
                party_selected = item.toString();
                refreshText();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub
            }
        });


        String[] votings = new String[]{
                "Τρέχον Δημοψήφισμα",
                "Δημοψήφισμα 27/06/2017",
                "Δημοψήφισμα 20/03/2014",
                "Δημοψήφισμα 24/11/2012",
                "Δημοψήφισμα 02/04/2010",
                "Δημοψήφισμα 05/09/2008"
        };
        ArrayAdapter<String> votings_adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, votings);
        votings_dropdown.setAdapter(votings_adapter);

        votings_dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                Object item = adapterView.getItemAtPosition(position);
                voting_selected = item.toString();
                refreshText();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub
            }
        });


        return root;
    }

    private void refreshText() {
        textView.setText("Θέση του κόμματος: " + party_selected + " για το: " + voting_selected);
    }

}
