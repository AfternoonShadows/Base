package com.example.myapplication1.Frangment.FrangmentAdapter;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication1.R;

public class FragmentRecyclerAdapter extends RecyclerView.Adapter<FragmentRecyclerAdapter.ViewHolder> {

    private String[] localDataSet;
    private OnItemClickListenerFragment onItemClickListenerFragment;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.fragmentListTextview);
        }
        public TextView getTextView(){
            return textView;
        }
    }

    public FragmentRecyclerAdapter(String[] localDataSet){
        this.localDataSet = localDataSet;
    }
//
    public interface OnItemClickListenerFragment{
        //      子条目单机事件
        void onItemClick(View view, int position);
        //      子条目长按事件
        void onItemLongClick(View view,int position);
    }
//  回调方法 将接口传递进来
    public void setOnItemClickListenerFragment(OnItemClickListenerFragment onItemClickListenerFragment)
    {
        this.onItemClickListenerFragment = onItemClickListenerFragment;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragmentadapterlist,parent,false);
        return new ViewHolder(view);
    }
//    获取文本内容 acuire content
    public String TV(int position){
        return localDataSet[position];
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.getTextView().setText(localDataSet[position]);
//
        if(onItemClickListenerFragment != null) {

            holder.getTextView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    onItemClickListenerFragment.onItemClick(holder.textView,position);
                }
            });

            holder.getTextView().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = holder.getLayoutPosition();
                    onItemClickListenerFragment.onItemLongClick(holder.textView,position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
