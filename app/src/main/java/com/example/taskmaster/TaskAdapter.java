package com.example.taskmaster;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
//    private String[] localDataSet;
    private Context context;
private ArrayList<Task> tasks=new ArrayList<>();
public TaskAdapter(Context c,ArrayList<Task>taskArrayList){
    this.context=c;
    tasks=taskArrayList;
}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //            View view = LayoutInflater.from(mContext).inflate(R.layout.myview, parent, false);
//            view.setOnClickListener(mOnClickListener);
//            return new MyViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView taskTitle;
        private final TextView taskBody;
        private final TextView taskState;

        public TextView getTaskTitle() {
            return taskTitle;
        }

        public TextView getTaskBody() {
            return taskBody;
        }

        public TextView getTaskState() {
            return taskState;
        }

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            taskTitle = (TextView) view.findViewById(R.id.textView11);
            taskBody = (TextView) view.findViewById(R.id.textView12);
            taskState = (TextView) view.findViewById(R.id.textView13);

        }

        @Override
        public void onClick(final View view) {
//            int itemPosition = mRecyclerView.getChildLayoutPosition(view);
//            String item = mList.get(itemPosition);
//            Toast.makeText(mContext, item, Toast.LENGTH_LONG).show();
            int taskPosition=getAdapterPosition();
            Intent intent;
        }


    }
}