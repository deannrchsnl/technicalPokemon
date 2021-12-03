package com.nrchsnl.technicaltest

import android.content.Context
import android.os.Bundle
import com.nrchsnl.technicaltest.helper.extensions.navigatorImplicit

object MainEnvironment {
    object ConstOther {
        // TODO add uncategories const in here
        const val HTTP_STRING = "http"

        const val SNACKBAR_TIMER_SHOWING_DEFAULT = 2000

    }

    object routeNavigation{
        private const val PACKAGE_DETAIL_PAGE = "com.nrchsnl.technicaltest.ui.detail.DetailActivity"
        private const val PACKAGE_FAVORITE_PAGE = "com.nrchsnl.technicaltest.ui.favorite.FavoriteActivity"
        private const val PACKAGE_IMAGE_PAGE = "com.nrchsnl.technicaltest.ui.image.ImageActivity"

        /**
         * detail
         */
        fun openDetailPage(context: Context, bundle: Bundle) {
            context.navigatorImplicit(context.packageName, PACKAGE_DETAIL_PAGE, bundle)
        }
        /**
         * genre
         */
        fun openFavoritePage(context: Context) {
            context.navigatorImplicit(context.packageName, PACKAGE_FAVORITE_PAGE)
        }
        /**
         * genre
         */
        fun openImagePage(context: Context, bundle: Bundle) {
            context.navigatorImplicit(context.packageName, PACKAGE_IMAGE_PAGE, bundle)
        }
    }
}