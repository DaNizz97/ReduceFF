package da.nizz.reduceff.di.component

import da.nizz.reduceff.di.module.CounterDaoModule
import da.nizz.reduceff.presenter.MainPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CounterDaoModule::class])
interface AppComponent {

    fun inject(mainPresenter: MainPresenter)
}