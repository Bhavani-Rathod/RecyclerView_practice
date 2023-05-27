package com.bhavani.recyclerview_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class MainActivity : AppCompatActivity() {

      private lateinit var searchView: SearchView
      private lateinit var recyclerView: RecyclerView
      private var itemList = ArrayList<Items>()
      private lateinit var adapter: AnimeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView = findViewById(R.id.searchView)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = AnimeAdapter(itemList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    private fun filterList(query:String?){

            if (query!=null){
                val filteredList = ArrayList<Items>()
                for (i in itemList){
                    if (i.title.lowercase(Locale.ROOT).contains(query)){
                        filteredList.add(i)
                    }
                    if (filteredList.isEmpty()){
                        Toast.makeText(this,"No Data Found",Toast.LENGTH_SHORT).show()
                    }else{
                        adapter.setFilteredList(filteredList)
                    }
                }
            }
    }

    private fun addDataToList(){
        itemList.add(Items(R.drawable.naruto,"Naruto"))
        itemList.add(Items(R.drawable.taki,"Taki"))
        itemList.add(Items(R.drawable.mikasa,"Mikasa"))
        itemList.add(Items(R.drawable.ichigo,"Ichigo"))
        itemList.add(Items(R.drawable.mitsuha,"Mitsuha"))
    }
}