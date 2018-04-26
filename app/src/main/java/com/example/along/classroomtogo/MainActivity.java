package com.example.along.classroomtogo;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Config;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private JSONArray result;
    private List<Course> myCourses;
    private ClassListAdapter classListAdapter;
    private ListView classListView;

    private static final String URL_PRODUCTS = "http://asimo1801.x10host.com/ClassRegister.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String firstname = intent.getStringExtra("firstname");
        int studentid = Integer.parseInt(intent.getStringExtra("id"));

        myCourses = new ArrayList<Course>();

        // Get data from server
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //JSONObject jsonResponse = null;
                try {
                    result = new JSONArray(response);

                    getCourses(result);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        ClassRegisterRequest classRegisterRequest = new ClassRegisterRequest(studentid, responseListener);
        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(classRegisterRequest);

        classListAdapter = new ClassListAdapter(this, R.layout.class_item, myCourses);
        classListView = (ListView) findViewById(R.id.lvclasses);
        classListView.setAdapter(classListAdapter);
    }


    private void getCourses(JSONArray j){
        for(int i=0;i<j.length();i++){
            try {
                JSONObject json = j.getJSONObject(i);
                int id = Integer.parseInt(json.getString("id"));
                String courseName = json.getString("coursename");
                String courseCode = json.getString("coursecode");
                String term = json.getString("term");
                String imageName = json.getString("imagename");
                myCourses.add(new Course(id, courseName, courseCode, term, imageName));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    public void showPopupMenu(View view)
    {
        if(view instanceof LinearLayout) {
            LinearLayout selectedLinearLayout = (LinearLayout) view;
            final Course selectedCourse = (Course) selectedLinearLayout.getTag();
            PopupMenu popup = new PopupMenu(MainActivity.this, selectedLinearLayout);
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                public boolean onMenuItemClick(MenuItem item) {
                    Toast.makeText(MainActivity.this,"You Clicked : " + item.getTitle() + " of " + selectedCourse.getmCourseName(),Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
            popup.show();
        }

    }
}
