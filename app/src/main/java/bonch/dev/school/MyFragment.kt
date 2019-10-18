package bonch.dev.school

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*






class MyFragment : Fragment() {

    companion object {
        fun newInstance() = MyFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bundle = this.arguments
        val boolean = bundle?.getBoolean(FirstActivity.EXTRA_INDICATOR, false)
        val int = bundle?.getInt(FirstActivity.EXTRA_COUNTER, 0)
        val string = bundle?.getString(FirstActivity.EXTRA_TEXT)
        textView.text = createText(boolean ?: false, int?: 0, string)

    }

    private fun createText(boolean: Boolean, int: Int, string: String?) :String {
        return "Button was clicked: $boolean \n" +
                "Button was clicked $int times \n" +
                "Text: $string"
    }

}