package com.example.rahul.officesg.Login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.rahul.officesg.AsyncTaskListener;
import com.example.rahul.officesg.Constants;
import com.example.rahul.officesg.Products.ItemListActivity;

/**
 * Created by Manish on 2/12/2016.
 */
public class SettingUp extends Activity implements AsyncTaskListener {


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //See if the user credentials are already stored in the system
        SharedPreferences settings = getSharedPreferences(Constants.COMMON_PREFS_FILE_NAME,
                Context.MODE_PRIVATE);
        String mUser = settings.getString("username",null);

        if (mUser==null || mUser.trim().equals("")) {
            showLogin();
        } else {


            UserLoginTask task = new UserLoginTask(this);
            task.execute(mUser,settings.getString("password",null));
        }

        finish();
    }

    private void showLogin() {


        //Go to Login screen if the user has not been registered previously
        Intent listIntent = new Intent(this, LoginActivity.class);
        startActivity(listIntent);
    }

    @Override
    public void cancelled() {
        showLogin();
    }

    @Override
    public void onPostExecute(boolean success, boolean error,
                              String exceptionMessage) {
        if (success) {
            showBookList();
        } else {
            showLogin();
        }

    }

    private void showBookList() {
        Intent loginIntent = new Intent(this, ItemListActivity.class);
        startActivity(loginIntent);
    }
}
