package com.marwa.azkar;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AzkarAdapter extends RecyclerView.Adapter<AzkarAdapter.AzkarHolder>{
    String x;
    Cursor mCursor;
    private List<Azkary> azkaryList;
    private Context context;
    int xx=1;



    public AzkarAdapter(Context context,List<Azkary> contactList) {
        this.azkaryList = contactList;
        this.context=context;
    }
    public AzkarAdapter(Sbha sbha, Cursor cursor) {

        mCursor = cursor;
    }
    public int getItemCount() {
        return azkaryList.size();
    }

    public void onBindViewHolder(final AzkarHolder  holder, final int position) {
        final Azkary azkary = azkaryList.get(position);
        holder.card.setTag(position);

        holder.azkarname.setText(azkary.getAzkarName());
        //Toast.makeText(context, azkary.getAzkarName(), Toast.LENGTH_SHORT).show();
        holder.azkarcount.setText(String.format ("%d", xx));

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (int) view.getTag();
                int  az=azkary.getCount();
                if(position==0)
            if (xx != az) {
                 xx++;
                //Toast.makeText(context, Integer.toString(position), Toast.LENGTH_SHORT).show();

                String y = String.format("%d", xx);
                  holder.azkarcount.setText(y);

              } else {

                  xx = 0;
                  holder.azkarcount.setText(String.format("%d", az));
                  // Toast.makeText(context, "completed", Toast.LENGTH_SHORT).show();
                  azkaryList.remove(position);
                  notifyItemRemoved(position);
                  notifyItemRangeChanged(position, azkaryList.size());

          }

            }
        });
    }
    @Override
    public AzkarHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new AzkarHolder(row);


    }

    public static class AzkarHolder extends RecyclerView.ViewHolder {


        protected TextView azkarname;

        protected TextView azkarcount ;
        protected  Button count;
        protected View card;


        public AzkarHolder(View v) {
            super(v);
            azkarname =  (TextView) v.findViewById(R.id.content);
            //  triptype = (TextView)  v.findViewById(R.id.triptype);
            azkarcount = (TextView)  v.findViewById(R.id.num);
            //  tripnotes = (TextView) v.findViewById(R.id.tripnotes);
            card=(CardView) v.findViewById(R.id.card);


        }

    }


}
