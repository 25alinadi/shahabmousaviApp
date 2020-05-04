package com.nbali.alinadi.shahabmousaviapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.daimajia.androidanimations.library.Techniques
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById<MeowBottomNavigation>(R.id.bottom_navigation_main)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        viewModel.getToken()

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
                    if (token.equals("")) {
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

//    private fun setupCurvedBottomNavigation() {
//        bottomNavigation = findViewById<BubbleNavigationLinearView>(R.id.bottom_navigation_main)
//        bottomNavigation.setNavigationChangeListener { view , position ->
//            when(position){
//                3->{
//                    var transaction = supportFragmentManager.beginTransaction()
//                    transaction.replace(R.id.main_fragment_frame, HomeFragment())
//                    transaction.commit()
//                }
//
//                2->{
//                    var transaction = supportFragmentManager.beginTransaction()
//                    transaction.replace(R.id.main_fragment_frame, QuestionFragment())
//                    transaction.commit()
//                }
//
//                1->{
//                    var transaction = supportFragmentManager.beginTransaction()
//                    transaction.replace(R.id.main_fragment_frame, PostFragment())
//                    transaction.commit()
//                }
//
//                0->{
//                    var transaction = supportFragmentManager.beginTransaction()
//                    transaction.replace(R.id.main_fragment_frame, ProfileFragment())
//                    transaction.commit()
//                }
//            }
//        }
//
//    }

    override fun onBackPressed() {
        var fragment = supportFragmentManager.findFragmentByTag("rulesFragment")
        if(fragment != null){
            var transaction =  supportFragmentManager.beginTransaction()
            Utils.customAnimation(findViewById(R.id.main_fragment_frame),animation = Techniques.SlideInLeft)
            transaction.replace(R.id.main_fragment_frame,QuestionFragment())
            transaction.commit()
        }
        super.onBackPressed()
    }
}
