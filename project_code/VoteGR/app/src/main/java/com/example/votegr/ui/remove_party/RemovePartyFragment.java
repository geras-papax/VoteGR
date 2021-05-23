package com.example.votegr.ui.remove_party;

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


public class RemovePartyFragment extends Fragment {

    private String party_selected = "";
    View root;
    TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        RemovePartyViewModel partiesViewModel =  new ViewModelProvider(this).get(RemovePartyViewModel.class);

        root = inflater.inflate(R.layout.admin_fragment_remove_party, container, false);
        textView = root.findViewById(R.id.TEXT_STATUS_ID);


        Spinner parties_dropdown = root.findViewById(R.id.spinnerparties);

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
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub
            }
        });


        return root;
    }


}
