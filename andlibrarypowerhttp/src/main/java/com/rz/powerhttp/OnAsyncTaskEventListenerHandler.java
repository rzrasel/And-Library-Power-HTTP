package com.rz.powerhttp;

/**
 * Created by Rz Rasel on 2017-08-27.
 */

public interface OnAsyncTaskEventListenerHandler<T> {
    public void onPreExecute();
    public T doInBackground(T... argURLParams);
    public void onPostExecute(T argResult);
    public void onProgressUpdate(Integer... argProgressValue);
    public void onCancelled();
}