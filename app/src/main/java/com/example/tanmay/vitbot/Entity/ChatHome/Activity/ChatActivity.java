package com.example.tanmay.vitbot.Entity.ChatHome.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.tanmay.vitbot.Boundary.API.ConnectAPI;
import com.example.tanmay.vitbot.Entity.Actors.BotResponseModel;
import com.example.tanmay.vitbot.Entity.ChatHome.Adapter.ChatHomeRecyclerViewAdapter;
import com.example.tanmay.vitbot.R;

import java.util.List;

public class ChatActivity extends AppCompatActivity {
    ConnectAPI connectAPI;
    RecyclerView chatMessagesRecyclerView;
    EditText chatMessageEditText;
    ImageButton chatMessageSendButton;
    List<BotResponseModel> botResponseList;
    String botResponse;

    RecyclerView botMessageRecyclerView;
    RecyclerView.Adapter botMessageRecyclerViewAdapter;
    RecyclerView.LayoutManager botMessageRecyclerViewLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        connectAPI=new ConnectAPI(getApplicationContext());
        chatMessagesRecyclerView=(RecyclerView)findViewById(R.id.chat_activity_recycler_view);
        chatMessageEditText=(EditText)findViewById(R.id.chat_activity_edit_text);
        chatMessageSendButton=(ImageButton)findViewById(R.id.chat_activity_button_send);
        botMessageRecyclerView=(RecyclerView)findViewById(R.id.chat_activity_recycler_view);
        botMessageRecyclerViewLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        botMessageRecyclerView.setLayoutManager(botMessageRecyclerViewLayoutManager);
        //Try this and check its result: botMessageRecyclerView.setHasFixedSize(true);
        //botResponseList=connectAPI.botRequestInitial();
        //botMessageRecyclerViewAdapter=new ChatHomeRecyclerViewAdapter(botResponseList,getApplicationContext());
        //botMessageRecyclerView.setAdapter(botMessageRecyclerViewAdapter);
    }

    public void onStart()
    {
        super.onStart();
        chatMessageSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botResponse=connectAPI.botRequest(chatMessageEditText.getText().toString());
                botResponseList.add(new BotResponseModel(chatMessageEditText.getText().toString(),"12pm"));
                botResponseList.add(new BotResponseModel(botResponse,"12pm"));
                botMessageRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
