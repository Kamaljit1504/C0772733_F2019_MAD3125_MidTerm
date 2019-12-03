package com.example.c0772733_f2019_mad3125_midterm;

import android.os.Parcel;
import android.os.Parcelable;

public class CRACustomer implements Parcelable {

    String SinNumber;
    String FirstName;
    String LastName;
    String FullName;
    String DateOfBirth;
    String Gender;
    String Age;
    String TaxDate;
    double GrossIncome;
    double FedralTax;
    double ProvincialTax;
    double Cpp;
    double  EI;
    double Rrsp;
    double CarryForwardRrsp;
    double TotalTaxedIncome;



    double TotalTaxPaid;
    double MaxRrsp;

    protected CRACustomer(Parcel in) {
        SinNumber = in.readString();
        FirstName = in.readString();
        LastName = in.readString();
        FullName = in.readString();
        DateOfBirth = in.readString();
        Gender = in.readString();
        Age = in.readString();
        TaxDate = in.readString();
        GrossIncome = in.readDouble();
        FedralTax = in.readDouble();
        ProvincialTax = in.readDouble();
        Cpp = in.readDouble();
        EI = in.readDouble();
        Rrsp = in.readDouble();
        CarryForwardRrsp = in.readDouble();
        TotalTaxedIncome = in.readDouble();
        TotalTaxPaid = in.readDouble();
        MaxRrsp=in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(SinNumber);
        dest.writeString(FirstName);
        dest.writeString(LastName);
        dest.writeString(FullName);
        dest.writeString(DateOfBirth);
        dest.writeString(Gender);
        dest.writeString(Age);
        dest.writeString(TaxDate);
        dest.writeDouble(GrossIncome);
        dest.writeDouble(FedralTax);
        dest.writeDouble(ProvincialTax);
        dest.writeDouble(Cpp);
        dest.writeDouble(EI);
        dest.writeDouble(Rrsp);
        dest.writeDouble(CarryForwardRrsp);
        dest.writeDouble(TotalTaxedIncome);
        dest.writeDouble(TotalTaxPaid);
        dest.writeDouble(MaxRrsp);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CRACustomer> CREATOR = new Creator<CRACustomer>() {
        @Override
        public CRACustomer createFromParcel(Parcel in) {
            return new CRACustomer(in);
        }

        @Override
        public CRACustomer[] newArray(int size) {
            return new CRACustomer[size];
        }
    };

    public void setSinNumber(String sinNumber) {
        SinNumber = sinNumber;
    }

    public void setFirstName(String firstName) {
        if(firstName.length()!=0) {
            char[] fn = firstName.toCharArray();
            fn[0] = Character.toUpperCase(fn[0]);
            for (int i = 1; i < fn.length; i++) {
                fn[i] = Character.toLowerCase(fn[i]);
            }
            firstName = String.valueOf(fn);
        }
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setAge(String age) {
        Age = age;
    }

    public void setGrossIncome(double grossIncome) {
        GrossIncome = grossIncome;
    }

    public void setRrsp(double rrsp) {
        Rrsp = rrsp;
    }

    public String getSinNumber() {
        return SinNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFullName() {
        FullName=LastName.toUpperCase()+","+FirstName;
        return FullName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public String getAge() {
        return Age;
    }

    public String getTaxDate() {
        return TaxDate;
    }

    public double getGrossIncome() {
        return GrossIncome;
    }

    public double getFedralTax() {
        FedralTax= CalFedralTax();
        return FedralTax;
    }

    public double getProvincialTax() {
        ProvincialTax=CalProvincialTax();
        return ProvincialTax;
    }
    public double getMaxRrsp() {
        MaxRrsp=CalRrsp();
        return MaxRrsp;
    }

    public double getCpp() {
        CalCpp();
        return Cpp;
    }

    public double getEI() {
        CalEi();
        return EI;
    }

    public double getRrsp() {
        return Rrsp;
    }

    public double getCarryForwardRrsp() {

        CarryForwardRrsp=MaxRrsp-Rrsp;
        return CarryForwardRrsp;
    }

    public double  getTotalTaxedIncome() {
        CalTotalTaxableIncome();
        return TotalTaxedIncome;
    }

    public double getTotalTaxPaid() {
        TotalTaxPaid=CalFedralTax()+CalProvincialTax();
        return TotalTaxPaid;
    }


    public double CalTotalTaxableIncome(){
        TotalTaxedIncome=GrossIncome-(CalEi()+CalCpp()+CalRrsp());
        return TotalTaxedIncome;

    }

    public double CalCpp(){

        if(GrossIncome>=57400){
            Cpp=  57400*0.051;
        }
        else{
            Cpp=GrossIncome*0.051;
        }
        return Cpp;

    }

    public double CalRrsp(){
        MaxRrsp=GrossIncome*0.18;

        return MaxRrsp;
    }

    public double CalEi(){

        if(GrossIncome>=53100){
            EI=  53100*0.0162;
        }
        else{
            EI=GrossIncome*0.0162;
        }
        return EI;

    }



    public double CalFedralTax()
    {


        double tax=0;
        double calculatedFtax=0;
        double tti=CalTotalTaxableIncome();
        if (tti>12069)
        {

            tti=tti-12069;
            if(tti>35561) {
                tax=35561;

            }
            else{

                tax=tti;
            }

            tax=tax*0.15;
            calculatedFtax=calculatedFtax+tax;
//            System.out.println("TAX 1:"+calculatedFtax);
//            System.out.println("FTax range 1 : "+tti);
            if(tti>35561)
            {
                tti=tti-35561;
                if(tti>47628.99)
                {
                    tax=47628.99;

                }
                else {
                    tax=tti;
                }
                tax=tax*0.205;
                // System.out.println("TAX 2:"+tax);
                calculatedFtax=calculatedFtax+tax;
                // System.out.println("FTax range 2 : "+tti );
                if(tti>47628.99)
                {
                    tti = tti-47628.99;
                    if(tti>52407.99){
                        tax=52407.99;
                    }
                    else{
                        tax=tti;
                    }
                    tax=tax*0.26;
                    calculatedFtax=calculatedFtax+tax;
//                    System.out.println("Tax 3 : "+tax);
//                    System.out.println("FTax range 3 : "+tti);
                    if (tti > 52407.99)
                    {
                        tti = tti-52407.99;
                        if(tti>62703.99){
                            tax=62703.99;
                        }
                        else{
                            tax=tti;
                        }
                        tax=tax*0.29;
                        calculatedFtax=+calculatedFtax+tax;

                        // System.out.println("FTax range 4 : "+tti);
                        if (tti > 62703.99)
                        {
                            tti = tti-62703.99;

                            tax=tti;
                            tax=tax*0.33;
                            calculatedFtax=+calculatedFtax+tax;

                            // System.out.println("FTax range 5 : "+tti);


                        }

                    }

                }
            }
        }

        else
        {
            System.out.println("TotalTaxableIncome Less Than 12069");
        }







        return calculatedFtax;
    }



    public double CalProvincialTax()
    {


        double tax=0;
        double calculatedPtax=0;
        double tti=CalTotalTaxableIncome();
        if (tti>10582)
        {

            tti=tti-10582;
            if(tti>33323.99) {
                tax=33323.99;

            }
            else{

                tax=tti;
            }

            tax=tax*0.0505;
            calculatedPtax=calculatedPtax+tax;
//            System.out.println("TAX 1:"+calculatedPtax);
//            System.out.println("FTax range 1 : "+tti);
            if(tti>33323.99)
            {
                tti=tti-33323.99;
                if(tti>43906.99)
                {
                    tax=43906.99;

                }
                else {
                    tax=tti;
                }
                tax=tax*0.0915;
                //   System.out.println("TAX 2:"+tax);
                calculatedPtax=calculatedPtax+tax;
                //  System.out.println("FTax range 2 : "+tti );
                if(tti>43906.99)
                {
                    tti = tti-43906.99;
                    if(tti>62186.99){
                        tax=62186.99;
                    }
                    else{
                        tax=tti;
                    }
                    tax=tax*0.1116;
                    calculatedPtax=calculatedPtax+tax;
//                    System.out.println("Tax 3 : "+tax);
//                    System.out.println("FTax range 3 : "+tti);
                    if (tti > 62186.99)
                    {
                        tti = tti-62186.99;
                        if(tti>69999.99){
                            tax=69999.99;
                        }
                        else{
                            tax=tti;
                        }
                        tax=tax*0.1216;
                        calculatedPtax=+calculatedPtax+tax;
//                        System.out.println(tax);
//                        System.out.println("FTax range 4 : "+tti);
                        if (tti > 69999.99)
                        {
                            tti = tti-69999.99;

                            tax=tti;
                            tax=tax*0.1316;
                            calculatedPtax=+calculatedPtax+tax;

                            //   System.out.println("FTax range 5 : "+tti);


                        }

                    }

                }
            }
        }

        else
        {
            System.out.println("TotalTaxableIncome Less Than 10582");
        }







        return calculatedPtax;
    }


    private static final CRACustomer ourInstance = new CRACustomer();





    public static CRACustomer getInstance() {
        return ourInstance;
    }

    public CRACustomer() {
    }



}
