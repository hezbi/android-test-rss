package com.islamistudio.rssfeed.ui.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.islamistudio.rssfeed.R;
import com.islamistudio.rssfeed.data.source.remote.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class FeedListAdapter extends RecyclerView.Adapter<FeedListAdapter.FeedListViewHolder> {

    private List<Item> itemList = new ArrayList<>();

    public void setItemList(List<Item> itemList) {
        if (itemList == null) return;
        this.itemList.clear();
        this.itemList.addAll(itemList);
    }

    @NonNull
    @Override
    public FeedListAdapter.FeedListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
        return new FeedListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedListAdapter.FeedListViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class FeedListViewHolder extends RecyclerView.ViewHolder {

        final ImageView imvBanner;
        final TextView tvTitle;
        final TextView tvTime;
        final TextView tvDesc;

        FeedListViewHolder(View itemView) {
            super(itemView);
            this.imvBanner = itemView.findViewById(R.id.imv_feed_banner);
            this.tvTitle = itemView.findViewById(R.id.tv_feed_title);
            this.tvTime = itemView.findViewById(R.id.tv_feed_time);
            this.tvDesc = itemView.findViewById(R.id.tv_feed_desc);
        }

        void bind(Item item) {
            tvTitle.setText(item.getTitle());
            tvTime.setText(item.getPubDate());

            int startIndex = item.getDescription().indexOf("<");
            int endIndex = item.getDescription().indexOf(">");
            String html = item.getDescription().substring(startIndex, endIndex + 1);
            String desc = item.getDescription().replace(html, "");

            int htmlStartIndex = html.indexOf("http");
            int htmlEndIndex = html.indexOf("\" align");
            String urlThumbnail = html.substring(htmlStartIndex, htmlEndIndex);

            tvDesc.setText(desc);
            Glide.with(itemView.getContext())
                    .load(urlThumbnail)
                    .into(imvBanner);

            //Pattern p = Pattern.compile("\"([^\"]*)\"");
            //Matcher m = p.matcher(item)

        }
    }
}
