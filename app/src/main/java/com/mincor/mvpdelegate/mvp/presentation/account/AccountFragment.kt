package com.mincor.mvpdelegate.mvp.presentation.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mincor.mvpdelegate.R

class AccountFragment : Fragment(), IAccountContract.IView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun showHello() {
        println("HELLO FROM ACCOUNT FRAGMENT")
    }
}
