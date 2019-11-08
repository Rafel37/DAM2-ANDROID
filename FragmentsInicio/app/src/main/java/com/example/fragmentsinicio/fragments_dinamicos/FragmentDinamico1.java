package com.example.fragmentsinicio.fragments_dinamicos;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragmentsinicio.R;

public class FragmentDinamico1 extends Fragment {

    View v;
    FragmentDinamico1.OnFragmentUnoListener listener;
    Button button;
    EditText editText;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnFragmentUnoListener) context;
        }
        catch ( ClassCastException e) {
            Log.v("ERROR", "Error al castear el objeto");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_dinamico_1 , container, false);

        editText = v.findViewById(R.id.editDin1);
        button = v.findViewById(R.id.botonDin1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentUnoSelected(editText.getText().toString());
            }
        });
        return v;
    }

    public interface OnFragmentUnoListener {
        public void onFragmentUnoSelected();
        public void onFragmentUnoSelected(String s);
    }
}
