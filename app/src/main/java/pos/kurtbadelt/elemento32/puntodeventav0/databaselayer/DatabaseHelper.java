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


    /**
     * Pendiente de Arreglar Query
     *
     * @return
     */
    public List<Articulo> getAllArticulo() {
        Articulo articulo = null;
        List<Articulo> listaArticulos = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Articulos where EstatusEnSistema='Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articulo = new Articulo();

            articulo.setNumeroArticulo(cursor.getInt(0));
            articulo.setNombreArticulo(cursor.getString(1));
            articulo.setDescripcion(cursor.getString(2));
            articulo.setPrecio(cursor.getDouble(3));
            articulo.setCosto(cursor.getDouble(4));
            articulo.setEstatusEnSistema(cursor.getString(5));

            listaArticulos.add(articulo);
            cursor.moveToNext();

        }
        cursor.close();
        closeDatabase();
        return listaArticulos;
    }

    public List<ArticulosEnComanda> getAllArticulosEnComanda() {
        ArticulosEnComanda articulosEnComanda = null;
        List<ArticulosEnComanda> listaArticulosEnComanda = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from ArticulosEnComanda where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articulosEnComanda = new ArticulosEnComanda();

            articulosEnComanda.setComanda_NumeroComanda(cursor.getInt(0));
            articulosEnComanda.setArticulos_NumeroArticulo(cursor.getInt(1));
            articulosEnComanda.setEstatusEnSistema(cursor.getString(2));

            listaArticulosEnComanda.add(articulosEnComanda);
            cursor.moveToNext();

        }
        cursor.close();
        closeDatabase();
        return listaArticulosEnComanda;
    }

    public List<ArticulosEnMenu> getAllArticulosEnMenu() {
        ArticulosEnMenu articulosEnMenu = null;
        List<ArticulosEnMenu> listaArticulosEnMenu = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from ArticulosEnMenu where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            articulosEnMenu = new ArticulosEnMenu();

            articulosEnMenu.setMenu_NumeroMenu(cursor.getInt(0));
            articulosEnMenu.setArticulos_NumeroArticulo(cursor.getInt(1));
            articulosEnMenu.setEstatusEnSistema(cursor.getString(2));

            listaArticulosEnMenu.add(articulosEnMenu);
            cursor.moveToNext();

        }
        cursor.close();
        closeDatabase();
        return listaArticulosEnMenu;
    }

    public List<ArticulosEnPromocion> getAllArticulosEnPromocion() {
        ArticulosEnPromocion articulosEnPromocion = null;
        List<ArticulosEnPromocion> listaArticulosEnPromocion = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from ArticulosEnPromocion where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            articulosEnPromocion = new ArticulosEnPromocion();

            articulosEnPromocion.setArticulos_NumeroArticulo(cursor.getInt(0));
            articulosEnPromocion.setPromociones_NumeroPromocion(cursor.getInt(1));
            articulosEnPromocion.setEstatusEnSistema(cursor.getString(2));

            listaArticulosEnPromocion.add(articulosEnPromocion);
            cursor.moveToNext();

        }
        cursor.close();
        closeDatabase();
        return listaArticulosEnPromocion;

    }

    public List<Asistencia> getAllAsistencia() {
        Asistencia asistencia = null;
        List<Asistencia> listaAsistencia = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Asistencia where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {

            asistencia = new Asistencia();

            asistencia.setNumeroAsistencia(cursor.getInt(0));
            asistencia.setFechaHoraEntrada(cursor.getString(1));
            asistencia.setFechaHoraSalida(cursor.getString(2));
            asistencia.setComentarios(cursor.getString(3));
            asistencia.setEstatusEnSistema(cursor.getString(4));
            asistencia.setEmpleado_NumeroEmpleado(cursor.getInt(5));
            asistencia.setEmpleado_NumeroTipoEmpleado(cursor.getInt(6));

            listaAsistencia.add(asistencia);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaAsistencia;
    }

    public List<BodegaInventario> getAllBodegaInventario() {
        BodegaInventario bodegaInventario = null;
        List<BodegaInventario> listaBodegaInventario = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from BodegaInventario where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            bodegaInventario = new BodegaInventario();

            bodegaInventario.setNumeroBodega(cursor.getInt(0));
            bodegaInventario.setNombreBodega(cursor.getString(1));
            bodegaInventario.setDescripcion(cursor.getString(2));
            bodegaInventario.setUbicacion(cursor.getString(3));
            bodegaInventario.setEstatusEnSistema(cursor.getString(4));

            listaBodegaInventario.add(bodegaInventario);
            cursor.moveToNext();


        }
        cursor.close();
        closeDatabase();
        return listaBodegaInventario;

    }

    public List<Cancelaciones> getAllCancelaciones() {
        Cancelaciones cancelaciones = null;
        List<Cancelaciones> listaCancelaciones = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Cancelaciones where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            cancelaciones = new Cancelaciones();

            cancelaciones.setNumeroCancelacion(cursor.getInt(0));
            cancelaciones.setDescripcion(cursor.getString(1));
            cancelaciones.setAprobacion(cursor.getString(2));
            cancelaciones.setEstatusEnSistema(cursor.getString(3));
            cancelaciones.setComanda_NumeroComanda(cursor.getInt(4));
            cancelaciones.setMotivosCancelacion_NumeroMotivo(cursor.getInt(5));

            listaCancelaciones.add(cancelaciones);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaCancelaciones;

    }

    public List<CategoriaMenu> getAllCategoriaMenu() {
        CategoriaMenu categoriaMenu = null;
        List<CategoriaMenu> listaCategoriaMenu = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from CategoriaMenu where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            categoriaMenu = new CategoriaMenu();

            categoriaMenu.setNumeroCategoria(cursor.getInt(0));
            categoriaMenu.setNombreCategoria(cursor.getString(1));
            categoriaMenu.setDescripcion(cursor.getString(2));
            categoriaMenu.setMenu_NumeroMenu(cursor.getInt(3));
            categoriaMenu.setEstatusEnSistema(cursor.getString(4));

            listaCategoriaMenu.add(categoriaMenu);
            cursor.moveToNext();

        }
        cursor.close();
        closeDatabase();
        return listaCategoriaMenu;
    }

    public List<Cocina> getAllCocina() {
        Cocina cocina = null;
        List<Cocina> listaCocina = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Cocina where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            cocina = new Cocina();

            cocina.setNumeroCocina(cursor.getInt(0));
            cocina.setNumeroCocineros(cursor.getInt(1));
            cocina.setTipoCocina_NumeroTipoCocina(cursor.getInt(2));
            cocina.setEstatusEnSistema(cursor.getString(3));

            listaCocina.add(cocina);
            cursor.moveToNext();

        }
        cursor.close();
        closeDatabase();
        return listaCocina;
    }

    public List<Comanda> getAllComanda() {
        Comanda comanda = null;
        List<Comanda> listaComanda = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Comanda where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            comanda = new Comanda();

            comanda.setNumeroComanda(cursor.getInt(0));
            comanda.setNumeroComensales(cursor.getInt(1));
            comanda.setEmpleado_NumeroEmpleado(cursor.getInt(2));
            comanda.setEstatusEnSistema(cursor.getString(3));
            comanda.setEmpleado_NumeroTipoEmpleado(cursor.getInt(4));

            listaComanda.add(comanda);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaComanda;
    }

    public List<ComandasEnCocina> getAllComandasEnCocina() {
        ComandasEnCocina comandasEnCocina = null;
        List<ComandasEnCocina> listaComandasEnCocina = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from ComandasEnCocina where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            comandasEnCocina = new ComandasEnCocina();

            comandasEnCocina.setCocina_NumeroCocina(cursor.getInt(0));
            comandasEnCocina.setComanda_NumeroComanda(cursor.getInt(1));
            comandasEnCocina.setEstatusEnSistema(cursor.getString(2));

            listaComandasEnCocina.add(comandasEnCocina);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaComandasEnCocina;

    }

    public List<ComandasEnMesa> getAllComandasEnMesa() {
        ComandasEnMesa comandasEnMesa = null;
        List<ComandasEnMesa> listaComandasEnMesa = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from ComandasEnMesa where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            comandasEnMesa = new ComandasEnMesa();

            comandasEnMesa.setComanda_NumeroComanda(cursor.getInt(0));
            comandasEnMesa.setMesa_NumeroMesa(cursor.getInt(1));
            comandasEnMesa.setMesa_NumeroEmpleado(cursor.getInt(2));
            comandasEnMesa.setMesa_NumeroTipoEmpleado(cursor.getInt(3));
            comandasEnMesa.setMesa_NumeroTipoMesa(cursor.getInt(4));
            comandasEnMesa.setEstatusEnSistema(cursor.getString(5));

            listaComandasEnMesa.add(comandasEnMesa);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaComandasEnMesa;
    }


    public List<ComandasEnVenta> getAllComandasEnVenta() {
        ComandasEnVenta comandasEnVenta = null;
        List<ComandasEnVenta> listaComandasEnVenta = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from ComandasEnVenta where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            comandasEnVenta = new ComandasEnVenta();

            comandasEnVenta.setVenta_NumeroTicket(cursor.getInt(0));
            comandasEnVenta.setVenta_NumeroTipoPago(cursor.getInt(1));
            comandasEnVenta.setComanda_NumeroComanda(cursor.getInt(2));
            comandasEnVenta.setComanda_NumeroComanda(cursor.getShort(3));

            listaComandasEnVenta.add(comandasEnVenta);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaComandasEnVenta;
    }

    public List<Comensales> getAllComensales() {
        Comensales comensales = null;
        List<Comensales> listaComensales = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Comensales where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            comensales = new Comensales();

            comensales.setNumeroComensal(cursor.getInt(0));
            comensales.setNombreComensal(cursor.getString(1));
            comensales.setApellidoComensal(cursor.getString(2));
            comensales.setCorreoElectronico(cursor.getString(3));
            comensales.setEstatusEnSistema(cursor.getString(4));

            listaComensales.add(comensales);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaComensales;
    }

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

    public List<EncuestaSatisfaccion> getAllEncuestaSatisfaccion() {
        EncuestaSatisfaccion encuestaSatisfaccion = null;
        List<EncuestaSatisfaccion> listaEncuestaSatisfaccion = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from EncuestaSatisfaccion where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            encuestaSatisfaccion = new EncuestaSatisfaccion();

            encuestaSatisfaccion.setNumeroEncuesta(cursor.getInt(0));
            encuestaSatisfaccion.setDescripcionPregunta1(cursor.getString(1));
            encuestaSatisfaccion.setEvaluacionPregunta1(cursor.getInt(2));
            encuestaSatisfaccion.setDescripcionPregunta2(cursor.getString(3));
            encuestaSatisfaccion.setEvaluacionPregunta2(cursor.getInt(4));
            encuestaSatisfaccion.setDescripcionPregunta3(cursor.getString(5));
            encuestaSatisfaccion.setEvaluacionPregunta3(cursor.getInt(6));
            encuestaSatisfaccion.setDescripcionPregunta4(cursor.getString(7));
            encuestaSatisfaccion.setEvaluacionPregunta4(cursor.getInt(8));
            encuestaSatisfaccion.setDescripcionPregunta5(cursor.getString(9));
            encuestaSatisfaccion.setEvaluacionPregunta5(cursor.getInt(10));
            encuestaSatisfaccion.setComentariosCliente(cursor.getString(11));
            encuestaSatisfaccion.setEstatusEnSistema(cursor.getString(12));
            encuestaSatisfaccion.setVenta_NumeroTicket(cursor.getInt(13));
            encuestaSatisfaccion.setVenta_NumeroTipoPago(cursor.getInt(14));

            listaEncuestaSatisfaccion.add(encuestaSatisfaccion);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaEncuestaSatisfaccion;
    }


    public List<EstatusComanda> getAllEstatusComanda() {
        EstatusComanda estatusComanda = null;
        List<EstatusComanda> listaEstatusComanda = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from EstatusComanda where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            estatusComanda = new EstatusComanda();

            estatusComanda.setNumeroEstatus(cursor.getInt(0));
            estatusComanda.setNombreEstatus(cursor.getString(1));
            estatusComanda.setDescripcion(cursor.getString(2));
            estatusComanda.setEstatusEnSistema(cursor.getString(3));

            listaEstatusComanda.add(estatusComanda);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaEstatusComanda;
    }

    public List<EstatusDeComandas> getAllEstatusDeComandas() {
        EstatusDeComandas estatusDeComandas = null;
        List<EstatusDeComandas> listaEstatusDeComandas = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from EstatusDeComandas where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            estatusDeComandas = new EstatusDeComandas();

            estatusDeComandas.setEstatusComanda_NumeroEstatus(cursor.getInt(0));
            estatusDeComandas.setComanda_NumeroComanda(cursor.getInt(1));
            estatusDeComandas.setFechaHoraIngreso(cursor.getString(2));
            estatusDeComandas.setEstatusEnSistema(cursor.getString(3));

            listaEstatusDeComandas.add(estatusDeComandas);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaEstatusDeComandas;
    }

    public List<EstatusIngrediente> getAllEstatusIngrediente() {
        EstatusIngrediente estatusIngrediente = null;
        List<EstatusIngrediente> listaEstatusIngrediente = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from EstatusIngrediente where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            estatusIngrediente = new EstatusIngrediente();

            estatusIngrediente.setNumeroEstatusIngrediente(cursor.getInt(0));
            estatusIngrediente.setNombreEstatusIngrediente(cursor.getString(1));
            estatusIngrediente.setDescripcion(cursor.getString(2));
            estatusIngrediente.setEstatusEnSistema(cursor.getString(3));

            listaEstatusIngrediente.add(estatusIngrediente);
            cursor.moveToNext();

        }
        cursor.close();
        closeDatabase();
        return listaEstatusIngrediente;
    }

    public List<EstatusIngredientes> getAllEstatusIngredientes() {
        EstatusIngredientes estatusIngredientes = null;
        List<EstatusIngredientes> listaEstatusIngredientes = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from EstatusIngredientes where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            estatusIngredientes = new EstatusIngredientes();

            estatusIngredientes.setIngrediente_NumeroIngrediente(cursor.getInt(0));
            estatusIngredientes.setEstatusIngrediente_NumeroEstatusIngrediente(cursor.getInt(1));
            estatusIngredientes.setEstatusEnSistema(cursor.getString(2));

            listaEstatusIngredientes.add(estatusIngredientes);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaEstatusIngredientes;
    }

    public List<EvaluacionEmpleado> getAllEvaluacionEmpleado() {
        EvaluacionEmpleado evaluacionEmpleado = null;
        List<EvaluacionEmpleado> listaEvaluacionEmpleado = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from EvaluacionEmpleado where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            evaluacionEmpleado = new EvaluacionEmpleado();

            evaluacionEmpleado.setNumeroEvaluacion(cursor.getInt(0));
            evaluacionEmpleado.setDescripcionPregunta1(cursor.getString(1));
            evaluacionEmpleado.setEvaluacionPregunta1(cursor.getInt(2));
            evaluacionEmpleado.setDescripcionPregunta2(cursor.getString(3));
            evaluacionEmpleado.setEvaluacionPregunta2(cursor.getInt(4));
            evaluacionEmpleado.setDescripcionPregunta3(cursor.getString(5));
            evaluacionEmpleado.setEvaluacionPregunta3(cursor.getInt(6));
            evaluacionEmpleado.setDescripcionPregunta4(cursor.getString(7));
            evaluacionEmpleado.setEvaluacionPregunta4(cursor.getInt(8));
            evaluacionEmpleado.setDescripcionPregunta5(cursor.getString(9));
            evaluacionEmpleado.setEvaluacionPregunta5(cursor.getInt(10));
            evaluacionEmpleado.setComentariosSupervisor(cursor.getString(11));
            evaluacionEmpleado.setEmpleado_NumeroEmpleado(cursor.getInt(12));
            evaluacionEmpleado.setEmpleado_NumeroTipoEmpleado(cursor.getInt(13));
            evaluacionEmpleado.setEstatusEnSistema(cursor.getString(14));

            listaEvaluacionEmpleado.add(evaluacionEmpleado);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaEvaluacionEmpleado;
    }

    public List<Facturas> getAllFacturas() {
        Facturas facturas = null;
        List<Facturas> listaFacturas = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Facturas where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            facturas = new Facturas();

            facturas.setNumeroFactura(cursor.getInt(0));
            facturas.setUUID(cursor.getString(1));
            facturas.setRFC(cursor.getString(2));
            facturas.setSubTotal(cursor.getDouble(3));
            facturas.setIva(cursor.getDouble(4));
            facturas.setTotal(cursor.getDouble(5));
            facturas.setDescripcion(cursor.getString(6));
            facturas.setEstatusEnSistema(cursor.getString(7));

            listaFacturas.add(facturas);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaFacturas;
    }

    public List<Ingrediente> getAllIngrediente() {
        Ingrediente ingrediente = null;
        List<Ingrediente> listaIngrediente = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Ingrediente where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ingrediente = new Ingrediente();

            ingrediente.setNumeroIngrediente(cursor.getInt(0));
            ingrediente.setNombreIngrediente(cursor.getString(1));
            ingrediente.setDescripcion(cursor.getString(2));
            ingrediente.setExistencia(cursor.getDouble(3));
            ingrediente.setPrecioCompra(cursor.getDouble(4));
            ingrediente.setPrecioVenta(cursor.getDouble(5));
            ingrediente.setTiempoEntregaDias(cursor.getInt(6));
            ingrediente.setFormatoMedicion(cursor.getString(7));
            ingrediente.setInventarioMinimo(cursor.getDouble(8));
            ingrediente.setInventarioMaximo(cursor.getDouble(9));
            ingrediente.setEstatusEnSistema(cursor.getString(10));

            listaIngrediente.add(ingrediente);

            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaIngrediente;
    }


    public List<IngredientesEnBodega> selectAllIngredientesEnBodega() {
        IngredientesEnBodega ingredientesEnBodega = null;
        List<IngredientesEnBodega> listaIngredientesEnBodega = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from IngredientesEnBodega where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ingredientesEnBodega = new IngredientesEnBodega();

            ingredientesEnBodega.setIngrediente_NumeroIngrediente(cursor.getInt(0));
            ingredientesEnBodega.setBodegaInventario_NumeroBodega(cursor.getInt(1));
            ingredientesEnBodega.setEstatusEnSistema(cursor.getString(2));

            listaIngredientesEnBodega.add(ingredientesEnBodega);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaIngredientesEnBodega;
    }


    public List<MenuRestaurante> getAllMenuRestaurante() {
        MenuRestaurante menuRestaurante = null;
        List<MenuRestaurante> listaMenuRestaurante = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Menu where EstatusEnSistema ='Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            menuRestaurante = new MenuRestaurante();

            menuRestaurante.setNumeroMenu(cursor.getInt(0));
            menuRestaurante.setNombreMenu(cursor.getString(1));
            menuRestaurante.setDescripcion(cursor.getString(2));
            menuRestaurante.setEstatusEnSistema(cursor.getString(3));

            listaMenuRestaurante.add(menuRestaurante);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaMenuRestaurante;
    }

    public List<Mesa> getAllMesa() {
        Mesa mesa = null;
        List<Mesa> listaMesa = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Mesa where EstatusEnSistema ='Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            mesa = new Mesa();

            mesa.setNumeroDeMesa(cursor.getInt(0));
            mesa.setNumeroDeComensales(cursor.getInt(1));
            mesa.setEmpleado_NumeroEmpleado(cursor.getInt(2));
            mesa.setEmpleado_NumeroTipoEmpleado(cursor.getInt(3));
            mesa.setComensales_NumeroComensal(cursor.getInt(4));
            mesa.setTipoMesa_NumeroTipoMesa(cursor.getInt(5));
            mesa.setEstatusEnSistema(cursor.getString(6));

            listaMesa.add(mesa);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaMesa;
    }

    public List<MotivosCancelacion> getAllMotivosCancelacion() {
        MotivosCancelacion motivosCancelacion = null;
        List<MotivosCancelacion> listaMotivosCancelacion = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from MotivosCancelacion where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            motivosCancelacion = new MotivosCancelacion();

            motivosCancelacion.setNumeroMotivo(cursor.getInt(0));
            motivosCancelacion.setNombreMotivo(cursor.getString(1));
            motivosCancelacion.setDescripcion(cursor.getString(2));
            motivosCancelacion.setEstatusEnSistema(cursor.getString(3));

            listaMotivosCancelacion.add(motivosCancelacion);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaMotivosCancelacion;
    }

    public List<Promociones> getAllPromociones() {
        Promociones promociones = null;
        List<Promociones> listaPromociones = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Promociones where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            promociones = new Promociones();

            promociones.setNumeroPromocion(cursor.getInt(0));
            promociones.setNombrePromocion(cursor.getString(1));
            promociones.setDescripcion(cursor.getString(2));
            promociones.setInicioPromocion(cursor.getString(3));
            promociones.setFinPromocion(cursor.getString(4));
            promociones.setDescuento(cursor.getDouble(5));
            promociones.setEstatusEnSistema(cursor.getString(6));

            listaPromociones.add(promociones);
            cursor.moveToNext();

        }
        cursor.close();
        closeDatabase();
        return listaPromociones;
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

    public List<ReservacionMesa> getAllReservacionMesa() {
        ReservacionMesa reservacionMesa = null;
        List<ReservacionMesa> listaReservacionesMesa = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from ReservacionMesa where EstatusEnSistema = 'Activo'", null);
        while (!cursor.isAfterLast()) {
            reservacionMesa = new ReservacionMesa();

            reservacionMesa.setMesa_numeroMesa(cursor.getInt(0));
            reservacionMesa.setMesa_Empleado_NumeroEmpleado(cursor.getInt(1));
            reservacionMesa.setMesa_Empleado_NumeroTipoEmpleado(cursor.getInt(2));
            reservacionMesa.setMesa_NumeroTipoMesa(cursor.getInt(3));
            reservacionMesa.setReservaciones_NumeroReservacion(cursor.getInt(4));
            reservacionMesa.setEstatusEnSistema(cursor.getString(5));

            listaReservacionesMesa.add(reservacionMesa);
            cursor.moveToNext();
        }

        cursor.close();
        closeDatabase();
        return listaReservacionesMesa;
    }


    public List<Reservaciones> getAllReservaciones() {
        Reservaciones reservaciones = null;
        List<Reservaciones> listaReservaciones = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Reservaciones where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            reservaciones = new Reservaciones();

            reservaciones.setNumeroReservacion(cursor.getInt(0));
            reservaciones.setFechaReservacion(cursor.getString(1));
            reservaciones.setVigenciaReservacion(cursor.getString(2));
            reservaciones.setNombreComensal(cursor.getString(3));
            reservaciones.setNumeroDeComensales(cursor.getInt(4));
            reservaciones.setComensales_NumeroComensal(cursor.getInt(5));
            reservaciones.setEstatusEnSistema(cursor.getString(6));

            listaReservaciones.add(reservaciones);
            cursor.moveToNext();

        }
        cursor.close();
        closeDatabase();
        return listaReservaciones;
    }

    public List<TicketsFacturas> getAllTicketFacturas() {
        TicketsFacturas ticketsFacturas = null;
        List<TicketsFacturas> listaTicketFacturas = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from TicketsFacturas where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ticketsFacturas = new TicketsFacturas();

            ticketsFacturas.setVenta_NumeroTicket(cursor.getInt(0));
            ticketsFacturas.setVenta_NumeroTipoPago(cursor.getInt(1));
            ticketsFacturas.setFacturas_NumeroFactura(cursor.getInt(2));
            ticketsFacturas.setEstatusEnSistema(cursor.getString(3));

            listaTicketFacturas.add(ticketsFacturas);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaTicketFacturas;

    }

    public List<TipoCocina> getAllTipoCocina() {
        TipoCocina tipoCocina = null;
        List<TipoCocina> listaTipoCocina = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from TipoCocina where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            tipoCocina = new TipoCocina();

            tipoCocina.setNumeroTipoCocina(cursor.getInt(0));
            tipoCocina.setNombreTipoCocina(cursor.getString(1));
            tipoCocina.setDescripcionTipoCocina(cursor.getString(2));
            tipoCocina.setEstatusEnSistema(cursor.getString(3));

            listaTipoCocina.add(tipoCocina);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaTipoCocina;
    }

    /**
     * @return
     */
    public List<TipoPago> getAllTipoPago() {
        TipoPago tipoPago = null;
        List<TipoPago> listaTipoPago = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from TipoDePago where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            tipoPago = new TipoPago();

            tipoPago.setNumeroTipoDePago(cursor.getInt(0));
            tipoPago.setNombreTipoDePago(cursor.getString(1));
            tipoPago.setDescripcionTIpoDePago(cursor.getString(2));
            tipoPago.setEstatusEnSistema(cursor.getString(3));

            listaTipoPago.add(tipoPago);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaTipoPago;

    }

    public List<TipoEmpleado> getAllTipoEmpleado() {
        TipoEmpleado tipoEmpleado = null;
        List<TipoEmpleado> listaTipoEmpleado = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from TipoEmpleado where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            tipoEmpleado = new TipoEmpleado();

            tipoEmpleado.setNumeroTipoEmpleado(cursor.getInt(0));
            tipoEmpleado.setNombreTipoEmpleado(cursor.getString(1));
            tipoEmpleado.setDescripcion(cursor.getString(2));
            tipoEmpleado.setEstatusEnSistema(cursor.getString(3));

            listaTipoEmpleado.add(tipoEmpleado);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaTipoEmpleado;
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

    public List<Venta> getAllVentas() {
        Venta venta = null;
        List<Venta> listaVentas = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("select * from Venta where EstatusEnSistema = 'Activo'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            venta = new Venta();

            venta.setNumeroTicket(cursor.getInt(0));
            venta.setNumeroFactura(cursor.getInt(1));
            venta.setMontoTotal(cursor.getDouble(2));
            venta.setEstatusEnSistema(cursor.getString(3));
            venta.setTipoDePago_NumeroTipoPago(cursor.getInt(4));

            listaVentas.add(venta);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return listaVentas;
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
