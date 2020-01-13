package com.example.distribuidorahyj.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.example.distribuidorahyj.R;
import com.example.distribuidorahyj.adaptadores.AdapterProducto;
import com.example.distribuidorahyj.dao.ProductoDAO;
import com.example.distribuidorahyj.dialogos.DialogoModificarMain;
import com.example.distribuidorahyj.dialogos.DialogoSedesPorProducto;
import com.example.distribuidorahyj.domain.Producto;
import com.example.distribuidorahyj.utils.AdminSQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et_codigo, et_descripcion, et_precio, editBuscar;
    Button eliminar, modificar, btnConsumoApi, btnIngreseSede;
    Switch disponible;
    Spinner spinnerProducto;
    ProductoDAO productoDAO;
    Producto producto;
    String item;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_codigo = findViewById(R.id.codigo);
        et_descripcion = findViewById(R.id.descripcion);
        et_precio = findViewById(R.id.precio);

        disponible = findViewById(R.id.switch1);

        spinnerProducto = findViewById(R.id.idSpinner);
        editBuscar = findViewById(R.id.editBuscar);

        eliminar = findViewById(R.id.btnEliminar);
        modificar = findViewById(R.id.btnModificar);

        btnConsumoApi = findViewById(R.id.btnConsumoApi);
        btnIngreseSede = findViewById(R.id.btnSede);

        dialogoEliminar();

        btnConsumoApi.setOnClickListener(v -> {
            Intent consumoApi = new Intent(getApplicationContext(), ConsumoApi.class);
            startActivity(consumoApi);
        });

        btnIngreseSede.setOnClickListener(v -> {
            DialogoSedesPorProducto dialogoSedesPorProducto = new DialogoSedesPorProducto(MainActivity.this);
            dialogoSedesPorProducto.DialogoSedes(producto);
        });

        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoModificarMain AlertDialog = new DialogoModificarMain(MainActivity.this);
                AlertDialog.modificarDialogo(producto);

            }
        });

        disponible.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked)
                Toast.makeText(MainActivity.this.getApplicationContext(), MainActivity.this.getApplicationContext().getString(R.string.textoDispo), Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this.getApplicationContext(), MainActivity.this.getApplicationContext().getString(R.string.textoNoDispo), Toast.LENGTH_SHORT).show();
        });

        spinnerProducto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item = String.valueOf(parent.getItemAtPosition(position));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public SQLiteDatabase Conexion() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "BaseDeDatosDistri", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();
        return BaseDeDatos;
    }

    //Metodos Para los Botones
    public void agregar(View view) {

        SQLiteDatabase oConexion = Conexion();

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();
        boolean dispo = ((Switch) findViewById(R.id.switch1)).isChecked();


        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty() && !item.isEmpty()) {

            productoDAO = new ProductoDAO(this);

            Cursor fila = oConexion.rawQuery
                    ("select descripcion, precio, disponible, tipoProducto from articulos where codigo =" + codigo, null);

            if (fila.moveToFirst()) {
                Toast.makeText(this, this.getString(R.string.canbia), Toast.LENGTH_SHORT).show();
                oConexion.close();
            } else {
                ContentValues registro = new ContentValues();
                registro.put("codigo", codigo);
                registro.put("descripcion", descripcion);
                registro.put("precio", precio);
                registro.put("disponible", dispo);
                registro.put("tipoProducto", item);

                oConexion.insert("articulos", null, registro);

                Toast.makeText(this, this.getString(R.string.IngresoDeDatos), Toast.LENGTH_SHORT).show();
                limpiar();
            }
        } else {
            Toast.makeText(this, this.getString(R.string.llenarDatos), Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para Buscar  productos
    public void buscarMain(View view) {

        limpiar();
        String buscar = editBuscar.getText().toString();

        if (!buscar.isEmpty()) {

            productoDAO = new ProductoDAO(this);

            this.producto = productoDAO.buscar(buscar);

            if (producto != null) {
                int cont = 0;

                String[] c = getResources().getStringArray(R.array.array_Producto);

                for( String item: c){
                    String[] tipo = c.toString().split(",");
                    String prueba = c[cont].toString();
                    String tipoPro =producto.getTipoProducto();

                    if (tipoPro.equals(prueba)){
                        cont = cont;
                        break;

                    }
                    cont = cont +1;
                }

                et_codigo.setText(producto.getCodigo());
                et_descripcion.setText(producto.getDescripcion());
                et_precio.setText(String.valueOf(producto.getPrecio()));
                disponible.setChecked(Boolean.valueOf(producto.isDisponible()));
                spinnerProducto.setSelection(cont);



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

    /*public void modificar(View view) {

        String codigo = et_codigo.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if (!codigo.isEmpty()) {

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

    /*@Override
    public void modificar(View view, Producto producto) {
        productoDAO = new ProductoDAO(this);
        productoDAO.modificar(producto);

    }*/

}

