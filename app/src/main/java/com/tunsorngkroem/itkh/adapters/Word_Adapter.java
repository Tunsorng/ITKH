package com.tunsorngkroem.itkh.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tunsorngkroem.itkh.DefinitionActivity;
import com.tunsorngkroem.itkh.R;
import com.tunsorngkroem.itkh.utils.ListenModel;

import java.util.List;

public class Word_Adapter extends RecyclerView.Adapter<Word_Adapter.ViewHolder> {

    public List<ListenModel> data;

    public Word_Adapter(){}
    public void setData(List<ListenModel> data){
        this.data=data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);

        View wordView=inflater.inflate(R.layout.word_item,parent,false);

        ViewHolder viewHolder=new ViewHolder(wordView,context);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListenModel listenModel =data.get(position);
        holder.wordText.setText(listenModel.getWord());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public Context context;
        public TextView wordText;
        public ViewHolder(View itemView, final Context context) {
            super(itemView);
            this.context=context;
            wordText=(TextView) itemView.findViewById(R.id.wordtext);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    ListenModel listenModel =data.get(position);

                    Intent intent=new Intent(context, DefinitionActivity.class);
                    intent.putExtra("WORD", listenModel.getWord());
                    intent.putExtra("DEFINITION", listenModel.getDefinition());
                    context.startActivity(intent);
                }
            });
        }
    }
}

