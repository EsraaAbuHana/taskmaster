package com.example.taskmaster;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.datastore.generated.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {
    public List<Task> tasks = new ArrayList<Task>();
    private OnTaskListener mOnTaskListener;

    public TaskAdapter(ArrayList<Task> tasks, OnTaskListener onTaskListener) {
        this.tasks = tasks;
        this.mOnTaskListener = onTaskListener;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public Task task;
        public TextView taskTitle;
        public TextView taskBody;
        public TextView taskState;
        OnTaskListener onTaskListener;
        public TaskViewHolder(View taskView, OnTaskListener onTaskListener) {
            super(taskView);
            taskTitle = taskView.findViewById(R.id.textViewLogin);
            taskBody = taskView.findViewById(R.id.textView12);
            taskState = taskView.findViewById(R.id.textView13);
            this.onTaskListener = onTaskListener;
            taskView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            onTaskListener.onTaskClick(getAdapterPosition());
        }
    }
    public interface OnTaskListener {
        void onTaskClick(int position);
    }
    @NonNull
    @Override
    public TaskAdapter.TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_task, parent, false);
        return new TaskViewHolder(view, mOnTaskListener);
    }
    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.TaskViewHolder holder, int position) {
        holder.task = tasks.get(position);
        TextView taskTitle = holder.taskTitle.findViewById(R.id.textViewLogin);
        TextView taskBody = holder.taskBody.findViewById(R.id.textView12);
        TextView taskState = holder.taskState.findViewById(R.id.textView13);
        taskTitle.setText(holder.task.getTitle());
        taskBody.setText(holder.task.getBody());
        taskState.setText(holder.task.getState());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }


}