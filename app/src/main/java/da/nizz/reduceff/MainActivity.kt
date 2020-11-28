package da.nizz.reduceff

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import da.nizz.reduceff.presenter.MainPresenter
import da.nizz.reduceff.view.MainView
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter.loadDaysNumber()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.loadDaysNumber()
    }

    override fun showDays(days: Int) {
        numberOfDays.setTextColor(getCorrespondingColor(days))
        numberOfDays.text = days.toString()
    }

    fun onClickReset(@Suppress("UNUSED_PARAMETER") view: View) {
        mPresenter.reset()
    }

    private fun getCorrespondingColor(days: Int): Int {
        val s = StringBuilder("state_color_")
        if (days >= 12)
            s.append(7)
        else
            s.append((days + 2) / 2)
        val colorRes = resources.getIdentifier(s.toString(), "color", packageName)
        return ContextCompat.getColor(applicationContext, colorRes)
    }
}
