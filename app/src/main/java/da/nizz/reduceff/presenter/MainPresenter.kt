package da.nizz.reduceff.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import da.nizz.reduceff.MyApplication
import da.nizz.reduceff.model.dao.CounterDAO
import da.nizz.reduceff.view.MainView
import javax.inject.Inject

@InjectViewState
class MainPresenter: MvpPresenter<MainView>() {

    @Inject
    lateinit var counterDAO: CounterDAO

    init {
        MyApplication.graph.inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadCounter()
    }

    private fun loadCounter() {
        val counter = counterDAO.findAll()[0]
        viewState.showDays(counter)
    }

    fun onReset() {
        val counter = counterDAO.findAll()[0]
        counter.reset()
        counterDAO.save(counter)
        viewState.showDays(counter)
    }
}