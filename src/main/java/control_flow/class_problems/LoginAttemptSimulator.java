package control_flow.class_problems;

public class LoginAttemptSimulator {

    void simulateLogin(String correctCode, String[] attempts) {
        for (int i = 0; i < attempts.length; i++) {
            if (attempts[i].equals(correctCode)) {
                System.out.println("Access granted on attempt " + (i + 1));
                break;
            }
            if (i == attempts.length - 1) {
                System.out.println("Access denied — all attempts used");
            }
        }
    }

    public static void main(String[] args) {
        LoginAttemptSimulator simulator = new LoginAttemptSimulator();
        simulator.simulateLogin("1234", new String[]{"0000", "1234", "9999"});
        simulator.simulateLogin("1234", new String[]{"1111", "2222", "3333"});
    }
}
