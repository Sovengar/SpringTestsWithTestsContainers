package testing.post;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Component
class PostDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PostDataLoader.class);
    private final ObjectMapper objectMapper;
    private final PostRepository postRepository;

    public PostDataLoader(ObjectMapper objectMapper, PostRepository postRepository) {
        this.objectMapper = objectMapper;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(postRepository.count() == 0){
            String POSTS_JSON = "/data/posts.json";
            log.info("Loading posts into database from JSON: {}", POSTS_JSON);

            try (InputStream inputStream = TypeReference.class.getResourceAsStream(POSTS_JSON)) {
                if (inputStream == null) {
                    throw new FileNotFoundException("Resource not found: " + POSTS_JSON);
                }

                String string = """
                        {
                          "posts": [
                            {
                              "userId": 1,
                              "id": 1,
                              "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
                              "body": "quia et suscipitnsuscipit recusandae consequuntur expedita et cumnreprehenderit molestiae ut ut quas totamnnostrum rerum est autem sunt rem eveniet architecto"
                            },
                            {
                              "userId": 1,
                              "id": 2,
                              "title": "qui est esse",
                              "body": "est rerum tempore vitaensequi sint nihil reprehenderit dolor beatae ea dolores nequenfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendisnqui aperiam non debitis possimus qui neque nisi nulla"
                            }
                          ]
                        }
                        """;

                Posts response = objectMapper.readValue(inputStream, Posts.class);

                for (Post2 post : response.posts()) {
                    System.out.println("Title: " + post.getTitle());
                    System.out.println("Body: " + post.getBody());
                    System.out.println("userrrrId: " + post.getUserId());
                    System.out.println();
                }

                // postRepository.saveAll(response.posts());
                log.info("Posts loaded to the DB");
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON data", e);
            }


        }
    }

}
