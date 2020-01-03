package ja.mrthor.back.ctlproject.respository;

import ja.mrthor.back.ctlproject.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface HomeRepository extends JpaRepository<Home, Integer> {

}
