package com.example.e_sports_app.dashboards;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.e_sports_app.MainActivity;
import com.example.e_sports_app.R;
import com.example.e_sports_app.helpers.PreferenceHelper;
import com.example.e_sports_app.userpages.FaqActivity;
import com.example.e_sports_app.userpages.FeedbackActivity;
import com.example.e_sports_app.userpages.GamesActivity;
import com.example.e_sports_app.userpages.NoticeBoard;
import com.google.android.material.card.MaterialCardView;

public class UserDashBoard extends Activity {
MaterialCardView open_games,open_fAs,open_feedback,open_notices,open_team_members,card_logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dash_board);
        PreferenceHelper preferenceHelper = new PreferenceHelper(getApplicationContext());
        Toast.makeText(getApplicationContext(), preferenceHelper.getEmail()+"", Toast.LENGTH_SHORT).show();

        open_fAs =findViewById(R.id.open_faqs);
        open_games =findViewById(R.id.open_games_page);
        open_feedback =findViewById(R.id.open_feedback);
        open_notices =findViewById(R.id.open_notice_board);
        open_team_members = findViewById(R.id.open_team_members);

        card_logout = findViewById(R.id.card_logout);

        preferenceHelper = new PreferenceHelper(getApplicationContext());

        open_notices.setOnClickListener(v->startActivity(new Intent(getApplicationContext(), NoticeBoard.class)));
        open_fAs.setOnClickListener(v->startActivity(new Intent(getApplicationContext(), FaqActivity.class)));
        open_feedback.setOnClickListener(v->startActivity(new Intent(getApplicationContext(), FeedbackActivity.class)));
        open_games.setOnClickListener(v->startActivity(new Intent(getApplicationContext(), GamesActivity.class)));

        open_team_members.setOnClickListener(v -> {

        });

        if (preferenceHelper.getType().equals("captain"))
        {
            open_team_members.setVisibility(View.VISIBLE);
        }


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