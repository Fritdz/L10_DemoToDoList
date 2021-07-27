package sg.edu.rp.c346.id20033454.demotodolist;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> toDoList;

    public CustomAdapter(Context context, int resource,
                         ArrayList<ToDoItem> objects){
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        toDoList = objects;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvDate = rowView.findViewById(R.id.tvDate);

        ToDoItem currentList = toDoList.get(position);

        if(currentList.getDate().get(Calendar.YEAR)==2021){
            tvTitle.setText(currentList.getTitle());
            tvDate.setText(currentList.toString());
            tvDate.setTextColor(Color.RED);
        } else {
            tvTitle.setText(currentList.getTitle());
            tvDate.setText(currentList.toString());
        }




        return rowView;
    }
}
