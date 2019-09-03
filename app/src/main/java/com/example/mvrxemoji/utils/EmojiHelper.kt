package com.example.mvrxemoji.utils

object EmojiHelper {
    private val emojis = 0x1F600..0x1F64F
    val emoji: String
        get() = String(Character.toChars(emojis.random()))
}