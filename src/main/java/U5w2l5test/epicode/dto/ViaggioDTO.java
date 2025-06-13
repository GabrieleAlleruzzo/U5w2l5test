package U5w2l5test.epicode.dto;


import U5w2l5test.epicode.model.StatoViaggio;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViaggioDTO {
    private String destinazione;
    private LocalDate data;
    private StatoViaggio stato;
}
