package com.example.votegr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_mode);

        Button button = findViewById(R.id.button);
        EditText user_detail = findViewById(R.id.user_detail);
        EditText password = findViewById(R.id.password);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                RequestQueue queue =  Volley.newRequestQueue(MainActivity.this);

                String url = "http://192.168.2.4/VoteGR/login.php";
                StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                Log.d("agis_test", response);

                                if(response.equals("citizen")) {
                                    startActivity(new Intent(MainActivity.this, CitizenActivity.class));
                                } else if(response.equals("party")) {
                                    startActivity(new Intent(MainActivity.this, PartyActivity.class));
                                } else if(response.equals("admin")) {
                                    startActivity(new Intent(MainActivity.this, AdminActivity.class));
                                }

                                // save user_detail & password
                                SharedPreferences sharedPref = getSharedPreferences("user_data", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPref.edit();
                                editor.putString("user_detail", user_detail.getText().toString());
                                //editor.putString("password", password.getText().toString());
                                editor.apply();
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.d("Error.Response", error.toString());
                                Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                                startActivity(intent);
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("user_detail", user_detail.getText().toString());
                        params.put("password", password.getText().toString());

                        return params;
                    }
                };
                queue.add(postRequest);
            }
        });




/*
        Button citizen_button = findViewById(R.id.citizen_button);
        Button party_button = findViewById(R.id.party_button);
        Button admin_button = findViewById(R.id.admin_button);

        citizen_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CitizenActivity.class));
            }
        });

        party_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PartyActivity.class));
            }
        });

        admin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AdminActivity.class));
            }
        });
*/
    }
}