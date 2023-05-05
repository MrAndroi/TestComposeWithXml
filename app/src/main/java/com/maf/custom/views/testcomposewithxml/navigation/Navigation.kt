package com.maf.custom.views.testcomposewithxml.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle

object Navigation {
    private const val PACKAGE_NAME = "com.maf.custom.views.testcomposewithxml"
    const val BUNDLE_DATA_KEY = "bundleDataKey"

    fun navigateToScreen(screen: Screen, context: Context, bundle: Bundle? = null) {
        val intent = Intent()
        intent.setClassName(PACKAGE_NAME, "$PACKAGE_NAME${screen.screenName}")
        intent.putExtra(BUNDLE_DATA_KEY, bundle)
        context.startActivity(intent)
    }

}