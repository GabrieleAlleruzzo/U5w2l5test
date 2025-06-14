package U5w2l5test.epicode.repository;

import U5w2l5test.epicode.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    @Query(value = "SELECT v.data FROM dipendente d " +
            "JOIN prenotazione p ON d.id = p.dipendente_id " +
            "JOIN viaggio v ON v.id = p.viaggio_id " +
            "WHERE d.id = :idDipendente", nativeQuery = true)
    LocalDate trovaDataPrenotazione(@Param("idDipendente") long idDipendente);
}
