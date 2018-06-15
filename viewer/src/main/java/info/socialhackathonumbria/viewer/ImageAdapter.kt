package info.socialhackathonumbria.viewer

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * This class is part of Codelab project.
 * Created by riccardopizzoni on 15/06/18.
 * Copyright © 2018 INDAPP
 * info@indapp.it
 */

class ImageAdapter(fm: FragmentManager?, val urls: Array<String?>)
    : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment =
            ImageFragment.newInstance(position, urls[position])

    override fun getCount(): Int = urls.size

}