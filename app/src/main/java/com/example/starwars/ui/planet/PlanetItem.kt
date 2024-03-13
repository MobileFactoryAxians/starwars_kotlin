package com.example.starwars.ui.planet

import android.view.View
import android.widget.TextView
import com.example.starwars.R
import com.example.starwars.data.planet.objects.Planet
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class PlanetItem(val planet: Planet): AbstractItem<PlanetItem.ViewHolder>() {

    override val layoutRes: Int
        get() = R.layout.list_item
    override val type: Int
        get() = R.id.fastadapter_planet_item_id

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View): FastAdapter.ViewHolder<PlanetItem>(view) {
        var name: TextView = view.findViewById(R.id.name)
        override fun bindView(item: PlanetItem, payloads: List<Any>) {
            name.text = item.planet.name
        }

        override fun unbindView(item: PlanetItem) {
            name.text = null
        }


    }
}