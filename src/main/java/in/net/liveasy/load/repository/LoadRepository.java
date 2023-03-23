package in.net.liveasy.load.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import in.net.liveasy.load.entity.Load;

@Repository
@Component
public interface LoadRepository extends JpaRepository<Load,Long> {

}
