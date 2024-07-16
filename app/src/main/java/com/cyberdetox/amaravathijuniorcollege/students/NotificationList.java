package com.cyberdetox.amaravathijuniorcollege.students;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.cyberdetox.amaravathijuniorcollege.BaseActivity;
import com.cyberdetox.amaravathijuniorcollege.NotificationModel;
import com.cyberdetox.amaravathijuniorcollege.adapters.NotificationViewAdapter;
import com.cyberdetox.amaravathijuniorcollege.utils.DatabaseHelper;
import com.cyberdetox.amaravathijuniorcollege.R;
import java.util.ArrayList;

public class NotificationList extends BaseActivity  {
    NotificationViewAdapter adapter;
    ListView listView;
    LinearLayout nodata_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_notification_list, null, false);
        mDrawerLayout.addView(contentView, 0);
        titleTV.setText(getApplicationContext().getString(R.string.notification));
        listView = findViewById(R.id.user_list);
        nodata_layout = findViewById(R.id.nodata_layout);

        DatabaseHelper db = new DatabaseHelper(this);
        ArrayList<NotificationModel> modelArrayList = db.GetUsers();
        if(modelArrayList.size()==0){
            listView.setVisibility(View.GONE);
            nodata_layout.setVisibility(View.VISIBLE);
        }else{
            nodata_layout.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
            adapter = new NotificationViewAdapter(NotificationList.this, modelArrayList,listView);
            listView.setAdapter(adapter);
        }

    }
}

