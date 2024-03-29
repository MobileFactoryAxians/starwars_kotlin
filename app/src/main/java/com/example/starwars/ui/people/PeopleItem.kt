package com.example.starwars.ui.people

import android.view.View
import android.widget.TextView
import com.example.starwars.R
import com.example.starwars.data.people.objects.People
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class PeopleItem(val people: People): AbstractItem<PeopleItem.ViewHolder>() {

    override val layoutRes: Int
        get() = R.layout.list_item
    override val type: Int
        get() = R.id.fastadapter_people_item_id

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View): FastAdapter.ViewHolder<PeopleItem>(view) {
        var name: TextView = view.findViewById(R.id.name)
        override fun bindView(item: PeopleItem, payloads: List<Any>) {
            name.text = item.people.name
        }

        override fun unbindView(item: PeopleItem) {
            name.text = null
        }


    }
}