package com.samuel.app_noticias.Utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.samuel.app_noticias.R;
import com.samuel.app_noticias.mPicasso.PicassoClient;

import java.util.ArrayList;


public class ArticlesModelAdapter extends RecyclerView.Adapter<ArticlesModelAdapter.MyViewHolder> {
    Context context;
    private ArrayList<ArticlesModel> modelList;


    public ArticlesModelAdapter(ArrayList<ArticlesModel> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_article, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ArticlesModel model = modelList.get(position);
        holder.textName.setText(model.getTitle());
        holder.textDescription.setText(model.getDescription());
        if (model.getPublishedAt().equals("null") || model.getPublishedAt().isEmpty()) {
            holder.textDate.setText("");
        } else {
            holder.textDate.setText(model.getPublishedAt());
        }

        if (model.getUrlToImage().equals("null") || model.getUrlToImage().equalsIgnoreCase("null")) {


        }

        PicassoClient.LoadImage(context, model.getUrlToImage(),
                holder.loadedImage, holder.textDate);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textName;
        private TextView textDate;
        private TextView textDescription;

        private ImageView loadedImage;


        public MyViewHolder(View view) {
            super(view);

            textName = (TextView) view.findViewById(R.id.txt_title);
            textDate = (TextView) view.findViewById(R.id.txt_date);
            textDescription = (TextView) view.findViewById(R.id.txt_description);
            loadedImage = (ImageView) view.findViewById(R.id.img_article);

        }
    }

}
