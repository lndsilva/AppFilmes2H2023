package br.com.etecia.myapp;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmesService {
    @GET("movie/popular")
    Call<ResponseBody> obterFilmesPopulares(@Query("api_key") String ChaveApi);
}
