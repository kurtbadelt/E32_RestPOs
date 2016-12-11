package pos.kurtbadelt.elemento32.puntodeventav0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NavegarDB extends AppCompatActivity {
    private static Button botonVerArticulos;
    private static Button botonVerRecetas;
    private static Button botonVerTipoMesa;
    private static Button botonVerEmpleados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegar_db);
        this.botonVerArticulos();
        this.botonVerRecetas();
        this.botonVerTipoMesa();
        this.botonVerEmpleados();
    }

    public void botonVerArticulos(){
        this.botonVerArticulos = (Button) findViewById(R.id.buttonViewArticulos);
        this.botonVerArticulos.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){

                    }
                }
        );
    }
    public void botonVerRecetas(){
        this.botonVerRecetas = (Button) findViewById(R.id.buttonViewRecetas);
        this.botonVerRecetas.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){

                    }
                }
        );
    }
    public void botonVerTipoMesa(){
        this.botonVerTipoMesa = (Button) findViewById(R.id.buttonViewTipoMesa);
        this.botonVerTipoMesa.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){

                    }
                }
        );
    }
    public void botonVerEmpleados(){
        this.botonVerEmpleados = (Button) findViewById(R.id.buttonViewEmpleados);
        this.botonVerEmpleados.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Log.i("****GetAllArticulo","FUUUUUUUUUUUUUUUUUUCK");
                        Toast.makeText(NavegarDB.this,"----->  Boton Ver Articulos", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent("pos.kurtbadelt.elemento32.puntodeventav0.activity_Empleados");
                        startActivity(intent);
                    }
                }
        );
    }

}
