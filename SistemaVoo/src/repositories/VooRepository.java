package repositories;

import models.Voo;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public void removerVoo(Voo voo) {
        this.voos.remove(voo);
    }

    public void removerVooPorId(UUID vooId) {
        this.voos.removeIf(voo -> voo.getID().equals(vooId));
    }

    public List<Voo> getVoosPorOrigem(String origem) {
        return this.voos.stream()
                .filter(voo -> voo.getOrigem().equals(origem))
                .collect(Collectors.toList());
    }

    public List<Voo> getVoosPorDestino(String destino) {
        return this.voos.stream()
                .filter(voo -> voo.getDestino().equals(destino))
                .collect(Collectors.toList());
    }

}
