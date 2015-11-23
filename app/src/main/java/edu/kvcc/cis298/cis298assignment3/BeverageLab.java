package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 * Created by aaernie7528 on 11/21/2015.
 */
//singleton that creates and holds the beverage list
public class BeverageLab {
    private static BeverageLab sBeverageLab;
    private Context mContext;

    private List<Beverage> mBeverage;

    //creates singleton if there is not one
    public static BeverageLab get(Context context){
        if (sBeverageLab == null){
            sBeverageLab = new BeverageLab(context);
        }
        return sBeverageLab;
    }

    private BeverageLab(Context context){
        mBeverage = new ArrayList<>();

        mContext = context;
        //populate list
        this.loadBeverageList();
    }

    public List<Beverage> getBeverages(){
        return mBeverage;
    }

    public Beverage getBeverage(UUID id) {
        for (Beverage beverage : mBeverage) {
            if (Beverage.getId().equals(id)){
                return beverage;
            }
        }
        return null;
    }

    //load the csv file
    private void loadBeverageList() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(mContext.getResources().openRawResource(R.raw.beverage_list));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String parts[] = line.split(",");
                String number = parts[0];
                String description = parts[1];
                String packsize = parts[2];
                String price = parts[3];
                String active = parts[4];
                double caseprice = Double.parseDouble(price);
                boolean isActive;
                if (active.equalsIgnoreCase("true")){
                    isActive = true;
                } else {
                    isActive = false;
                }
                mBeverage.add(new Beverage(number, description, packsize, caseprice, isActive));
            }
        } catch (Exception e) {
            //there could be a log here
        } finally {
            scanner.close();
        }
    }
}
