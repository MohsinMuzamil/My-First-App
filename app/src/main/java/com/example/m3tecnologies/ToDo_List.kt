package com.example.m3tecnologies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ItemTouchHelper
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import android.graphics.Color

class ToDo_List : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var adapter: TaskAdapter
    private val taskList = mutableListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do_list)

        supportActionBar?.hide()

        recyclerView = findViewById(R.id.taskRecyclerview)
        fab = findViewById(R.id.fab)

        // Pass 'this' as the context to the adapter
        adapter = TaskAdapter(this, taskList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Set up ItemTouchHelper for swipe-to-delete functionality
        val itemTouchHelper = ItemTouchHelper(SwipeToDeleteCallback(adapter))
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // Handle FAB click to add a new task
        fab.setOnClickListener {
            showAddTaskDialog()
        }
    }

    private fun showAddTaskDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.new_task, null)
        val taskInput = dialogView.findViewById<EditText>(R.id.newtaskText)
        val saveButton = dialogView.findViewById<Button>(R.id.newtaskbutton)

        // ✅ Focus input and show keyboard
        taskInput.requestFocus()
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(taskInput, InputMethodManager.SHOW_IMPLICIT)

        // ✅ Change Save button text color on input
        taskInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val isNotEmpty = !s.isNullOrEmpty()
                saveButton.setTextColor(
                        if (isNotEmpty) Color.parseColor("#FF9800") // Orange when text is entered
                    else Color.DKGRAY // Gray when empty
                )
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        saveButton.setOnClickListener {
            val taskText = taskInput.text.toString().trim()
            if (taskText.isNotEmpty()) {
                adapter.addTask(Task(taskText))
                dialog.dismiss()
            } else {
                Toast.makeText(this, "Please enter a task", Toast.LENGTH_SHORT).show()
            }
        }

        dialog.show()
    }



}
