package testing.post;

public class Post2 {
    private int userId;
    private int id;
    private String title;
    private String body;

    // Constructor vacío necesario para la deserialización
    public Post2() {}

    // Getters y setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }
}
