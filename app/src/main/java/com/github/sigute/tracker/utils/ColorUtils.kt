package com.github.sigute.tracker.utils

import android.content.Context
import android.support.v4.graphics.ColorUtils
import com.github.sigute.tracker.R
import java.util.*

fun getRandomRainbowColor(context: Context, alpha: Float): Int {
    val colours = context.resources.getIntArray(R.array.rainbow)
    val colourInt = colours[Random().nextInt(colours.size)]
    return ColorUtils.setAlphaComponent(colourInt, (alpha * 255).toInt())
}