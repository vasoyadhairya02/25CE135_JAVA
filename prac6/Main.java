interface Switchable {
    void on();
    void off();

    default void toggle() {
        off();
        on();
    }
}

class Fan implements Switchable {
    private boolean status = false;

    public void on() {
        status = true;
        System.out.println("Fan is ON");
    }

    public void off() {
        status = false;
        System.out.println("Fan is OFF");
    }
}

class Light implements Switchable {
    private boolean status = false;

    public void on() {
        status = true;
        System.out.println("Light is ON");
    }

    public void off() {
        status = false;
        System.out.println("Light is OFF");
    }
}

interface SwitchPermission {
    boolean maySwitchOn(Switchable device, int hour);
}

public class Main {
    public static void main(String[] args) {

        Switchable[] devices = {
            new Fan(),
            new Light()
        };

        System.out.println("Toggling devices:");

        for (Switchable device : devices) {
            device.toggle();
        }


        SwitchPermission permission1 = new SwitchPermission() {
            public boolean maySwitchOn(Switchable device, int hour) {
                return hour >= 6 && hour <= 22;
            }
        };

    
        SwitchPermission permission2 =
            (device, hour) -> hour >= 6 && hour <= 22;

        System.out.print("\nAnonymous class:");
        System.out.print(permission1.maySwitchOn(devices[0], 10));

        System.out.print("\nLambda:");
        System.out.print(permission2.maySwitchOn(devices[1], 23));
    }
}