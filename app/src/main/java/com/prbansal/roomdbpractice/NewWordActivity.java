package com.prbansal.roomdbpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.prbansal.roomdbpractice.databinding.ActivityNewWordBinding;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.prbansal.roompractice.REPLY";
    ActivityNewWordBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewWordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (binding.wordTxt.getText()==null) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = binding.wordTxt.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, word);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });
    }
}