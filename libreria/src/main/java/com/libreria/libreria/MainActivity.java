package com.libreria;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.libreria.api.ApiClient;
import com.libreria.api.VentaApi;
import com.libreria.Entity.Venta;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText libroInput;
    private EditText cantidadInput;
    private EditText precioInput;
    private Button registrarVentaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Conecta las variables con los elementos visuales del archivo XML
        libroInput = findViewById(R.id.libro_input);
        cantidadInput = findViewById(R.id.cantidad_input);
        precioInput = findViewById(R.id.precio_input);
        registrarVentaButton = findViewById(R.id.registrar_venta_button);

        // Define qué sucede al hacer clic en el botón
        registrarVentaButton.setOnClickListener(view -> {
            registrarNuevaVenta();
        });
    }

    private void registrarNuevaVenta() {
        // Valida que todos los campos estén llenos
        if (libroInput.getText().toString().isEmpty() ||
            cantidadInput.getText().toString().isEmpty() ||
            precioInput.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Por favor, llena todos los campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Obtiene los valores de los campos
        String libro = libroInput.getText().toString();
        int cantidad = Integer.parseInt(cantidadInput.getText().toString());
        double precioUnitario = Double.parseDouble(precioInput.getText().toString());

        // Crea un nuevo objeto Venta con los datos ingresados
        Venta nuevaVenta = new Venta();
        nuevaVenta.setLibro(libro);
        nuevaVenta.setCantidad(cantidad);
        nuevaVenta.setPrecioUnitario(precioUnitario);

        // Obtiene la interfaz para la API de ventas
        VentaApi ventaApi = ApiClient.getClient().create(VentaApi.class);

        // Llama al método para registrar la venta en tu servidor
        Call<Venta> call = ventaApi.registrarVenta(nuevaVenta);
        call.enqueue(new Callback<Venta>() {
            @Override
            public void onResponse(Call<Venta> call, Response<Venta> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "¡Venta registrada con éxito!", Toast.LENGTH_SHORT).show();
                    // Limpia los campos después de un registro exitoso
                    libroInput.setText("");
                    cantidadInput.setText("");
                    precioInput.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Error al registrar la venta. Código: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Venta> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de conexión: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}