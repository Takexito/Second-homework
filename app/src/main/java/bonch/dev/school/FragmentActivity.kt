package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FragmentActivity : AppCompatActivity() {
    var isDark = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FirstFragment.newInstance())
                .commitNow()
        }
    }

    fun replaceFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, if(isDark) SecondFragment.newInstance() else FirstFragment.newInstance())
            .commitNow()

        isDark = !isDark
    }

}
