public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentWeather currentWeather = new CurrentWeather();
        WeatherStatistics weatherStatistics = new WeatherStatistics();

        weatherData.registerObserver(currentWeather);
        weatherData.registerObserver(weatherStatistics);
        weatherData.startMeasurement();

        while(true){
            //currentWeather.display();
            weatherStatistics.display();

        }

        //weatherData.setMeasurmentData();
        //weatherData.notifyObservers();
        //System.out.println(weatherData);
        //System.out.println("---------------------");
    }
}
