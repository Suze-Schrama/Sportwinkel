package be.vdab.sportwinkel;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "artikels")
public class Artikel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;
    private BigDecimal aankoopprijs;
    private BigDecimal verkoopprijs;

    Artikel(String naam, BigDecimal aankoopprijs, BigDecimal verkoopprijs) {
        this.naam = naam;
        this.aankoopprijs = aankoopprijs;
        this.verkoopprijs = verkoopprijs;
    }
    protected Artikel(){
    }

    long getId() {
        return id;
    }

    String getNaam() {
        return naam;
    }

    BigDecimal getAankoopprijs() {
        return aankoopprijs;
    }

    BigDecimal getVerkoopprijs() {
        return verkoopprijs;
    }
}
