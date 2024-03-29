package com.example.androidmasterclass.recyclerview
//
//import android.graphics.Color
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import androidx.databinding.DataBindingUtil
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.androidmasterclass.R
//import com.example.androidmasterclass.databinding.ActivityRecyclerViewDemo1Binding
//
//class RecyclerViewDemo1 : AppCompatActivity() {
//    private lateinit var binding: ActivityRecyclerViewDemo1Binding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view_demo1)
//
//        binding.recyclerView.setBackgroundColor(Color.YELLOW)
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//
//        val fruits = listOf(
//            Fruit("Mango", "Alberto"),
//            Fruit("Apple", "Benito"),
//            Fruit("Banana", "Carmen"),
//            Fruit("Papaya", "David"),
//            Fruit("Lemon", "Esteban"),
//            Fruit("Pear", "Fernando"),
//            Fruit("Orange", "Gerardo")
//        )
//        binding.recyclerView.adapter = MyRecyclerViewAdapter(fruits, {selectedFruit: Fruit->getItemClicked(selectedFruit)})
//    }
//
//    private fun getItemClicked(fruit: Fruit) {
//        Toast.makeText(
//            this@RecyclerViewDemo1,
//            "Supplier name is ${fruit.supplier}",
//            Toast.LENGTH_LONG
//        ).show()
//    }
//}