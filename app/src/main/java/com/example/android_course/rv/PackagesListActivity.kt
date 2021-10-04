package com.example.android_course.rv

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_course.R

class PackagesListActivity: AppCompatActivity() {

    private var packagesCounter = 1
    private lateinit var adapter: PackagesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_packages_list)
        findViewById<Button>(R.id.more_packages).setOnClickListener {
            (0..++packagesCounter).map { getPackages() }.flatten()
                .let(adapter::setPackages)
        }
        findViewById<RecyclerView>(R.id.rv).apply {
            layoutManager = LinearLayoutManager(this@PackagesListActivity)
            this@PackagesListActivity.adapter = PackagesListAdapter(getPackages())
            adapter = this@PackagesListActivity.adapter
        }
    }

    private fun getPackages(): List<PackagesListAdapter.Package> =
        packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
            .mapNotNull { it.name?.let(PackagesListAdapter::Package) }

}