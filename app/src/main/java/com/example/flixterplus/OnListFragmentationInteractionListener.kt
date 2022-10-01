package com.example.flixterplus

/**
 * This interface is used by the [FlixterPlusRecyclerViewAdapter] to ensure
 * it has an appropriate Listener.
 *
 * In this app, it's implemented by [FlixterPlusFragment]
 */
interface OnListFragmentInteractionListener {
    fun onItemClick(item: FlixterItem)
}