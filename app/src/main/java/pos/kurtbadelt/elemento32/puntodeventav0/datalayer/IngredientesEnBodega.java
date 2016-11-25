package pos.kurtbadelt.elemento32.puntodeventav0.datalayer;

import android.content.ContentValues;

/**
 * Created by kurtbadelt on 11/2/16.
 */

public class IngredientesEnBodega extends DataLayerObject {


    private String nombreTabla = "IngredientesEnBodega";
    private int ingrediente_NumeroIngrediente=0;
    private int bodegaInventario_NumeroBodega=0;
    private String estatusEnSistema="";

    public int getIngrediente_NumeroIngrediente() {
        return ingrediente_NumeroIngrediente;
    }

    public void setIngrediente_NumeroIngrediente(int ingrediente_NumeroIngrediente) {
        this.ingrediente_NumeroIngrediente = ingrediente_NumeroIngrediente;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }


    public int getBodegaInventario_NumeroBodega() {
        return bodegaInventario_NumeroBodega;
    }

    public void setBodegaInventario_NumeroBodega(int bodegaInventario_NumeroBodega) {
        this.bodegaInventario_NumeroBodega = bodegaInventario_NumeroBodega;
    }

    public String getEstatusEnSistema() {
        return estatusEnSistema;
    }

    public void setEstatusEnSistema(String estatusEnSistema) {
        this.estatusEnSistema = estatusEnSistema;
    }
    public String toString(){
        String output="";
        output=this.getIngrediente_NumeroIngrediente()+";"+this.getBodegaInventario_NumeroBodega()+";"+this.getEstatusEnSistema();
        return output;
    }
    public ContentValues toDB(){
        ContentValues output = new ContentValues();
        output.put("Ingrediente_NumeroIngrediente",this.getIngrediente_NumeroIngrediente());
        output.put("BodegaInventario_NumeroBodega",this.getBodegaInventario_NumeroBodega());
        output.put("EstatusEnSistema",this.getEstatusEnSistema());

        return output;

    }
}
