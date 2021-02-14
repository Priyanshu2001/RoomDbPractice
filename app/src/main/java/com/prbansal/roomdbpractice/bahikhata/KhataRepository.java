package com.prbansal.roomdbpractice.bahikhata;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.prbansal.roomdbpractice.Word;
import com.prbansal.roomdbpractice.WordDao;
import com.prbansal.roomdbpractice.WordRoomDatabase;

import java.util.List;

public class KhataRepository {
    private KhataDao khataDao;
    private LiveData<List<UserData>> getAllUsers;
    private LiveData<List<Bills>> getBills;
    private LiveData<List<Transactions>> getTxn;


    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    KhataRepository(Application application) {
        KhataDatabase db = KhataDatabase.getDatabase(application);
        khataDao = db.khataDao();
        getAllUsers = khataDao.getAllUsers();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<UserData>> getAllUsers() {
        return getAllUsers;
    }
    LiveData<List<Bills>> getBills(long id) {
        return khataDao.getBills(id);
    }
    LiveData<List<Transactions>> getTxn(long number) {
        return khataDao.getTxn(number);
    }


    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insertUserData(UserData userData) {
        KhataDatabase.databaseWriteExecutor.execute(() -> {
            khataDao.insertUserData(userData);
        });
    }

    void insertBill(Bills newBill) {
        KhataDatabase.databaseWriteExecutor.execute(() -> {
            khataDao.insertBill(newBill);
        });
    }

    void insertTxn(Transactions transactions) {
        KhataDatabase.databaseWriteExecutor.execute(() -> {
            khataDao.insertTxn(transactions);
        });
    }

    void updateUserData(UserData userData) {
        KhataDatabase.databaseWriteExecutor.execute(() -> {
            khataDao.updateUserData(userData);
        });
    }

    void updateBill(Bills newBill) {
        KhataDatabase.databaseWriteExecutor.execute(() -> {
            khataDao.updateBill(newBill);
        });
    }

    void updateTxn(Transactions transactions) {
        KhataDatabase.databaseWriteExecutor.execute(() -> {
            khataDao.updateTxn(transactions);
        });
    }
}
