package com.prbansal.roomdbpractice.bahikhata;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;

@Entity(tableName = "bills_data")
public class Bills {
    @PrimaryKey(autoGenerate = true)
    public long billNo;
    public long uniqueId;

    public String item;
    public float principal;
    public float roi;
    public long startDate;
    public long notifyDate;

    public long  lastPayDate;
    public float lastPayAmt;
    public float lastPayROI;

    public int status;
    public float rewardAmt;

    /*public Bills(String item, float principal, float roi, long startDate, long notifyDate) {
        this.item = item;
        this.principal = principal;
        this.roi = roi;
        this.startDate = startDate;
        this.notifyDate = notifyDate;
    }*/

    public Bills(String item, float principal, float roi, long startDate) {
        this.item = item;
        this.principal = principal;
        this.roi = roi;
        this.startDate = startDate;
    }

    public long getBillNo() {
        return billNo;
    }

    public long getLastPayDate() {
        return lastPayDate;
    }

    public float getLastPayAmt() {
        return lastPayAmt;
    }

    public float getLastPayROI() {
        return lastPayROI;
    }

    public int getStatus() {
        return status;
    }

    public float getRewardAmt() {
        return rewardAmt;
    }
}
