package indigo.login.repository;


import indigo.login.entity.ProfileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileDataRepository extends JpaRepository<ProfileData, String> {
    
    Optional<ProfileData> findByEmail(String email);

    Optional<ProfileData> findByPhone(String phone);
}
