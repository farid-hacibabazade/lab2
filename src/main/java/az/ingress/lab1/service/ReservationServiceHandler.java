package az.ingress.lab1.service;

import az.ingress.lab1.dao.entity.ReservationEntity;
import az.ingress.lab1.dao.repository.ReservationRepository;
import az.ingress.lab1.model.enums.ReservationStatus;
import az.ingress.lab1.model.request.CreateReservationRequest;
import az.ingress.lab1.model.response.ReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceHandler implements ReservationsService{
    private final ReservationRepository reservationRepository;

    @Override
    public void saveReservation(CreateReservationRequest reservation){
        reservationRepository.save(
                ReservationEntity.builder()
                        .tableName(reservation.getTableName())
                        .customer(reservation.getCustomer())
                        .date(reservation.getDate())
                        .membersCount(reservation.getMembersCount())
                        .build());
    }

    @Override
    public void deleteReservation(Long id){
       var reservation = fetchReservationIfExits(id);
        reservation.setStatus(ReservationStatus.INACTIVE);
        reservationRepository.save(reservation);
    }

    @Override
    public ReservationResponse getReservation(Long id){
        var reservation = fetchReservationIfExits(id);
        return new ReservationResponse(
                reservation.getTableName(),
                reservation.getCustomer(),
                reservation.getDate(),
                reservation.getMembersCount()
        );
    }

    @Override
    public List<ReservationEntity> getAllActiveReservationsWithDateAfter(LocalDateTime dateAfter){
        return reservationRepository.findAllByStatusNotAndDateAfter(ReservationStatus.INACTIVE, dateAfter);
    }

    private ReservationEntity fetchReservationIfExits(Long id){
        return reservationRepository.findByIdAndStatusNot(id, ReservationStatus.INACTIVE)
                .orElseThrow(RuntimeException::new);
    }
}
