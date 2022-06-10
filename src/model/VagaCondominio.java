/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalTime;

/**
 *
 * @author alexandreluis
 */
public class VagaCondominio
{
    private int idVaga;
    private int numVaga;
    private Carro carro;
    private LocalTime checkIn;
    private LocalTime checkOut;
    

    public VagaCondominio()
    {
    }

    public VagaCondominio(int idVaga, int numVaga, Carro carro, LocalTime checkIn, LocalTime checkOut)
    {
        this.idVaga = idVaga;
        this.numVaga = numVaga;
        this.carro = carro;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }



    public int getIdVaga()
    {
        return idVaga;
    }

    public void setIdVaga(int idVaga)
    {
        this.idVaga = idVaga;
    }

    public int getNumVaga()
    {
        return numVaga;
    }

    public void setNumVaga(int numVaga)
    {
        this.numVaga = numVaga;
    }

    public Carro getCarro()
    {
        return carro;
    }

    public void setCarro(Carro carro)
    {
        this.carro = carro;
    }

    @Override
    public String toString()
    {
        return "VagaCondominio{" + "idVaga=" + idVaga + ", numVaga=" + numVaga + ", carro=" + carro + ", checkIn=" + checkIn + ", checkOut=" + checkOut + '}';
    }

    public LocalTime getCheckIn()
    {
        return checkIn;
    }

    public void setCheckIn(LocalTime checkIn)
    {
        this.checkIn = checkIn;
    }

    public LocalTime getCheckOut()
    {
        return checkOut;
    }

    public void setCheckOut(LocalTime checkOut)
    {
        this.checkOut = checkOut;
    }
}