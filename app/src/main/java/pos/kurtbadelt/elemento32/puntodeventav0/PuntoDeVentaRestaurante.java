package pos.kurtbadelt.elemento32.puntodeventav0;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import pos.kurtbadelt.elemento32.puntodeventav0.adapters.ListArticulosAdapter;
import pos.kurtbadelt.elemento32.puntodeventav0.adapters.ListEmpleadoAdapter;
import pos.kurtbadelt.elemento32.puntodeventav0.adapters.ListTipoMesaAdapter;
import pos.kurtbadelt.elemento32.puntodeventav0.databaselayer.*;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Articulo;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Empleado;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.TipoMesa;

public class PuntoDeVentaRestaurante extends AppCompatActivity {
    private ListView lvEmpleado;
    private ListView lvTipoMesa;
  //  private ListView lvArticulo;

    private ListEmpleadoAdapter empleadoAdapter;
    private List<Empleado> mEmpleadoList;

   // private ListArticulosAdapter articulosAdapter;
    //private List<Articulo> mArticuloList;

    private ListTipoMesaAdapter tipoMesaAdapter;
    private List<TipoMesa> mTipoMesaList;

    private DatabaseHelper mDBHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvEmpleado = (ListView) findViewById(R.id.listview_empleado);
        lvTipoMesa = (ListView) findViewById(R.id.listview_TipoMesa);
      //  lvArticulo = (ListView) findViewById(R.id.listview_Articulo);

        mDBHelper = new DatabaseHelper(this);

        //Validar existencia de la base de datos
        File database = getApplicationContext().getDatabasePath(DatabaseHelper.DBNAME);
        if(!database.exists()) {
            mDBHelper.getReadableDatabase();
            //Copy db
            if(copyDatabase(this)) {
                Toast.makeText(this, "Copy database succes", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        // Leer base de datos
        mEmpleadoList = mDBHelper.getAllEmpleados();
        mTipoMesaList = mDBHelper.getAllTiopoMesa();
       // mArticuloList = mDBHelper.getAllArticulo();

        // Iniciar adaptador
        empleadoAdapter = new ListEmpleadoAdapter(this,mEmpleadoList);
        tipoMesaAdapter = new ListTipoMesaAdapter(this,mTipoMesaList);
       // articulosAdapter = new ListArticulosAdapter(this,mArticuloList);

        //Set Adaptador
       // lvArticulo.setAdapter(articulosAdapter);
        lvEmpleado.setAdapter(empleadoAdapter);
        lvTipoMesa.setAdapter(tipoMesaAdapter);

       // registerForContextMenu(lvArticulo);
        registerForContextMenu(lvEmpleado);
        registerForContextMenu(lvTipoMesa);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_punto_de_venta_restaurante, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean copyDatabase(Context context) {
        try {

            InputStream inputStream = context.getAssets().open(DatabaseHelper.DBNAME);
            String outFileName = DatabaseHelper.DBLOCATION + DatabaseHelper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[]buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("MainActivity","DB copied");
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
