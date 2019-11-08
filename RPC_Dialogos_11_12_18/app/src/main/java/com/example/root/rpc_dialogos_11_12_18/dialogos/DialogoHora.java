package com.example.root.rpc_dialogos_11_12_18.dialogos;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

public class DialogoHora extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar calendar = Calendar.getInstance();

//        TimePickerDialog dialog = new TimePickerDialog(getActivity(), getActivity());

        return super.onCreateDialog(savedInstanceState);
    }
}
