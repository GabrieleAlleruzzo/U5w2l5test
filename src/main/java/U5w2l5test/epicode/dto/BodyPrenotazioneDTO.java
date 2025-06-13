package U5w2l5test.epicode.dto;

import U5w2l5test.epicode.model.Dipendente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BodyPrenotazioneDTO {
    private Dipendente dipendete;
    private ViaggioDTO viaggioDto;
    private PrenotazioneDTO prenotazioneDto;
}
