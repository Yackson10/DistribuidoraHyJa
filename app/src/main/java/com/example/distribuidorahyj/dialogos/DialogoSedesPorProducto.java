package com.example.distribuidorahyj.dialogos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.dao.ProductoDAO;
import com.example.distribuidorahyj.domain.Producto;

import java.util.ArrayList;

public class DialogoSedesPorProducto extends AppCompatActivity {

    Context context;
    ArrayList<Producto> listProducto;
    Spinner spi;


    public DialogoSedesPorProducto(Context context) {
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogo_sedes_por_producto);

        spi = findViewById(R.id.spinnera);

    }

    public void  DialogoSedes(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);


        //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //View views = inflater.inflate(R.layout.activity_dialogo_sedes_por_producto,null);

        //builder.setView(views);

        builder.setTitle("Seleccione Sede");

        builder.setItems(R.array.array_Producto, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context, "asdds", Toast.LENGTH_SHORT).show();
            }

        });


        Dialog dialog = builder.create();
        dialog.show();

    }


}
