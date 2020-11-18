package da.nizz.reduceff.model

import com.activeandroid.Model
import com.activeandroid.annotation.Column

class Counter : Model {

    @Column
    var value: Int = 0

    constructor(value: Int) : super() {
        this.value = value
    }

    constructor()

    fun reset() {
        value = 0
    }
}