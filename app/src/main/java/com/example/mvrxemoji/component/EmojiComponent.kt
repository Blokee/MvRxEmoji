package com.example.mvrxemoji.component

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.example.mvrxemoji.R
import kotlinx.android.synthetic.main.component_emoji.view.*

@ModelView(autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT)
class EmojiComponent @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet?= null,
    defStyle:Int = 0
): RelativeLayout(context, attributeSet, defStyle) {

    init {
        View.inflate(context, R.layout.component_emoji, this)
    }

    @TextProp
    fun setEmoji(emoji: CharSequence) {
        emojiTextView.text = emoji
    }

}