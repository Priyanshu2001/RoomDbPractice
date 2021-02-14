package com.prbansal.roomdbpractice.bahikhata;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.prbansal.roomdbpractice.Word;

import java.util.List;

@Dao
public interface KhataDao {

    //Insert Operations
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUserData(UserData data);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertBill(Bills bills);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertTxn(Transactions transactions);

    //Update Operations
    @Update
    void updateUserData(UserData userData);
    @Update
    void updateBill(Bills bills);
    @Update
    void updateTxn(Transactions transactions);

    //Queries for getting lists
    @Query("SELECT * FROM user_data")
    LiveData<List<UserData>> getAllUsers();
    @Query("SELECT * FROM bills_data WHERE uniqueId =:id ")
    LiveData<List<Bills>> getBills(long id);
    @Query("SELECT * FROM txn_data WHERE billNo =:number ")
    LiveData<List<Transactions>> getTxn(long number);

    //queries for searching
    @Query("SELECT * FROM user_data WHERE name LIKE :query " + "OR address LIKE :query " + "OR phoneNo LIKE :query ")
    LiveData<List<UserData>> searchUsers(String query);

}
