package com.wbj.customview

import android.content.Context
import android.graphics.*
import android.util.*
import android.view.View
import androidx.core.util.forEach

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


    private var TAG = "SurfView"
    private var mPaint: Paint? = null
    //每个滑块宽度
    private var mPerWidth: Int = 20
    //滑块间隔
    private var mSpace: Int = 20
    //滑块最大高度
    private var mMaxHeight: Int = 50
    //滑块数量
    private var mCount: Int = 3
    //每组滑块的数量，用于滑块数量多时呈现波浪效果
    private var mGroupChild: Int = 3
    //mode 0 从中间上下波动 //mode 1 从底部上下波动
    private var mMode: Int = 0
    //滑块的圆角
    private var mRaidus: Int = 0
    //滑块高度变化时的权重，越小越丝滑
    private var mWeight = if (mMode == 0) {
        mMaxHeight / 2 / mCount / 4
    } else {
        mMaxHeight / mCount / 4
    }
    //记录每个滑块顶部
    private var mArrTop = SparseIntArray()
    //记录每个滑块是否需要反向
    private var mRevers = SparseBooleanArray()
    //当前要画的 滑块的 l t r b 坐标
    private val mRectF = RectF()


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
     * 设置几个块为一组，
     */
    fun setGroupChild(groupChild: Int) {
        mGroupChild = groupChild
    }


    /**
     * mode 0 从中间上下波动
     * mode 1 从底部上下波动
     */
    fun setMode(mode: Int) {
        mMode = mode
    }

    fun setRadius(radius: Int) {
        mRaidus = radius
    }

    /**
     * 计算宽高，宽为滑块数量宽度和 + 间隔和
     * 高为maxHeight
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(mCount * mPerWidth + mSpace * mCount, mMaxHeight)
    }

    /**
     * 初始化每个滑块的顶部位置,需区分滑动模式
     */
    fun initArr() {
        mArrTop.clear()
        if (mMode == 0) {
            repeat(mCount) {
                //该计算是为了呈现波浪效果
//                val result = it / mGroupChild
//                val perH = mMaxHeight / 2 / mGroupChild //每份高度
//                if (result % 2 == 0) {//偶数
//                    mArrTop.put(it, mMaxHeight / 2 - perH * (it % mGroupChild))
//                } else {//奇数
//                    mArrTop.put(it, mMaxHeight / 2 - perH * ((mGroupChild - 1) - it % mGroupChild))
//                }
                val perH = mMaxHeight / 2 / mGroupChild //每份高度
                //和上一个对比
                if (it <= 1){
                    mArrTop.put(it, mMaxHeight - perH * (it % (mGroupChild)))
                }else {
                    //判断 是递增还是递减
                    if (mArrTop[it - 1] < mArrTop[it - 2]){//递减
                        if (mArrTop[it - 1] == 0){
                            mArrTop.put(it,perH)
                        } else if (mArrTop[it - 1] < perH){
                            mArrTop.put(it,0)
                        }else{
                            mArrTop.put(it,mArrTop[it - 1] - perH)
                        }
                    }else{//递增
                        if (mArrTop[it - 1] == mMaxHeight){
                            mArrTop.put(it,mMaxHeight - perH)
                        }else{
                            mArrTop.put(it,mArrTop[it - 1] + perH)
                        }
                    }
                }
            }
        } else {
            repeat(mCount) {
                val perH = mMaxHeight /(mGroupChild - 1) //每份高度
                if (it <= 1){
                    mArrTop.put(it, mMaxHeight - perH * (it % (mGroupChild)))
                }else {
                    //判断 是递增还是递减
                    if (mArrTop[it - 1] < mArrTop[it - 2]){//递减
                        if (mArrTop[it - 1] == 0){
                            mArrTop.put(it,perH)
                        } else if (mArrTop[it - 1] < perH){
                            mArrTop.put(it,0)
                        }else{
                            mArrTop.put(it,mArrTop[it - 1] - perH)
                        }
                    }else{//递增
                        if (mArrTop[it - 1] == mMaxHeight){
                            mArrTop.put(it,mMaxHeight - perH)
                        }else{
                            mArrTop.put(it,mArrTop[it - 1] + perH)
                        }
                    }
                }
            }
        }
        mArrTop.forEach { key, value ->
            mRevers.put(key, false)
        }
        mArrTop.forEach { key, value ->
            Log.e(TAG, "初始化值为：key=${key} | value = $value")
        }

    }

    override fun onDraw(canvas: Canvas?) {
        repeat(mCount) {
            mRectF.left = it * (mPerWidth + mSpace) * 1.0f
            mRectF.top = getTop(it) * 1.0f
            mRectF.right = (it * mPerWidth + mPerWidth + mSpace * it) * 1.0f
            mRectF.bottom = getBottom(it) * 1.0f
            canvas!!.drawRoundRect(mRectF, mRaidus * 1.0f, mRaidus * 1.0f, mPaint!!)
        }
        postDelayed({
            invalidate()
        }, 20)
    }

    private fun getTop(pos: Int): Int {
        var currHeight = mArrTop[pos]
        Log.e(TAG, "mCurrHeight----top=$currHeight --size=${mArrTop.size()}")
        var needReverse = mRevers[pos]
        if (mMode == 0) {//从中间波动
            if (!needReverse) {
                currHeight -= mWeight
            } else {
                currHeight += mWeight
            }

            if (currHeight >= mMaxHeight) {//需要反转
                currHeight = mMaxHeight
                needReverse = !needReverse
            } else if (currHeight <= 0) {
                needReverse = !needReverse
                currHeight = 0
            }
            mArrTop.put(pos, currHeight)
            mRevers.put(pos, needReverse)
            Log.e(TAG, "mCurrHeight-top=$currHeight")
            return currHeight
        } else {//以bottom为底波动
            if (!needReverse) {
                currHeight -= mWeight
            } else {
                currHeight += mWeight
            }
            if (currHeight >= mMaxHeight) {//需要反转
                currHeight = mMaxHeight
                needReverse = !needReverse
            } else if (currHeight <= 0) {
                needReverse = !needReverse
                currHeight = 0
            }
            mArrTop.put(pos, currHeight)
            mRevers.put(pos, needReverse)
            Log.e(TAG, "mCurrHeight2-top=$currHeight")
            return currHeight
        }
    }

    private fun getBottom(pos: Int): Int {
        if (mMode == 0) {
            return mMaxHeight - mArrTop[pos]
        } else {
            return mMaxHeight
        }
    }


}