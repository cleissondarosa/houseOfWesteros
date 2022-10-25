package com.example.houseofdragon

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private lateinit var rvMain: RecyclerView
    private lateinit var myAdapter: MyAdapter
    private lateinit var houseList: ArrayList<housesWesteros>
    private lateinit var db: FirebaseFirestore



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvMain = findViewById(R.id.rv_main)
        rvMain.layoutManager = GridLayoutManager(this,2)
        rvMain.setHasFixedSize(true)
        houseList = arrayListOf()
        myAdapter = MyAdapter(houseList, this)
        rvMain.adapter = myAdapter
////
        myAdapter.onItemClick = {
            val intent = Intent(this, secondActivity::class.java)
            startActivity(intent)

        }
        EventChangeListener()


    }

    private fun EventChangeListener() {


        db = FirebaseFirestore.getInstance()
        db.collection("houses")
            .addSnapshotListener { value, error ->
                if (error != null) {

                    Log.d("error", "error")

                }
                for (dc: DocumentChange in value?.documentChanges!!) {
                    if (dc.type == DocumentChange.Type.ADDED) {
                        houseList.add(dc.document.toObject(housesWesteros::class.java))
                    }
                }
                myAdapter.notifyDataSetChanged()
            }
    }

}

