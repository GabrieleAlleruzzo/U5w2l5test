package U5w2l5test.epicode.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataRichiesta;

    @Column(length = 500)
    private String note;

    @OneToOne
    private Dipendente dipendente;

    @OneToOne
    private Viaggio viaggio;
}
