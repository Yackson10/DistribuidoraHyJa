package com.example.distribuidorahyj.dialogos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.domain.Producto;

public class DialogoSedesPorProducto extends AppCompatActivity {

    Context context;

    public DialogoSedesPorProducto(Context context) {
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogo_sedes_por_producto);

    }

    public void DialogoSedes(Producto producto) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.activity_dialogo_sedes_por_producto,null);

        builder.setView(view);

        builder.setTitle("Desea Modificar el Producto ")

                .setPositiveButton("MODIFICAR",
                        (dialog, which) -> {

                        })
                .setNegativeButton("GUARDAR",
                        (dialog, which) -> dialog.cancel());

        builder.show();
    }

}
