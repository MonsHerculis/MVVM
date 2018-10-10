package skipcreative.com.MVVM.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import skipcreative.com.MVVM.service.adatper.UserAdapter

import skipcreative.it.MVVM.R
import skipcreative.com.MVVM.service.model.User
import skipcreative.com.MVVM.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {


    private var userViewModel: UserViewModel? = null
    private var userList: ArrayList<User>? = null
    private lateinit var adapter: UserAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        findViewById<View>(R.id.btnContinua).setOnClickListener {
            userList!![0].name = "CIRO"
            userViewModel!!.userObservable.value = userList
        }

    }


    override fun onResume() {
        super.onResume()

        userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        observeViewModel(userViewModel!!)



    }

    private fun observeViewModel(viewModel: UserViewModel) {
        // Update the list when the data changes
        viewModel.userObservable.observe(this, Observer { listaUser ->
            if (listaUser != null) {
                userList = listaUser as ArrayList<User>?
                //val tv = findViewById<TextView>(R.id.tvText)
                //tv.text = listaUser[0].name
                adapter = UserAdapter(listaUser!!, this)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = adapter
            }
        })
    }
}
