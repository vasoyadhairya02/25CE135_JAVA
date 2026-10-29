@FunctionalInterface
interface Notifier {
    void send(String message);
}

interface Urgent {
}

class UrgentEmail implements Notifier, Urgent {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

public class Main2 {
    public static void main(String[] args) {

        Notifier email = message ->
                System.out.println("Email: " + message);

        Notifier sms = message ->
                System.out.println("SMS: " + message);

        Notifier urgentEmail = new UrgentEmail();

        Notifier[] senders = { email, sms, urgentEmail };

        String message = "Exam starts at 10 AM";

        for (Notifier sender : senders) {
            sender.send(message);

            if (sender instanceof Urgent) {
                sender.send(message);
            }
        }
    }
}