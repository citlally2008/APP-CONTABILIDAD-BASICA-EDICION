package com.libreria.api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import java.util.List;
import com.libreria.model.Venta;

public interface VentaApi {

    @GET("/ventas")
        Call<List<Venta>> obtenerVentas();

            @POST("/ventas")
                Call<Venta> registrarVenta(@Body Venta venta);
                }
                