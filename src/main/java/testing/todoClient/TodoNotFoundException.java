package testing.todoClient;

public class TodoNotFoundException extends Throwable {
    public TodoNotFoundException(String message) {
        super(message);
    }
}
