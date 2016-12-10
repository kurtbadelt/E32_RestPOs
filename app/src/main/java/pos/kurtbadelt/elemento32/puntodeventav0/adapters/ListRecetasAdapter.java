package pos.kurtbadelt.elemento32.puntodeventav0.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pos.kurtbadelt.elemento32.puntodeventav0.R;
import pos.kurtbadelt.elemento32.puntodeventav0.datalayer.RecetasIngredientesEnArticulos;

/**
 * Created by kurtbadelt on 11/6/16.
 */

public class ListRecetasAdapter extends BaseAdapter {
    private Context mContext;
    private List<RecetasIngredientesEnArticulos> mListaRecetas;

    @Override
    public int getCount() {
        return mListaRecetas.size();
    }

    @Override
    public Object getItem(int i) {
        return mListaRecetas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mListaRecetas.get(i).getNumeroReceta();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista = View.inflate(mContext, R.layout.recetas_listview, null);

        TextView tvNumeroReceta = (TextView) vista.findViewById(R.id.tv_Recetas_NumeroDeReceta);
        TextView tvNumeroArticuloEnReceta = (TextView) vista.findViewById(R.id.tv_Recetas_NumeroArticuloEnReceta);
        TextView tvIngredienteEnReceta = (TextView) vista.findViewById(R.id.tv_Recetas_Ingrediente_NumeroIngrediente);
        TextView tvCantidadIngrediente = (TextView) vista.findViewById(R.id.tv_Recetas_Ingrediente_CantidadEnReceta);
        TextView tvFormaMedicion = (TextView) vista.findViewById(R.id.tv_Recetas_FormatoMedicion);
        TextView tvComentariosReceta = (TextView) vista.findViewById(R.id.tv_Recetas_Comentarios);
        TextView tvEstatusEnSistema = (TextView) vista.findViewById(R.id.tv_Recetas_EstatusEnSistema);

        tvNumeroReceta.setText("Numero de Receta: " + mListaRecetas.get(i).getNumeroReceta());
        tvNumeroArticuloEnReceta.setText("Numero Articulo: " + mListaRecetas.get(i).getArticulo_NumeroArticulo());
        tvIngredienteEnReceta.setText("Numero de Ingrediente: " + mListaRecetas.get(i).getIngrediente_NumeroIngrediente());
        tvCantidadIngrediente.setText("Cantidad Ingrediente: " + mListaRecetas.get(i).getCantidad());
        tvFormaMedicion.setText("Forma de Medida: " + mListaRecetas.get(i).getFormaMedicion());
        tvComentariosReceta.setText("Comentarios: " + mListaRecetas.get(i).getComentarios());
        tvEstatusEnSistema.setText(("Estatus en Sistema: " + mListaRecetas.get(i).getEstatusEnSistema()));


        return vista;
    }

    public void updateList(List<RecetasIngredientesEnArticulos> listItem) {
        mListaRecetas.clear();
        mListaRecetas.addAll(listItem);
        this.notifyDataSetChanged();
    }


}
