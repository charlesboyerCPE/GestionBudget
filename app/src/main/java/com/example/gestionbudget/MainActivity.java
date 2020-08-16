package com.example.gestionbudget;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity
{
    private EditText mTotalBudget,
                    mFood,
                    mGoOut,
                    mHouseHold,
                    mClothes,
                    mTransport,
                    mRent,
                    mSalary;

    private Users myUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTotalBudget =  (EditText) findViewById(R.id.editTextNumberDecimalTotalBudget);
        mFood        =  (EditText) findViewById(R.id.editTextNumberDecimalFood);
        mGoOut       =  (EditText) findViewById(R.id.editTextNumberDecimalGoOut);
        mHouseHold   =  (EditText) findViewById(R.id.editTextNumberDecimalHousehold);
        mClothes     =  (EditText) findViewById(R.id.editTextNumberDecimalClothes);
        mTransport   =  (EditText) findViewById(R.id.editTextNumberDecimalTransport);
        mRent        =  (EditText) findViewById(R.id.editTextNumberDecimalRent);
        mSalary      =  (EditText) findViewById(R.id.editTextNumberDecimalSalary);

        myUsers = null;
    }

    public void onClickConfirmed(View view)
    {
        String title = null,
                message = null;

        int[] valueEditText;

        if(isEmpty(mTotalBudget) || isEmpty(mFood) || isEmpty(mGoOut) || isEmpty(mHouseHold) ||
                isEmpty(mClothes) || isEmpty(mTransport) || isEmpty(mRent) || isEmpty(mSalary))
        {
            title = getString(R.string.titleEmptyCase);
            message = getString(R.string.messageEmptyCase);
            generateDialogue(title, message);
        } else
        {
            valueEditText = new int[8];

            valueEditText[0] = Integer.parseInt(mTotalBudget.getText().toString());
            valueEditText[1] = Integer.parseInt(mFood.getText().toString());
            valueEditText[2] = Integer.parseInt(mGoOut.getText().toString());
            valueEditText[3] = Integer.parseInt(mHouseHold.getText().toString());
            valueEditText[4] = Integer.parseInt(mClothes.getText().toString());
            valueEditText[5] = Integer.parseInt(mTransport.getText().toString());
            valueEditText[6] = Integer.parseInt(mRent.getText().toString());
            valueEditText[7] = Integer.parseInt(mSalary.getText().toString());

            myUsers = new Users(valueEditText);

            Intent budgetScreen = new Intent(this, BudgetScreen.class);
            budgetScreen.putExtra("Users", myUsers);
            startActivity(budgetScreen);
        }
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