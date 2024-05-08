package indigo.login.repository;



import indigo.login.entity.ProfileData;
import lombok.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppDataRepository extends JpaRepository<Data, String> {
    
    Optional<ProfileData> findByEmail(String email);

    Optional<ProfileData> findByNumber(String number);
}
