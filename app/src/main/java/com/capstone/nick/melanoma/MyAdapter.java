package com.capstone.nick.melanoma;


import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<CreateList> galleryList;
    //public hashmap?
    public ArrayList<ViewHolder> imageViews = new ArrayList<>();
    public ArrayList<ViewHolder> selViews = new ArrayList<>();

    private Context context;

    public MyAdapter(Context context, ArrayList<CreateList> galleryList) {
        this.galleryList = galleryList;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_layout, viewGroup, false);
        ViewHolder temp = new ViewHolder(view);
        imageViews.add(temp);
        return temp;
    }

    @Override
    public void onBindViewHolder(final MyAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(galleryList.get(i).getImage_title());
        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //viewHolder.img.setImageResource((galleryList.get(i).getImage_ID()));
        //String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString()+"/JPEG Images/";
        //path+=galleryList.get(i).getImage_title();
        //File tempFile = new File(path);
        //viewHolder.img.setImageURI(Uri.fromFile(tempFile));

        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Image",Toast.LENGTH_SHORT).show();
                //show bigger view of image
            }
        });

        viewHolder.chkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Checked",Toast.LENGTH_SHORT).show();
                selViews.add(viewHolder);
                //if(!isChecked()) add to list of selected images
            }
        });
        viewHolder.chkBox.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView img;
        public CheckBox chkBox;
        public ViewHolder(View view) {
            super(view);

            title = (TextView)view.findViewById(R.id.title);
            img = (ImageView) view.findViewById(R.id.img);
            chkBox = (CheckBox)view.findViewById(R.id.chkImage);
        }
    }
}
