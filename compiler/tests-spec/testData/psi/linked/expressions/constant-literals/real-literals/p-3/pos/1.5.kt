/*
 * KOTLIN PSI SPEC TEST (POSITIVE)
 *
 * SPEC VERSION: 0.1-106
 * PLACE: expressions, constant-literals, real-literals -> paragraph 3 -> sentence 1
 * NUMBER: 5
 * DESCRIPTION: Real literals suffixed by f/F (float suffix) with omitted a whole-number part and an exponent mark.
 */

val value = .0e0f
val value = .0e-00F
val value = .0E000F
val value = .0E+0000f
val value = .0e+0f
val value = .00e00f
val value = .000E-000F

val value = .0E+1F
val value = .00e22F
val value = .000e-333f
val value = .0000e4444F
val value = .0E-55555f
val value = .00e666666f
val value = .000E7777777F
val value = .0000e-88888888f
val value = .0E+999999999F

val value = .1234567890E999999999f
val value = .23456789E+123456789f
val value = .345678e00000000001f
val value = .4567E-100000000000F
val value = .56e-0F
val value = .65e000000000000F
val value = .7654E+010f
val value = .876543E1F
val value = .98765432e-2f
val value = .0987654321E-3F

val value = .1111e4F
val value = .22222E-5F
val value = .33333e+6f
val value = .444444E7F
val value = .5555555e8f
val value = .66666666e308f
val value = .777777777E-308f
val value = .8888888888e+309F
val value = .99999999999e-309f

val value = .888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888e+111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111f
val value = .000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000e0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000F
val value = .000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000e-000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000f
val value = .000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000e+000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000F
