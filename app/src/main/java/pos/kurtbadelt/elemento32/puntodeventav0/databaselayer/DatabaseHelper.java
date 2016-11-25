package pos.kurtbadelt.elemento32.puntodeventav0.databaselayer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Articulo;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.ArticulosEnComanda;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.ArticulosEnMenu;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.ArticulosEnPromocion;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Asistencia;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.BodegaInventario;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Cancelaciones;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.CategoriaMenu;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Cocina;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Comanda;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.ComandasEnCocina;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.ComandasEnMesa;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.ComandasEnVenta;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Comensales;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.DataLayerObject;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Empleado;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.EncuestaSatisfaccion;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.EstatusComanda;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.EstatusDeComandas;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.EstatusIngrediente;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.EstatusIngredientes;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.EvaluacionEmpleado;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Facturas;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Ingrediente;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.IngredientesEnBodega;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.MenuRestaurante;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Mesa;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.MotivosCancelacion;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Promociones;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.RecetasIngredientesEnArticulos;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.ReservacionMesa;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Reservaciones;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.TicketsFacturas;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.TipoCocina;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.TipoEmpleado;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.TipoMesa;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.TipoPago;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Venta;

/**
 * Created by kurtbadelt on 11/5/16.
 * Conexion a la base de datos de SQLITE incluida en los Assets
 * por el tamaño de la BD hay que evaluar hacer uso de multiples hilos.
 * se incluyen los selects inserts y updates para los tipos de datos
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "POS_Restaurante.sqlite";
    public static final String DBLOCATION = "/data/data/pos.kurtbadelt.elemento32.puntodeventav0/databases/";
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

    public List<Empleado> getAllEmpleados() {
        Empleado empleado = null;
        List<Empleado> listaEmpleados = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Empleado where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
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

    public List<TipoMesa> getAllTiopoMesa() {
        TipoMesa tipomesa = null;
        List<TipoMesa> listaTipoMesas = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from TipoMesa where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
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

    public List<RecetasIngredientesEnArticulos> getAllRecetas() {
        RecetasIngredientesEnArticulos receta = null;
        List<RecetasIngredientesEnArticulos> listaRecetas = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Recetas_IngredientesEnArticulos where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
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

    public List<String> getAllUserNames() {

        List<String> usuarios = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select UsuarioSistema from Empleado where EstatusEnSistema ='Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            usuarios.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return usuarios;

    }

    public String getPassword(String user) {
        String output = "";
        String query = "select password from Empleado where usuariosistema ='" + user + "'";
        openDatabase();
        Cursor cursor = mDatabase.rawQuery(query, null);
        cursor.moveToFirst();
        output = cursor.getString(0);
        cursor.close();
        closeDatabase();

        return output;
    }

    public boolean validarDisponibilidadUsuario(String user) {
        String query = "select count(*) from Empleado where UsuarioSistema = '" + user + "'";
        openDatabase();
        Cursor cursor = mDatabase.rawQuery(query, null);
        cursor.moveToFirst();
        int contador = cursor.getInt(0);
        cursor.close();
        closeDatabase();
        if (contador == 0) {
            return true;
        }

        return false;
    }

    //End of User related --------------------------------------------------------------------------


    //Inserts

    public long insertDataLayerObject(DataLayerObject objeto, String tabla) {
        this.openDatabase();
        long returnValue = mDatabase.insert(tabla, null, objeto.toDB());
        this.closeDatabase();
        return returnValue;


    }

    public long insertArticulo(Articulo objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }


    public long insertArticulosEnComanda(ArticulosEnComanda objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertArticulosEnMenu(ArticulosEnMenu objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertArticulosEnPromocion(ArticulosEnPromocion objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertAsistencia(Asistencia objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertBodegaInventario(BodegaInventario objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertCancelaciones(Cancelaciones objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertCategoriaMenu(CategoriaMenu objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertCocina(Cocina objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertComanda(Comanda objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertComandasEnCocina(ComandasEnCocina objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertComandasEnMesa(ComandasEnMesa objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertComandasEnVenta(ComandasEnVenta objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertComensales(Comensales objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertEmpleado(Empleado objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertEncuestaSatisfaccion(EncuestaSatisfaccion objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertEstatusComanda(EstatusComanda objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertEstatusDeComandas(EstatusDeComandas objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertEstatusIngrediente(EstatusIngrediente objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertEstatusIngredientes(EstatusIngredientes objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertEvaluacionEmpleado(EvaluacionEmpleado objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertFacturas(Facturas objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertIngrediente(Ingrediente objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertIngredientesEnBodega(IngredientesEnBodega objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertMenuRestaurante(MenuRestaurante objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertMesa(Mesa objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertMotivosCancelacion(MotivosCancelacion objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertPromociones(Promociones objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertRecetasIngredientesEnArticulos(RecetasIngredientesEnArticulos objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertReservaciones(Reservaciones objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertReservacionMesa(ReservacionMesa objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertTicketsFacturas(TicketsFacturas objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertTipoCocina(TipoCocina objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertTipoEmpleado(TipoEmpleado objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertTipoMesa(TipoMesa objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertTipoPago(TipoPago objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }

    public long insertVenta(Venta objeto) {
        long returnValue = this.insertDataLayerObject(objeto, objeto.getNombreTabla());
        return returnValue;

    }
}
