package api;

import retrofit2.Call;
import retrofit2.http.POST;

public interface Apipatde {

    @POST("hospital_list.php")
    Call<Hospitallist_responsepatde> hospitallist();
}
