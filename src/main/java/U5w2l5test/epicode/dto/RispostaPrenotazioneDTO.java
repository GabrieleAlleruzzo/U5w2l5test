package U5w2l5test.epicode.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RispostaPrenotazioneDTO {
    private String nomeDipendete;
    private String cognomeDipendete;
    private LocalDate dataPrenotazione;
    private String luogo;
    private String note;
}
