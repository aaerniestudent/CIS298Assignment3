package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.UUID;

/**
 * Created by Anthony on 11/23/2015.
 */
public class BeveragePagerActivity extends FragmentActivity {

    private static final String EXTRA_BEVERAGE_ID = "edu.kvcc.cis298.assignment3.assignment3.beverage_id";


    private ViewPager mViewPager;
    private List<Beverage> mBeverages;


    public static Intent newIntent(Context packageContext, UUID beverageId) {
        Intent intent = new Intent(packageContext, BeveragePagerActivity.class);
        intent.putExtra(EXTRA_BEVERAGE_ID, beverageId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage_pager);

        UUID beverageId = (UUID) getIntent().getSerializableExtra(EXTRA_BEVERAGE_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_beverage_pager_view_pager);

        mBeverages = BeverageLab.get(this).getBeverages();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Beverage beverage = mBeverages.get(position);
                return BeverageFragment.newInstance(beverage.getId());
            }

            @Override
            public int getCount() {
                return mBeverages.size();
            }
        });

        for (int i = 0; i < mBeverages.size(); i++) {
            if (mBeverages.get(i).getId().equals(beverageId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }
}
