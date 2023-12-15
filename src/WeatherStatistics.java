import java.util.ArrayList;
import java.util.List;

public class WeatherStatistics implements Observer, Display{
    private List<Float> temperatureList = new ArrayList<>();
    private List<Float> humidityList = new ArrayList<>();
    private List<Float> pressureList = new ArrayList<>();

    @Override
    public void display() {
        System.out.println(" T average= " + average(temperatureList));
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        temperatureList.add(temp);
        humidityList.add(humidity);
        pressureList.add(pressure);
        display();
    }
    private float average(List<Float> list){
        float sum = 0;
        if (list.size() == 1) {
            return list.get(0);
        }
        else {
            for (Float f : list) {
                sum += f;
            }
            return sum / list.size();
        }
    }
}
