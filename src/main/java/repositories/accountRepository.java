package repositories;
import models.account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface accountRepository extends MongoRepository <account, String> {
}
