package com.example.c0772733_f2019_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static com.example.c0772733_f2019_mad3125_midterm.R.color.colorAccent;

public class DisplayDataActivity extends AppCompatActivity {


    CRACustomer c;
    TextView sin,fullname,gender,age,taxdate,grossIncome,federalTax,provincialTax,cpp,ei,carry,totalTaxableIncome,Totaltax;

    // m = (Marks) getIntent().getSerializableExtra("marks");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_data);

        c = (CRACustomer) getIntent().getParcelableExtra("data");

        sin=findViewById(R.id.txtSin);
        fullname=findViewById(R.id.txtFullName);
        gender=findViewById(R.id.txtGender);
        age=findViewById(R.id.txtAge);
        taxdate=findViewById(R.id.txtTaxDate);
        grossIncome=findViewById(R.id.txtGrossIncome);
        federalTax=findViewById(R.id.txtFederalTax);
        provincialTax=findViewById(R.id.txtProvincialTax);
        cpp=findViewById(R.id.txtcpp);
        ei=findViewById(R.id.txtEi);
        carry=findViewById(R.id.txtCarryFrwd);
        totalTaxableIncome=findViewById(R.id.txtTaxableIncome);
        Totaltax=findViewById(R.id.txtTotalTax);


        SimpleDateFormat sm=new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
        Calendar myCalendar = Calendar.getInstance();
        String currdate=sm.format(myCalendar.getTime());
        if(c.getCarryForwardRrsp()<0){
            carry.setTextColor(this.getResources().getColor(colorAccent));
            carry.setTypeface(null, Typeface.BOLD_ITALIC);
        }



        sin.setText(c.getSinNumber());
        fullname.setText(c.getFullName());
        gender.setText(c.getGender());
        age.setText(c.getAge());
        taxdate.setText(currdate);
        grossIncome.setText(String.valueOf(c.getGrossIncome()));
        federalTax.setText(String.valueOf(c.getFedralTax()));
        provincialTax.setText(String.valueOf(c.getProvincialTax()));
        cpp.setText(String.valueOf(c.getCpp()));
        ei.setText(String.valueOf(c.getEI()));
        carry.setText(String.valueOf(c.getCarryForwardRrsp()));
        totalTaxableIncome.setText(String.valueOf(c.getTotalTaxedIncome()));
        Totaltax.setText(String.valueOf(c.getTotalTaxPaid()));



//        System.out.println("Sin Number : "+c.getSinNumber());
//
//        System.out.println("Full Name : "+c.getFullName());
//        System.out.println("DOB : "+c.getDateOfBirth());
//        System.out.println("Age : "+c.getAge());
//        System.out.println("Gender : "+c.getGender());
//        System.out.println("Cpp : "+c.getCpp());
//        System.out.println("Rrsp : "+c.getRrsp());
//        System.out.println("Max Rrsp : "+c.getMaxRrsp());
//        System.out.println("Carry : "+c.getCarryForwardRrsp());
//        System.out.println("Ei : " + c.getEI());
//        System.out.println("Total Taxable Income : "+c.getTotalTaxedIncome());
//        System.out.println("Federal Tax : "+c.getFedralTax());
//        System.out.println("Provincial Tax : "+c.getProvincialTax());
//        System.out.println("Total Tax Paid : "+c.getTotalTaxPaid());







    }

}

