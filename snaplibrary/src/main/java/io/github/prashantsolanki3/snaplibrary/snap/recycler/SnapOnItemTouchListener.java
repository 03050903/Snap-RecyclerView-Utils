package io.github.prashantsolanki3.snaplibrary.snap.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import io.github.prashantsolanki3.snaplibrary.snap.AbstractSnapMultiAdapter;
import io.github.prashantsolanki3.snaplibrary.snap.SnapViewHolder;
import io.github.prashantsolanki3.snaplibrary.snap.utils.SnapGestureDetector;

public class SnapOnItemTouchListener implements RecyclerView.OnItemTouchListener {

    SnapGestureDetector snapGestureDetector;
    private SnapOnItemClickListener listener;

    public SnapOnItemTouchListener(final Context context, final SnapOnItemClickListener listener) {
        this.listener = listener;
        snapGestureDetector = new SnapGestureDetector(context, gestureListener);
        gestureListener.setDetector(snapGestureDetector);
    }

    SnapGestureDetector.SnapGestureListener gestureListener = new SnapGestureDetector.SnapGestureListener() {

        @Override
        public boolean onSingleTapUp(MotionEvent e, SnapViewHolder viewHolder, View view, int position) {
            listener.onItemClick(viewHolder, view, position);
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e, SnapViewHolder viewHolder, View view, int position) {
            listener.onItemLongPress(viewHolder, view, position);
        }

    };

    @Override
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent e) {
        View childView = recyclerView.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && listener != null) {
            SnapViewHolder viewHolder = ((SnapViewHolder) recyclerView
                    .getChildViewHolder(childView));
            snapGestureDetector.setView(childView);
            snapGestureDetector.setViewHolder(viewHolder);
            snapGestureDetector.setPosition(((AbstractSnapMultiAdapter) recyclerView.getAdapter())
                    .getItemPosition(viewHolder.getItemData()));

            if (snapGestureDetector.onTouchEvent(e))
                return true;
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

}