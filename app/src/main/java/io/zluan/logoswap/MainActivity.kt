package io.zluan.logoswap

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import io.zluan.logoswap.utils.FLAGS_FULLSCREEN
import java.io.File
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MainActivity : AppCompatActivity() {

    private lateinit var container: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        container = findViewById(R.id.fragment_container)
    }

    override fun onResume() {
        super.onResume()
        // Before setting full screen flags, we must wait a bit to let UI settle; otherwise, we may
        // be trying to set app to immersive mode before it's ready and the flags do not stick
        container.postDelayed(
            { container.systemUiVisibility = FLAGS_FULLSCREEN },
            IMMERSIVE_FLAG_TIMEOUT
        )
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        return when (keyCode) {
            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                val intent = Intent(KEY_EVENT_ACTION).apply { putExtra(KEY_EVENT_EXTRA, keyCode) }
                LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
                true
            }
            else -> super.onKeyDown(keyCode, event)
        }
    }

    companion object {
        const val KEY_EVENT_ACTION = "key_event_action"
        const val KEY_EVENT_EXTRA = "key_event_extra"

        private const val IMMERSIVE_FLAG_TIMEOUT = 500L

        /** Use external media if it is available, our app's file directory otherwise */
        fun getOutputDirectory(context: Context): File {
            val appContext = context.applicationContext
            val mediaDir = context.externalMediaDirs.firstOrNull()?.let {
                File(it, appContext.resources.getString(R.string.app_name)).apply { mkdirs() }
            }
            return if (mediaDir?.exists() == true) {
                mediaDir
            } else {
                appContext.filesDir
            }
        }
    }
}
