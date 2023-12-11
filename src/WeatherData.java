import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class WeatherData implements Subject{
    private float temperature;
    private float humidity;
    private float pressure;
    private List<Observer> observers = new ArrayList<>();
    private Random random = new Random();
    private boolean isRunning = false;
    private boolean serverOn = false;
    private Thread measurmentThread;
    private long updateInterval = 1000;

    public void startMeasurment(){
        if(!serverOn){
            startServer();
            isRunning = true;
        }
    }

    public void stopMeasurment(){
        if(isRunning){
            isRunning = false;
        }
    }

    private void startServer(){
        if(!serverOn){
            serverOn = true;
            measurmentThread = new Thread(()->{
                while(!Thread.currentThread().isInterrupted()){
                    if(isRunning){
                        setMeasurmentData();
                        notifyObservers();

                        try{
                            Thread.sleep(updateInterval);
                        }catch(InterruptedException e){
                            System.out.println("Thread was destroyed");
                        }
                    }
                }
          });
        }
        measurmentThread.start();
    }

    public void stopServer(){
        if(serverOn){
            measurmentThread.interrupt();
            serverOn = false;
            isRunning = false;
        }
    }

    public void setMeasurmentData(){
        temperature = random.nextFloat(-10, 30);
        humidity = random.nextFloat(0, 100);
        pressure = random.nextFloat(980, 1030);
    }

    @Override
    public String toString(){
        return "T= " + temperature + " H= " + humidity + " P= " + pressure;
    }

    @Override
    public void registerObserver(Observer o) {
        if(!observers.contains(o)){
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        if(observers.contains(o)){
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers){
            o.update(temperature, humidity, pressure);
        }
    }
}
