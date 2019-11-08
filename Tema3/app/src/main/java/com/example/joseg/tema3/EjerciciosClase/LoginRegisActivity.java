package com.example.joseg.tema3.EjerciciosClase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.joseg.tema3.EjerciciosClase.Dialogos.DialogAniadido;
import com.example.joseg.tema3.EjerciciosClase.Dialogos.DialogLogin;
import com.example.joseg.tema3.EjerciciosClase.Dialogos.DialogPassIncorrecta;
import com.example.joseg.tema3.EjerciciosClase.Dialogos.DialogRegistrar;
import com.example.joseg.tema3.EjerciciosClase.Dialogos.DialogYaExiste;
import com.example.joseg.tema3.EjerciciosClase.Utils.Usuario;
import com.example.joseg.tema3.R;

import java.util.Hashtable;

public class LoginRegisActivity extends AppCompatActivity implements View.OnClickListener, DialogRegistrar.OnDialogoRegistrarListener, DialogLogin.OnDialogoLoginListener {

    private Hashtable<String, Usuario> usuarios;
    private Button log, reg;
    final static String  TAG_REG = "registro", TAG_LOG = "login", TAG_ERR = "error", TAG_ADD = "exito", TAG_PASS = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_regis);

        instancias();
        acciones();

    }

    private void acciones() {
        log.setOnClickListener(this);
        reg.setOnClickListener(this);
    }

    private void instancias() {
        usuarios = new Hashtable<>();
        log = findViewById(R.id.btnLogearLR);
        reg = findViewById(R.id.btnRegistrarLR);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnLogearLR:
                DialogLogin dl = new DialogLogin();
                dl.show(getSupportFragmentManager(),TAG_LOG);
                break;
            case R.id.btnRegistrarLR:
                DialogRegistrar dr = new DialogRegistrar();
                dr.show(getSupportFragmentManager(),TAG_REG);
                break;
        }
    }

    @Override
    public void onDialogoOkSelected(Usuario u) {
        if (!usuarios.containsKey(u.getCorreo())) {
            usuarios.put(u.getCorreo(), u);
            DialogAniadido da = new DialogAniadido();
            da.show(getSupportFragmentManager(),TAG_ADD);
        }else {
            DialogYaExiste dye = new DialogYaExiste();
            dye.show(getSupportFragmentManager(),TAG_ERR);
        }
    }

    public Hashtable<String, Usuario> getUsuarios() {
        return usuarios;
    }

    @Override
    public void onDialogoLoginSelected(String correo, String pass) {

        if (usuarios.containsKey(correo) && usuarios.get(correo).getPass().equals(pass)){
            Intent intent = new Intent(getApplicationContext(), null);
            intent.putExtra("usuario", usuarios.get(correo));
            startActivity(intent);
        }else {
            DialogPassIncorrecta dpi = new DialogPassIncorrecta();
            dpi.show(getSupportFragmentManager(),TAG_PASS);
        }

    }
}
