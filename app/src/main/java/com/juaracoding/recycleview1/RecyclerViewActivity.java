package com.juaracoding.recycleview1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        arrayList=new ArrayList();
        for(int i=0; i<50; i++) {
            arrayList.add(i);

        }
        RecyclerView recycleView=findViewById(R.id.rv);
        recycleView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recycleView.setAdapter(new RecyclerView.Adapter() {
            public int getItemViewType(int position){
                return position%2==0?R.layout.activity_reitemdua:R.layout.activity_reitemsatu;
            }
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewtype) {
                View view=LayoutInflater.from(viewGroup.getContext()).inflate(viewtype, viewGroup, false);
                return new RecyclerView.ViewHolder(view){};
            }
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            TextView textView=viewHolder.itemView.findViewById(R.id.txtTitle);
            textView.setText(String.valueOf(arrayList.get(i)));
            }

            @Override
            public int getItemCount() {
                return arrayList.size();
            }
        });
    }
}
