package weather;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class OpenWeatherDataRetriever {

	public static void main(String[] args) throws IOException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(
				"https://api.openweathermap.org/data/2.5/weather?lat=40.7128&lon=74.0060&appid=apikey")
				.build(); 
		Response response = client.newCall(request).execute();
		ObjectMapper objectMapper = new ObjectMapper();
		Root root = objectMapper.readValue(response.body().string(), Root.class);
		System.out.println(root.getMain().getTemp() + " temp");
	}

}
