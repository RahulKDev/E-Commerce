package com.example.rahul.officesg.Login;

import android.os.AsyncTask;

import com.example.rahul.officesg.AsyncTaskListener;

/**
 * Represents an asynchronous login/registration task used to authenticate
 * the user.
 */
public class UserLoginTask extends AsyncTask<String, Void, Boolean> {


    public UserLoginTask(AsyncTaskListener listener) {
        this.listener = listener;
    }

    private AsyncTaskListener listener;

    private boolean error = false;
    boolean exceptionOccured = false;
    String exceptionMessage = null;

    @Override
    protected void onCancelled() {
        // TODO Auto-generated method stub
        listener.cancelled();
    }

    @Override
    protected void onPostExecute(Boolean result) {
        listener.onPostExecute(result, error, exceptionMessage);
    }

    @Override
    protected Boolean doInBackground(String... params) {

        //(This will be done server side getting credentials using api call - json data)
        //-presently sending true for all values
        return true;
    }
}
