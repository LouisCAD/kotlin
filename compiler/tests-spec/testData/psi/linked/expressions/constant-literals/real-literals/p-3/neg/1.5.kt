/*
 * KOTLIN PSI SPEC TEST (NEGATIVE)
 *
 * SPEC VERSION: 0.1-106
 * PLACE: expressions, constant-literals, real-literals -> paragraph 3 -> sentence 1
 * NUMBER: 5
 * DESCRIPTION: Real literals with omitted whole-number part and an exponent mark followed by a float suffix and digits.
 */

val value = .0f00e0

val value = .0f0e-0
val value = .00F9E9
val value = .000F0e1

val value = .0F0e
val value = .00F9e+f
val value = .000f5ef
val value = .0000F1EF2EF3EF4EF5EF6EF7EF8EF9
val value = .0f7e+0F
val value = .00F000000000000e-0000000000000
val value = .000f9E0000000000000F
val value = .0000f2e+0000000000000
val value = .0F4E+F

val value = .888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888f8e+0
val value = .000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000f8e8
val value = .000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000f0E0000001
val value = .000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000f6E010
