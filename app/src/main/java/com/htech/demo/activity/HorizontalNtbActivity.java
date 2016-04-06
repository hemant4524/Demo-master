package com.htech.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gigamole.library.NavigationTabBar;
import com.htech.demo.R;
import com.htech.demo.adapter.CustomerAdapter;
import com.htech.demo.model.Customer;

import java.util.ArrayList;

/**
 * Created by GIGAMOLE on 28.03.2016.
 */
public class HorizontalNtbActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_ntb);
        initUI();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.runFinalization();
        Runtime.getRuntime().gc();
        System.gc();
    }

    private void initUI() {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.vp_horizontal_ntb);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public boolean isViewFromObject(final View view, final Object object) {
                return view.equals(object);
            }

            @Override
            public void destroyItem(final View container, final int position, final Object object) {
                ((ViewPager) container).removeView((View) object);
            }

            @Override
            public Object instantiateItem(final ViewGroup container, final int position) {
                if(position == 0){
                    final View view = LayoutInflater.from(
                            getBaseContext()).inflate(R.layout.activity_customer, null, false);
                    setCustomerList(view);
                    container.addView(view);
                    return view;
                }else  if(position == 1){
                    final View view = LayoutInflater.from(
                            getBaseContext()).inflate(R.layout.activity_home, null, false);

                    container.addView(view);
                    return view;
                }else  if(position == 2){
                    final View view = LayoutInflater.from(
                            getBaseContext()).inflate(R.layout.history_item, null, false);

                    container.addView(view);
                    return view;
                }else  if(position == 3){
                    final View view = LayoutInflater.from(
                            getBaseContext()).inflate(R.layout.sync_data_item, null, false);

                    container.addView(view);
                    return view;
                } else{
                    final View view = LayoutInflater.from(
                            getBaseContext()).inflate(R.layout.vp_item, null, false);

                    final TextView txtPage = (TextView) view.findViewById(R.id.txt_vp_item_page);
                    txtPage.setText(String.format("Page #%d", position));

                    container.addView(view);
                    return view;
                }

            }
        });

        final String[] colors = getResources().getStringArray(R.array.default_preview);

        final NavigationTabBar navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb_horizontal);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(new NavigationTabBar.Model(
                getResources().getDrawable(R.drawable.ic_first), Color.parseColor(colors[0]), "Customer"));
        models.add(new NavigationTabBar.Model(
                getResources().getDrawable(R.drawable.ic_second), Color.parseColor(colors[1]), "Register"));
        models.add(new NavigationTabBar.Model(
                getResources().getDrawable(R.drawable.ic_third), Color.parseColor(colors[2]), "History"));
        models.add(new NavigationTabBar.Model(
                getResources().getDrawable(R.drawable.ic_fourth), Color.parseColor(colors[3]), "SyncData"));
        models.add(new NavigationTabBar.Model(
                getResources().getDrawable(R.drawable.ic_fifth), Color.parseColor(colors[4]), "Reports"));
        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(viewPager, 0);

        navigationTabBar.setOnTabBarSelectedIndexListener(new NavigationTabBar.OnTabBarSelectedIndexListener() {
            @Override
            public void onStartTabSelected(final NavigationTabBar.Model model, final int index) {

            }

            @Override
            public void onEndTabSelected(final NavigationTabBar.Model model, final int index) {
                model.hideBadge();
            }
        });

        navigationTabBar.post(new Runnable() {
            @Override
            public void run() {
                final View bgNavigationTabBar = findViewById(R.id.bg_ntb_horizontal);
                bgNavigationTabBar.getLayoutParams().height = (int) navigationTabBar.getBarHeight();
                bgNavigationTabBar.requestLayout();
            }
        });

        navigationTabBar.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < navigationTabBar.getModels().size(); i++) {
                    final NavigationTabBar.Model model = navigationTabBar.getModels().get(i);
                    switch (i) {
                        case 0:
                            model.setBadgeTitle("NTB");
                            break;
                        case 1:
                            model.setBadgeTitle("with");
                            break;
                        case 2:
                            model.setBadgeTitle("title");
                            break;
                        case 3:
                            model.setBadgeTitle("badge");
                            break;
                        case 4:
                            model.setBadgeTitle("777");
                            break;
                    }
                    navigationTabBar.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            model.showBadge();
                        }
                    }, i * 100);
                }
            }
        }, 500);
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


        CustomerAdapter productAdapter = new CustomerAdapter(HorizontalNtbActivity.this, customers);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        rvCustomerList.setHasFixedSize(true);

        rvCustomerList.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        rvCustomerList.setAdapter(productAdapter);
    }
}
