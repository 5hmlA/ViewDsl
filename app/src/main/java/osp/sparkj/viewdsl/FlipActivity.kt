package osp.sparkj.viewdsl

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.AttributeSet
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.PARENT_ID
import androidx.core.view.WindowCompat
import osp.sparkj.cartoon.wings.todp
import osp.sparkj.cartoon.wings.todpf
import osp.sparkj.dsl.*

class FlipActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(FlipView(this))
//        setContentView(Touch3D(this))
    }
}

val topOffset = 126.todpf
val widthScale = .86F

class FlipView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs), ViewCompose {
    init {
        clipChildren = false
        clipToPadding = false
        vLayoutConstraint(
            modifier = Modifier
                .vSize(-1, -1)
                .vFlipFather()
        ) {
            vLayoutConstraint(
                modifier = Modifier
                    .vSize(-1, -1)
                    .vFlipExpand(cardWidthFactor = widthScale, topOffset = topOffset)
            ) {
                icon(width = 0, height = 0) {
                    setImageResource(R.mipmap.img)
                    scaleType = ImageView.ScaleType.CENTER_CROP
                    layoutParams {
                        width = 0
                        height = 0
                        topToTop = PARENT_ID
                        startToStart = PARENT_ID
                        endToEnd = PARENT_ID
                        bottomToBottom = PARENT_ID
                    }
                }
            }

            flipCardWithView()
//            flipCardWithDraw()
        }
    }

    private fun LayoutConstraint.flipCardWithView() {

        val head = vLayoutConstraint(
            modifier = Modifier
                .vSizeFactor(widthScale, 0)
                .vFlipHeadView { v, p ->
                    v.alpha = 1 - p * 2
                }
        ) {
            layoutParams {
                height = topOffset.toInt()
                topToTop = PARENT_ID
                startToStart = PARENT_ID
                endToEnd = PARENT_ID
            }
            text(width = -1, height = -1) {
                padding(top = 16.todp)
                text = "发现新版本"
                textSize = 30F
                layoutParams {
                    width = -2
                    height = 100.todp
                    topToTop = PARENT_ID
                    topMargin = 35.todp
                    startToStart = PARENT_ID
                }
            }
        }
        vLayoutConstraint(
            modifier = Modifier
                .debug(Color.YELLOW)
                .vSizeFactor(widthScale, .66)
                .vFlipCardView(widthScale)
        ) {
//            shapeRound(radiusRatio = 8.todpf)
            background {
                cornerRadius = 13.todpf
                color = ColorStateList.valueOf(Color.BLUE)
            }
            layoutParams {
                topToBottom = head.id
                startToStart = PARENT_ID
                endToEnd = PARENT_ID
            }
        }
    }

    private fun LayoutConstraint.flipCardWithDraw() {
        vLayoutConstraint(
            modifier = Modifier
                .vSize(-1, -1)
                .vFlipCard(topOffset = topOffset)
        ) {
            padding(horizontal = 13.todp)
            icon(width = 0, height = 0) {
                setImageResource(R.mipmap.img)
                scaleType = ImageView.ScaleType.CENTER_CROP
                layoutParams {
                    width = 0
                    height = 0
                    topToTop = PARENT_ID
                    startToStart = PARENT_ID
                    endToEnd = PARENT_ID
                    bottomToBottom = PARENT_ID
                }
            }
        }
    }
}

class Touch3D @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), ViewCompose {

    init {
        framelayoutParams(-1, -1) {
            gravity = Gravity.CENTER
        }

        setBackgroundColor(Color.RED)

        vLayoutConstraint(
            modifier = Modifier
                .debug()
//                .v3DTouch2()
                .vRotateHover()
//                .vFold()
        ) {
            icon {
                setBackgroundColor(Color.BLACK)
                setImageResource(R.mipmap.img)
                scaleType = ImageView.ScaleType.CENTER_CROP

                layoutParams(all2parent = true) {
                    width = 0
                    height = 0
                }
            }
            framelayoutParams(200.todp, 200.todp) {
                gravity = Gravity.CENTER
            }
        }
    }

}