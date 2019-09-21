package io.zluan.logoswap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.opencv.android.OpenCVLoader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (OpenCVLoader.initDebug()) {
            Toast.makeText(this, "openCv successfully loaded", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "openCv cannot be loaded", Toast.LENGTH_LONG).show()
        }
    }
}
