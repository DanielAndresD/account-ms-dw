package com.example.account.repositories;
import com.example.account.models.account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface accountRepository extends MongoRepository <account, String> {
}
