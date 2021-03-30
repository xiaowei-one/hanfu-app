/*
 * Copyright (C) 2017 skydoves
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.Hanfu.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import com.Hanfu.R;
import com.skydoves.powermenu.CircularEffect;
import com.skydoves.powermenu.MenuAnimation;
import com.skydoves.powermenu.OnMenuItemClickListener;
import com.skydoves.powermenu.PowerMenu;
import com.skydoves.powermenu.PowerMenuItem;

public class PowerMenuUtils {

    public static PowerMenu getHamburgerPowerMenu(
            Context context,
            LifecycleOwner lifecycleOwner,
            OnMenuItemClickListener<PowerMenuItem> onMenuItemClickListener
    ) {
        return new PowerMenu.Builder(context)
                .addItem(new PowerMenuItem("发布文章", true))
                .addItem(new PowerMenuItem("发布视频", false))
                .addItem(new PowerMenuItem("草稿箱", false))
                .setAutoDismiss(true)
                .setLifecycleOwner(lifecycleOwner)
                .setAnimation(MenuAnimation.FADE)
                .setCircularEffect(CircularEffect.BODY)
                .setMenuRadius(10f)
                .setTextSize(12)
                .setTextGravity(Gravity.CENTER)
                .setTextTypeface(Typeface.create("sans-serif-medium", Typeface.BOLD))
                .setSelectedTextColor(Color.WHITE)
                .setMenuColor(0xffeeeeef)
                .setTextColor(ContextCompat.getColor(context, R.color.black))
                .setSelectedMenuColor(ContextCompat.getColor(context, R.color.competitionBack))
                .setSelectedTextColor(ContextCompat.getColor(context, R.color.competitionBackground))
                .setOnMenuItemClickListener(onMenuItemClickListener)
                .setPreferenceName("HamburgerPowerMenu")
                .setInitializeRule(Lifecycle.Event.ON_CREATE, 0)
                .setShowBackground(false)
                .build();
    }
}
