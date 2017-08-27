package com.rz.powerhttp;

import com.rz.logger.LogWriter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rz Rasel on 2017-08-27.
 */

public class PowerHTTPConnection {
    private String strDomainURL;
    private final String userAgent = "Mozilla/5.0";
    private HTTPMethod httpMethod;
    private boolean isAllowRedirects;
    private int readTimeout = 0;
    private int connectTimeout = 0;
    private boolean isUseCaches = false;
    private HashMap<String, String> urlHeaders = new HashMap<String, String>();
    private HashMap<String, String> urlRequestParameters = new HashMap<String, String>();

    public PowerHTTPConnection() {
    }

    public PowerHTTPConnection onPrepareConnection(String argStrDomainURL, HTTPMethod argHTTPMethod, boolean argIsAllowRedirects) {
        this.strDomainURL = argStrDomainURL;
        this.httpMethod = argHTTPMethod;
        this.isAllowRedirects = argIsAllowRedirects;
        return this;
    }

    public PowerHTTPConnection setUrlHeader(HashMap<String, String> argUrlHeaderList) {
        this.urlHeaders = argUrlHeaderList;
        return this;
    }

    public PowerHTTPConnection setURLParameters(HashMap<String, String> argRequestParameterList) {
        this.urlRequestParameters = argRequestParameterList;
        return this;
    }

    public PowerHTTPConnection setReadTimeout(int argReadTimeout) {
        this.readTimeout = argReadTimeout;
        return this;
    }

    public PowerHTTPConnection setConnectTimeout(int argConnectTimeout) {
        this.readTimeout = argConnectTimeout;
        return this;
    }

    public PowerHTTPConnection setUseCaches(boolean argIsUseCaches) {
        this.isUseCaches = argIsUseCaches;
        return this;
    }

    public void onOpenConnection() {
        try {
            URL domainURL = new URL(strDomainURL);
            //Get url protocol: domainURL.getProtocol()
            LogWriter.Log("HTTP_REQUESTED_URL: " + strDomainURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) domainURL.openConnection();
            httpURLConnection.setRequestMethod(httpMethod.getMethodName());
            LogWriter.Log("HTTP_REQUESTED_METHODS: " + httpMethod.getMethodName());
            if (connectTimeout > 0) //15000
                httpURLConnection.setConnectTimeout(connectTimeout);
            if (readTimeout > 0) //15000
                httpURLConnection.setReadTimeout(readTimeout);
            httpURLConnection.setUseCaches(isUseCaches);
            //httpURLConnection.setRequestProperty("User-Agent", userAgent);
            httpURLConnection.setInstanceFollowRedirects(isAllowRedirects);
            httpURLConnection.setRequestProperty("charset", "utf-8");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            if (urlHeaders.size() > 0) {
                //JSONObject jsonObject = new JSONObject(urlHeaderList);
                //LogWriter.Log("PRINT_HEADER_LIST:- " + jsonObject.toString());
                for (Map.Entry<String, String> entry : urlHeaders.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    httpURLConnection.setRequestProperty(key, value);
                }
            }
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            if (httpMethod.POST == httpMethod && urlRequestParameters.size() > 0) {
                //onWriteHttpUrlData(httpURLConnection);
                PowerURLReadWrite.onURLWriter(httpURLConnection, PowerURLParameters.getFormatedURLParameters(urlRequestParameters));
            }
            int responseCode = httpURLConnection.getResponseCode();
            LogWriter.Log("HTTP_RESPONSE_CODE: " + responseCode);
            String httpURLData = PowerURLReadWrite.onURLReader(httpURLConnection);
            httpURLConnection.disconnect();
            if (httpURLData != null) {
                LogWriter.Log("URL_DATA: " + httpURLData);
            }
        } catch (MalformedURLException e) {
            LogWriter.Log("PRINT_ERROR_MalformedURLException: " + e.toString());
        } catch (IOException e) {
            LogWriter.Log("PRINT_ERROR_IOException: " + e.toString());
        }
    }
}