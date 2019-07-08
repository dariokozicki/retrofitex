import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface RetrofitAccuWeatherService {
    @GET("/currentconditions/v1/{locationKey}?apikey=XYufUv9ESFuNw0ViO8Ffd4CRdrJQRRLq")
    Call<List<ResponseConditions>> getCurrentConditions(@Path("locationKey") int locationKey);

}