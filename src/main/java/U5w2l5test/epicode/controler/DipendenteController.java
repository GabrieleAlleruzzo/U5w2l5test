package U5w2l5test.epicode.controler;

import U5w2l5test.epicode.dto.BodyPrenotazioneDTO;
import U5w2l5test.epicode.dto.DipendenteDTO;
import U5w2l5test.epicode.dto.RispostaPrenotazioneDTO;
import U5w2l5test.epicode.model.Dipendente;
import U5w2l5test.epicode.service.DipeneteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {
    @Autowired
    public DipeneteService dipenenteService; //solo ora mi sono accorto del erroe di battitura, lo lascero per tutto il compito
    @PostMapping //crea API
    public ResponseEntity<Dipendente> crea(@Valid @RequestBody DipendenteDTO d) {

        return ResponseEntity.ok(dipenenteService.saveDipendete(d));

    }

    @PostMapping("/creaprenotazioni/")
    public ResponseEntity<RispostaPrenotazioneDTO> creaPrenotazione(@Valid @RequestBody BodyPrenotazioneDTO body) {
        return ResponseEntity.ok(dipenenteService.creaPrenotazioneViaggio(body));
    }

    /*
    @PostMapping("/{id}/upload")
    public ResponseEntity<?> uploadImmagine(@PathVariable Long id, @RequestParam MultipartFile file) {

    } */
}
