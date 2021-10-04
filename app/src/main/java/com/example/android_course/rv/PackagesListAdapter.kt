package com.example.android_course.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_course.R

class PackagesListAdapter(
    packages: List<ListItem>
) : RecyclerView.Adapter<PackagesListAdapter.PackageViewHolder>() {

    private var packages: List<ListItem> = packages

    fun setPackages(packages: List<ListItem>) {
        this.packages = packages
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when (packages[position]) {
            is Package -> PACKAGE
            is Title -> TITLE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_package, parent, false)
            .let(::PackageViewHolder)
    }

    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) {
//        holder.text = packages[position].name
    }

    private fun convert(a: Any): Int {
        return when (a) {
            is String -> 0
            is Int -> 1
            else -> -1
        }
    }

    override fun getItemCount(): Int = packages.size

    sealed class ListItem

    data class Title(
        val text: String
    ) : ListItem()

    data class Package(
        val name: String
    ) : ListItem()

    class PackageViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        var text: String
            set(value) {
                (view as TextView).text = value
            }
            get() = (view as TextView).text.toString()
    }

    companion object {
        const val TITLE = 42
        const val PACKAGE = 43
    }
}