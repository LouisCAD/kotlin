// "Change parameter 'x' type of function 'foo' to '(String) -> Int'" "true"
package bar
fun foo(w: Int = 0, x: Int, y: Int = 0, z: (Int) -> Int = {42}) {
    foo(1, { a: String -> 42}<caret>, 1)
}
