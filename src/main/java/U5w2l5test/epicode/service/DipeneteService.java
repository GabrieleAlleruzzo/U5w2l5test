package U5w2l5test.epicode.service;

import U5w2l5test.epicode.dto.BodyPrenotazioneDTO;
import U5w2l5test.epicode.dto.DipendenteDTO;
import U5w2l5test.epicode.dto.PrenotazioneDTO;
import U5w2l5test.epicode.dto.RispostaPrenotazioneDTO;
import U5w2l5test.epicode.model.Dipendente;
import U5w2l5test.epicode.model.Prenotazione;
import U5w2l5test.epicode.model.Viaggio;
import U5w2l5test.epicode.repository.DipendenteRepository;
import U5w2l5test.epicode.repository.PrenotazioneRepository;
import U5w2l5test.epicode.repository.ViaggioRepository;
import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DipeneteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;
/*
    @Autowired
    private Cloudinary cloudinary;
*/
    public Dipendente saveDipendete (DipendenteDTO dipendeteDto) {

        Dipendente dipendete = new Dipendente();
        dipendete.setNome(dipendeteDto.getNome());
        dipendete.setCognome(dipendeteDto.getCognome());
        dipendete.setEmail(dipendeteDto.getEmail());
        return dipendenteRepository.save(dipendete);
    }

    @Autowired
    public ViaggioRepository viaggioRepository;

    @Autowired
    public PrenotazioneRepository prenotazioneRepository;

    public RispostaPrenotazioneDTO creaPrenotazioneViaggio (BodyPrenotazioneDTO body) {
        if (checkDataPrenotazione(body.getDipendete().getId(),body.getViaggioDto().getData())) { return null;}

        Viaggio viaggio = new Viaggio();
        viaggio.setDestinazione(body.getViaggioDto().getDestinazione());
        viaggio.setData(body.getViaggioDto().getData());
        viaggio.setStato(body.getViaggioDto().getStato());
        Viaggio viaggioSalvato=viaggioRepository.save(viaggio);

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setNote(body.getPrenotazioneDto().getNote());
        prenotazione.setViaggio(viaggioSalvato);
        prenotazione.setDipendente(body.getDipendete());
        prenotazione.setData(body.getPrenotazioneDto().getDataRichiesta());
        prenotazioneRepository.save(prenotazione);
        RispostaPrenotazioneDTO risposta = new RispostaPrenotazioneDTO();
        risposta.setMessaggio("prenotazione avvenuta con successo");
        return risposta;
    }

    public boolean checkDataPrenotazione (long idDipendente, LocalDate dataPrenotazione) {
        LocalDate data =  dipendenteRepository.trovaDataPrenotazione(idDipendente);
        if(data==null){
            return false;
        }
        if(data.equals(dataPrenotazione)){ return true;}
        return false;
    }
}
