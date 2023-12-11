public class CurrentWeather implements Observer, Display{
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void display() {
        System.out.println("T= " + temperature + " H= " + humidity + " P= " + pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
