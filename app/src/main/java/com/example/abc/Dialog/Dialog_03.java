package com.example.abc.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.example.abc.R;

public class Dialog_03 extends DialogFragment {
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Руслан")
                .setIcon(R.drawable.c)
                .setMessage("Я думаю что это вариант С")
                .setPositiveButton("Ok",null)
                .create();
    }
}