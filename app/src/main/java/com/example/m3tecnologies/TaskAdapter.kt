package com.example.m3tecnologies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import android.content.Context


class TaskAdapter(val context: Context, private val taskList: MutableList<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox: CheckBox = itemView.findViewById(R.id.todocheckbox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.task_layout, parent, false) // Use context here
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.checkBox.text = task.title
        holder.checkBox.isChecked = task.isChecked

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            task.isChecked = isChecked
        }
    }

    override fun getItemCount(): Int = taskList.size

    fun addTask(task: Task) {
        taskList.add(task)
        notifyItemInserted(taskList.size - 1)
    }

    fun removeTask(position: Int) {
        if (position >= 0 && position < taskList.size) {
            taskList.removeAt(position)
            notifyItemRemoved(position)
        }
    }
}

