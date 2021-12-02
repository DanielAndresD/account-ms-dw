package repositories;
import models.reservacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface reservacionRepository extends MongoRepository<reservacion, String> {
    List<reservacion> findByUsernameUbOrigin (String usernameUbOrigin);
    List<reservacion> findByUsernameUbHotel (String usernameUbOrigin);
}


