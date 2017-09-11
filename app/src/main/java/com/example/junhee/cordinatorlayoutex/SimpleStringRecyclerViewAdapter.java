package com.example.junhee.cordinatorlayoutex;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by JunHee on 2017. 9. 11..
 */

public class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {

    private List<String> mValues;
    private OnTouchItemListener mListener;


    public SimpleStringRecyclerViewAdapter(List<String> items, OnTouchItemListener mListener) {
        this.mListener = mListener;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mBoundString = mValues.get(position);
        holder.mPositioin = position;
        holder.mValue = mValues.get(position);
        holder.mTextView.setText(mValues.get(position));

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public String mBoundString;
        public final View mView;
        public String mValue;
        public final TextView mTextView;
        public int mPositioin;
        public OnTouchItemListener mListener;

        public ViewHolder(View view, final OnTouchItemListener mListener) {
            super(view);
            mView = view;
            mTextView = (TextView) view.findViewById(android.R.id.text1);
            this.mListener = mListener;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.itemTouched(mValue);


                }
            });
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTextView.getText();
        }
    }
}
