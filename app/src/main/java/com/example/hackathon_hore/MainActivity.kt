package com.example.hackathon_hore

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.denzcoskun.imageslider.models.SlideModel
import com.example.hackathon_hore.Api.ApiConfig
import com.example.hackathon_hore.Constant.hasilPencarian
import com.example.hackathon_hore.Constant.kategori
import com.example.hackathon_hore.Model.HasilPencarian
import com.example.hackathon_hore.Model.Kategori
import com.example.hackathon_hore.Model.Response
import com.example.hackathon_hore.databinding.ActivityMainBinding
import retrofit2.Call
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)
        binding.appBarMain.toolbar.navigationIcon = AppCompatResources.getDrawable(this, R.drawable.hamburger)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,R.id.nav_berita, R.id.nav_tentang,R.id.nav_kontak
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun onItemCategoriesGetClicked(){
        val intent = Intent(this, CategoriesClickedActivity::class.java)
        startActivity(intent)
    }
    fun onItemGetClicked(item: HasilPencarian){
        intent = Intent(this, ListTokoActivity::class.java)
        intent.putExtra(ListTokoActivity.EXTRA_INFO, item)
        startActivity(intent)
    }
}