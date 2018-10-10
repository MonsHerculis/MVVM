package skipcreative.com.MVVM.service.adatper

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import skipcreative.com.MVVM.service.model.User
import skipcreative.it.MVVM.R


class UserAdapter(val userList : ArrayList<User>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_item, p0, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.name?.text = userList.get(position).name
        holder?.cardView.setOnClickListener {
            Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()

        }
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return userList.size
    }
}
class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name:TextView = itemView.findViewById(R.id.nameRow)
    val cardView: CardView = itemView.findViewById(R.id.cardView)

}

