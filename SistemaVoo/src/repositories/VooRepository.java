package repositories;

import models.Voo;

import java.util.ArrayList;

public class VooRepository {

    private ArrayList<Voo> voos;

    public VooRepository(ArrayList<Voo> voos) {
        this.voos = voos;
    }

    public int getTotalVoosCadastrados() {
        return this.voos.size();
    }

    public void adicionarVoo(Voo voo) {
        this.voos.add(voo);
    }

}
