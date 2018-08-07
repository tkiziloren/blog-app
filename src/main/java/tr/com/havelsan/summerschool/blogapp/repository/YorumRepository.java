package tr.com.havelsan.summerschool.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.havelsan.summerschool.blogapp.domain.Yorum;

/**
 * Created by tkiziloren on 7.08.2018.
 */
@Repository
public interface YorumRepository extends JpaRepository<Yorum, Integer> {
}
