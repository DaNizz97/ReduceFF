package da.nizz.reduceff.model.dao

import com.activeandroid.query.Select
import da.nizz.reduceff.model.Counter

class CounterDAO {
    companion object {
        const val FIRST_ID = 0
    }

    fun save(counter: Counter): Long = counter.save()

    fun findById(id: Long): Counter =
        Select().from(Counter::class.java).where("id = ?", id).executeSingle()

    fun findAll(): List<Counter> = Select().from(Counter::class.java).execute()

    fun delete(counter: Counter) = counter.delete()

    fun loadCounter(): Counter =
        Select().from(Counter::class.java).where("id = ?", FIRST_ID).executeSingle()
}
