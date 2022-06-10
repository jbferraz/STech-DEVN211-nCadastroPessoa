/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Carro;

/**
 *
 * @author jairb
 */
public class CCarro implements InterfaceController<Carro>
{
    private ArrayList<Carro> carros = new ArrayList<>();
    int idCarro = 1;

    @Override
    public int gerarId()
    {
        return this.idCarro++;
    }

    @Override
    public void add(Carro c)
    {
        this.carros.add(c);
    }

    /**
     *
     * @return ArrayList de Carros
     */
    @Override
    public ArrayList<Carro> getAll()
    {
        return carros;
    }

    public void mokCarros()
    {
        Carro c1 = new Carro();
        c1.setIdCarro(gerarId());
        c1.setPlaca("CHS6647");
        c1.setMarca("Peugeot");
        c1.setModelo("405 GRI");
        c1.setAnoFabricacao(1995);
        c1.setAnoModelo(1996);
        c1.setCor("VERDE");
        c1.setnPortas(5);
        c1.setIdPessoa(1);
        add(c1);

        Carro c2 = new Carro();
        c2.setIdCarro(gerarId());
        c2.setPlaca("IPI3E08");
        c2.setMarca("CHEVROLET");
        c2.setModelo("CORSA");
        c2.setAnoFabricacao(1996);
        c2.setAnoModelo(1996);
        c2.setCor("CHUMBO");
        c2.setnPortas(3);
        c2.setIdPessoa(2);
        add(c2);
    }

    public boolean remover(Carro c)
    {
        boolean removido = this.carros.remove(c);
        return removido;
    }

    public boolean verPlaca(String placa)
    {
        boolean vp = false;
        for (Carro listCar : carros)
        {
            if (listCar.getPlaca().equalsIgnoreCase(placa))
            {
                vp = true;
                break;
            }
        }
        return vp;
    }

    @Override
    public Carro getByDoc(String placa)
    {
        Carro c = new Carro();
        for (Carro listCar : carros)
        {
            if (listCar.getPlaca().equalsIgnoreCase(placa))
            {
                c = listCar;
                break;
            }
        }
        return c;
    }
}