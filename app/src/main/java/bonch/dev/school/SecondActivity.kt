package bonch.dev.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val boolean = intent.getBooleanExtra(FirstActivity.EXTRA_INDICATOR, false)
        val int = intent.getIntExtra(FirstActivity.EXTRA_COUNTER, 0)
        val string = intent.getStringExtra(FirstActivity.EXTRA_TEXT)
        textView.text = createText(boolean, int, string)
    }

    private fun createText(boolean: Boolean, int: Int, string: String?) :String {
        return "Button was clicked: $boolean \n" +
                "Button was clicked $int times \n" +
                "Text: $string"
    }
}
