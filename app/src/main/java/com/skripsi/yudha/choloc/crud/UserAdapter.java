package com.skripsi.yudha.choloc.crud;

/**
 * Created by yudha on 14/04/2016.
 */

import java.util.ArrayList;
import java.util.HashMap;

import com.skripsi.yudha.choloc.R;
import com.skripsi.yudha.choloc.crud.User;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class UserAdapter extends BaseAdapter {
    private Activity activity;
    //private ArrayList<HashMap<String, String>> data;
    private ArrayList<User> data_user=new ArrayList<User>();

    private static LayoutInflater inflater = null;

    public UserAdapter(Activity a, ArrayList<User> d) {
        activity = a; data_user = d;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public int getCount() {
        return data_user.size();
    }
    public Object getItem(int position) {
        return data_user.get(position);
    }
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.list_item_user, null);
        TextView id_user = (TextView) vi.findViewById(R.id.id_user);
        TextView username = (TextView) vi.findViewById(R.id.username);
        TextView password = (TextView) vi.findViewById(R.id.password);
        TextView no_hp = (TextView) vi.findViewById(R.id.no_hp);
        TextView email = (TextView) vi.findViewById(R.id.email);

        User daftar_mhs = data_user.get(position);
        id_user.setText(daftar_mhs.getUserId());
        username.setText(daftar_mhs.getUserame());
        password.setText(daftar_mhs.getPassword());
        no_hp.setText(daftar_mhs.getNoHp());
        email.setText(daftar_mhs.getEmail());

        return vi;
    }
}