package pos.kurtbadelt.elemento32.puntodeventav0.databaselayer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.ArrayList;
import java.util.List;

import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Empleado;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.RecetasIngredientesEnArticulos;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.TipoMesa;

/**
 * Created by kurtbadelt on 11/5/16.
 * Conexion a la base de datos de SQLITE incluida en los Assets
 * por el tamaño de la BD hay que evaluar hacer uso de multiples hilos.
 * se incluyen los selects inserts y updates para los tipos de datos
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "POS_Restaurante.sqlite";
    public static final String DBLOCATION="/data/data/pos.kurtbadelt.elemento32.puntodeventav0/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public DatabaseHelper(Context context) {
        super(context, DBNAME, null, 1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if (mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if (mDatabase != null) {
            mDatabase.close();
        }
    }

    // Select All ----------------------------------------------------------------------------------

    public List<Empleado> getAllEmpleados(){
        Empleado empleado = null;
        List<Empleado> listaEmpleados = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Empleado where EstatusEnSistema = 'Activo'",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            empleado = new Empleado();

            empleado.setNumeroEmpleado(cursor.getInt(0));
            empleado.setNombre(cursor.getString(1));
            empleado.setApellido(cursor.getString(2));
            empleado.setFechaNacimiento(cursor.getString(3));
            empleado.setTelefonoCasa(cursor.getString(4));
            empleado.setTelefonoMovil(cursor.getString(5));
            empleado.setCalle(cursor.getString(6));
            empleado.setNumeroExterior_Interior(cursor.getString(7));
            empleado.setMunicipio_Delegacion(cursor.getString(8));
            empleado.setEstado(cursor.getString(9));
            empleado.setCodigoPostal(cursor.getString(10));
            empleado.setTipoEmpleado_NumeroTipoEmpleado(cursor.getInt(11));
            empleado.setEstatusEnSistema(cursor.getString(12));
            empleado.setUsuarioSistema(cursor.getString(13));
            empleado.setPassword(cursor.getString(14));

            listaEmpleados.add(empleado);
            cursor.moveToNext();


        }
        cursor.close();
        closeDatabase();
        return listaEmpleados;


    }

    public List<TipoMesa> getAllTiopoMesa(){
        TipoMesa tipomesa = null;
        List<TipoMesa> listaTipoMesas = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from TipoMesa where EstatusEnSistema = 'Activo'",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            tipomesa = new TipoMesa();

            tipomesa.setNumeroTipoMesa(cursor.getInt(0));
            tipomesa.setNombreTipoMesa(cursor.getString(1));
            tipomesa.setDescripcion(cursor.getString(2));
            tipomesa.setEstatusEnSistema(cursor.getString(3));

            listaTipoMesas.add(tipomesa);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
    return listaTipoMesas;
    }

    public List<RecetasIngredientesEnArticulos> getAllRecetas(){
        RecetasIngredientesEnArticulos receta = null;
        List<RecetasIngredientesEnArticulos> listaRecetas = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Recetas_IngredientesEnArticulos where EstatusEnSistema = 'Activo'",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            receta = new RecetasIngredientesEnArticulos();

            receta.setNumeroReceta(cursor.getInt(0));
            receta.setArticulo_NumeroArticulo(cursor.getInt(1));
            receta.setIngrediente_NumeroIngrediente(cursor.getInt(2));
            receta.setCantidad(cursor.getInt(3));
            receta.setFormaMedicion(cursor.getString(4));
            receta.setComentarios(cursor.getString(5));
            receta.setEstatusEnSistema(cursor.getString(6));

            listaRecetas.add(receta);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaRecetas;
    }


// End of Select All ------------------------------------------------------------------------------

// Select Users and pass

    public List<String> getAllUserNames(){

        List<String> usuarios = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select UsuarioSistema from Empleado where EstatusEnSistema ='Activo'",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){

            usuarios.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return usuarios;

    }

    public String getPassword(String user){
        String output="";
        String query = "select password from Empleado where usuariosistema ='"+user+"'";
        openDatabase();
        Cursor cursor = mDatabase.rawQuery(query,null);
        cursor.moveToFirst();
        output = cursor.getString(0);
        cursor.close();
        closeDatabase();

      return output;
    }

    public boolean validarDisponibilidadUsuario(String user){
        String query = "select count(*) from Empleado where UsuarioSistema = '"+user+"'";
        openDatabase();
        Cursor cursor = mDatabase.rawQuery(query,null);
        cursor.moveToFirst();
        int contador = cursor.getInt(0);
        cursor.close();
        closeDatabase();
        if(contador==0){
            return true;
        }

    return false;
    }

    //End of User related --------------------------------------------------------------------------


    //Inserts

    /*public void insertDataLayerObject(DataLayerObject objeto){


    }*/
}
