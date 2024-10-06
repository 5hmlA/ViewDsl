package osp.sparkj.viewdsl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.preference.PreferenceFragmentCompat
import osp.sparkj.dsl.preference.category
import osp.sparkj.dsl.preference.checkBox
import osp.sparkj.dsl.preference.screen
import osp.sparkj.dsl.preference.seekBar
import osp.sparkj.dsl.preference.switch
import osp.sparkj.dsl.preference.switchCompat

class MyPreferenceFragmentCompat : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        screen {
            category("title") {
                switch("te", "标题", "描述", R.drawable.ic_launcher_background)
                switchCompat("te3", "标题", "描述", R.drawable.ic_launcher_background)
            }
            checkBox("s7s","cb"){
                println("0000000000   $isChecked")
            }
            seekBar("s00s","cb3"){
                println("0000000000   $value")
            }

            category("title") {
                checkBox("s7s","cb"){
                    println("0000000000   $isChecked")
                }
                seekBar("s00s","cb3"){
                    println("0000000000   $value")
                }
            }
            //switchCompat("te", "标题", "描述", R.drawable.ic_launcher_background)
        }
    }
}

class PreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.commit {
            val myPreferenceFragmentCompat: androidx.fragment.app.Fragment = MyPreferenceFragmentCompat()
            replace(android.R.id.content, myPreferenceFragmentCompat)
        }
    }
}

