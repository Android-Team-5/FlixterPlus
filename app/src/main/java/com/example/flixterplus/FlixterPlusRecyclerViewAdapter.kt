package com.example.flixterplus

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * [RecyclerView.Adapter] that can display a [BestSellerBook] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class FlixterPlusRecyclerViewAdapter (
    private val items: List<FlixterItem>,
    private val fListener: OnListFragmentInteractionListener?
    )
    : RecyclerView.Adapter<FlixterPlusRecyclerViewAdapter.ItemViewHolder>()
    {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_flixter_item, parent, false)
            return ItemViewHolder(view)
        }

        /**
         * This inner class lets us refer to all the different View elements
         * (Yes, the same ones as in the XML layout files!)
         */
        inner class ItemViewHolder(val fView: View) : RecyclerView.ViewHolder(fView) {
            var fItem: FlixterItem? = null
            val fTitle: TextView = fView.findViewById<View>(R.id.item_title) as TextView
            val fDescription: TextView = fView.findViewById<View>(R.id.item_description) as TextView
            val fPoster: ImageView = fView.findViewById<View>(R.id.item_image) as ImageView
        }

        /**
         * This lets us "bind" each Views in the ViewHolder to its' actual data!
         */
        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val item = items[position]

            holder.fItem = item
            holder.fTitle.text = item.title
            holder.fDescription.text = item.description

            Glide.with(holder.fView)
                .load(item.fLink)
                .centerInside()
                .into(holder.fPoster)

            holder.fView.setOnClickListener {
                holder.fItem?.let { item ->
                    fListener?.onItemClick(item)
                }
            }
        }

        /**
         * Remember: RecyclerView adapters require a getItemCount() method.
         */
        override fun getItemCount(): Int {
            return items.size
        }
    }