package bonch.dev.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class FirstActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_INDICATOR = "bonch.dev.school.EXTRA_INDICATOR"
        const val EXTRA_COUNTER = "bonch.dev.school.EXTRA_COUNTER"
        const val EXTRA_TEXT = "bonch.dev.school.EXTRA_TEXT"
    }

    var isClicked = false
    var counter = 0
    var text = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isClicked = savedInstanceState?.getBoolean(EXTRA_INDICATOR) ?: false
        counter = savedInstanceState?.getInt(EXTRA_COUNTER) ?: 0
        text = savedInstanceState?.getString(EXTRA_TEXT) ?: "TEXT"

        initView()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(EXTRA_INDICATOR, isClicked)
        outState.putInt(EXTRA_COUNTER, counter)
        outState.putString(EXTRA_TEXT, text)
    }

    private fun initView(){
        indicatorButton.setOnClickListener { v ->
            v.isEnabled = false
            isClicked = true
        }

        counterButton.setOnClickListener { v ->
            (v as Button).text = counter++.toString()
        }

        nextActivityButton.setOnClickListener {
            startActivity(createIntent(isClicked, counterButton.text.toString().toInt(),textField.text.toString()))
        }

        indicatorButton.isEnabled = !isClicked
        counterButton.text = counter.toString()
        textField.setText(text)
    }

    private fun createIntent(indicator: Boolean, counter: Int, text: String): Intent{
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(EXTRA_INDICATOR, indicator)
        intent.putExtra(EXTRA_TEXT, text)
        intent.putExtra(EXTRA_COUNTER, counter)

        return intent
    }
}
