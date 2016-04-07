package com.htech.demo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.htech.demo.R;
import com.htech.demo.model.Customer;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link TwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TwoFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @InjectView(R.id.cvSaveInfo)
    CardView mcvSaveInfo;
    @InjectView(R.id.ft_etSearch)
    EditText metSearch;
    @InjectView(R.id.tvName)
    TextView mtvName;
    @InjectView(R.id.tvAcNumber)
    TextView mtvAcNumber;
    @InjectView(R.id.etAmount)
    EditText metAmount;
    @InjectView(R.id.tvSave)
    TextView mtvSave;

    private String mParam1;
    private String mParam2;
    private ArrayList<Customer> mCustomers;


    public TwoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OneFragment.
     */
    public static TwoFragment newInstance(String param1, String param2) {
        TwoFragment fragment = new TwoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        ButterKnife.inject(this, view);
        setCustomerList();
        metAmount.setVisibility(View.GONE);
        mtvSave.setVisibility(View.GONE);
        mcvSaveInfo.setVisibility(View.GONE);

        metSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable input) {

                if (input != null) {

                    for (Customer customer : mCustomers) {

                        if (customer.getAccountNumber().equalsIgnoreCase(input.toString())) {

                            mtvAcNumber.setText(customer.getAccountNumber());
                            mtvName.setText(customer.getCustomerName());
                            metAmount.setVisibility(View.VISIBLE);
                            mtvSave.setVisibility(View.VISIBLE);
                            mcvSaveInfo.setVisibility(View.VISIBLE);
                        }


                    }
                } else {
                    mtvAcNumber.setText("");
                    mtvName.setText("");
                    mtvName.setVisibility(View.GONE);
                    metAmount.setVisibility(View.GONE);
                    mcvSaveInfo.setVisibility(View.GONE);
                }

            }
        });
        return view;
    }

    @OnClick(R.id.tvSave)
    public void onSave(){
        clearData();
        mcvSaveInfo.setVisibility(View.GONE);
        Toast.makeText(getActivity(),"Save Successfully.",Toast.LENGTH_LONG).show();
    }

    public void clearData(){
        metSearch.setText("");
        metAmount.setText("");
        mtvName.setText("");
        mtvAcNumber.setText("");
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    private void setCustomerList() {

        mCustomers = new ArrayList<Customer>();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setCustomerName("Hemant Patel");
        customer.setAccountNumber("001");
        mCustomers.add(customer);

        Customer customer1 = new Customer();
        customer1.setId(2);
        customer1.setCustomerName("Ishan Gandhi");
        customer1.setAccountNumber("002");
        mCustomers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setCustomerName("Vivek Kakad");
        customer2.setAccountNumber("003");
        mCustomers.add(customer2);

        Customer customer3 = new Customer();
        customer3.setId(4);
        customer3.setCustomerName("Ketan Patel");
        customer3.setAccountNumber("004");
        mCustomers.add(customer3);

        Customer customer4 = new Customer();
        customer4.setId(4);
        customer4.setCustomerName("Nikunj Patel");
        customer4.setAccountNumber("005");
        mCustomers.add(customer4);

    }
}
