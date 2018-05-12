package com.ymelo.testlib;

import android.util.Log;

/**
 * Example of a class <b>only</b> accessible to the full version
 * of the library.
 * This class does NOT have an equivalent in the restricted version.
 * This allows to distribute libraries with debugging features or paid
 * features accessible only to some users of the library
 *
 * This could be useful when distributing a
 * library to multiple customers, or
 * if some debugging features should be completely
 * invisible to customer, but visible to developers
 */
public class SuperConfiguration {
    public int otherInt = 1;
    public void doSomething() {
        Log.d("full", "I can do it");
    }
}
