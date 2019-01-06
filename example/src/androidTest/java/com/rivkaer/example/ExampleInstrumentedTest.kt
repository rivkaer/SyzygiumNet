package com.rivkaer.example

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.rivkaer.example.bean.Types
import com.rivkaer.example.bean.Welfare
import com.rivkaer.example.net.GankioRetrofit
import com.rivkaer.moonnet.Callback.CustCallback

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import retrofit2.Call

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.rivkaer.moonnet", appContext.packageName)
    }
}
