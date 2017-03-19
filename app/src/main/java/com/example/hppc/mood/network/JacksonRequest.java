package com.example.hppc.mood.network;

import android.text.TextUtils;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by madscientist on 19/3/17.
 */

public class JacksonRequest<T> extends JsonRequest<T> {
    private Class<T> responseType;

    /**
     * Creates a new request.
     *
     * @param method the HTTP method to use
     * @param url URL to fetch the JSON from
     * @param requestData A {@link Object} to post and convert into json as the request. Null is allowed and indicates no parameters will be posted along with request.
     * @param listener Listener to receive the JSON response
     * @param errorListener Error listener, or null to ignore errors.
     */
    public JacksonRequest(int method, String url, Object requestData, Class<T> responseType, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, (requestData == null) ? null : Mapper.string(requestData), listener, errorListener);
        Log.e("jacksonrequest",  method + " " + url);
        this.responseType = responseType;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        // Log.e("jackson","parse called");
        try {
            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(Mapper.objectOrThrow(jsonString, responseType), HttpHeaderParser.parseCacheHeaders(response));
        } catch (Exception e) {
            e.printStackTrace();
            if (response.statusCode == 200) {
                Exception exception = new Exception(new String(response.data));
                return Response.error(new ParseError(exception));
            } else {
                return Response.error(new VolleyError("Parsing failed"));
            }
        }
    }

    @Override protected VolleyError parseNetworkError(VolleyError error) {
        error.printStackTrace();
        VolleyError volleyError = error;
//    Crashlytics.logException(error);
        if( error instanceof NetworkError) {
            //volleyError = new VolleyError("We are currently down for maintenance, we will be back shortly!");
            //Network Error - you may login with some wi-fi which is under firewall means you are connected but not able to transfer data. you are allowed to transfer only even after login manually with the firewall.
            //Before login to firewall the network error is displayed
            volleyError = new VolleyError("Oops! There seems to be a problem connecting to the network, please try again.");
        } else if( error instanceof ParseError) {
            volleyError = new VolleyError("There seems to be a technical error, email us for support on hello@getfrapp.com");
        } else if( error instanceof ServerError) {
            volleyError = new VolleyError("Seems like we are facing an issue, go grab a coffee, we will be back soon.");
        } else if( error instanceof AuthFailureError) {
        } else if( error instanceof NoConnectionError) {
            // No connection Error - you doesn't have a data connection and wi-fi Connection
            //volleyError = new VolleyError("Network connection failed");
            volleyError = new VolleyError("No network, please check internet connection and try again.");
        } else if( error instanceof TimeoutError) {
            volleyError = new VolleyError("Is your net stable? Please try connecting again.");
        }
        return super.parseNetworkError(volleyError);
    }
}
