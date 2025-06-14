package U5w2l5test.epicode.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Data
@Entity
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String note;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "dipendente_id")
    private Dipendente dipendente;

    @ManyToOne
    @JoinColumn(name = "viaggio_id")
    private Viaggio viaggio;


}
