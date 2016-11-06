package pos.kurtbadelt.elemento32.puntodeventav0.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pos.kurtbadelt.elemento32.puntodeventav0.R;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Empleado;

/**
 * Created by kurtbadelt on 11/5/16.
 */

public class ListEmpleadoAdapter extends BaseAdapter {
    private Context mContext;
    private List<Empleado> mEmpleadoList;

    public ListEmpleadoAdapter(Context mContext, List<Empleado> mEmpleadoList) {
        this.mContext = mContext;
        this.mEmpleadoList = mEmpleadoList;
    }

    @Override
    public int getCount() {
        return mEmpleadoList.size();
    }

    @Override
    public Object getItem(int pos) {
        return mEmpleadoList.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return mEmpleadoList.get(pos).getNumeroEmpleado();
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {

        View vista = View.inflate(mContext, R.layout.empleado_listview,null);

        TextView tvNumeroEmpleado = (TextView)vista.findViewById(R.id.tv_Empleado_numeroEmpleado);
        TextView tvNombreEmpleado = (TextView)vista.findViewById(R.id.tv_Empleado_nombreEmpleado);
        TextView tvApellidoEmpleado = (TextView)vista.findViewById(R.id.tv_Empleado_apellidoEmpleado);
        TextView tvFechaNacimiento = (TextView)vista.findViewById(R.id.tv_Empleado_fechaNacimiento);
        TextView tvTelefonoCasa = (TextView)vista.findViewById(R.id.tv_Empleado_telefonoCasa);
        TextView tvTelefonoMovil = (TextView)vista.findViewById(R.id.tv_Empleado_telefonoMovil);
        TextView tvCalle = (TextView)vista.findViewById(R.id.tv_Empleado_calle);
        TextView tvNumeroExtInt = (TextView)vista.findViewById(R.id.tv_Empleado_NumeroExteriorInterior);
        TextView tvMunicipioDelegacion = (TextView)vista.findViewById(R.id.tv_Empleado_MunicipioDelegacion);
        TextView tvEstado = (TextView)vista.findViewById(R.id.tv_Empleado_Estado);
        TextView tvCodigoPostal = (TextView)vista.findViewById(R.id.tv_Empleado_CodigoPostal);
        TextView tvTipoEmpleado = (TextView)vista.findViewById(R.id.tv_Empleado_tipoEmpleado);
        TextView tvEstatusEnSistema = (TextView)vista.findViewById(R.id.tv_Empleado_EstatusEnSistema);
        TextView tvUsuario = (TextView)vista.findViewById(R.id.tv_Empleado_Usuario);
        TextView tvPassword = (TextView)vista.findViewById(R.id.tv_Empleado_Password);




        tvNombreEmpleado.setText("Nombre: "+mEmpleadoList.get(pos).getNombre());
        tvApellidoEmpleado.setText("Apellido: "+mEmpleadoList.get(pos).getApellido());
        tvTipoEmpleado.setText("Tipo Empleado: "+String.valueOf(mEmpleadoList.get(pos).getTipoEmpleado_NumeroTipoEmpleado()));
        tvNumeroEmpleado.setText("Numero Empleado: "+String.valueOf(mEmpleadoList.get(pos).getNumeroEmpleado()));
        tvFechaNacimiento.setText("Fecha de Nacimiento: "+mEmpleadoList.get(pos).getFechaNacimiento());
        tvTelefonoCasa.setText("Telefono Casa: "+mEmpleadoList.get(pos).getTelefonoCasa());
        tvTelefonoMovil.setText("Telefono Movil: "+mEmpleadoList.get(pos).getTelefonoMovil());
        tvCalle.setText("Calle: "+mEmpleadoList.get(pos).getCalle());
        tvNumeroExtInt.setText("Numero Exterior e Interior: "+mEmpleadoList.get(pos).getNumeroExterior_Interior());
        tvMunicipioDelegacion.setText("Municipio/Delegacion: "+mEmpleadoList.get(pos).getMunicipio_Delegacion());
        tvEstado.setText("Estado: "+mEmpleadoList.get(pos).getEstado());
        tvEstatusEnSistema.setText("Estatus en Sistema: "+mEmpleadoList.get(pos).getEstatusEnSistema());
        tvCodigoPostal.setText("Codigo Postal: "+mEmpleadoList.get(pos).getCodigoPostal());
        tvUsuario.setText("Usuario: "+mEmpleadoList.get(pos).getUsuarioSistema());
        tvPassword.setText("Password: "+mEmpleadoList.get(pos).getPassword());

        return vista;
    }

    public void updateList(List<Empleado> lstItem){
        mEmpleadoList.clear();
        mEmpleadoList.addAll(lstItem);
        this.notifyDataSetChanged();
    }
}
