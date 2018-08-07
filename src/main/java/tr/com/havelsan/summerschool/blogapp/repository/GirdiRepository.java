package tr.com.havelsan.summerschool.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.havelsan.summerschool.blogapp.domain.Girdi;

/**
 * Created by tkiziloren on 7.08.2018.
 */
@Repository
public interface GirdiRepository extends JpaRepository<Girdi, Integer> {
}
