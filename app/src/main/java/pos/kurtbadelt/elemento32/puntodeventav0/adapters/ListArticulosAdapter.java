package pos.kurtbadelt.elemento32.puntodeventav0.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pos.kurtbadelt.elemento32.puntodeventav0.R;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.Articulo;

/**
 * Created by kurtbadelt on 12/9/16.
 */

public class ListArticulosAdapter extends BaseAdapter {
    private Context mContext;
    private List<Articulo> listaArticulos;

    public ListArticulosAdapter(Context context, List<Articulo> listaArticulos) {
        this.mContext = context;
        this.listaArticulos = listaArticulos;
    }

    @Override
    public int getCount() {
        return listaArticulos.size();
    }

    @Override
    public Object getItem(int i) {
        return listaArticulos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listaArticulos.get(i).getNumeroArticulo();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista = View.inflate(mContext, R.layout.articulos_listview, null);

        TextView tvNumeroArticulo = (TextView) vista.findViewById(R.id.tv_Articulos_NumeroArticulo);
        TextView tvNombreArticulo = (TextView) vista.findViewById(R.id.tv_Articulos_NombreArticulo);
        TextView tvDescripcionArticulo = (TextView) vista.findViewById(R.id.tv_Articulos_DescripcionArticulo);
        TextView tvPrecio = (TextView) vista.findViewById(R.id.tv_Articulos_PrecioArticulo);

        return null;
    }

    public void updateList(List<Articulo> listaArticulos) {
        this.listaArticulos.clear();
        listaArticulos.addAll(listaArticulos);
        this.notifyDataSetChanged();
    }
}
