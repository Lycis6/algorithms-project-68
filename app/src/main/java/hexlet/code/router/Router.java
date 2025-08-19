package hexlet.code.router;

public class Router {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new Router().getGreeting());
    }
}
