package com.example.distribuidorahyj.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import android.database.Cursor;
import android.widget.Toast;
import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.adaptadores.AdapterProducto;
import com.example.distribuidorahyj.dao.ProductoDAO;
import com.example.distribuidorahyj.dialogos.DialogModificarList;
import com.example.distribuidorahyj.domain.Producto;
import com.example.distribuidorahyj.utils.AdminSQLiteOpenHelper;

public class ListActivity extends AppCompatActivity implements AdapterProducto.onItemClick, AdapterProducto.onItemClicks {

    Context context = this;
    Producto producto;
    ArrayList<Producto> listArticulos;
    RecyclerView recyclerViewArticulos;
    ProductoDAO eliminarProd;
    AdapterProducto adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lis_view);

        recyclerViewArticulos = findViewById(R.id.recyclerId);
        recyclerViewArticulos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        listArticulos = new ArrayList<>();

        consultarLista();

        adapter = new AdapterProducto(listArticulos, new ProductoDAO(this));
        adapter.setClickListener(this);
        adapter.setClickListeners(this);

        recyclerViewArticulos.setAdapter(adapter);
    }

    public SQLiteDatabase Conexion() {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        return BaseDeDatos;
    }

    public void consultarLista() {

        SQLiteDatabase oConexion = Conexion();

        Cursor fila = oConexion.rawQuery

                ("select codigo,descripcion,precio from articulos", null);

        for (fila.moveToFirst(); !fila.isAfterLast(); fila.moveToNext()) {

            producto = new Producto();
            producto.setCodigo(Integer.parseInt(fila.getString(0)));
            producto.setDescripcion(fila.getString(1));
            producto.setPrecio(fila.getString(2));
            listArticulos.add(producto);
        }
    }

    public void eliminar(Producto producto) {

        if (!producto.getCodigo().isEmpty()) {

            Toast.makeText(this, "Desea eliminar el producto", Toast.LENGTH_SHORT).show();

            eliminarProd = new ProductoDAO(this);

            int cantidad = eliminarProd.eliminar(producto);

            if (cantidad == 1) {
                Toast.makeText(this, this.getString(R.string.Eliminado), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, this.getString(R.string.NoExiste), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, this.getString(R.string.llenarDatos), Toast.LENGTH_SHORT).show();
        }
    }

    public void listar(View view) {
        Intent listar = new Intent(this, ListActivity.class);
        startActivity(listar);
    }

    public void itemclick(final View view, final Producto producto) {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setMessage("Desea eliminar el producto " + producto.getCodigo());

        dialogo1.setCancelable(false);
        dialogo1.setPositiveButton("Si", (dialog, id) -> {
            if (producto.getCodigo().isEmpty())
                Toast.makeText(ListActivity.this, "", Toast.LENGTH_SHORT).show();
            eliminar(producto);

            listArticulos.remove(producto);
            adapter.notifyDataSetChanged();

            dialog.dismiss();

        });
        dialogo1.setNegativeButton("No", (dialog, which) -> dialog.cancel());
        dialogo1.show();
    }

    public void itemclicks(final View view, final Producto producto, final int pos) {
        DialogModificarList dialogo = new DialogModificarList(adapter, context);
        dialogo.itemclickd(producto, pos);
    }

    public void regresar(View view) {
        Intent regresar = new Intent(this, MainActivity.class);
        startActivity(regresar);
    }
}
