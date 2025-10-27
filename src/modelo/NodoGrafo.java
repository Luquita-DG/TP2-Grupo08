package modelo;

import interfaces.INodoGrafo;
import java.util.ArrayList;
import java.util.List;

public class NodoGrafo implements INodoGrafo {

    private int valor;
    private List<Arista> vecinos = new ArrayList<>();

    public NodoGrafo(int valor) {
        this.valor = valor;
    }

    @Override
    public int getValor() {
        return valor;
    }

    @Override
    public void agregarVecino(INodoGrafo destino, int peso) {
        vecinos.add(new Arista(destino, peso));
    }

    @Override
    public List<Arista> getVecinos() {
        return vecinos;
    }
}
