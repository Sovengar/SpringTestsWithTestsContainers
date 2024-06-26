package testing.postModel;

import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

interface PostRepository extends ListCrudRepository<Post,Integer> {

    Optional<Post> findByTitle(String title);

}
