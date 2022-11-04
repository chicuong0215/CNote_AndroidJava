package com.cuong.app.cnote.ui.main;

import com.cuong.app.cnote.data.db.model.Note;

import java.util.List;

public class MainPresenter {
    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void addNote(List<Note> notes, Note note) {
        notes.add(note);
        mainView.updateListNote();
    }
}
