package com.domain.ryan.chapter5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by user on 2/13/18.
 */
public class taskAdapter extends BaseAdapter{
    private Context context;
    private Task[] tasks;
    private static LayoutInflater inflater = null;
    private int count = 0;
    private DatabaseManager db = null;

    /**
     * Instantiates a new Task adapter.
     *
     * @param context the context
     * @param data    the data
     * @param db      the db
     */
    public taskAdapter(Context context, Task[] data, DatabaseManager db)
    {
        this.context = context;
        this.tasks = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.count = this.tasks.length;
        this.db = db;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int i) {
        return tasks[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final Date today = new Date();
        View vi = view;
        if(vi == null) vi = inflater.inflate(R.layout.task_row,null);

        TextView colorTag = vi.findViewById(R.id.ColorTab);
        TextView message = vi.findViewById(R.id.TaskMessage);
        TextView deadline = vi.findViewById(R.id.DeadlineText);
        CheckBox completed = vi.findViewById(R.id.TaskCheckbox);

        final Task thisTask = (Task) getItem(i);

        setColorTag(vi, thisTask, today);

        colorTag.setText(" ");
        message.setText(thisTask.getMessage());
        deadline.setText(thisTask.getDeadline().toString());
        completed.setChecked(thisTask.getComplete());

        completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = thisTask.getID();
                Task newTask = new Task(thisTask.getMessage(), thisTask.getDeadline(), thisTask.getComplete() ? 0 : 1);
                db.deleteById(id);
                db.insert(newTask);
                view.setActivated(newTask.getComplete());
            }
        });

        vi.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                db.deleteById(thisTask.getID());
                return true;
            }
        });
        return vi;
    }

    /**
     * Set color tag.
     *
     * @param vi       the vi
     * @param thisTask the this task
     * @param today    the today
     */
    protected void setColorTag(View vi, Task thisTask, Date today){

        TextView colorTag = vi.findViewById(R.id.ColorTab);

        if(!thisTask.getComplete()){
            if(thisTask.getDeadline().compareTo(today) <= 0){
                colorTag.setBackgroundResource(R.color.Red);
            }
            else{
                colorTag.setBackgroundResource(R.color.Yellow);
            }
        }
        else{
            colorTag.setBackgroundResource(R.color.Green);
        }
    }
}
