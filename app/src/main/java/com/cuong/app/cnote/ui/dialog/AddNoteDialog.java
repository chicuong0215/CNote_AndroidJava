package com.cuong.app.cnote.ui.dialog;

import android.app.Dialog;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.cuong.app.cnote.R;
import com.cuong.app.cnote.data.db.model.Note;
import com.cuong.app.cnote.ui.main.MainActivity;

public class AddNoteDialog extends Dialog {

    public AddNoteDialog(@NonNull MainActivity context) {
        super(context);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.setContentView(R.layout.dialog_add_note);

        EditText edtTitle = findViewById(R.id.edtTitle), edtContent = findViewById(R.id.edtContent);
        Button btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(v -> {
            context.addNote(new Note(0, edtTitle.getText().toString(), edtContent.getText().toString()));
            this.cancel();
        });
    }
}
