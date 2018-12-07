package skipcreative.com.MVVM.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.button.MaterialButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import skipcreative.com.MVVM.service.adatper.UserAdapter
import skipcreative.com.MVVM.service.model.User
import skipcreative.com.MVVM.viewmodel.LedViewModel
import skipcreative.com.MVVM.viewmodel.UserViewModel
import skipcreative.it.MVVM.R

class LedActivity : AppCompatActivity() {


    private var userViewModel: UserViewModel? = null
    /*private var userViewModel: UserViewModel? = null
    private var userList: ArrayList<User>? = null
    private lateinit var adapter: UserAdapter
    private lateinit var recyclerView: RecyclerView*/


    private var ledOn: Button? = null
    private var ledOff: Button? = null
    private var tvLedStatus: TextView? = null
    private var ledViewModel: LedViewModel? = null
    private var ledString: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvLedStatus = findViewById<TextView>(R.id.ledStatus)
        ledOff = findViewById<Button>(R.id.ledOff)
        ledOn = findViewById<Button>(R.id.ledOn)


        /*findViewById<View>(R.id.ledOn).setOnClickListener {
            userList!![0].name = "CIRO"
            userViewModel!!.userObservable.value = userList
        }*/

        findViewById<Button>(R.id.ledOff).setOnClickListener {
            ledString = "OFF"
            ledViewModel!!.ledObservable.value = ledString
        }

        findViewById<Button>(R.id.ledOn).setOnClickListener {
            ledString = "On"
            ledViewModel!!.ledObservable.value = ledString
        }

    }


    override fun onResume() {
        super.onResume()

       /* userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        observeViewModel(userViewModel!!)*/

        ledViewModel = ViewModelProviders.of(this).get(LedViewModel::class.java)
        observeViewModel(ledViewModel!!)



    }

    private fun observeViewModel(viewModel: LedViewModel) {
        // Update the list when the data changes
        viewModel.ledObservable.observe(this, Observer { led ->
            if (led != null) {
                Toast.makeText(this, "QUI", Toast.LENGTH_LONG).show()
            }
        })
    }
}
