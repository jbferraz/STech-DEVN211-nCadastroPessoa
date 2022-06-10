/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jairb
 */
public class Pessoa {

    private int idPessoa;//não atualizar
    private String nomePessoa;
    private String cpf;//não atualizar
    private String sexo;
    private String endereco;
    private String telefone;

    /**
     * Construtor vazio, que acessa os geters e seters
     */
    public Pessoa() {
    }

    /**
     * Construtor com atributos
     *
     * @param idPessoa
     * @param nomePessoa
     * @param cpf
     * @param sexo
     * @param endereco
     * @param telefone
     */
    public Pessoa(int idPessoa, String nomePessoa, String cpf, String sexo, String endereco, String telefone) {
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.cpf = cpf;
        this.sexo = sexo;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    //Métodos acessores geters e seters
    /**
     * Retorna o id da pessoa
     *
     * @return
     */
    public int getIdPessoa() {
        return idPessoa;
    }

    /**
     * Atribui/Cria o id da pessoa
     *
     * @param idPessoa
     */
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "idPessoa=" + idPessoa + ", nomePessoa=" + nomePessoa + ", cpf=" + cpf + ", sexo=" + sexo + ", endereco=" + endereco + ", telefone=" + telefone + '}';
    }

}
