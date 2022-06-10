/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalTime;
import java.util.ArrayList;
import model.VagaCondominio;
import ncadastropessoa.NCadastroPessoa;

/**
 *
 * @author alexandreluis
 */
public class CVagaCondominio implements InterfaceController<VagaCondominio>
{
    ArrayList<VagaCondominio> vagas = new ArrayList<>();
    int idVaga = 1;
    
    
    @Override
    public int gerarId()
    {
        return this.idVaga++;
    }

    @Override
    public void add(VagaCondominio o)
    {
        vagas.add(o);
    }
        
    @Override
    public boolean remover(VagaCondominio o)
    {
        boolean v = this.vagas.remove(o);
        return v;
    }

    @Override
    public ArrayList<VagaCondominio> getAll()
    {
        return this.vagas;
    }
    
    public void listaVagasComCarro()
    {
        for(VagaCondominio vaga: vagas)
        {
            System.out.println("getIdVaga " + vaga.getIdVaga());
            System.out.println("getIdCarro " + vaga.getCarro().getIdCarro());
            System.out.println("getCor " + vaga.getCarro().getCor());
            System.out.println("getMarca " + vaga.getCarro().getMarca());
            System.out.println("getPlaca " + vaga.getCarro().getPlaca());
            System.out.println("getModelo " + vaga.getCarro().getModelo());
            System.out.println("getAnoModelo " + vaga.getCarro().getAnoModelo());
            System.out.println("getAnoFabricacao " + vaga.getCarro().getAnoFabricacao());
            System.out.println("getnPortas " + vaga.getCarro().getnPortas());
            System.out.println("getCheckIn() " + vaga.getCheckIn());
            System.out.println("getCheckOut() " + vaga.getCheckOut());
            System.out.println("\n");
        }
        
    }

    @Override
    public VagaCondominio getByDoc(String o)
    {
        //------
        return null;
    }
    
    public VagaCondominio getVagaComCarro(String placa)
    {
        //
        VagaCondominio vagac = new VagaCondominio();
        
        for(VagaCondominio vaga: vagas)
        {
            if(vaga.getCarro().getPlaca().equals(placa))
            {
                vagac = vaga;
                break;
            }
        }
        return vagac;
    }
    
    
    public VagaCondominio getByNumVaga(int n)
    {
        VagaCondominio vagac = new VagaCondominio();
        
        for(VagaCondominio vaga: vagas)
        {
            if(vaga.getNumVaga() == n)
            {
                vagac = vaga;
                break;
            }
        }
        return vagac;
    }
    
    public void mokVaga()
    {
        CCarro c = new CCarro();
        
        VagaCondominio v = new VagaCondominio();
        v.setIdVaga(gerarId());
        v.setNumVaga(1);
        v.setCarro(NCadastroPessoa.cadCarros.getByDoc("CHS6647"));
        LocalTime checkIn = LocalTime.of(20, 00);
        LocalTime checkOut = LocalTime.of(22, 00);
        v.setCheckIn(checkIn);
        v.setCheckOut(checkOut);
        add(v);

        VagaCondominio v11 = new VagaCondominio();
        v11.setIdVaga(gerarId());
        v11.setNumVaga(2);
        v11.setCarro(NCadastroPessoa.cadCarros.getByDoc("IPI3e08"));
        checkIn = LocalTime.of(22, 00);
        checkOut = LocalTime.of(23, 00);
        v.setCheckIn(checkIn);
        v.setCheckOut(checkOut);
        add(v11);
    }
}