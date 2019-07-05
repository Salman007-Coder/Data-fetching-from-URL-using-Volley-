package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String url="http://178.128.127.249:5000/api/habits";
    private ProgressDialog dialog;
    private List<item> array=new ArrayList<item>();
    private ListView listView;
    private itemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        adapter = new itemAdapter(this,array);
        listView.setAdapter(adapter);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                hideDialogue();
                for(int i=0;i<response.length();i++)
                {
                        try
                        {
                            JSONObject obj=response.getJSONObject(i);
                            item item3=new item();
                            item3.setDescription(obj.getString("description"));
                            item3.setId(obj.getString("id"));
                            item3.setName(obj.getString("name"));
                            item3.setPunishment(obj.getString("punishment"));
                            item3.setReward(obj.getString("reward"));
                            array.add(item3);


                        }


                        catch (JSONException ex)
                        {
                            ex.printStackTrace();
                        }
                }
                adapter.notifyDataSetChanged();

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getmInstance().addToRequesQueue(jsonArrayRequest);
    }

    public void hideDialogue() {
        if(dialog!=null) {
            dialog.dismiss();
            dialog=null;
        }
    }
}
