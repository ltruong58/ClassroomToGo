package com.example.along.classroomtogo;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Long on 4/17/2018.
 */

public class RegisterRequest extends StringRequest{
    private static  final String REGISTER_REQUEST_URL = "http://asimo1801.x10host.com/Register.php";
    private Map<String, String> params;

    public  RegisterRequest(int id, String firstname, String lastname, String email, String password, Response.Listener<String> listener) {
        super(Request.Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("id", id + "");
        params.put("firstname", firstname);
        params.put("lastname", lastname);
        params.put("email", email);
        params.put("password", password);

    }

    @Override
    public  Map<String, String> getParams() {
        return params;
    }
}
