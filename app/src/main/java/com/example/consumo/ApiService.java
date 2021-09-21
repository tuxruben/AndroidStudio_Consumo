package com.example.consumo;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    public static final String URL="http://192.168.1.70:8888/webserviceph/";
// @GET("webservice.php?usuario=1")
// Call<List<Usuario>> listaUsuarios();
/*
* @FormUrlEncoded : Point out this method will construct a form submit
action.
* @POST : Point out the form submit will use post method, the form
action url is the parameter of @POST annotation.
* @Field("form_field_name") : Indicate the form filed name, the filed
value will be assigned to input parameter userNameValue.
* */

    // Obtiene registrso popr nombre, se puede filtrar por cualquier campo
    @FormUrlEncoded
    @POST("webservice.php?usuario=1")
    Call<List<Usuario>> obtenerUsuario(@Field("nombre") String nombre);
    //Obtiene el total de registros de usuarios y los almacena en la lista
    @POST("webservice.php?usuario=1")
    Call<List<Usuario>> listaUsuarios();
}