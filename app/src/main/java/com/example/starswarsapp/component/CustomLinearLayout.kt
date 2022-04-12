package com.example.starswarsapp.component

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.example.starswarsapp.R
import com.example.starswarsapp.databinding.StyleTextLinearBinding

class CustomLinearLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private val binding: StyleTextLinearBinding = StyleTextLinearBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    init {
        initLinearLayout()

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomLinearLayout)
        this.binding.tvTextLinear.text =
            attributes.getString(R.styleable.CustomLinearLayout_textLinear)
        this.binding.tvTextLinear.textSize =
            attributes.getFloat(R.styleable.CustomLinearLayout_size, 22f)
        //this.binding.tvTextLinear.setTextColor(Color.YELLOW)
        //this.binding.tvTextLinear.textAlignment = TEXT_ALIGNMENT_CENTER

        if (attributes.getBoolean(R.styleable.CustomLinearLayout_bold, true)) {
            this.binding.tvTextLinear.setTypeface(Typeface.DEFAULT_BOLD)


        } else {
            this.binding.tvTextLinear.setTypeface(Typeface.DEFAULT)
        }

    }

    /*private lateinit var texto : TextView

    init {
        initLinearLayout()
        initTextView()
    }*/

    fun initLinearLayout() {
        this.orientation = VERTICAL
        val params =
            ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        this.layoutParams = params
        this.setBackground(ContextCompat.getDrawable(context!!, R.drawable.style_linear_layout))

    }
}