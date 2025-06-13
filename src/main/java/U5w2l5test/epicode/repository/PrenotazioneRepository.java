package U5w2l5test.epicode.repository;

import U5w2l5test.epicode.model.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    Optional<Prenotazione> findByDipendenteIdAndDataRichiesta(Long dipendenteId, LocalDate dataRichiesta);
}
