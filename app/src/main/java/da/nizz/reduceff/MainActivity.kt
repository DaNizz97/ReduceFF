package da.nizz.reduceff

import android.os.Bundle
import android.view.View
import com.activeandroid.query.Select
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import da.nizz.reduceff.model.Counter
import da.nizz.reduceff.presenter.MainPresenter
import da.nizz.reduceff.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showDays(counter: Counter) {
        numberOfDays.text = counter.value.toString()

    }

    fun onClickReset(view: View) {
        mPresenter.onReset()
    }
}
