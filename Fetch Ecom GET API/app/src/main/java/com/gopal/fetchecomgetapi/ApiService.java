package com.gopal.fetchecomgetapi;


import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class ApiService {
    private final String API_URL = "https://dummyjson.com/products/1";
    private final RequestQueue requestQueue;

    public ApiService(Context context) {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public void fetchProducts(Response.Listener<JSONArray> successListener, Response.ErrorListener errorListener) {
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, API_URL, null, successListener, errorListener);
        requestQueue.add(jsonArrayRequest);
    }
}
