package com.example.purplegamingmenu

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : Activity() {

private val purple = Color.rgb(170, 80, 255)
private val background = Color.rgb(18, 14, 28)

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    window.statusBarColor = background
    window.navigationBarColor = background

    val root = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        setPadding(24, 28, 24, 24)
        setBackgroundColor(background)
    }

    val scroll = ScrollView(this)
    scroll.addView(root)

    val title = TextView(this).apply {
        text = "PURPLE GAMING"
        textSize = 27f
        setTextColor(purple)
        typeface = Typeface.DEFAULT_BOLD
        gravity = Gravity.CENTER
    }
    root.addView(title)

    val subtitle = TextView(this).apply {
        text = "GAMING MENU  •  VERSION 1.0"
        textSize = 12f
        setTextColor(Color.LTGRAY)
        gravity = Gravity.CENTER
        setPadding(0, 8, 0, 28)
    }
    root.addView(subtitle)

    addOption(root, "Performance Mode")
    addOption(root, "Gaming Overlay")
    addOption(root, "Custom Interface")
    addOption(root, "Save Settings")

    val info = TextView(this).apply {
        text = "Purple Gaming Menu\\nInterface demo — no game modification"
        textSize = 13f
        setTextColor(Color.LTGRAY)
        gravity = Gravity.CENTER
        setPadding(0, 28, 0, 12)
    }
    root.addView(info)

    setContentView(scroll)
}

private fun addOption(parent: LinearLayout, label: String) {
    val button = Button(this).apply {
        text = "$label  •  OFF"
        setTextColor(Color.WHITE)
        setBackgroundColor(Color.rgb(75, 35, 110))

        setOnClickListener {
            val enabled = tag == true
            tag = !enabled
            text = "$label  •  ${if (enabled) "OFF" else "ON"}"
            setBackgroundColor(
                if (enabled) Color.rgb(75, 35, 110) else purple
            )
        }
    }

    parent.addView(
        button,
        LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ).apply {
            bottomMargin = 12
        }
    )
}

}
