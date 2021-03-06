package com.example.e_sports_app.dashboards;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.e_sports_app.MainActivity;
import com.example.e_sports_app.R;
import com.example.e_sports_app.adminpages.ManageFaq;
import com.example.e_sports_app.adminpages.ManageFeedBack;
import com.example.e_sports_app.adminpages.ManageGames;
import com.example.e_sports_app.adminpages.ManageNotices;
import com.example.e_sports_app.adminpages.ManageRequests;
import com.example.e_sports_app.adminpages.ManageTeams;
import com.example.e_sports_app.adminpages.ManageUsers;
import com.google.android.material.card.MaterialCardView;

public class AdminDashboard extends Activity {
MaterialCardView open_manage_users,open_manage_notices,open_manage_games,open_manage_faq,open_manage_feedback,open_manage_teams,card_logout,open_manage_requests;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        open_manage_users = findViewById(R.id.open_manage_users);
        open_manage_notices = findViewById(R.id.open_manage_notices);
        open_manage_games = findViewById(R.id.open_manage_games);
        open_manage_faq = findViewById(R.id.open_manage_faq);
        open_manage_feedback = findViewById(R.id.open_manage_feedback);
        open_manage_teams = findViewById(R.id.open_manage_teams);
        card_logout = findViewById(R.id.card_logout);
        open_manage_requests = findViewById(R.id.open_manage_requests);

        open_manage_users.setOnClickListener(v->{
            Intent intent= new Intent(getApplicationContext(), ManageUsers.class);
            startActivity(intent);
        });

        open_manage_notices.setOnClickListener(v->{
            Intent intent= new Intent(getApplicationContext(), ManageNotices.class);
            startActivity(intent);
        });
        open_manage_games.setOnClickListener(v->{
            Intent intent= new Intent(getApplicationContext(), ManageGames.class);
            startActivity(intent);
        });
        open_manage_faq.setOnClickListener(v->{
            Intent intent= new Intent(getApplicationContext(), ManageFaq.class);
            startActivity(intent);
        });
        open_manage_feedback.setOnClickListener(v->{
            Intent intent= new Intent(getApplicationContext(), ManageFeedBack.class);
            startActivity(intent);
        });

        open_manage_teams.setOnClickListener(v->{
        Intent intent= new Intent(getApplicationContext(), ManageTeams.class);
        startActivity(intent);
    });
        open_manage_requests.setOnClickListener(v->{
            Intent intent= new Intent(getApplicationContext(), ManageRequests.class);
            startActivity(intent);
        });

        card_logout.setOnClickListener(v -> {

            SharedPreferences preferences=getSharedPreferences("user",MODE_PRIVATE);
            SharedPreferences.Editor editor=preferences.edit();

                editor.clear();
                editor.apply();
                Toast.makeText(this, "Logout Successful!!", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent1);
                this.finish();

        });
    }
}