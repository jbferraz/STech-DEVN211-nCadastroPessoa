/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Pessoa;

/**
 *
 * @author jairb
 */
public class CPessoa implements InterfaceController<Pessoa>{

    ArrayList<Pessoa> pessoas = new ArrayList<>();//Repositório, onde vamos armazenar as Pessoas
    int idPessoa = 1;

    @Override
    public int gerarId() {
        return this.idPessoa++;
    }

    @Override
    public void add(Pessoa p) {
        this.pessoas.add(p);
    }

    /**
     * mokPessoa serve para inicializar a apllicação com dados.
     */
    public void mokPessoas() {
        Pessoa p1 = new Pessoa();
        p1.setIdPessoa(this.gerarId());
        p1.setNomePessoa("Felispino das Candongas");
        p1.setCpf("12312312312");
        p1.setSexo("Masculino");
        p1.setTelefone("989888888");
        p1.setEndereco("Mario Quintana");
        this.add(p1);

        Pessoa p2 = new Pessoa();
        p2.setIdPessoa(this.gerarId());
        p2.setNomePessoa("Jorge da Borracharia");
        p2.setCpf("32132132132");
        p2.setSexo("Masculino");
        p2.setTelefone("6969696969");
        p2.setEndereco("Rua da Borracharia");
        this.add(p2);
    }

    @Override
    public ArrayList<Pessoa> getAll() {
        return pessoas;
    }

    public boolean CPFExiste(String cpf) {
        boolean cpfTF = false;
        for (Pessoa listPes : pessoas) {
            if (listPes.getCpf().equals(cpf)) {
                cpfTF = true;
                break;
            }
        }
        return cpfTF;
    }

    @Override
    public Pessoa getByDoc(String cpf) {
        Pessoa p = new Pessoa();
        for (Pessoa pes : pessoas) {
            if (pes.getCpf().equals(cpf)) {
                p = pes;
                break;
            }
        }
        return p;
    }

    @Override
    public boolean remover(Pessoa p) {
        boolean rp = this.pessoas.remove(p);
        return rp;
    }

    public boolean removerPessoas() {
        boolean rp = this.pessoas.removeAll(pessoas);
        return rp;
    }

    public String getNomePessoa(int idPessoa) {
        String nome = null;
        for (Pessoa pes : pessoas) {
            if (pes.getIdPessoa() == idPessoa) {
                nome = pes.getNomePessoa();
                break;
            }
        }
        return nome;
    }

    public int getIdPessoa(String cpf) {
        int id = 0;
        //foreach que poercorre um objeto do tipo Array
        for (Pessoa pes : pessoas) {
            if (pes.getCpf().equals(cpf)) {
                id = pes.getIdPessoa();
                break;
            }
        }
        return id;
    }

}
