package sa.muraviev.tanknotebook

import android.content.Context
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.view.Menu
import android.view.MenuItem
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import sa.muraviev.tanknotebook.databinding.ActivityMainBinding

//
var coordinatorLayout:CoordinatorLayout?=null
var constraintLayout:ConstraintLayout?=null
var context:Context?=null
//
var cellSize=150

var arrayTank= mutableListOf<Tank>()
var tank:Tank?=null
//ходы
var stepTime=200
var stepDistance=10


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setSupportActionBar(binding.toolbar)

        //val navController = findNavController(R.id.nav_host_fragment_content_main)
        //appBarConfiguration = AppBarConfiguration(navController.graph)
        //setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        coordinatorLayout=findViewById<CoordinatorLayout>(R.id.activity)
        context= coordinatorLayout?.context
        start()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    //override fun onSupportNavigateUp(): Boolean {
        //val navController = findNavController(R.id.nav_host_fragment_content_main)
        //return navController.navigateUp(appBarConfiguration)
        //        || super.onSupportNavigateUp()
   // }
}

fun start(){
    var thread=Thread(
        //запуск потока, есть еще корутины они современней и наверно правильно через них
        //в боте их делал, по сути разница на сколько понял что корутины более оптимально сделаны
        //но в своих мини делах разницы не вижу абсолютно
        //по потокам хз ты сталкивался ли, суть в чем, есть основной поток, именно в нем показывается экран пользователю
        //какие то действия можно делать в других потоках, но рисовать, именно добавлять картинки или гифки можно только
        //в основном потоке, по этому по ходу дела будет запускаться основной, ну если ты будешь смотреть код то увидишь
        {
            Layout().create()
            Tank(Coordinate(4,4)).create()
            Thread.sleep(300)
            Step(0).start()
        }
    )
    thread.start()
}

data class Coordinate(
    var x:Int,
    var y:Int,
){

}