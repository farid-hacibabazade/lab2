package az.ingress.lab1.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReservationRequest {
    private String tableName;
    private String customer;
    private LocalDateTime date;
    private Integer membersCount;
}
