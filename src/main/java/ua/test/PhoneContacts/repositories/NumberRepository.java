package ua.test.PhoneContacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.test.PhoneContacts.models.Number;

@Repository
public interface NumberRepository extends JpaRepository<Number, Integer> {
}
