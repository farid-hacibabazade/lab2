package az.ingress.lab1.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponse {
    private String tableName;
    private String customer;
    private LocalDateTime date;
    private Integer membersCount;
}
