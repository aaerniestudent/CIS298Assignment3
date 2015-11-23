package edu.kvcc.cis298.cis298assignment3;

import android.support.v4.app.Fragment;

/**
 * Created by Anthony on 11/23/2015.
 */
//creates the fragment when the app starts up
public class BeverageListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new BeverageListFragment();
    }
}
