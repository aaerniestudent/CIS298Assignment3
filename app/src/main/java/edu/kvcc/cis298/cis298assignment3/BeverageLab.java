package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by aaernie7528 on 11/21/2015.
 */
public class BeverageLab {
    private static BeverageLab sBeverageLab;

    private List<Beverage> mBeverage;
    public static BeverageLab get(Context context){
        if (sBeverageLab == null){
            sBeverageLab = new BeverageLab(context);
        }
        return sBeverageLab;
    }
    private BeverageLab(Context context){
        mBeverage = new ArrayList<>();
        //populate
            for (int i = 0; i <100; i++) {
                Beverage beverage = new Beverage();
                beverage.setDescription("Beverage #" + i);
                beverage.setCasePrice(1.00 + i);
                beverage.setActive(true);
                beverage.setPackSize("13 ml");
                mBeverage.add(beverage);
            }
    }
    public List<Beverage> getBeverage(){
        return mBeverage;
    }
    public Beverage getBeverage(UUID id) {
        for (Beverage crime : mBeverage) {
            if (Beverage.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }
}
