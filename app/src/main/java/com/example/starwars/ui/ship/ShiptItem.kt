package com.example.starwars.ui.ship

import android.view.View
import android.widget.TextView
import com.example.starwars.R
import com.example.starwars.data.ship.objects.Ship
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class ShiptItem(val ship: Ship): AbstractItem<ShiptItem.ViewHolder>() {

    override val layoutRes: Int
        get() = R.layout.list_item
    override val type: Int
        get() = R.id.fastadapter_ship_item_id

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View): FastAdapter.ViewHolder<ShiptItem>(view) {
        var name: TextView = view.findViewById(R.id.name)
        override fun bindView(item: ShiptItem, payloads: List<Any>) {
            name.text = item.ship.name
        }

        override fun unbindView(item: ShiptItem) {
            name.text = null
        }


    }
}