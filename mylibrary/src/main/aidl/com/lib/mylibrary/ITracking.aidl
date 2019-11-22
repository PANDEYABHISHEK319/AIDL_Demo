// ITracking.aidl
package com.lib.mylibrary;

// Declare any non-default types here with import statements

interface ITracking {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void onOrientationUpdate(float x, float y, float z);

   /* void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);*/
}
