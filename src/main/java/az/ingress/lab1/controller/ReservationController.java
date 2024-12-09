package az.ingress.lab1.controller;

import az.ingress.lab1.dao.entity.ReservationEntity;
import az.ingress.lab1.model.request.CreateReservationRequest;
import az.ingress.lab1.model.response.ReservationResponse;
import az.ingress.lab1.service.ReservationsService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("v1/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationsService reservationsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveReservation(@RequestBody CreateReservationRequest reservations) {
        reservationsService.saveReservation(reservations);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservation(@PathVariable Long id){
        reservationsService.deleteReservation(id);
    }

    @GetMapping("/{id}")
    public ReservationResponse getReservation(@PathVariable Long id){
       return reservationsService.getReservation(id);
    }

    @GetMapping
    public ReservationEntity getAllActiveReservationsWithDateAfter(@RequestParam LocalDateTime dateAfter){
        return (ReservationEntity) reservationsService.getAllActiveReservationsWithDateAfter(dateAfter);
    }
}
