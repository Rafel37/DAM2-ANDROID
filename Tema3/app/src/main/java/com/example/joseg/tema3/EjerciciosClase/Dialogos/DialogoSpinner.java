package com.example.joseg.tema3.EjerciciosClase.Dialogos;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.joseg.tema3.EjerciciosClase.Adaptadores.AdaptadorPersoRecycler;
import com.example.joseg.tema3.EjerciciosClase.Adaptadores.AdaptadorPersoSpinner;
import com.example.joseg.tema3.EjerciciosClase.Utils.Hobie;
import com.example.joseg.tema3.R;

public class DialogoSpinner extends DialogFragment implements AdaptadorPersoRecycler.OnHobieRecyclerListener {

    View v;
    Spinner spinner;
    RecyclerView recycler;
    AdaptadorPersoSpinner adaptadorspinner;
    AdaptadorPersoRecycler adaptadorrecycler;
    Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(context).inflate(R.layout.dialogo_personalizado, null);
        this.context = context;
    }

    /*@Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.dialogo_spinner,null);
        return v;
    }*/

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        instancias();
        acciones();
        builder.setView(v);
        return builder.create();
    }

    private void acciones() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),String.valueOf(position),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void instancias() {
        adaptadorspinner = new AdaptadorPersoSpinner(getContext());
        spinner = v.findViewById(R.id.spinnerDialog);
        //spinner.setAdapter(adaptadorspinner);
        adaptadorrecycler = new AdaptadorPersoRecycler(getActivity());
        recycler = v.findViewById(R.id.recyclerDialog);
        recycler.setAdapter(adaptadorrecycler);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recycler.setLayoutManager(new GridLayoutManager(getContext(),2,LinearLayoutManager.VERTICAL,false));
        //recyclerView.addItemDecoration();
    }

    @Override
    public void onElementSelected(Hobie hobie) {

    }

    public interface OnDialogoSpinnerListener{
        public void onDialogoElementSelected();
    }
}
