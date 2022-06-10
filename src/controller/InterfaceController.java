/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author alexandreluis
 */
public interface InterfaceController<G>
{
    public int gerarId();//
    public void add(G o);//
    public boolean remover(G o);//
    public ArrayList<G> getAll(); //
    public G getByDoc(String o);
}