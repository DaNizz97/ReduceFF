package da.nizz.reduceff.view

import com.arellomobile.mvp.MvpView

interface MainView : MvpView {
    fun showDays(days: Int)
}