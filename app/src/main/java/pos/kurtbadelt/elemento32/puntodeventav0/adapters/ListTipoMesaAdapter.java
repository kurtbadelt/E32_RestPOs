package pos.kurtbadelt.elemento32.puntodeventav0.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import pos.kurtbadelt.elemento32.puntodeventav0.R;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.TipoMesa;

/**
 * Created by kurtbadelt on 11/5/16.
 */

public class ListTipoMesaAdapter extends BaseAdapter {
    private Context mContext;
    private List<TipoMesa> mTipoMesaList;

    public ListTipoMesaAdapter(Context mContext, List<TipoMesa> mTipoMesaList) {
        this.mContext = mContext;
        this.mTipoMesaList = mTipoMesaList;
    }


    @Override
    public int getCount() {
        return mTipoMesaList.size();
    }

    @Override
    public Object getItem(int i) {
        return mTipoMesaList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mTipoMesaList.get(i).getNumeroTipoMesa();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista = View.inflate(mContext, R.layout.tipomesa_listview,null);

        TextView tvNumeroTipoMesa = (TextView)vista.findViewById(R.id.tv_TipoMesa_NumeroTipoMesa);
        TextView tvNombreTipoMesa = (TextView)vista.findViewById(R.id.tv_TipoMesa_NombreTipoMesa);
        TextView tvDescripcionTipoMesa = (TextView)vista.findViewById(R.id.tv_TipoMesa_DescripcionTipoMesa);
        TextView tvEstausEnSistema = (TextView)vista.findViewById(R.id.tv_TipoMesa_EstatusENSistema);

        tvNumeroTipoMesa.setText("Numero Tipo de Mesa: "+mTipoMesaList.get(i).getNumeroTipoMesa());
        tvNombreTipoMesa.setText("Nombre TIpo de Mesa: "+mTipoMesaList.get(i).getNombreTipoMesa());
        tvDescripcionTipoMesa.setText("Descripcion: "+mTipoMesaList.get(i).getNombreTipoMesa());
        tvEstausEnSistema.setText("Estatus en Sistema: "+mTipoMesaList.get(i).getEstatusEnSistema());

        return vista;
    }

    public void updateList(List<TipoMesa> listItem){
        mTipoMesaList.clear();
        mTipoMesaList.addAll(listItem);
        this.notifyDataSetChanged();
    }
}
