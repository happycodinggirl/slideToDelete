package com.lily.administrator.slidetodelete;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */

public class SlideAdapter extends RecyclerView.Adapter {

    List<DateEntity> dataList;
    LayoutInflater inflater;

    public SlideAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    public void setDataList(List<DateEntity> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ItemViewHolder(inflater.inflate(R.layout.layout_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        final DateEntity data = dataList.get(holder.getAdapterPosition());
        itemViewHolder.tvItem.setText(data.getContent());
        itemViewHolder.swipeLayout.setAnimOpenFunction(new SwipeLayout.OnDeleteOpenListener() {
            @Override
            public void onOpen() {
                itemViewHolder.swipeLayout.setTag(data);
            }
        });
        itemViewHolder.swipeLayout.setAnimCloseFunction(new SwipeLayout.OnDeleteCloseListener() {
            @Override
            public void onClose() {
                itemViewHolder.swipeLayout.setTag(null);
            }
        });


        itemViewHolder.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.isCanDelete()){
                    dataList.remove(data);
                    notifyDataSetChanged();
                }else{
                    itemViewHolder.swipeLayout.swipeToNormal();
                    itemViewHolder.swipeLayout.setTag(null);
                }
            }
        });

        Object tag = itemViewHolder.swipeLayout.getTag();

        if (tag != null && tag.equals(data)) {
            Log.v("LILY","tag is "+tag+"  equal is true toOpen");

            itemViewHolder.swipeLayout.toOpen();
        } else {
            itemViewHolder.swipeLayout.toNormal();
        }


    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvItem;
        TextView tvDelete;
        SwipeLayout swipeLayout;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tvItem = (TextView) itemView.findViewById(R.id.tvItem);
            tvDelete = (TextView) itemView.findViewById(R.id.tvDelete);
            swipeLayout = (SwipeLayout) itemView.findViewById(R.id.swipeLayout);
        }
    }
}
