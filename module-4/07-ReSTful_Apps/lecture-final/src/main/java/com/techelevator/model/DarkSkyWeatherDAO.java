package com.techelevator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import tk.plogitech.darksky.api.jackson.DarkSkyJacksonClient;
import tk.plogitech.darksky.forecast.APIKey;
import tk.plogitech.darksky.forecast.ForecastRequest;
import tk.plogitech.darksky.forecast.ForecastRequestBuilder;
import tk.plogitech.darksky.forecast.ForecastRequestBuilder.Units;
import tk.plogitech.darksky.forecast.GeoCoordinates;
import tk.plogitech.darksky.forecast.model.DailyDataPoint;
import tk.plogitech.darksky.forecast.model.Forecast;
import tk.plogitech.darksky.forecast.model.Latitude;
import tk.plogitech.darksky.forecast.model.Longitude;

@Component("weatherapi")
public class DarkSkyWeatherDAO implements WeatherDAO {

	private static final String DARK_SKY_API_KEY = "your_personal_api_key_goes_here";

	public static Map<String, double[]> parkCoordinates = new HashMap<>();
	
	static {
		parkCoordinates.put("CVNP", new double[] { 41.280880, -81.568668 });
		parkCoordinates.put("ENP", new double[] { 25.308786, -80.924585 });
		parkCoordinates.put("GCNP", new double[] { 36.082743, -112.2224191 });
		parkCoordinates.put("GNP", new double[] { 48.753126, -113.751136 });
		parkCoordinates.put("GSMNP", new double[] { 35.609131, -83.506203 });
		parkCoordinates.put("GTNP", new double[] { 43.799082, -110.696796 });
		parkCoordinates.put("MRNP", new double[] { 46.878179, -121.703833 });
		parkCoordinates.put("RMNP", new double[] { 40.342764, -105.691623 });
		parkCoordinates.put("WNP", new double[] { 48.459453, -120.137157 });
		parkCoordinates.put("YNP", new double[] { 44.4277753, -110.589141 });
		parkCoordinates.put("YNP2", new double[] { 37.866753, -119.555182 });
	}
	
	@Override
	public List<Weather> getForecastForPark(String parkcode) {
		
		double[] latlong = parkCoordinates.get(parkcode);
		List<Weather> weather = new ArrayList<>();

		ForecastRequest request = new ForecastRequestBuilder()
		        .key(new APIKey(DARK_SKY_API_KEY))
		        .location(new GeoCoordinates(new Longitude(latlong[1]), new Latitude(latlong[0])))
		        .units(Units.us)
		        .build();

		DarkSkyJacksonClient client = new DarkSkyJacksonClient();
		Forecast forecast;
		
		try {
			forecast = client.forecast(request);
		} catch (Exception fe) {
			fe.printStackTrace();
			return weather;
		}
		
		int forecastValue = 1;
		for(DailyDataPoint point : forecast.getDaily().getData()) {
			Weather w = new Weather();
			w.setHighTemp(point.getTemperatureHigh().intValue());
			w.setLowTemp(point.getTemperatureLow().intValue());
			w.setFiveDayForecastValue(forecastValue);
			forecastValue++;
			
			if(point.getWindSpeed() > 15.0 && point.getPrecipIntensity() > 0.5 && point.getTemperatureLow() > 32) {
				w.setForecast("thunderstorm");
			} else if (point.getPrecipIntensity() > 0.2 && point.getTemperatureLow() > 32) {
				w.setForecast("rain");
			} else if (point.getPrecipIntensity() > 0.2) {
				w.setForecast("snow");
			} else if(point.getCloudCover() > 0.75) {
				w.setForecast("cloudy");
			} else if(point.getCloudCover() > 0.25) {
				w.setForecast("partly cloudy");
			} else {
				w.setForecast("sunny");
			}
			
			weather.add(w);
			
		}		
		
		
		return weather;
	}
	
}
