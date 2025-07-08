package br.com.leoman.jogodamemoria.AbstractFactory;

public class Factory {
    public static NivelFactory criarFactory(Nivel nivel) {
        switch (nivel) {
            case FACIL:
                return new FacilFactory();
            case MEDIO:
                return new MedioFactory();
            case DIFICIL:
                return new DificilFactory();
            case ALEATORIO:
                return new AleatorioFactory();
            default:
             throw new IllegalArgumentException("Nível inválido");
        }
    }
}