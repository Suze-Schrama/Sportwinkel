package be.vdab.sportwinkel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class ArtikelController {
    private final ArtikelService artikelService;

    ArtikelController(ArtikelService artikelService) {
        this.artikelService = artikelService;
    }

    private record NieuwArtikel(@NotBlank String naam, @NotNull @PositiveOrZero BigDecimal aankoopprijs, @NotNull @PositiveOrZero BigDecimal verkoopprijs){}

    @PostMapping("/artikels")
    @ResponseStatus(HttpStatus.CREATED)
    void post(@RequestBody NieuwArtikel nieuwArtikel){
        var artikel = new Artikel(nieuwArtikel.naam, nieuwArtikel.aankoopprijs, nieuwArtikel.verkoopprijs);
        artikelService.create(artikel);
    }
}
