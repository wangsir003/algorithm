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
    private var mSpace: Int = 20
    private var mPerWidth: Int = 20
    private var mMaxHeight: Int = 50
    private var mCount: Int = 3
    private var mGroupChild: Int = 3
    private var mMode: Int = 0//mode 0 从中间上下波动 //mode 1 从底部上下波动
    private var mRaidus: Int = 0

    private var mNeedReverse = false

    private var mCurrHeight = mMaxHeight //权值为-2， 顶部底部计算用加减权值的方式
    private var mWidget = if (mMode == 0) {
        mMaxHeight / 2 / mCount / 4
    } else {
        mMaxHeight / mCount / 4
    } //权值为-2， 顶部底部计算用加减权值的方式

    private var mArr = SparseIntArray()
    private var mRevers = SparseBooleanArray()


    private fun init() {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint!!.color = Color.BLACK
        Log.e(TAG, "mCurrHeight-wedget=$mWidget")
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

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        //计算宽高
        setMeasuredDimension(mCount * mPerWidth + mSpace * mCount, mMaxHeight)
    }

    //    val rect = Rect(it * (mPerWidth + mSpace),0,it * mPerWidth + mPerWidth + mSpace * it,mMaxHeight)
    private val mRectF = RectF()

    fun initArr() {
        mArr.clear()
        if (mMode == 0) {
//            mGroupChild
            repeat(mCount) {
                val result = it / mGroupChild
                val perH = mMaxHeight / 2 / mGroupChild //每份高度
                if (result % 2 == 0) {//偶数
                    mArr.put(it, mMaxHeight / 2 - perH * (it % mGroupChild))
                } else {//奇数
                    mArr.put(it, mMaxHeight / 2 - perH * ((mGroupChild - 1) - it % mGroupChild))
                }
            }
        } else {
            repeat(mCount) {
//                val perH = mMaxHeight / mGroupChild //每份高度
//                mArr.put(it, mMaxHeight - perH * (it % (mGroupChild * 2)))

                val result = it / mGroupChild
                val perH = mMaxHeight /(mGroupChild - 1) //每份高度
                //和上一个对比
                if (it <= 1){
                    mArr.put(it, mMaxHeight - perH * (it % (mGroupChild)))
                }else {
                    //判断 是递增还是递减
                    if (mArr[it - 1] < mArr[it - 2]){//递减
                        if (mArr[it - 1] == 0){
                            mArr.put(it,perH)
                        } else if (mArr[it - 1] < perH){
                            mArr.put(it,0)
                        }else{
                            mArr.put(it,mArr[it - 1] - perH)
                        }
                    }else{//递增
                        if (mArr[it - 1] == mMaxHeight){
                            mArr.put(it,mMaxHeight - perH)
                        }/*else if (mMaxHeight - mArr[it - 1] <= perH){
                            mArr.put(it,mMaxHeight)
                        }*/else{
                            mArr.put(it,mArr[it - 1] + perH)
                        }
                    }
                }
            }
        }
        mArr.forEach { key, value ->
            mRevers.put(key, false)
        }

        mArr.forEach { key, value ->
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
        var currHeight = mArr[pos]
        Log.e(TAG, "mCurrHeight----top=$currHeight --size=${mArr.size()}")
        var needReverse = mRevers[pos]
        if (mMode == 0) {//从中间波动
//            mCurrHeight -= pos * mWidget
            if (!needReverse) {
                currHeight -= mWidget
            } else {
                currHeight += mWidget
            }

            if (currHeight >= mMaxHeight) {//需要反转
                currHeight = mMaxHeight
                needReverse = !needReverse
            } else if (currHeight <= 0) {
                needReverse = !needReverse
                currHeight = 0
            }
            mArr.put(pos, currHeight)
            mRevers.put(pos, needReverse)
            Log.e(TAG, "mCurrHeight-top=$currHeight")
            return currHeight
        } else {//以bottom为底波动
//            currHeight -= mWidget

            if (!needReverse) {
                currHeight -= mWidget
            } else {
                currHeight += mWidget
            }

            if (currHeight >= mMaxHeight) {//需要反转
                currHeight = mMaxHeight
                needReverse = !needReverse
            } else if (currHeight <= 0) {
                needReverse = !needReverse
                currHeight = 0
            }

//            if (needReverse && currHeight < 0) {
//                currHeight += mWidget
//                Log.e(TAG, "mCurrHeight-top0=${mCurrHeight + mWidget}")
//            } else {
//                Log.e(TAG, "mCurrHeight-top1=$mCurrHeight")
//                if (currHeight <= 0) {
//                    needReverse = true
//                }
//            }
            mArr.put(pos, currHeight)
            mRevers.put(pos, needReverse)
            return currHeight
        }
    }

    private fun getBottom(pos: Int): Int {
        if (mMode == 0) {
//            Log.e(TAG,"mCurrHeight-bottom=$mCurrHeight")
            Log.e(TAG, "mCurrHeight=${mCurrHeight}---bottom=$${mMaxHeight - mCurrHeight}")
            return mMaxHeight - mArr[pos]
        } else {
            return mMaxHeight
        }
    }


}