package com.prbansal.roomdbpractice.bahikhata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.prbansal.roomdbpractice.Word;


import java.util.List;

public class KhataViewModel extends AndroidViewModel {
    private KhataRepository repository;
    private LiveData<List<UserData>> getAllUsers;
    private LiveData<List<Bills>> getBills;
    private LiveData<List<Transactions>> getTxn;

    public KhataViewModel(@NonNull Application application) {
        super(application);
        repository = new KhataRepository(application);
        getAllUsers = repository.getAllUsers();

    }

   public LiveData<List<UserData>> getAllUsers() {
        return getAllUsers;
    }
  public   LiveData<List<Bills>> getBills(long id) {
        return repository.getBills(id);
    }
   public LiveData<List<Transactions>> getTxn(long number) {
        return repository.getTxn(number);
    }

  public   void insertUserData(UserData userData) {
        KhataDatabase.databaseWriteExecutor.execute(() -> {
            repository.insertUserData(userData);
        });
    }

   public void insertBill(Bills newBill) {
        KhataDatabase.databaseWriteExecutor.execute(() -> {
            repository.insertBill(newBill);
        });
    }

   public void insertTxn(Transactions transactions) {
        KhataDatabase.databaseWriteExecutor.execute(() -> {
            repository.insertTxn(transactions);
        });
    }

   public void updateUserData(UserData userData) {
        KhataDatabase.databaseWriteExecutor.execute(() -> {
            repository.updateUserData(userData);
        });
    }

   public void updateBill(Bills newBill) {
        KhataDatabase.databaseWriteExecutor.execute(() -> {
            repository.updateBill(newBill);
        });
    }

   public void updateTxn(Transactions transactions) {
        KhataDatabase.databaseWriteExecutor.execute(() -> {
            repository.updateTxn(transactions);
        });
    }
}
