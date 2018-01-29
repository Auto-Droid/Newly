package com.autodroid.newly.dialog

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import com.autodroid.newly.R
import com.autodroid.newly.NewlyOnTouchListener


/**
 * Created by sourabhkarkal on 24/01/18.
 */
class Newly private constructor(builder: Build) {

    var context : Activity? =null
    var backgroundColor : String? = null
    var backgroundDrawable : Int? = null
    var textColor  : String? = null
    var text  : String? = null
    var heightOffset  : Int? = null
    var hideOnTouch : Boolean = true
    var popUpHeight  : Int? = null
    var popUpWidth  : Int? = null


    init {
        this.context = builder.context
        this.backgroundColor = builder.backgroundColor
        this.backgroundDrawable = builder.backgroundDrawable
        this.textColor = builder.textColor
        this.text = builder.text
        this.heightOffset = builder.heightOffset
        this.hideOnTouch = builder.hideOnTouch
        this.popUpHeight = builder.popUpHeight
        this.popUpWidth = builder.popUpWidth
    }

    //private constructor(build : Build) : this(build.backgroundColor?)


    class Build(private val _context: Activity){

        private var _backgroundColor: String? = null
        private var _backgroundDrawable : Int? = null
        private var _textColor  : String? = null
        private var _text  : String? = null
        private var _heightOffset  : Int? = null
        private var _hideOnTouch : Boolean = true
        private var _popUpHeight  : Int? = null
        private var _popUpWidth  : Int? = null

        var context: Activity? = null
            get() = this._context

        var backgroundColor: String? =  null
            get() = this._backgroundColor

        var backgroundDrawable: Int? =  null
            get() = this._backgroundDrawable

        var textColor: String? =  null
            get() = this._textColor

        var text: String? =  null
            get() = this._text

        var heightOffset: Int? =  null
            get() = this._heightOffset

        var hideOnTouch: Boolean = false
            get() = this._hideOnTouch

        var popUpHeight: Int? =  null
            get() = this._popUpHeight

        var popUpWidth: Int? =  null
            get() = this._popUpWidth



        fun setBackgroundColor(backgroundColor: String): Build {
            this._backgroundColor = backgroundColor
            return this
        }

        fun setBackgroundDrawable(backgroundDrawable: Int): Build {
            this._backgroundDrawable = backgroundDrawable
            return this
        }

        fun setTextColor(textColor: String): Build {
            this._textColor = textColor
            return this
        }

        fun setText(text : String): Build {
            this._text = text
            return this
        }

        fun setHeightOffset(heightOffset: Int): Build {
            this._heightOffset = heightOffset
            return this
        }

        fun setHideOnTouch(heightOffset: Boolean): Build {
            this._hideOnTouch = hideOnTouch
            return this
        }

        fun setPopUpHeight(popUpHeight: Int): Build {
            this._popUpHeight = popUpHeight
            return this
        }

        fun setPopUpWidth(popUpWidth: Int): Build {
            this._popUpWidth = popUpWidth
            return this
        }


        fun build(): Newly {
            return Newly(this)
        }

    }

    fun show(){
        val dialogBuilder = AlertDialog.Builder(context,com.autodroid.newly.R.style.CustomDialog)
        val inflater = context?.layoutInflater

        val dialogView = inflater?.inflate(R.layout.newly_dialog, null)
        dialogBuilder.setView(dialogView)
        //dialogBuilder.setView(dialogView)

        val tvPopText = dialogView?.findViewById<View>(R.id.tvPopText) as TextView
        val llPopBackground = dialogView?.findViewById<View>(R.id.llPopBackground) as LinearLayout

        //setting values
        tvPopText.setText(text)
        if(textColor!=null) tvPopText.setTextColor(Color.parseColor(textColor));

        if (backgroundDrawable!=null) {
            llPopBackground.setBackgroundResource(backgroundDrawable!!)

        }

        val dBuilder = dialogBuilder.create()

        val window = dBuilder.window
        val wlp = window.getAttributes()
        window.setBackgroundDrawableResource(android.R.color.transparent)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

        val params = llPopBackground.getChildAt(0).layoutParams
        if(popUpHeight!=null) params.height = popUpHeight as Int else params.height = 100
        if(popUpWidth!=null) params.width = popUpWidth as Int else params.width = LinearLayout.LayoutParams.WRAP_CONTENT

        llPopBackground.setLayoutParams(params)

        wlp.gravity = Gravity.TOP
           //x position
        if( heightOffset != null) wlp.y = heightOffset as Int else wlp.y = 200
        window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        window.setAttributes(wlp)

        llPopBackground.setOnClickListener {
            if(hideOnTouch)
                dBuilder.dismiss();

            var newlyTouch = context as NewlyOnTouchListener;
            newlyTouch.onNewlyTouchListener();
        }

        dBuilder.show()
    }



}
