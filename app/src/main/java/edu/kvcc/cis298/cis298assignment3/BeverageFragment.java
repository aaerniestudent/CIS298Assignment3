package edu.kvcc.cis298.cis298assignment3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by Anthony on 11/23/2015.
 */
//single item fragment for pager view
public class BeverageFragment extends Fragment {

    private static final String ARG_BEVERAGE_ID = "beverage_id";

    private Beverage mBeverage;
    private TextView mDescription;
    private EditText mId;
    private EditText mPackSize;
    private EditText mPrice;
    private CheckBox mActiveCheckBox;

    public static BeverageFragment newInstance(UUID beverageId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_BEVERAGE_ID, beverageId);

        BeverageFragment fragment = new BeverageFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID beverageId = (UUID) getArguments().getSerializable(ARG_BEVERAGE_ID);
        mBeverage = BeverageLab.get(getActivity()).getBeverage(beverageId);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_beverage, container, false);
        //description edit text
        mDescription = (EditText) v.findViewById(R.id.beverage_title);
        mDescription.setText(mBeverage.getDescription());
        mDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBeverage.setDescription(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //blank
            }
        });
        //Id/Number edittext, not actually the id, as I have it set up
        mId = (EditText) v.findViewById(R.id.beverage_title);
        mId.setText(mBeverage.getNumber());
        mId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBeverage.setNumber(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //blank
            }
        });
        //pack size edittext
        mPackSize = (EditText) v.findViewById(R.id.beverage_pack);
        mPackSize.setText(mBeverage.getPackSize());
        mPackSize.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBeverage.setPackSize(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //blank
            }
        });
        //price edittext
        mPrice = (EditText) v.findViewById(R.id.beverage_price);
        mPrice.setText(Double.toString(mBeverage.getCasePrice()));
        mPackSize.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBeverage.setCasePrice(Double.parseDouble(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //blank
            }
        });
        //active checkbox
        mActiveCheckBox = (CheckBox)v.findViewById(R.id.beverage_active);
        mActiveCheckBox.setChecked(mBeverage.isActive());
        mActiveCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //set the crime's solved property
                mBeverage.setActive(isChecked);
            }
        });
        return v;
    }
}
