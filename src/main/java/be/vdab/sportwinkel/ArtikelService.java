package be.vdab.sportwinkel;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional(readOnly = true)
public class ArtikelService {
    private ArtikelRepository repository;
    private final AmqpTemplate template;

    ArtikelService(ArtikelRepository repository, AmqpTemplate template) {
        this.repository = repository;
        this.template = template;
    }
@Transactional
    public void create(Artikel artikel){
        repository.save(artikel);
        template.convertAndSend("sportartikels", null, new ArtikelGemaakt(artikel));
    }
}
