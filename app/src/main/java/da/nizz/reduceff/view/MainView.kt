package da.nizz.reduceff.view

import com.arellomobile.mvp.MvpView

interface MainView : MvpView {
    fun onReset()
    fun showDays()
}