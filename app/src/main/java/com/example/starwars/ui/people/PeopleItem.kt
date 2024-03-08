package com.example.starwars.ui.people

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.starwars.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class PeopleItem: AbstractItem<PeopleItem.ViewHolder>() {
    var name: String? = null

    override val layoutRes: Int
        get() = R.layout.people_item
    override val type: Int
        get() = R.id.fastadapter_people_item_id

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View): FastAdapter.ViewHolder<PeopleItem>(view) {
        var name: TextView = view.findViewById(R.id.peopleName)
        override fun bindView(item: PeopleItem, payloads: List<Any>) {
            name.text = item.name
        }

        override fun unbindView(item: PeopleItem) {
            name.text = null
        }


    }
}