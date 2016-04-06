package com.htech.demo.activity;

//  https://github.com/Er-Kalpesh/bloodbank/blob/master/india-state-city-database-list.php

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.htech.demo.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 *
 * Design https://play.google.com/store/apps/details?id=com.cellcore.app.payconnect
 *
 */

public class HomeActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    @InjectView(R.id.email)
    AutoCompleteTextView email;
    @InjectView(R.id.address)
    EditText address;
    @InjectView(R.id.ah_etMobileNumber)
    EditText ahEtMobileNumber;
    @InjectView(R.id.ah_etEmail)
    EditText ahEtEmail;
    @InjectView(R.id.ah_rgGender)
    RadioGroup ahRgGender;
    @InjectView(R.id.ah_tvBirthdayLabel)
    TextView mtvBirthdayLabel;
    @InjectView(R.id.email_sign_in_button)
    Button emailSignInButton;
    @InjectView(R.id.email_login_form)
    LinearLayout emailLoginForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);

    }

    @OnClick(R.id.ah_tvBirthdayLabel) void getBirthday() {
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                HomeActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = "You picked the following date: "+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;

    }
}
