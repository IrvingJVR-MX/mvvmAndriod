package com.example.mvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.adapter.RecyclerViewAdapter
import com.example.mvvm.models.RecyclerList
import com.example.mvvm.viewmodel.RecyclerListViewModel

class RecyclerListFragment : Fragment() {
    private  lateinit var recyclerAdapter: RecyclerViewAdapter
    private  val mainviewModel : RecyclerListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recycler_list, container, false)
        val btnSortbyId =view.findViewById<Button>(R.id.btn_sort)

        btnSortbyId.setOnClickListener{
            mainviewModel.sortById()
        }

        initAdapter(view)
        initViewModel()
        return view
    }

    private fun initAdapter(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decoration = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)
        recyclerAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerAdapter
    }

    private fun initViewModel (){
        mainviewModel.getRecyclerListObserver().observe(viewLifecycleOwner, Observer<ArrayList<RecyclerList>>{ currentArray ->
       if(currentArray != null){
           recyclerAdapter.setUpdatedData(currentArray)
       } else {
           Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
       }
   })
        mainviewModel.makeApiCall()

    }

    companion object {
        @JvmStatic
        fun newInstance() = RecyclerListFragment()
    }
}