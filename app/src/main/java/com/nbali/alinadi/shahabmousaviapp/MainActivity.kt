package com.nbali.alinadi.shahabmousaviapp

import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.nbali.alinadi.shahabmousaviapp.broadcast.ConnectivityBroadcastReceiver
import com.nbali.alinadi.shahabmousaviapp.home.HomeFragment
import com.nbali.alinadi.shahabmousaviapp.post.PostFragment
import com.nbali.alinadi.shahabmousaviapp.profile.LoginFragment
import com.nbali.alinadi.shahabmousaviapp.profile.ProfileFragment
import com.nbali.alinadi.shahabmousaviapp.profile.ProfileViewModel
import com.nbali.alinadi.shahabmousaviapp.question.QuestionFragment
import com.nbali.alinadi.shahabmousaviapp.utils.Utils

class MainActivity : AppCompatActivity() {

    lateinit var viewModel:ProfileViewModel
    lateinit var bottomNavigation: MeowBottomNavigation
    var backPressedOnce = false
    private lateinit var connectivityBroadcastReceiver : ConnectivityBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById<MeowBottomNavigation>(R.id.bottom_navigation_main)
        var splashScreen = findViewById<RelativeLayout>(R.id.rel_main_splash)
        var disconnected = findViewById<LinearLayout>(R.id.ll_home_disconnected)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        viewModel.getToken()
        Utils.changeStatusBarColor(this)

        Handler().postDelayed({
            Utils.customAnimation(findViewById(R.id.rel_main_splash), animation = Techniques.SlideOutUp)
            splashScreen.visibility = View.GONE
        },3000)

        connectivityBroadcastReceiver = ConnectivityBroadcastReceiver {
            if(!it){
                disconnected.visibility = View.VISIBLE
            }else{
                disconnected.visibility = View.GONE
                bottomNavigation.show(4)
                var transaction = supportFragmentManager.beginTransaction()
                Utils.customAnimation(findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
                transaction.replace(R.id.main_fragment_frame, HomeFragment())
                transaction.commit()
            }
        }

        setupCurvedBottomNavigation()

        var transaction = supportFragmentManager.beginTransaction()
        Utils.customAnimation(findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
        transaction.replace(R.id.main_fragment_frame, HomeFragment())
        transaction.commit()
    }

    private fun setupCurvedBottomNavigation() {


        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_profile_black))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.ic_post_black))
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_question_black))
        bottomNavigation.add(MeowBottomNavigation.Model(4, R.drawable.ic_home_black_24dp))

        bottomNavigation.show(4, true)
        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                4->{
                    var transaction = supportFragmentManager.beginTransaction()
                    Utils.customAnimation(findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
                    transaction.replace(R.id.main_fragment_frame, HomeFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()
                }

                3->{
                    var token = viewModel.getToken()
                    if (token == "") {
                        var transaction = supportFragmentManager.beginTransaction()
                        Utils.customAnimation(findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
                        transaction.replace(R.id.main_fragment_frame, LoginFragment("question"))
                        transaction.addToBackStack(null)
                        transaction.commit()
                    }else{
                        var transaction = supportFragmentManager.beginTransaction()
                        Utils.customAnimation(findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
                        transaction.replace(R.id.main_fragment_frame, QuestionFragment())
                        transaction.addToBackStack(null)
                        transaction.commit()
                    }
                }

                2->{
                    var transaction = supportFragmentManager.beginTransaction()
                    Utils.customAnimation(findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
                    transaction.replace(R.id.main_fragment_frame, PostFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()
                }

                1->{
                    var transaction = supportFragmentManager.beginTransaction()
                    Utils.customAnimation(findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInRight)
                    transaction.replace(R.id.main_fragment_frame, ProfileFragment())
                    transaction.addToBackStack(null)
                    transaction.commit()
                }
            }
        }

    }

    override fun onStart() {
        super.onStart()
        this.registerReceiver(connectivityBroadcastReceiver, IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"))
    }

    override fun onBackPressed() {
        var backStack = supportFragmentManager.backStackEntryCount
        if(backStack <= 1){
            if(bottomNavigation.isShowing(4)){
                if(backPressedOnce){
                    super.onBackPressed()
                    return
                }else{
                    backPressedOnce = true
                    Toast.makeText(this,"برای خروج دوباره دکمه بازگشت را بزنید",Toast.LENGTH_SHORT).show()
                    Handler().postDelayed({
                        backPressedOnce = false
                    },2000)
                }
            }else{
                bottomNavigation.show(4)
                var transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.main_fragment_frame, HomeFragment())
                transaction.commit()
            }
        }else{
            super.onBackPressed()
        }
    }

    override fun onStop() {
        super.onStop()
        this.unregisterReceiver(connectivityBroadcastReceiver)
    }
}
