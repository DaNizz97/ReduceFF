package da.nizz.reduceff.view

import com.arellomobile.mvp.MvpView
import da.nizz.reduceff.model.Counter

interface MainView : MvpView {
    fun showDays(counter: Counter)
}