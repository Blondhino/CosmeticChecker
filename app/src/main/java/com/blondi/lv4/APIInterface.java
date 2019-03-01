package com.blondi.lv4;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Enio on 12/30/2018.
 */

public interface APIInterface {

    //String Baserequest="products.json?brand="+search.getSearchString();
    @GET("products.json")
    Call<List<Product>> getProducts(@Query("brand") String product_type);

}
