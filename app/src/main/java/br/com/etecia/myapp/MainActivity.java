package br.com.etecia.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView idRecyclerViewFilmes;
    List<Filmes> lstFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idRecyclerViewFilmes = findViewById(R.id.idRecyclerViewFilmes);

        ApiService.getInstance().obterFilmesPopulares("c6542c60576a2adc86c966e6f6f555bf")
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable throwable) {

                    }
                });

        lstFilmes = new ArrayList<>();

        lstFilmes.add(new Filmes("Batman", "Ação", "Filme de ação", "5", R.drawable.batman));

        idRecyclerViewFilmes.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

        idRecyclerViewFilmes.setHasFixedSize(true);

        AdapterFilmes adapter = new AdapterFilmes(getApplicationContext(), lstFilmes);

        idRecyclerViewFilmes.setAdapter(adapter);


    }
}