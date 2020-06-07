package com.scwang.smartrefresh.horizontal.demo.fragment

import android.graphics.drawable.Animatable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scwang.smartrefresh.horizontal.demo.R
import com.scwang.smartrefresh.layout.api.RefreshHeader
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener
import kotlinx.android.synthetic.main.fragment_practice_pager2.*

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */
class PracticePager2Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_practice_pager2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setNavigationOnClickListener {
            activity?.finish()
        }

        refreshLayout.setEnableOverScrollBounce(false)
        refreshLayout.setOnMultiPurposeListener(object : SimpleMultiPurposeListener() {
            override fun onHeaderStartAnimator(h: RefreshHeader?, footerHeight: Int, maxDragHeight: Int) {
                (header.drawable as? Animatable)?.start()
            }

            override fun onHeaderFinish(h: RefreshHeader?, success: Boolean) {
                (header.drawable as? Animatable)?.stop()
            }
        })

        refreshLayout.setOnRefreshListener {
            refreshLayout.finishRefresh(1500)
        }
        refreshLayout.setOnLoadMoreListener {
            refreshLayout.finishLoadMore(1000)
        }
    }

}