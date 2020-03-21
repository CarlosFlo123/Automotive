interface Door {
    public void open();
    public void close();
}

interface LockableDoor extends Door {
    public void lock();
    public void unlock();
}

interface Alarm {
    public boolean isAlarmOn();
    public void turnOnAlarm();
    public void turnOffAlarm();
}

class CarPart {
    private int partID;
    private double weight;
    private double cost;

    public CarPart(int p, double w, double c){
        this.partID = p;
        this.weight = w;
        this.cost = c;
    }

    public void aMethod() {
        System.out.println("This is a car part method");
    }

    // Implement this method
    public float getWeight() {
        return this.weight;
    }

    // Implement this method
    public float getPartID() {
        return this.partID;
    }

    // Implement this method
    public float getCost() {
        return this.cost;
    }
}

class CarDoor extends CarPart implements LockableDoor, Alarm {
    // Car door has a lock
    private boolean lockFlag;
    // Car door has an alarm switch for you to turn on/off alarm
    private boolean alarmFlag;

    public CarDoor(int p, double w, double c){
        super(p, w, c);
        this.lockFlag = false;
        this.alarmFlag = false;
    }
    // Implement this method
    public boolean isAlarmOn() {
        return this.alarmFlag;
    }

    // Implement this method
    public void turnOnAlarm() {
        this.alarmFlag = true;
    }

    // Implement this method
    public void tunrOffAlarm() {
        this.alarmFlag = false;
    }

     // Implement this method
     public void lock() {
        this.lockFlag = true;
        System.out.println("Locking car..");
    }

    // Implement this method
    public void unlock() {
        this.lockFlag = false;
        System.out.println("Unlocking car..");
    }

    // To simulate the situation that you open a car while
    // sitting in the car
    //
    // Step 1: Turn on the alarm
    // Step 2: Unlock the car
    // Step 3: Display "Look out, opening the door"
    public void open() {
        this.turnOnAlarm();
        this.unlock();
        System.out.println("Look out, opening the door..");
    }

    // To simulate the situation that you close a car while
    // sitting in the car
    //
    // Step 1: Display "Look out, closing the door"
    // Step 2: lock the car
    // Step 3: Turn off the alarm
    public void close() {
        System.out.println("Look out, closing the door..");
        this.lock();
        this.turnOffAlarm();
    }
}

public class TestCar {
    public static void main(String[] args) {
        // I have an sedan car
        CarDoor sedan = new CarDoor(172364, 90.4, 380.5);

        sedan.open();
        // I close the door
        sedan.close();

    }
}