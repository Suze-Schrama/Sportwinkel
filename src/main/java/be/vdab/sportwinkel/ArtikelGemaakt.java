package be.vdab.sportwinkel;

public class ArtikelGemaakt {
    private final long id;
    private final String naam;

    ArtikelGemaakt(Artikel artikel) {
        id = artikel.getId();
        naam = artikel.getNaam();
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
