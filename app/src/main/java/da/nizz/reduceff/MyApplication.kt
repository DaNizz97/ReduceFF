package da.nizz.reduceff

import com.activeandroid.app.Application
import da.nizz.reduceff.di.component.AppComponent
import da.nizz.reduceff.di.component.DaggerAppComponent
import da.nizz.reduceff.di.module.CounterDaoModule

class MyApplication : Application() {

    companion object {
        lateinit var graph: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        graph = DaggerAppComponent.builder().counterDaoModule(CounterDaoModule()).build()
    }
}