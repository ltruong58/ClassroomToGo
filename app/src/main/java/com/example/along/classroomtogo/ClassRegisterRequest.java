package com.example.along.classroomtogo;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Long on 4/17/2018.
 */

public class ClassRegisterRequest extends StringRequest{
    private static  final String CLASS_REGISTER_REQUEST_URL = "http://asimo1801.x10host.com/ClassRegister.php";
    private Map<String, String> params;

    public  ClassRegisterRequest(int studentid, Response.Listener<String> listener) {
        super(Request.Method.POST, CLASS_REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("studentid", studentid + "");
    }

    @Override
    public  Map<String, String> getParams() {
        return params;
    }
}

