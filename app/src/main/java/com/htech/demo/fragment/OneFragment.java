package com.htech.demo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.htech.demo.R;
import com.htech.demo.adapter.CustomerAdapter;
import com.htech.demo.model.Customer;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link OneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OneFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    public OneFragment() {
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
    public static OneFragment newInstance(String param1, String param2) {
        OneFragment fragment = new OneFragment();
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
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        setCustomerList(view);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void setCustomerList(View view) {
        RecyclerView rvCustomerList =(RecyclerView) view.findViewById(R.id.ca_rvCustomerList);

        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setCustomerName("Hemant Patel");
        customer.setAccountNumber("ac001e");
        customers.add(customer);

        Customer customer1 = new Customer();
        customer1.setId(2);
        customer1.setCustomerName("Ishan Gandhi");
        customer1.setAccountNumber("ac002c");
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setCustomerName("Vivek Kakad");
        customer2.setAccountNumber("ac003d");
        customers.add(customer2);

        Customer customer3 = new Customer();
        customer3.setId(4);
        customer3.setCustomerName("Ketan Patel");
        customer3.setAccountNumber("ac004k");
        customers.add(customer3);

        Customer customer4 = new Customer();
        customer4.setId(4);
        customer4.setCustomerName("Nikunj Patel");
        customer4.setAccountNumber("ac005nc");
        customers.add(customer4);

        Customer customer5 = new Customer();
        customer5.setId(5);
        customer5.setCustomerName("Shivam");
        customer5.setAccountNumber("ac805nc");
        customers.add(customer5);

        Customer customer6 = new Customer();
        customer6.setId(4);
        customer6.setCustomerName("Krisna");
        customer6.setAccountNumber("ac025nc");
        customers.add(customer6);

        Customer customer7 = new Customer();
        customer7.setId(4);
        customer7.setCustomerName("Vk Patel");
        customer7.setAccountNumber("ac055nc");
        customers.add(customer7);


        CustomerAdapter productAdapter = new CustomerAdapter(getActivity(), customers);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        rvCustomerList.setHasFixedSize(true);

        rvCustomerList.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        rvCustomerList.setAdapter(productAdapter);
    }
}
