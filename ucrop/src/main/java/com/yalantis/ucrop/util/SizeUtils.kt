package com.yalantis.ucrop.util

import android.content.Context

fun dp2px(float: Float, context: Context):Int{
    val scale: Float = context.resources.displayMetrics.density
    return (float * scale + 0.5f).toInt()
}

fun sp2px(spValue: Float, context: Context): Int {
    val fontScale: Float = context.resources.displayMetrics.scaledDensity
    return (spValue * fontScale + 0.5f).toInt()
}