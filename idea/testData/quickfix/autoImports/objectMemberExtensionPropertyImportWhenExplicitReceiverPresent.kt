// "Import" "true"
package p

class T
class NotT
class NotTT

object TopLevelObject1 {
    val T.foobar get() = 10
}

object TopLevelObject2 {
    val NotT.foobar get() = 10 // other type, should not be imported
}

object TopLevelObject3 {
    val foobar get() = 10 // not an extension, should not be imported
}

object TopLevelObject4 {
    val NotTT.foobar get() = 10 // NotTT present as receiver, but explicit receiver shuts him down
}

fun NotTT.usage(t: T) {
    t.foobar<caret>
}