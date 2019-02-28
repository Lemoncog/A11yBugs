package uk.co.bbc.accessibilityissues

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        list_view.adapter = MyAdapter()
        list_view.layoutManager = GridLayoutManager(this, 3)
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title = view as TextView
    }

    class MyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): RecyclerView.ViewHolder {
            val title = TextView(viewGroup.context)
            title.height = 400
            val viewHolder = MyViewHolder(title)

            return viewHolder
        }

        override fun getItemCount(): Int {
            return 12
        }

        val random = Random()

        override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
            val myViewholder = (viewHolder as MyViewHolder)
            myViewholder.title.text = "Hello $position"
            myViewholder.title.setBackgroundColor(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)))
        }
    }
}