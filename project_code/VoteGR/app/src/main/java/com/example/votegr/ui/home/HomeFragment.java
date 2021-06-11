package com.example.votegr.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.votegr.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Context mContext;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.citizen_fragment_home, container, false);
        final TextView text_home_msg = root.findViewById(R.id.text_home_msg);
        final TextView text_home_name = root.findViewById(R.id.text_home_name);
        final TextView text_home_role = root.findViewById(R.id.text_home_role);

        this.mContext = getContext();
        SharedPreferences sharedPref = mContext.getSharedPreferences("user_data", Context.MODE_PRIVATE);
        String user_detail = sharedPref.getString("user_detail", "Not Found");
        String role = sharedPref.getString("role", "Not Found");

        homeViewModel.setName(user_detail);
        homeViewModel.setRole(role);

        text_home_msg.setText(homeViewModel.getMessage());
        text_home_name.setText(homeViewModel.getName());
        text_home_role.setText(homeViewModel.getRole());

        return root;
    }
}