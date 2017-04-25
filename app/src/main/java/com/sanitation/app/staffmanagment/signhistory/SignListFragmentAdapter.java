package com.sanitation.app.staffmanagment.signhistory;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sanitation.app.R;

import java.util.List;


public class SignListFragmentAdapter extends RecyclerView.Adapter<SignListFragmentAdapter.ViewHolder> {

    private final List<SignHistory> mValues;

    public SignListFragmentAdapter(List<SignHistory> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_sign_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTitleView.setText(mValues.get(position).title);
        holder.mDateView.setText(mValues.get(position).date);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, SignDetailActivity.class);
                intent.putExtra(SignDetailFragment.ARG_ID, holder.mItem.id);
                intent.putExtra(SignDetailFragment.ARG_TITLE, holder.mItem.title);
                intent.putExtra(SignDetailFragment.ARG_CONTENT, holder.mItem.content);
                intent.putExtra(SignDetailFragment.ARG_DATE, holder.mItem.date);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleView;
        public final TextView mDateView;
        public SignHistory mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = (TextView) view.findViewById(R.id.title);
            mDateView = (TextView) view.findViewById(R.id.date);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleView.getText() + "'";
        }
    }
}
