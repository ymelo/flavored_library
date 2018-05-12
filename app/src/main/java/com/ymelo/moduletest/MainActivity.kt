package com.ymelo.moduletest

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.ymelo.testlib.Configuration
import com.ymelo.testlib.Specific

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Value from config " + Configuration().int, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        Specific().doSpecificImplementation()
        /*
        The SuperConfiguration can only be used
        when using the full version.
        This could be useful when distributing a
        library to multiple customers, or
        if some debugging features should be completely
        invisible to customer, but visible to developers
         */
        //SuperConfiguration().doSomething()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
