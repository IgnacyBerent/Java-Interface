public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentWeather currentWeather = new CurrentWeather();
        WeatherStatistics wheatherStatistics = new WeatherStatistics();

        weatherData.registerObserver(currentWeather);
        weatherData.registerObserver(wheatherStatistics);
        weatherData.startMeasurment();

        while(true){
            //currentWeather.display();
            wheatherStatistics.display();

        }



        //weatherData.setMeasurmentData();
        //weatherData.notifyObservers();
        //System.out.println(weatherData);
        //System.out.println("---------------------");
    }
}
