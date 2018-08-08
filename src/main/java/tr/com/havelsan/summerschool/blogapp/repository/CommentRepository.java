package tr.com.havelsan.summerschool.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.havelsan.summerschool.blogapp.domain.Comment;
import tr.com.havelsan.summerschool.blogapp.domain.Post;

import java.util.List;

/**
 * Created by tkiziloren on 7.08.2018.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByPostId(int id);

}
