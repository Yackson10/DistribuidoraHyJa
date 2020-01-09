package com.example.distribuidorahyj.dialogos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.adaptadores.AdapterDialogoSede;
import com.example.distribuidorahyj.dao.ProductoDAO;
import com.example.distribuidorahyj.domain.Producto;
import com.example.distribuidorahyj.domain.Sede;
import com.example.distribuidorahyj.utils.AdminSQLiteOpenHelper;
import com.example.distribuidorahyj.utils.Tabla_Sede;

import java.util.ArrayList;

public class DialogoSedesPorProducto extends AppCompatActivity {

    Context context;
    RecyclerView recyclerListadoDialogo;
    ArrayList<Producto> listProductoAlert = new ArrayList<>();
    Spinner spinnerSedes;
    ArrayList<String> listCombo;
    ArrayList<Sede> listSedes;

    public DialogoSedesPorProducto(Context context) {
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogo_sedes_por_producto);

        spinnerSedes = (Spinner)findViewById(R.id.spinnerSede);

        recyclerListadoDialogo = (RecyclerView)findViewById(R.id.recyclerId2);
        recyclerListadoDialogo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        AdapterDialogoSede adapterDialogoSede = new AdapterDialogoSede(listProductoAlert);
        recyclerListadoDialogo.setAdapter(adapterDialogoSede);

        consultarListaSede();


    }
    public SQLiteDatabase Conexion() {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BaseDeDatosDistri", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        return BaseDeDatos;
    }

    private void consultarListaSede(){
        SQLiteDatabase oConexion = Conexion();

        Sede sede = null;
        listSedes = new ArrayList<Sede>();

        Cursor cursor = oConexion.rawQuery("SELECT * FROM "+ Tabla_Sede.TABLA_SEDE,null);

        while(cursor.moveToNext()){
            sede = new Sede();
            sede.setCodigo(cursor.getInt(0));
            sede.setNombre(cursor.getString(1));
            sede.setDepartamento(cursor.getString(2));

            listSedes.add(sede);

        }
        obtenerLista();
    }

    private void obtenerLista(){
        listCombo = new ArrayList<String>();
        listCombo.add("Seleccione");

        //for (int i= 0; i < ){}


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
