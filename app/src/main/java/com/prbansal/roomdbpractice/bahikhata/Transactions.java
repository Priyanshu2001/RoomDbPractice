package com.prbansal.roomdbpractice.bahikhata;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "txn_data")
public class Transactions {

    @PrimaryKey
    public long TxnId;

    public float amount;
    public float rewardROI;

    public long billNo;

    public Transactions(long txnId, float amount, float rewardROI, long billNo) {
        TxnId = txnId;
        this.amount = amount;
        this.rewardROI = rewardROI;
        this.billNo = billNo;
    }

    public Transactions() {
    }
}
