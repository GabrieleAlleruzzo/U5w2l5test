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
import org.springframework.stereotype.Service;

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
        Viaggio viaggio = new Viaggio();
        viaggio.setDestinazione(body.getViaggioDto().getDestinazione());
        viaggio.setData(body.getViaggioDto().getData());
        viaggio.setStato(body.getViaggioDto().getStato());
        Viaggio viaggioSalvato=viaggioRepository.save(viaggio);

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setNote(body.getPrenotazioneDto().getNote());
        prenotazione.setViaggio(viaggioSalvato);
        prenotazione.setDipendente(body.getDipendete());
        prenotazione.setDataRichiesta(body.getPrenotazioneDto().getDataRichiesta());
        prenotazioneRepository.save(prenotazione);
        RispostaPrenotazioneDTO risposta = new RispostaPrenotazioneDTO();
        risposta.setNote(prenotazione.getNote());
        risposta.setDataPrenotazione(prenotazione.getDataRichiesta());
        risposta.setLuogo(prenotazione.getViaggio().getDestinazione());
        risposta.setNomeDipendete(prenotazione.getDipendente().getNome());
        risposta.setCognomeDipendete(prenotazione.getDipendente().getCognome());
        return risposta;
    }
}
