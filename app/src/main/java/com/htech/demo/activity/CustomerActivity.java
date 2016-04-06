package com.htech.demo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.htech.demo.R;
import com.htech.demo.adapter.CustomerAdapter;
import com.htech.demo.model.Customer;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CustomerActivity extends AppCompatActivity {

    @InjectView(R.id.ca_rvCustomerList)
    RecyclerView mrvCustomerList;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        ButterKnife.inject(this);
        initView();
        setCustomerList();
    }

    private void initView() {
        mContext = this;
    }

    private void setCustomerList() {

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

        CustomerAdapter productAdapter = new CustomerAdapter(mContext, customers);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mrvCustomerList.setHasFixedSize(true);

        mrvCustomerList.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mrvCustomerList.setAdapter(productAdapter);
    }
}
