package com.example.ex9;

import static android.content.Context.CLIPBOARD_SERVICE;

import static com.google.android.material.internal.ContextUtils.getActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[],data2[],data3[];
    Context context;

    public MyAdapter(Context ct, String s1[], String s2[], String s3[]) {
        context= ct;
        data1 = s1;
        data2=s2;
        data3=s3;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.my_row,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.MyText1.setText(data1[position]);
        holder.MyText2.setText(data2[position]);
        holder.MyText3.setText(data3[position]);

        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "added to Fav library",
                        Toast.LENGTH_LONG).show();

            }
        });

        holder.bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "added to Bookmark library",
                        Toast.LENGTH_LONG).show();

            }
        });
        holder.copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("label", data2[position]);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "copy in clipboard",
                        Toast.LENGTH_LONG).show();
            }
        });


        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, data2[position]);
                context.startActivity(Intent.createChooser(shareIntent,"please choose :"));


            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "edit is unavailable",
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView MyText1,MyText2,MyText3;

        ImageButton fav,bookmark,copy,share,edit;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            MyText1=itemView.findViewById(R.id.MyText1);
            MyText2=itemView.findViewById(R.id.MyText2);
            MyText3=itemView.findViewById(R.id.MyText3);
            fav=itemView.findViewById(R.id.fav);
            bookmark=itemView.findViewById(R.id.bookmark);
            copy=itemView.findViewById(R.id.copy);
            share=itemView.findViewById(R.id.share);
            edit=itemView.findViewById(R.id.edit);


        }
    }


}
