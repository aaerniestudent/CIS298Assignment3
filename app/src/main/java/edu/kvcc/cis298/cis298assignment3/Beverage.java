package edu.kvcc.cis298.cis298assignment3;

import java.util.UUID;

/**
 * Created by aaernie7528 on 11/17/2015.
 */
//beverage POJO
public class Beverage {
    private UUID mId;
    private String mNumber;
    private String mDescription;
    private String mPackSize;
    private double mCasePrice;
    private boolean mActive;

    //build beverage
    public Beverage(String number, String description, String packsize, double price, boolean active) {
        mId = UUID.randomUUID();
        mNumber = number;
        mDescription = description;
        mPackSize = packsize;
        mCasePrice = price;
        mActive = active;
    }

    public UUID getId() {
        return mId;
    }

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public boolean isActive() {
        return mActive;
    }

    public void setActive(boolean mActive) {
        this.mActive = mActive;
    }

    public double getCasePrice() {
        return mCasePrice;
    }

    public void setCasePrice(double mCasePrice) {
        this.mCasePrice = mCasePrice;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getPackSize() {
        return mPackSize;
    }

    public void setPackSize(String mPackSize) {
        this.mPackSize = mPackSize;
    }
}
