package bonch.dev.school

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class FragmentActivity : AppCompatActivity() {
    var isDark = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FirstFragment.newInstance())
                .commit()
        }
    }

    fun replaceFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, if(isDark) SecondFragment.newInstance() else FirstFragment.newInstance())
            .addToBackStack(null)
            .commit()

        isDark = !isDark
    }

}
