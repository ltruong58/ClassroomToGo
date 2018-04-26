package com.example.along.classroomtogo;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Long on 3/11/2018.
 */

public class DBHelper extends SQLiteOpenHelper{
    private Context mContext;

    static final String DATABASE_NAME = "ClassRoomToGo";
    private static final String DATABASE_PROFESSOR_TABLE = "professor";
    private static final String DATABASE_COURSE_TABLE = "Course";
    private static final String DATABASE_SECTION_TABLE = "Section";
    private static final String DATABASE_ANNOTATION_TABLE = "Annotation";
    private static final String DATABASE_STUDENT_TABLE = "Student";
    private static final String DATABASE_ANSWER_TABLE = "Answer";
    private static final String DATABASE_QUESTION_TABLE = "Question";
    private static final String DATABASE_CHAPTER_TABLE = "Chapter";
    private static final String DATABASE_NOTE_TABLE = "Note";
    private static final String DATABASE_TEXTBOOK_TABLE = "Textbook";
    private static final int DATABASE_VERSION = 1;

    // DEFINE THE FIELDS (COLUMN NAMES) FOR THE STUDENT TABLE
    private static final String STUDENT_KEY_FIELD_ID = "id";
    //private static final String STUDENT_FIELD_USERNAME = "username";
    //private static final String STUDENT_FIELD_NUMBER_OF_POSTS = "number_of_posts";
    private static final String STUDENT_FIELD_LAST_NAME = "last_name";
    private static final String STUDENT_FIELD_FIRST_NAME = "first_name";
    private static final String STUDENT_FIELD_EMAIL = "email";
    private static final String STUDENT_FIELD_PASSWORD = "password";

    /**
     * Default constructor that get Context from activity, create database name and version.
     * @param context
     */
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    /**
     *  Create data table: room. room booking, student
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {



        //STUDENT
        String table = "CREATE TABLE " + DATABASE_STUDENT_TABLE + "("
                + STUDENT_KEY_FIELD_ID + " INTEGER, "
                //+ STUDENT_FIELD_USERNAME + " TEXT, "
                //+ STUDENT_FIELD_NUMBER_OF_POSTS + " INTEGER, "
                + STUDENT_FIELD_LAST_NAME + " TEXT, "
                + STUDENT_FIELD_FIRST_NAME + " TEXT, "
                + STUDENT_FIELD_EMAIL + " TEXT, "
                + STUDENT_FIELD_PASSWORD + " TEXT)";
        sqLiteDatabase.execSQL(table);


    }

    /**
     * Delete Data tables if their already exists in the phone, then create new data tables.
     * @param sqLiteDatabase
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_PROFESSOR_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_COURSE_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_SECTION_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_ANNOTATION_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_STUDENT_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_TEXTBOOK_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_ANSWER_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_QUESTION_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_CHAPTER_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_NOTE_TABLE);
        onCreate(sqLiteDatabase);
    }

    //******* import data from csv file ********

    /**
     * import data for Student table in the CSV file
     * @param csvFileName
     * @return
     */
    public boolean importStudentsFromCSV(String csvFileName) {
        AssetManager manager = mContext.getAssets();
        InputStream inStream;
        try {
            inStream = manager.open(csvFileName);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        BufferedReader buffer = new BufferedReader(new InputStreamReader(inStream));
        String line;
        try {
            while ((line = buffer.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length != 5) {
                    Log.d("OCC Library", "Skipping Bad CSV Row: " + Arrays.toString(fields));
                    continue;
                }
                int id = Integer.parseInt(fields[0].trim());
                String lastName = fields[1].trim();
                String firstName = fields[2].trim();
                String email = fields[3].trim();
                String password = fields[4].trim();

                addStudent(new Student(id, lastName, firstName, email, password));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * insert student into Student table
     * @param student
     */
    public void addStudent(Student student)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(STUDENT_KEY_FIELD_ID, student.getId());
        values.put(STUDENT_FIELD_LAST_NAME, student.getLastName());
        values.put(STUDENT_FIELD_FIRST_NAME, student.getFirstName());
        values.put(STUDENT_FIELD_EMAIL, student.getEmail());
        values.put(STUDENT_FIELD_PASSWORD, student.getPassword());

        db.insert(DATABASE_STUDENT_TABLE, null, values);
        db.close();
    }
}
