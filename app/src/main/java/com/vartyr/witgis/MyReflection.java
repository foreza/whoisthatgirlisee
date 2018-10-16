package com.vartyr.witgis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.aerserv.sdk.AerServBanner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyReflection extends AppCompatActivity {

    private final String LOG_TAG = "MyReflection";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reflection);
        beginExamineAerServ();           // Examine the AerServSDK in the mirror!
    }


    // Examine the AerServ SDK
    public void beginExamineAerServ(){

        String sClassName = "com.aerserv.sdk.AerServBanner";        // Sample class we will examine

        try {
            Class classToInvestigate = Class.forName(sClassName);



            examineClassConstructors(classToInvestigate);           // Examine the class constructors
            examineFieldAvailable(classToInvestigate);              // Examine the fields available
            examineMethodsAvailable(classToInvestigate);            // Examine the methods available




        } catch (ClassNotFoundException e) {
            Log.e(LOG_TAG, "Class ain't found in the mirror.");
            // Class not found!
        } catch (Exception e) {
            // Unknown exception
            Log.e(LOG_TAG, "Something unknown ain't in the mirror." + e.getLocalizedMessage());
        }

    }

    public void examineClassConstructors(Class classToInvestigate) {


        Constructor[] aClassConstructors = classToInvestigate.getDeclaredConstructors();
        for(Constructor c : aClassConstructors){
            // Found a constructor c
            Log.e(LOG_TAG, "Found a constructor: " + c.getName());
        }
        // Dynamically do stuff with this class
        // List constructors, fields, methods, etc.

    }

    public void examineFieldAvailable(Class classToInvestigate) {
        Field[] aClassFields = classToInvestigate.getDeclaredFields();
        for(Field f : aClassFields){
            Log.e(LOG_TAG, "Found a field: " + f.getName());
        }

    }

    public void examineMethodsAvailable(Class classToInvestigate){
        Method[] aClassMethods = classToInvestigate.getDeclaredMethods();
        for(Method m : aClassMethods)
        {
            Log.e(LOG_TAG, "Found a method: " + m.getName());        }

    }

}
