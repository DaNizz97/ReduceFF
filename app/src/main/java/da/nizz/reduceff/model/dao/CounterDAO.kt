package da.nizz.reduceff.model.dao

import com.activeandroid.query.Select
import da.nizz.reduceff.model.Counter
import java.util.*

class CounterDAO {

    fun save(counter: Counter): Long = counter.save()

    fun loadCounter(): Counter =
        Select().from(Counter::class.java).executeSingle() ?: Counter(Date(-1))
}
