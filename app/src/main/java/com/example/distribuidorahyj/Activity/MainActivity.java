package com.example.distribuidorahyj.Activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.dao.ProductoDAO;
import com.example.distribuidorahyj.dialogos.DialogoModificarMain;
import com.example.distribuidorahyj.domain.Producto;
import com.example.distribuidorahyj.utils.AdminSQLiteOpenHelper;

public class MainActivity extends AppCompatActivity implements DialogoModificarMain.IProducto {


    EditText et_codigo, et_descripcion, et_precio, descripcionMain, precioMain;
    private Button eliminar, modificar, btnConsumoApi;
    private Switch Switch;
    private Spinner spinner;
    ProductoDAO productoDAO;
    Producto producto;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_codigo = findViewById(R.id.codigo);
        et_descripcion = findViewById(R.id.descripcion);
        et_precio = findViewById(R.id.precio);

        Switch = findViewById(R.id.switch1);
        spinner = findViewById(R.id.idSpinner);
        eliminar = findViewById(R.id.btnEliminar);
        modificar = findViewById(R.id.btnModificar);
        descripcionMain = findViewById(R.id.dialogoAgregarDescripcionMain);
        precioMain = findViewById(R.id.dialogoAgregarPrecioMain);
        btnConsumoApi = findViewById(R.id.btnConsumoApi);
        dialogoEliminar();

        btnConsumoApi.setOnClickListener(v -> {
            Intent consumoApi = new Intent(getApplicationContext(), ConsumoApi.class);
            startActivity(consumoApi);
        });

        modificar.setOnClickListener(v -> {
            DialogoModificarMain AlertDialog = new DialogoModificarMain(MainActivity.this);
            AlertDialog.modificarDialogo(producto);
        });

        /*eliminar.setOnClickListener(v -> {
            DialogoModificarMain AlertDialogEliminarProducto = new DialogoModificarMain(MainActivity.this);
            AlertDialogEliminarProducto.dialogoEliminar(producto);
        });*/

        ArrayAdapter<Producto> adapter = new ArrayAdapter<>(this, R.layout.item_adapter_spinner, R.id.textSpinner, Producto.getProducto("<z"));
        spinner.setAdapter(adapter);

        Switch.setOnCheckedChangeListener((compoundButton, b) -> {

            if (b)
                Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.textoNoDispo), Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.textoDispo), Toast.LENGTH_SHORT).show();
        });
    }

    public SQLiteDatabase Conexion() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        return BaseDeDatos;
    }

    //Metodos Para los Botones
    public void agregar(View view) {

        SQLiteDatabase oConexion = Conexion();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()) {

            productoDAO = new ProductoDAO(this);

            Cursor fila = oConexion.rawQuery
                    ("select descripcion, precio from articulos where codigo =" + codigo, null);

            if (fila.moveToFirst()) {
                Toast.makeText(this, this.getString(R.string.IngreceAr), Toast.LENGTH_SHORT).show();
                oConexion.close();
            } else {
                ContentValues registro = new ContentValues();
                registro.put("codigo", codigo);
                registro.put("descripcion", descripcion);
                registro.put("precio", precio);

                oConexion.insert("articulos", null, registro);

                Toast.makeText(this, this.getString(R.string.IngresoDeDatos), Toast.LENGTH_SHORT).show();
            }
            limpiar();
        } else {
            Toast.makeText(this, this.getString(R.string.llenarDatos), Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para Buscar Articulos o productos
    public void buscarMain(View view) {

        String codigo = et_codigo.getText().toString();

        if (!codigo.isEmpty()) {

            productoDAO = new ProductoDAO(this);

            this.producto = productoDAO.buscar(codigo);

            if (producto == null) {
                Toast.makeText(this, this.getString(R.string.NoExiste), Toast.LENGTH_SHORT).show();
                return;
            }
            if (!producto.getCodigo().equals("0")) {

                et_descripcion.setText(producto.getDescripcion());
                et_precio.setText(String.valueOf(producto.getPrecio()));
                modificar.setEnabled(true);
                eliminar.setEnabled(true);
            } else {
                Toast.makeText(this, this.getString(R.string.NoExiste), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, this.getString(R.string.IngresarCodig), Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminar(Producto producto) {

        //String codigo = et_codigo.getText().toString();

        if (!producto.getCodigo().isEmpty()) {

            productoDAO = new ProductoDAO(this);

            int elimina = productoDAO.eliminar(producto);

            limpiar();

            if (elimina == 1) {
                Toast.makeText(this, this.getString(R.string.Eliminado), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, this.getString(R.string.NoExiste), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, this.getString(R.string.llenarDatos), Toast.LENGTH_SHORT).show();
        }
    }

    /*public void modificar() {

//        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if (!producto.getCodigo().isEmpty()) {

            if (!descripcion.isEmpty() && !precio.isEmpty()) {

                productoDAO = new ProductoDAO(this);
                int cantidad = productoDAO.modificar(producto);

                if (cantidad == 1) {
                    Toast.makeText(this, this.getString(R.string.Modificado), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, this.getString(R.string.NoExiste), Toast.LENGTH_LONG).show();
                }
            }
        }
    }*/

    public void listar(View view) {
        Intent listar = new Intent(this, ListActivity.class);
        startActivity(listar);
    }

    public void dialogoEliminar() {

        eliminar.setOnClickListener(v -> {
            String mensaje;

            String codigo = et_codigo.getText().toString();

            if (!codigo.isEmpty()) {
                mensaje = "Desea eliminar el producto # " + producto.getCodigo();
            } else {
                mensaje = "Debe de ingresar el campo Còdigo para eliminar el producto";
            }

            AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
            alerta.setMessage(mensaje)
                    .setCancelable(false)

                    .setPositiveButton(" SI ", (dialog, which) -> {
                        eliminar(producto);
                        dialog.dismiss();
                    })
                    .setNegativeButton(" NO ", (dialog, which) -> dialog.cancel());
            AlertDialog titulo = alerta.create();
            titulo.setTitle("Eliminar Producto");
            titulo.show();
        });
    }

    public void limpiar() {
        et_codigo.setText("");
        et_descripcion.setText("");
        et_precio.setText("");
    }

    @Override
    public void modificar(View view, Producto producto) {
        productoDAO = new ProductoDAO(this);
        productoDAO.modificar(producto);
    }

    /*@Override
    public void alertDialog(Producto producto) {

    }*/
}


