# And-Library-Power-HTTP
And Library Power HTTP

### Minimal Usages:
```Minimal Usages
PowerFeedHTTPAsyncTask powerFeedHTTPAsyncTask = new PowerFeedHTTPAsyncTask();
powerFeedHTTPAsyncTask.onExecute(context, "http://jagoron24.com/");
```

### Extended Usages:
```Extended Usages
PowerFeedHTTPAsyncTask powerFeedHTTPAsyncTask = new PowerFeedHTTPAsyncTask(new OnFeedHTTPEventListenerHandler() {
    @Override
    public void onPreExecute() {
    }

    @Override
    public Object doInBackground(Object... argURLParams) {
        return "Hi I am returned";
    }

    @Override
    public void onPostExecute(Object argResult) {
        LogWriter.Log("onPostExecute" + argResult + "");
    }

    @Override
    public void onProgressUpdate(Integer... argProgressValue) {
    }

    @Override
    public void onCancelled() {
    }
});

HashMap<String, String> urlHeaders = new HashMap<String, String>();
        HashMap<String, String> urlRequestParameters = new HashMap<String, String>();
        urlHeaders.put("head1", "headeValue1");
        urlHeaders.put("head2", "headeValue2");
        urlRequestParameters.put("param1", "paramValue1");
        urlRequestParameters.put("param2", "paramValue2");
        powerFeedHTTPAsyncTask
                .setHTTPMethod(HTTPMethod.POST)
                .setUrlHeader(urlHeaders)
                .setURLParameters(urlRequestParameters)
                .onExecute(context, "http://jagoron24.com/");
```