package com.prbansal.roomdbpractice.bahikhata;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;

@Entity(tableName = "user_data")
public class UserData {

    public String phoneNo;
    public String name;
    public String fathersName;
    public String address;
    public String aadharNo;

    @PrimaryKey
    @NonNull
    public long uniqueID;

    public UserData(String phoneNo, String name, String fathersName, String address, String aadharNo) {
        this.phoneNo = phoneNo;
        this.name = name;
        this.fathersName = fathersName;
        this.address = address;
        this.aadharNo = aadharNo;
        this.uniqueID = Calendar.getInstance().getTimeInMillis();
    }

    public long getUniqueID() {
        return uniqueID;
    }
}
