package da.nizz.reduceff.model.dao

import com.activeandroid.Model
import com.activeandroid.query.Select
import da.nizz.reduceff.model.Counter
import java.time.LocalDate
import java.util.*

class CounterDAO {
    companion object {
        const val FIRST_ID = 0
    }

    fun save(counter: Counter): Long = counter.save()

    fun loadCounter(): Counter =
        Select().from(Counter::class.java).executeSingle() ?: Counter(Date(-1))
}
