package edu.kvcc.cis298.cis298assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Anthony on 11/23/2015.
 */
//RecyclerView Fragment.
public class BeverageListFragment extends Fragment {

    private RecyclerView mBeverageRecyclerView;
    private BeverageAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beverage_list, container, false);
        mBeverageRecyclerView = (RecyclerView) view.findViewById(R.id.beverage_recycler_view);
        mBeverageRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
    //updates the UI when it changes
    private void updateUI() {
        BeverageLab beverageLab = BeverageLab.get(getActivity());
        List<Beverage> beverages = beverageLab.getBeverages();
        if (mAdapter == null) {
            mAdapter = new BeverageAdapter(beverages);
            mBeverageRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }
    //where the fragment is wired up to the recyclerview
    private class BeverageHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Beverage mBeverage;
        private TextView mDescription;
        private TextView mNumber;
        private TextView mPrice;
        public BeverageHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mDescription = (TextView) itemView.findViewById(R.id.list_item_beverage_name_text_view);
            mNumber = (TextView)
                    itemView.findViewById(R.id.list_item_beverage_number_text_view);
            mPrice = (TextView)
                    itemView.findViewById(R.id.list_item_beverage_price_text_view);
        }
        //sets the information in the fragment
        public void bindBeverage(Beverage beverage) {
            mDescription.setText(mBeverage.getDescription());
            mNumber.setText(mBeverage.getNumber());
            mPrice.setText("$" + Double.toString(mBeverage.getCasePrice()));
        }

        @Override
        public void onClick(View view) {
            Intent intent = BeveragePagerActivity.newIntent(getActivity(), mBeverage.getId());
            startActivity(intent);
        }
    }
    //Creates the RecyclerView from the beverages list
    private class BeverageAdapter extends RecyclerView.Adapter<BeverageHolder> {
        private List<Beverage> mBeverages;

        public BeverageAdapter(List<Beverage> beverages) {
            mBeverages = beverages;

        }

        @Override
        public BeverageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_beverage, parent, false);
            return new BeverageHolder(view);
        }

        @Override
        public void onBindViewHolder(BeverageHolder holder, int position) {
            Beverage beverage = mBeverages.get(position);
            holder.bindBeverage(beverage);
        }

        @Override
        public int getItemCount() {
            return mBeverages.size();
        }

    }
}
