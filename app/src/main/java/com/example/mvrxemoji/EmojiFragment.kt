package com.example.mvrxemoji

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.example.mvrxemoji.controller.EmojiController
import kotlinx.android.synthetic.main.fragment_emoji.*

class EmojiFragment: BaseMvRxFragment() {
    private val viewModel: EmojiViewModel by activityViewModel()
    private val emojiController = EmojiController()

    private val gridLayoutManager: GridLayoutManager by lazy {
        val layout = GridLayoutManager(activity, 7)
        layout
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_emoji, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        gridLayoutManager.spanCount = 7
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.setController(emojiController)

        addEmojiButton.setOnClickListener {
            viewModel.addEmoji()
        }

        removeEmojiButton.setOnClickListener {
            viewModel.removeEmoji()
        }

        shuffleEmojiButton.setOnClickListener {
            viewModel.shuffleEmoji()
        }
    }

    override fun invalidate() = withState(viewModel) { state ->
        emojiController.setData(state.emojiList, false)
    }
}