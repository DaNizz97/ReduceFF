package da.nizz.reduceff.model

import com.activeandroid.Model
import com.activeandroid.annotation.Column
import java.util.*

class Counter : Model {

    @Column
    var sinceDate: Date = Date()

    constructor(sinceDate: Date) : super() {
        this.sinceDate = sinceDate
    }

    @Suppress("unused")
    constructor()

    fun reset() {
        this.sinceDate = Date()
    }
}