package com.example.gestionbudget;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    EditText mTotalBudget,
        mFood,
        mGoOut,
        mHouseHold,
        mClothes,
        mTransport,
        mRent,
        mSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTotalBudget =  findViewById(R.id.editTextNumberDecimalTotalBudget);
        mFood        =  findViewById(R.id.editTextNumberDecimalFood);
        mGoOut       =  findViewById(R.id.editTextNumberDecimalGoOut);
        mHouseHold   =  findViewById(R.id.editTextNumberDecimalHousehold);
        mClothes     =  findViewById(R.id.editTextNumberDecimalClothes);
        mTransport   =  findViewById(R.id.editTextNumberDecimalTransport);
        mRent        =  findViewById(R.id.editTextNumberDecimalRent);
        mSalary      =  findViewById(R.id.editTextNumberDecimalSalary);
    }

    public void onClickConfirmed(View view)
    {
        if(isEmpty(mTotalBudget) || isEmpty(mFood) || isEmpty(mGoOut) || isEmpty())
    }

    public void generateDialogue(String title, String message)
    {
        AlertDialog.Builder messageAlerte;

        messageAlerte = new AlertDialog.Builder(this);
        messageAlerte.setTitle(title);
        messageAlerte.setMessage(message);
        messageAlerte.setPositiveButton(R.string.buttonDialogue, null);
        messageAlerte.create().show();
    }

    public boolean isEmpty (EditText editText)
    {
        return TextUtils.isEmpty(editText.getText().toString());
    }
}