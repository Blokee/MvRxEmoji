package com.example.mvrxemoji

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.example.mvrxemoji.utils.EmojiHelper

data class EmojiViewState(
    val emojiList: List<String> = emptyList()
): MvRxState


class EmojiViewModel(initialState: EmojiViewState): BaseMvRxViewModel<EmojiViewState>(initialState, false) {
    fun addEmoji() = setState {
        var mutableEmojiList = emojiList.toMutableList()
        mutableEmojiList.add(EmojiHelper.emoji)
        copy(emojiList = mutableEmojiList)
    }

    fun removeEmoji() = setState {
        var mutableEmojiList = emojiList.toMutableList()
        val index = if (mutableEmojiList.isEmpty()) 0 else (0 until mutableEmojiList.size).random()
        mutableEmojiList.removeAt(index)
        copy(emojiList = mutableEmojiList)
    }

    fun shuffleEmoji() = setState {
        val mutableEmojiList = emojiList.toMutableList()
        mutableEmojiList.shuffle()
        copy(emojiList = mutableEmojiList)
    }
}