package com.rz.powerhttp;

/**
 * Created by Rz Rasel on 2017-08-27.
 */

public interface OnFeedHTTPEventListenerHandler {
    public void onPreExecute();
    public Object doInBackground(Object... argURLParams);
    public void onPostExecute(Object argResult);
    public void onProgressUpdate(Integer... argProgressValue);
    public void onCancelled();
}