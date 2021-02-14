package com.prbansal.roomdbpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.prbansal.roomdbpractice.bahikhata.KhataViewModel;
import com.prbansal.roomdbpractice.bahikhata.UserData;
import com.prbansal.roomdbpractice.databinding.ActivityMainBinding;

import static com.prbansal.roomdbpractice.WordRoomDatabase.databaseWriteExecutor;

public class MainActivity extends AppCompatActivity {
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    WordAdapter adapter;
    ViewModelStore store = new ViewModelStore();
    ViewModelProvider.Factory model;
    private KhataViewModel khataViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setAdapter();
        model = new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                KhataViewModel khataViewModel = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(KhataViewModel.class);
                return (T) khataViewModel;
            }
        };
        khataViewModel = new ViewModelProvider(store,model).get(KhataViewModel.class);
        khataViewModel.getAllUsers().observe(this, userData -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(userData);


        });
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserData newUser1 = new UserData("12345","Prb","hello","xyz","00000");
                khataViewModel.insertUserData(newUser1);
            }
        });

    }

    private void setAdapter() {
        adapter = new WordAdapter(new WordAdapter.WordDiff(),this);
        binding.recyclerview.setAdapter(adapter);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    /*public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Word word = new Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY));
            KhataViewModel.insert(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "not saved",
                    Toast.LENGTH_LONG).show();
        }
    }*/
}