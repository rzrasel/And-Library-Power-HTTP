package com.rz.powerhttp;

import com.rz.logger.LogWriter;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Rz Rasel on 2017-08-27.
 */

class PowerURLParameters {
    protected static String getFormatedURLParameters(Map<String, String> argUrlParameters) {
        //byte[] retVal;
        String retVal = null;
        StringBuilder stringBuilderUrlParams = new StringBuilder();
        Iterator<Map.Entry<String, String>> iterator = argUrlParameters.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> urlParameters = iterator.next();
            stringBuilderUrlParams.append(urlParameters.getKey()).append('=').append(urlParameters.getValue());
            if (iterator.hasNext()) {
                stringBuilderUrlParams.append('&');
            }
        }
        //String strUrlParams = stringBuilderUrlParams.toString();
        //retVal = strUrlParams.getBytes();
        retVal = stringBuilderUrlParams.toString();
        LogWriter.Log("HTTP_REQUESTED_PARAMETERS: " + retVal);
        return retVal;
    }
}