package az.ingress.lab1.service;

import az.ingress.lab1.dao.entity.ReservationEntity;
import az.ingress.lab1.model.request.CreateReservationRequest;
import az.ingress.lab1.model.response.ReservationResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationsService {

    void saveReservation(CreateReservationRequest request);

    void deleteReservation(Long id);

    ReservationResponse getReservation(Long id);

    List<ReservationEntity> getAllActiveReservationsWithDateAfter(LocalDateTime dateAfter);


}
