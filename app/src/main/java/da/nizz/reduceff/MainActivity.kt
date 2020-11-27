package da.nizz.reduceff

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import da.nizz.reduceff.presenter.MainPresenter
import da.nizz.reduceff.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

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
        numberOfDays.text = days.toString()
    }

    fun onClickReset(@Suppress("UNUSED_PARAMETER") view: View) {
        mPresenter.reset()
    }
}
