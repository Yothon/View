package com.yothon.view.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yothon.view.R;
import com.yothon.view.model.Data;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：Yoshon
 * on 2016/11/18 15:26
 * 邮箱：wanyouxin@parim.net
 */
public class LoginRecyclerAdapter extends RecyclerView.Adapter<LoginRecyclerAdapter.MyViewHodler> {

    private List<Data> list;
    private Context context;

    public LoginRecyclerAdapter(Context context,List<Data> list){
        this.context = context;
        this.list = list;
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.login_recycle_adapter_item,parent,false);
        return new MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(MyViewHodler holder, int position) {
        holder.textView.setText(list.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHodler extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.textView)
        TextView textView;


        public MyViewHodler(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onItemClickListener!=null){
                onItemClickListener.onItemClick(view,getPosition());
            }
        }
    }

    public OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
}
