import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Main {

    public static void main(String[]args){

        int locationKey = 7894;

        RetrofitAccuWeatherService service = cargarServicio();
        
        System.out.println(getTemperatura(service,locationKey));

    }
    public static RetrofitAccuWeatherService cargarServicio(){
        String base_url = "http://dataservice.accuweather.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RetrofitAccuWeatherService.class);
    }
    public static double getTemperatura(RetrofitAccuWeatherService service,int locationKey){
        Call<List<ResponseConditions>> call = service.getCurrentConditions(locationKey);
        try{
            Response<List<ResponseConditions>> response = call.execute();
            Temperature temperatura = response.body().get(0).Temperature;

            return temperatura.valor();
        }
        catch (Exception ex){
            System.out.print(ex.getMessage());
            return -1;
        }
    }
}
