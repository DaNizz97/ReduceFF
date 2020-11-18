package da.nizz.reduceff.di.module

import da.nizz.reduceff.model.dao.CounterDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CounterDaoModule {

    @Provides
    @Singleton
    fun provideCounterDao(): CounterDAO = CounterDAO()
}