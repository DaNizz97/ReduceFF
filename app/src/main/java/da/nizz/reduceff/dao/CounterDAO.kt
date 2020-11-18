package da.nizz.reduceff.dao

import com.activeandroid.query.Delete
import com.activeandroid.query.Select
import da.nizz.reduceff.model.Counter

class CounterDAO {

    fun save(counter: Counter): Long = counter.save()

    fun findById(id: Long): Counter =
        Select().from(Counter::class.java).where("id = ?", id).executeSingle()

    fun findAll(): List<Counter> = Select().from(Counter::class.java).execute()

    fun delete(counter: Counter) = counter.delete()
}