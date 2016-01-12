package io.prashantslolanki3.snaprecyclerview.sample.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import io.github.prashantsolanki3.snaplibrary.snap.layout.viewholder.SnapViewHolder;
import io.github.prashantsolanki3.snaprecyclerviewutils.R;
import io.prashantslolanki3.snaprecyclerview.sample.model.HorizontalRecyclerModel;

/**
 *
 * Created by Prashant on 12/12/2015.
 *
 */
public class HorizontalRecyclerViewHolder extends SnapViewHolder<HorizontalRecyclerModel> {

    final TextView title;

    public HorizontalRecyclerViewHolder(View itemView, Context context) {
        super(itemView, context);
        title = (TextView) itemView.findViewById(R.id.item_title);
    }

    @Override
    public void attachOnClickListeners(SnapViewHolder viewHolder, HorizontalRecyclerModel item, int pos) {

    }

    @Override
    public void animateViewHolder(SnapViewHolder viewHolder, int pos) {

    }

    @Override
    public void populateViewHolder(HorizontalRecyclerModel data, int pos) {
        title.setText(data.getTitle());
    }
}
