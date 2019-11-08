package com.example.fragmentrecyclercuatro.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragmentrecyclercuatro.R;

public class FragmentTres extends Fragment {

    TextView nombrePersoTres;
    ImageView imgPersoTres, fondoPersoTres;

    OnFragmentTresListener listenerTres;

    View vTres;
    Context cTres;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        cTres = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        vTres = inflater.inflate(R.layout.fragment_tres,container,false);

        nombrePersoTres = vTres.findViewById(R.id.nombrePersonajeTres);
        imgPersoTres = vTres.findViewById(R.id.imagenPersonajeTres);
        fondoPersoTres = vTres.findViewById(R.id.fondoPersonajeTres);
        fondoPersoTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(cTres, "Falta por configurar", Toast.LENGTH_SHORT).show();
            }
        });

        return vTres;
    }

    public interface OnFragmentTresListener{
        public void onFragmentTresSelected();
    }
}
