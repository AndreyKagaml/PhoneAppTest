package ua.test.PhoneContacts.repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.test.PhoneContacts.models.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {
}
