// !USE_EXPERIMENTAL: kotlin.Experimental
// !DIAGNOSTICS: -UNUSED_VARIABLE
// FILE: api.kt

package api

@Experimental(Experimental.Level.WARNING)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.TYPEALIAS,
        AnnotationTarget.VALUE_PARAMETER)
annotation class ExperimentalAPI

@ExperimentalAPI
fun function(): String = ""

@ExperimentalAPI
val property: String = ""

@ExperimentalAPI
typealias Typealias = String

// FILE: usage-propagate.kt

package usage1

import api.*

@ExperimentalAPI
fun useAll() {
    function()
    property
    val s: Typealias = ""
}

@ExperimentalAPI
class Use {
    fun useAll() {
        function()
        property
        val s: Typealias = ""
    }
}

// FILE: usage-use.kt

package usage2

import api.*

fun useAll() {
    @UseExperimental(ExperimentalAPI::class)
    <!UNRESOLVED_REFERENCE!>{
        function()
        property
        val s: Typealias = ""
    }()<!>
}

@UseExperimental(ExperimentalAPI::class)
class Use {
    fun useAll() {
        function()
        property
        val s: Typealias = ""
    }
}

// FILE: usage-none.kt

package usage3

import api.*

fun use() {
    function()
    property
    val s: Typealias = ""
    s.hashCode()
}
