package U5w2l5test.epicode.dto;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrenotazioneDTO {
    private LocalDate dataRichiesta;
    private String note;
    private Long dipendenteId;
    private Long viaggioId;
}

