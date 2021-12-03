package com.nrchsnl.technicaltest.helper.extensions

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.nrchsnl.technicaltest.MainEnvironment.ConstOther.SNACKBAR_TIMER_SHOWING_DEFAULT
import com.nrchsnl.technicaltest.R
import com.nrchsnl.technicaltest.data.remote.model.Result
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.text.SimpleDateFormat


fun View.showSnackbarDefault(
    message: String,
    duration: Int = 0
) {


    val finalDuration = if (duration == 0) {
        SNACKBAR_TIMER_SHOWING_DEFAULT
    } else {
        duration
    }

    Snackbar.make(this, message, finalDuration).show()
}


fun getAPIKey() : String{
    return "78e8426278269a9f15963322ae7afdaa"
}

fun getBaseUrlImage(image: String): String {
    return "https://image.tmdb.org/t/p/original$image"
}

fun getAPIKeyYoutube() : String {
    return "AIzaSyCWqDp6KZqm-uoG5m4gPz12kPpEB91AvTE"
}


fun ImageView.setImageUrl(url: Any){
    Glide.with(this)
        .load(url)
        .into(this)
}
fun ImageView.setImageGif(url: Any){
    Glide.with(this)
        .asGif()
        .load(url)
        .into(this)
}


fun Context.navigatorImplicit(
    activityPackage: String,
    className: String,
    extras: Bundle = Bundle(),
    clearStack: Boolean = false,
    option: Bundle? = null) {
    val intent = Intent()
    try {
        intent.setClassName(activityPackage, className).putExtras(extras)

        if (clearStack) {
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        if (option != null) {
            startActivity(intent, option)
        } else {
            startActivity(intent)
        }

    } catch (e: Exception) {
        Toast.makeText(this, "Activity not found", Toast.LENGTH_SHORT).show()
        e.printStackTrace()
    }
}

fun changeFormatDate(date : String) : String{
    var parser = SimpleDateFormat("yyyy-MM-dd")
    var formater = SimpleDateFormat("dd MMM yyyy")
    return formater.format(parser.parse(date))
}

fun LinearLayout.changeBackgroundByType(type:String) {
    var res = resources.getColor(R.color.transparant)
    when (type) {
        "bug" -> {
            res = resources.getColor(R.color.bug)
        }
        "dark" -> {
            res = resources.getColor(R.color.dark)
        }
        "dragon" -> {
            res = resources.getColor(R.color.dragon)
        }
        "electric" -> {
            res = resources.getColor(R.color.electric)
        }
        "fairy" -> {
            res = resources.getColor(R.color.fairy)
        }
        "fighting" -> {
            res = resources.getColor(R.color.fighting)
        }
        "fire" -> {
            res = resources.getColor(R.color.fire)
        }
        "flying" -> {
            res = resources.getColor(R.color.flying)
        }
        "ghost" -> {
            res = resources.getColor(R.color.ghost)
        }
        "grass" -> {
            res = resources.getColor(R.color.grass)
        }
        "ground" -> {
            res = resources.getColor(R.color.ground)
        }
        "ice" -> {
            res = resources.getColor(R.color.ice)
        }
        "normal" -> {
            res = resources.getColor(R.color.normal)
        }
        "poison" -> {
            res = resources.getColor(R.color.poison)
        }
        "psychic" -> {
            res = resources.getColor(R.color.psychic)
        }
        "rock" -> {
            res = resources.getColor(R.color.rock)
        }
        "steel" -> {
            res = resources.getColor(R.color.steel)
        }
        "water" -> {
            res = resources.getColor(R.color.water)
        }
    }
    this.setBackgroundColor(res)
}

    fun ImageView.setImagebyType(types: String) {
        var res: Drawable = resources.getDrawable(R.drawable.placeholder)
        when (types) {
            "bug" -> {
                res = resources.getDrawable(R.drawable.type_bug)
            }
            "dark" -> {
                res = resources.getDrawable(R.drawable.type_dark)
            }
            "dragon" -> {
                res = resources.getDrawable(R.drawable.type_dragon)
            }
            "electric" -> {
                res = resources.getDrawable(R.drawable.type_electric)
            }
            "fairy" -> {
                res = resources.getDrawable(R.drawable.type_fairy)
            }
            "fighting" -> {
                res = resources.getDrawable(R.drawable.type_fighting)
            }
            "fire" -> {
                res = resources.getDrawable(R.drawable.type_fire)
            }
            "flying" -> {
                res = resources.getDrawable(R.drawable.type_flying)
            }
            "ghost" -> {
                res = resources.getDrawable(R.drawable.type_ghost)
            }
            "grass" -> {
                res = resources.getDrawable(R.drawable.type_grass)
            }
            "ground" -> {
                res = resources.getDrawable(R.drawable.type_ground)
            }
            "ice" -> {
                res = resources.getDrawable(R.drawable.type_ice)
            }
            "normal" -> {
                res = resources.getDrawable(R.drawable.type_normal)
            }
            "poison" -> {
                res = resources.getDrawable(R.drawable.type_poison)
            }
            "psychic" -> {
                res = resources.getDrawable(R.drawable.type_psychic)
            }
            "rock" -> {
                res = resources.getDrawable(R.drawable.type_rock)
            }
            "steel" -> {
                res = resources.getDrawable(R.drawable.type_steel)
            }
            "water" -> {
                res = resources.getDrawable(R.drawable.type_water)
            }
        }

        Glide.with(this)
            .load(res)
            .into(this)

    }