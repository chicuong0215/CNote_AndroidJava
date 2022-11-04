package com.cuong.app.cnote.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.cuong.app.cnote.R;
import com.cuong.app.cnote.data.db.model.Note;
import com.cuong.app.cnote.ui.dialog.AddNoteDialog;
import com.cuong.app.cnote.ui.item.ItemNoteAdapter;
import com.cuong.app.cnote.utils.ScreenUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    private GridView gvNote;
    private FloatingActionButton fabAdd;

    private List<Note> mNotes;
    private ItemNoteAdapter itemNoteAdapter;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScreenUtils.setFullScreen(getWindow());
        init();
    }

    private void init() {
        gvNote = findViewById(R.id.gvNote);
        fabAdd = findViewById(R.id.fabAdd);

        mNotes = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            mNotes.add(new Note(0, "Tiêu đề " + i, "Nội dung " + i + "\nNội dung " + i));
        }

        itemNoteAdapter = new ItemNoteAdapter(this, mNotes);

        gvNote.setAdapter(itemNoteAdapter);

        fabAdd.setOnClickListener(this);

        mainPresenter = new MainPresenter(this);
    }

    public void addNote(Note note) {
        mainPresenter.addNote(mNotes, note);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fabAdd:
                AddNoteDialog dialog = new AddNoteDialog(this);
                dialog.show();
                break;
            default:
                break;
        }
    }

    @Override
    public void updateListNote() {
        itemNoteAdapter.notifyDataSetChanged();
    }
}