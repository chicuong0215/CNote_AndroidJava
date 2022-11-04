package com.cuong.app.cnote.ui.item;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cuong.app.cnote.R;
import com.cuong.app.cnote.data.db.model.Note;
import com.cuong.app.cnote.ui.main.MainActivity;

import java.util.List;

public class ItemNoteAdapter extends BaseAdapter {

    private MainActivity mContext;
    private List<Note> mNotes;

    public ItemNoteAdapter(MainActivity context, List<Note> notes) {
        this.mContext = context;
        this.mNotes = notes;
    }

    @Override
    public int getCount() {
        return mNotes.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //create views
        LayoutInflater inflater = LayoutInflater.from(mContext);
        @SuppressLint("ViewHolder") View v = (View) inflater.inflate(R.layout.item_note, null);
        TextView tvTitle = v.findViewById(R.id.tvTitle), tvContent = v.findViewById(R.id.tvContent);
        ImageButton ibtnDelete = v.findViewById(R.id.ibtnDelete);
        ibtnDelete.setOnClickListener((p) -> {
            mNotes.remove(i);
            mContext.updateListNote();
        });

        //set value for views
        Note note = mNotes.get(i);

        tvTitle.setText(note.getTitle());
        tvContent.setText(note.getContent());
        return v;
    }
}
