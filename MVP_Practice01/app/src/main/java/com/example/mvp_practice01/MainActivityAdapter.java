package com.example.mvp_practice01;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

/**
 * Created by tzia on 18-May-17.
 */

public class MainActivityAdapter implements Adapter
{

    Context context;

    public MainActivityAdapter()
    {
    }

    public MainActivityAdapter( Context context )
    {
        this.context = context;
    }

    @Override public void registerDataSetObserver( DataSetObserver dataSetObserver )
    {

    }

    @Override public void unregisterDataSetObserver( DataSetObserver dataSetObserver )
    {

    }

    @Override public int getCount()
    {
        return 0;
    }

    @Override public Object getItem( int i )
    {
        return null;
    }

    @Override public long getItemId( int i )
    {
        return 0;
    }

    @Override public boolean hasStableIds()
    {
        return false;
    }

    @Override public View getView( int i, View view, ViewGroup viewGroup )
    {
        return null;
    }

    @Override public int getItemViewType( int i )
    {
        return 0;
    }

    @Override public int getViewTypeCount()
    {
        return 0;
    }

    @Override public boolean isEmpty()
    {
        return false;
    }
}
