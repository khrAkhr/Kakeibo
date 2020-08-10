package com.khrakhr.kakeibo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.NextMonthBtn).setOnClickListener(this);
        findViewById(R.id.PrevMonthBtn).setOnClickListener(this);
        findViewById(R.id.SettingsBtn).setOnClickListener(this);
    }

    public void onClick(View view){
        if (view != null) {
            Intent intent;
            switch (view.getId()) {
                case R.id.NextMonthBtn:
                    intent = new Intent(this, MainActivity2.class);
                    startActivity(intent);
                    break;

                case R.id.PrevMonthBtn:
                    intent = new Intent(this, MainActivity2.class);
                    startActivity(intent);
                    break;

                case R.id.SettingsBtn:
                    intent = new Intent(this, SettingsActivity.class);
                    startActivity(intent);
                    break;

                default:
                    break;
            }
        }
    }

}