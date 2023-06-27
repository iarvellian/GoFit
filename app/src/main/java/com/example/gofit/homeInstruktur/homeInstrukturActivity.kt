package com.example.gofit.homeInstruktur

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.gofit.R
import com.example.gofit.databinding.ActivityHomeInstrukturBinding
import com.example.gofit.homeInstruktur.izinInstruktur.izinInstrukturFragment
import com.example.gofit.homeInstruktur.presensiMemberKelas.presensiMemberFragment
import com.example.gofit.homeInstruktur.profileInstruktur.profileInstrukturFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class homeInstrukturActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeInstrukturBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeInstrukturBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = homeInstrukturFragment()
        val secondFragment = izinInstrukturFragment()
        val thirdFragment = presensiMemberFragment()
        val fourthFragment = profileInstrukturFragment()

        val bundle = intent.extras
        val id_user = bundle?.getString("id_user")

        val fragmentBundle = Bundle()
        fragmentBundle.putString("id_user", id_user)

        val navView: BottomNavigationView = binding.bottomNavigationInstruktur

        navView.setOnNavigationItemSelectedListener {
            if (it.itemId == R.id.nav_home_instruktur) {
                setCurrentFragment(firstFragment)
            } else if (it.itemId == R.id.nav_izinInstruktur) {
                secondFragment.arguments = fragmentBundle
                setCurrentFragment(secondFragment)
            } else if (it.itemId == R.id.nav_presensiMemberKelas) {
                thirdFragment.arguments = fragmentBundle
                setCurrentFragment(thirdFragment)
            } else if (it.itemId == R.id.nav_profileInstruktur) {
                fourthFragment.arguments = fragmentBundle
                setCurrentFragment(fourthFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerInstruktur,fragment)
            commit()
        }
    }
}