package U5w2l5test.epicode.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.action.internal.OrphanRemovalAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cognome;
    private String email;
    private String immagineProfilo;

    @OneToMany(mappedBy = "dipendente", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioneList= new ArrayList<>();

}

