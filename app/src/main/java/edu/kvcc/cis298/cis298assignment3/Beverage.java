package edu.kvcc.cis298.cis298assignment3;

import java.util.UUID;

/**
 * Created by aaernie7528 on 11/17/2015.
 */
public class Beverage {
    private UUID mNumber;
    private String mDescription;
    private String mPackSize;
    private String mCasePrice;
    private boolean mActive;

    public UUID getmNumber() {
        return mNumber;
    }

    public void setmNumber(UUID mNumber) {
        this.mNumber = mNumber;
    }

    public boolean ismActive() {
        return mActive;
    }

    public void setmActive(boolean mActive) {
        this.mActive = mActive;
    }

    public String getmCasePrice() {
        return mCasePrice;
    }

    public void setmCasePrice(String mCasePrice) {
        this.mCasePrice = mCasePrice;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmPackSize() {
        return mPackSize;
    }

    public void setmPackSize(String mPackSize) {
        this.mPackSize = mPackSize;
    }
}
