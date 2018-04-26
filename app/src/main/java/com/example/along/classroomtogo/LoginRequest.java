package com.example.along.classroomtogo;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Long on 4/17/2018.
 */

public class LoginRequest extends StringRequest{
    private static  final String LOGIN_REQUEST_URL = "http://asimo1801.x10host.com/Login.php";
    private Map<String, String> params;

    public  LoginRequest(int id,  String password, Response.Listener<String> listener) {
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("id", id + "");
        params.put("password", password);
    }

    @Override
    public  Map<String, String> getParams() {
        return params;
    }
}
