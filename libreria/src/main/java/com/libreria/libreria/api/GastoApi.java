package com.libreria.api;

import com.libreria.model.Gasto;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.DELETE;
import retrofit2.http.Path;
import retrofit2.http.PUT;

public interface GastoApi {

    @GET("/gastos")
        Call<List<Gasto>> obtenerGastos();

            @POST("/gastos")
                Call<Gasto> crearGasto(@Body Gasto gasto);

                    @DELETE("/gastos/{id}")
                        Call<Void> eliminarGasto(@Path("id") Long id);
                            
                                @PUT("/gastos/{id}")
                                    Call<Gasto> actualizarGasto(@Path("id") Long id, @Body Gasto gasto);
                                    }