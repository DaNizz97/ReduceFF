package da.nizz.reduceff

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.activeandroid.query.Select
import da.nizz.reduceff.model.Counter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickInc(view: View) {
        val counterDB = Select().from(Counter::class.java).executeSingle<Counter>()
        if (counterDB == null) {
            Counter(1).save()

        }
        ++counterDB.value
        counterDB.save()
        findViewById<TextView>(R.id.numberOfDays).text = counterDB.value.toString()
    }
}
