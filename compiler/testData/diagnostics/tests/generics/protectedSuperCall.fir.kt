// !WITH_NEW_INFERENCE
// FILE: GA.kt

package test.x

open class GA<T> protected constructor()

// FILE: Main.kt
package test

import test.x.GA

class C : GA<Any>() {
    companion object {
        fun bar() = GA<Any>() // Should be error
    }
}

fun main(args: Array<String>) {
    C.bar()
}