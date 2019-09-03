package com.example.mvrxemoji.controller

import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.epoxy.Typed2EpoxyController
import com.example.mvrxemoji.component.emojiComponent

class EmojiController: Typed2EpoxyController<List<String>, Boolean>() {

    override fun getSpanSizeLookup(): GridLayoutManager.SpanSizeLookup {
        return object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return 1
            }
        }
    }

    override fun buildModels(emojiList: List<String>, loadingMore: Boolean) {
        emojiList.forEachIndexed { index, emoji ->
            emojiComponent {
                id(emoji.hashCode().toLong())
                emoji(emoji)
            }
        }
    }

}