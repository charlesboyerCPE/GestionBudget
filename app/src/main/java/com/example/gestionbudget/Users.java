package com.example.gestionbudget;

import android.os.Parcel;
import android.os.Parcelable;

public class Users implements Parcelable
{
    private int totalBudget,
                food,
                goOut,
                houseHold,
                clothes,
                transport,
                rent,
                salary;

    public Users(int[] valueEditText)
    {
        totalBudget = valueEditText[0];
        food = valueEditText[1];
        goOut = valueEditText[2];
        houseHold = valueEditText[3];
        clothes = valueEditText[4];
        transport = valueEditText[5];
        rent = valueEditText[6];
        salary = valueEditText[7];
    }


    protected Users(Parcel in) {
        totalBudget = in.readInt();
        food = in.readInt();
        goOut = in.readInt();
        houseHold = in.readInt();
        clothes = in.readInt();
        transport = in.readInt();
        rent = in.readInt();
        salary = in.readInt();
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(totalBudget);
        parcel.writeInt(food);
        parcel.writeInt(goOut);
        parcel.writeInt(houseHold);
        parcel.writeInt(clothes);
        parcel.writeInt(transport);
        parcel.writeInt(rent);
        parcel.writeInt(salary);
    }
}
