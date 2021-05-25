package com.wbj.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/5/25 下午5:23
 * 描述：
 */

class SurfView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private var mPaint: Paint? = null
    private var mSpace: Int = 20
    private var mPerWidth: Int = 20
    private var mMaxHeight: Int = 50
    private var mCount: Int = 3
    private var mMode: Int = 0


    private fun init() {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint!!.color = Color.BLACK
    }

    fun setSlideCount(count: Int) {
        mCount = count
    }

    fun setColor(color: Int) {
        mPaint?.color = color
    }

    fun setSpace(space: Int) {
        mSpace = space
    }

    fun setMaxHeight(height: Int) {
        mMaxHeight = height
    }

    fun setSliderWidth(width: Int) {
        mPerWidth = width
    }

    /**
     * mode 0 从中间上下波动
     * mode 1 从底部上下波动
     */
    fun setMode(mode:Int){
        mMode = mode
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //计算宽高
        setMeasuredDimension(mCount * mPerWidth + mSpace * mCount, mMaxHeight)
    }

    //    val rect = Rect(it * (mPerWidth + mSpace),0,it * mPerWidth + mPerWidth + mSpace * it,mMaxHeight)
    private val mRect = Rect()


    override fun onDraw(canvas: Canvas?) {
        repeat(mCount) {
            mRect.left = it * (mPerWidth + mSpace)
            mRect.top = 0
            mRect.right = it * mPerWidth + mPerWidth + mSpace * it
            mRect.bottom = mMaxHeight

            canvas!!.drawRect(mRect, mPaint!!)
        }
    }


}