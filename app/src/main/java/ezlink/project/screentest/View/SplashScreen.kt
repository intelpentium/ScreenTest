package ezlink.project.screentest.View

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import ezlink.project.screentest.R
import kotlinx.android.synthetic.main.activity_splashscreen.*

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        tv_title.animate().translationY(1400F).setDuration(1000).setStartDelay(3000);
        tv_version.animate().translationY(1400F).setDuration(1000).setStartDelay(3000);
        lottieGift.animate().translationY(1400F).setDuration(1000).setStartDelay(3000);

        Handler().postDelayed({
            val intent = Intent(this, Genre::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }
}