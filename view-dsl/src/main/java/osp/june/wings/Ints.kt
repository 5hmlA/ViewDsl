package osp.june.wings

import android.annotation.SuppressLint
import android.content.Context

context(Context)
fun Int.getString() = getText(this)

context(Context)
fun Int.getColor() = getColor(this)

context(Context)
@SuppressLint("UseCompatLoadingForDrawables")
fun Int.getDrawable() = getDrawable(this)