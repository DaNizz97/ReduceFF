package da.nizz.reduceff.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import da.nizz.reduceff.R
import da.nizz.reduceff.presenter.MainPresenter
import da.nizz.reduceff.view.MainView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var mPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter.loadDaysNumber()
        setColor()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.settings_item -> {
                showSettings()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showSettings() {
        startActivityForResult(Intent(this, SettingsActivity::class.java), 0)
    }

    override fun onResume() {
        super.onResume()
        mPresenter.loadDaysNumber()
    }

    override fun showDays(days: Int) {
        numberOfDays.setTextColor(getCorrespondingColor(days))
        numberOfDays.text = days.toString()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        setColor()
    }

    private fun setColor() {
        val sharedPreferences: SharedPreferences = PreferenceManager
            .getDefaultSharedPreferences(this)
        val selectedColor = sharedPreferences.getInt(getString(R.string.toolbar_color_picker), -1)

        if (selectedColor == -1) {
            val layout = findViewById<ConstraintLayout>(R.id.main_activity_background)
            layout.setBackgroundResource(R.drawable.test_shape)
            return
        }
        main_activity_background.setBackgroundColor(selectedColor)
    }

    fun onClickReset(@Suppress("UNUSED_PARAMETER") view: View) {
        mPresenter.reset()
    }

    private fun getCorrespondingColor(days: Int): Int {
        val s = StringBuilder("state_color_")
        if (days >= 12)
            s.append(7)
        else
            s.append((days + 2) / 2)
        val colorRes = resources.getIdentifier(s.toString(), "color", packageName)
        return ContextCompat.getColor(applicationContext, colorRes)
    }
}
