package com.example.tanmay.vitbot.Entity.ChatHome.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tanmay.vitbot.Entity.Actors.BotResponseModel;
import com.example.tanmay.vitbot.R;

import java.util.List;

/**
 * Created by tanmay on 23/07/17.
 */

public class ChatHomeRecyclerViewAdapter extends RecyclerView.Adapter<ChatHomeRecyclerViewAdapter.ViewHolder> {
    Context context;
    private List<BotResponseModel> botResponseList;
    View view;

    public ChatHomeRecyclerViewAdapter(List<BotResponseModel> botResponseList1,Context context1)
    {
        botResponseList=botResponseList1;
        context=context1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView messageView,timeView;
        public ViewHolder(View v)
        {
            super(v);
            messageView=(TextView)v.findViewById(R.id.card_view_chat_box_message);
            timeView=(TextView)v.findViewById(R.id.card_view_chat_box_time);
            view=v.findViewById(R.id.card_view_chat_box);
        }
    }

    public void add(int position,BotResponseModel item){
        botResponseList.add(position,item);
        notifyItemInserted(position);
    }

    public void remove(BotResponseModel item){
        int position=botResponseList.indexOf(item);
        botResponseList.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int postion){
        //TODO: TRY SOME FADE IN ANIMATION HERE
        holder.messageView.setText(botResponseList.get(postion).getResponse());
        holder.timeView.setText(botResponseList.get(postion).getTime());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context.getApplicationContext(),botResponseList.get(postion).getResponse(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return botResponseList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card_chat_message,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }
}
