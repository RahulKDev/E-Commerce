package com.example.rahul.officesg;

public interface AsyncTaskListener {
    void cancelled();
    void onPostExecute(boolean success, boolean error,String exceptionMessage);
}
