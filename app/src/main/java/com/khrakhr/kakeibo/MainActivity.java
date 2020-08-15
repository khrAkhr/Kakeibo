package com.khrakhr.kakeibo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextWatcher;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

//TODO バージョンの設定
//TODO 設定画面の開発
//TODO ファイルI/O
//TODO 変数名をどうにかする

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.addKarikata).setOnClickListener(this);
        findViewById(R.id.addKashikata).setOnClickListener(this);
        findViewById(R.id.registerShiwake).setOnClickListener(this);
        findViewById(R.id.NextMonthBtn).setOnClickListener(this);
        findViewById(R.id.PrevMonthBtn).setOnClickListener(this);
        findViewById(R.id.SettingsBtn).setOnClickListener(this);

        EditText KarikataHimoku = (EditText)findViewById(R.id.textInputKarikataHimokuEdit);
        EditText KarikataKinagaku = (EditText)findViewById(R.id.textInputKarikataKingakuEdit);
        EditText KashikataHimoku = findViewById(R.id.textInputKashikataHimokuEdit);
        EditText KashikataKinagaku = findViewById(R.id.textInputKashikataKingakuEdit);
        KarikataHimoku.addTextChangedListener(new GenericTextWatcher(KarikataHimoku));
        KarikataKinagaku.addTextChangedListener(new GenericTextWatcher(KarikataKinagaku));
        KashikataHimoku.addTextChangedListener(new GenericTextWatcher(KashikataHimoku));
        KashikataKinagaku.addTextChangedListener(new GenericTextWatcher(KashikataKinagaku));

    }

    public void onClick(View view){
        if (view != null) {
            Intent intent;
            switch (view.getId()) {
                case R.id.addKarikata:
                    Toast.makeText(this, "借方費目の追加", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.addKashikata:
                    TextInputEditText KarikataKingaku = (TextInputEditText)findViewById(R.id.textInputKarikataKingakuEdit);
                    TextInputEditText KashikataKingaku = (TextInputEditText)findViewById(R.id.textInputKashikataKingakuEdit);
                    String KarikataKingakuStr = KarikataKingaku.getEditableText().toString();
                    String KashikataKingakuStr = KashikataKingaku.getEditableText().toString();
                    if (KarikataKingakuStr.equals("")) {
                        Toast.makeText(this, "借方の金額を入力してください。", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (KashikataKingakuStr.equals("")) {
                        Toast.makeText(this, "貸方の金額を入力してください。", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    int a = Integer.parseInt(KarikataKingakuStr) + Integer.parseInt(KashikataKingakuStr);
                    Toast.makeText(this, String.valueOf(a), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(this, "貸方費目の追加", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.registerShiwake:
                    registerShiwake();
                    break;

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

    private class GenericTextWatcher implements TextWatcher {

        private View view;

        private GenericTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Context context = getApplicationContext();
            switch (view.getId()) {
                case R.id.textInputKarikataKingakuEdit:
                    Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.textInputKashikataKingakuEdit:
                    Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        public void afterTextChanged(Editable s) {}

    }

    public void registerShiwake() {
        TextInputEditText KarikataHimoku = (TextInputEditText)findViewById(R.id.textInputKarikataHimokuEdit);
        TextInputEditText KarikataKingaku = (TextInputEditText)findViewById(R.id.textInputKarikataKingakuEdit);
        TextInputEditText KashikataHimoku = (TextInputEditText)findViewById(R.id.textInputKashikataHimokuEdit);
        TextInputEditText KashikataKingaku = (TextInputEditText)findViewById(R.id.textInputKashikataKingakuEdit);
        Toast.makeText(this, "借方: " + KarikataHimoku.getEditableText()+ " " + KarikataKingaku.getEditableText() + "円\r\n" +
                                        "貸方: " + KashikataHimoku.getEditableText() + " " + KashikataKingaku.getEditableText() + "円",
                                        Toast.LENGTH_SHORT).show();
    }

}