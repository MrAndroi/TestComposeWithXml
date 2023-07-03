package com.maf.custom.views.testcomposewithxml.navigation

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

object Navigation {
    private const val PACKAGE_NAME = "com.maf.custom.views.testcomposewithxml"
    const val BUNDLE_DATA_KEY = "bundleDataKey"

    fun Activity.navigateToScreen(
        screen: Screen,
        bundle: Bundle? = null,
        navigateAndRemoveFromStack: Boolean = false,
    ) {
        val intent = Intent()
        intent.setClassName(PACKAGE_NAME, "$PACKAGE_NAME${screen.screenName}")
        intent.putExtra(BUNDLE_DATA_KEY, bundle)
        this.startActivity(intent)
        if (navigateAndRemoveFromStack) this.finish()
    }

    fun Context.getActivity(): AppCompatActivity? = when (this) {
        is AppCompatActivity -> this
        is ContextWrapper -> baseContext.getActivity()
        else -> null
    }
}