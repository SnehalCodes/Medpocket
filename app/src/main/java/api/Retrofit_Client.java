package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_Client {
    private static  String url = "http://143.110.176.39/presco_new/apis/";
    private static Retrofit retrofit;
    private static Retrofit_Client retrofit_client;

    private  static Gson gson;

    private Retrofit_Client()

    {        Gson gson = new GsonBuilder()
            .setLenient()
            .create();
        retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
    }


    public static synchronized  Retrofit_Client getInstance()
    {
        if(retrofit_client == null)
        {
            retrofit_client = new Retrofit_Client();

        }
        return retrofit_client;
    }

    public  Apipatde getApi()
    {
        return  retrofit.create(Apipatde.class);
    }


}

