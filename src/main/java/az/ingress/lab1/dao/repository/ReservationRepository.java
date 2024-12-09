package az.ingress.lab1.dao.repository;

import az.ingress.lab1.dao.entity.ReservationEntity;
import az.ingress.lab1.model.enums.ReservationStatus;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {

    Optional<ReservationEntity> findByIdAndStatusNot(Long id, ReservationStatus status);

    List<ReservationEntity> findAllByStatusNotAndDateAfter(ReservationStatus status,
                                                               LocalDateTime dateAfter);

}
