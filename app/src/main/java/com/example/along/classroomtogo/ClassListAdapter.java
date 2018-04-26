package com.example.along.classroomtogo;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import android.content.res.AssetManager;

/**
 * Created by Long on 3/13/2018.
 */

public class ClassListAdapter extends ArrayAdapter<Course>  {
    private Context mContext;
    private List<Course> mCourseList = new ArrayList<>();
    private int mResourceId;
    private AssetManager assetManager;
    private ImageView mCourseImageView;
    private TextView mCourseNameTextView;
    private LinearLayout mClassItemLinearLayout;
    /**
     * Creates a new <code>TaskListAdapter</code> given a mContext, resource id and list of tasks.
     *
     * @param c The mContext for which the adapter is being used (typically an activity)
     * @param rId The resource id (typically the layout file name)
     * @param courses The list of tasks to display
     */
    public ClassListAdapter(Context c, int rId, List<Course> courses) {
        super(c, rId, courses);
        mContext = c;
        mResourceId = rId;
        mCourseList = courses;

    }

    /**
     * Gets the view associated with the layout (sets CheckBox content).
     * @param pos The position of the Task selected.
     * @param convertView The converted view.
     * @param parent The parent - ArrayAdapter
     * @return The new view with all content (CheckBox) set.
     */
    @Override
    public View getView(int pos, View convertView, ViewGroup parent)
    {
        final Course selectedCourse = mCourseList.get(pos);
        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);

        // Let's fill the check box with text and update status(checked or not checked)
        mCourseImageView = (ImageView) view.findViewById(R.id.classImageView);
        mCourseNameTextView = (TextView) view.findViewById(R.id.classNameTextView);
        mClassItemLinearLayout = (LinearLayout) view.findViewById(R.id.llClassItem);

        assetManager = getContext().getAssets();
        try
        {
            String filename = selectedCourse.getmImageName();
            // get input stream
            InputStream is = assetManager.open(filename);
            Bitmap  bitmap = BitmapFactory.decodeStream(is);
            mCourseImageView.setImageBitmap(bitmap);
        }
        catch(IOException ex)
        {
            Log.e("MainActivity", ex.getMessage());
        }
        mCourseNameTextView.setText(selectedCourse.getmCourseName());

        // Let's associate each CheckBox with a specific Task
        // Every View has a property called its "Tag"
        // Tag is a locker for one object
        mClassItemLinearLayout.setTag(selectedCourse);

        return view;
    }



}
