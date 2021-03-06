package da.nizz.reduceff.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import da.nizz.reduceff.MyApplication
import da.nizz.reduceff.model.dao.CounterDAO
import da.nizz.reduceff.view.MainView
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.math.abs

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    @Inject
    lateinit var counterDAO: CounterDAO
    private var lastLoadedCounter: Int = 0

    init {
        MyApplication.graph.inject(this)
    }

    fun loadDaysNumber() {
        val counter = counterDAO.loadCounter()
        if (counter.sinceDate.time == -1L) {
            counter.sinceDate = Date()
            counterDAO.save(counter)
            lastLoadedCounter = 0
        } else {
            val diffInMillis: Long = abs(Date().time - counter.sinceDate.time)
            val diff: Long = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS)
            lastLoadedCounter = diff.toInt()
        }
        viewState.showDays(lastLoadedCounter)
    }

    fun reset() {
        val counter = counterDAO.loadCounter()
        counter.reset()
        counterDAO.save(counter)
        lastLoadedCounter = 0
        viewState.showDays(0)
    }
}