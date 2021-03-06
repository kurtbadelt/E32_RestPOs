package pos.kurtbadelt.elemento32.puntodeventav0;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import pos.kurtbadelt.elemento32.puntodeventav0.adapters.ListEmpleadoAdapter;
import pos.kurtbadelt.elemento32.puntodeventav0.databaselayer.DatabaseHelper;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Empleado;

public class activity_Empleados extends AppCompatActivity {

    private ListView lvEmpleado;
    private ListEmpleadoAdapter empleadoAdapter;
    private List<Empleado> mEmpleadoList;
    private DatabaseHelper mDBHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleados);

        lvEmpleado = (ListView) findViewById(R.id.listview_empleado);

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

        // Iniciar adaptador
        empleadoAdapter = new ListEmpleadoAdapter(this,mEmpleadoList);

        //Set Adaptador
        lvEmpleado.setAdapter(empleadoAdapter);
        registerForContextMenu(lvEmpleado);
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
