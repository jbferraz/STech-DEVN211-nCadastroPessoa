/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ncadastropessoa;

import controller.CCarro;
import controller.CPessoa;
import controller.CVagaCondominio;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import model.Carro;
import model.Pessoa;
import model.VagaCondominio;

/**
 *
 * @author jairb
 */
public class NCadastroPessoa
{

    public static Scanner ler = new Scanner(System.in);
    public static CPessoa cadPessoas = new CPessoa();
    public static CCarro cadCarros = new CCarro();
    public static CVagaCondominio cadastraVaga = new CVagaCondominio();

    /**
     * Função para Ler String e burlar problema com console do Java
     *
     * @return
     */
    public static String leTexto()
    {
        //Matheus Gre
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    public static String formataCPF(String CPF)
    {
        return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "."
                + CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
    }

    public static void menu()
    {
        System.out.println("\n-- Menu Principal --");
        System.out.println("1 - Ir para Pessoa");
        System.out.println("2 - Ir para Veículo");
        System.out.println("3 - Ir para Estacionar");
        System.out.println("0 - Sair");
        System.out.print("Escolha um opção: ");
    }

    public static void menuP()
    {
        System.out.println("\n-- Menu --");
        System.out.println("1 - Cadastra Pessoa");
        System.out.println("2 - Listar Pessoa");
        System.out.println("3 - Editar Pessoa");
        System.out.println("4 - Excluir Pessoa");
        System.out.println("5 - Limpar Cadastro de Pessoas");
        System.out.println("0 - Voltar");
        System.out.print("Escolha uma opção: ");
    }

    public static void menuC()
    {
        System.out.println("\n-- Cadastro Carro --");
        System.out.println("1 - Cadastrar Carro");
        System.out.println("2 - Atualizar Carro");
        System.out.println("3 - Imprimir Carro");
        System.out.println("4 - Deletar Carros");
        System.out.println("0 - Voltar");
        System.out.print("Escolha um opção: ");
    }

    public static void menuEstacionar()
    {
        System.out.println("\n-- Estacionamento --");
        System.out.println("1 - CheckIn");
        System.out.println("2 - CheckOut");
        System.out.println("3 - Listar");
        System.out.println("0 - Voltar");
        System.out.print("Escolha um opção: ");
    }

    public static void cadastrarPessoa()
    {
        int continua = 0;
        do
        {
            //var temporarias
            int idPessoa;
            String nomePessoa, cpf, sexo, endereco, telefone;
            System.out.println("-- Cadastro de Pessoa --");
            System.out.println("Informe o nome:");

            nomePessoa = leTexto().toUpperCase();
            boolean testaCPF = false;
            do
            {
                System.out.println("Informe o CPF:");
                cpf = leTexto();
                if (cpf.length() == 11)
                {
                    testaCPF = cadPessoas.CPFExiste(cpf);
                    if (testaCPF)
                    {
                        System.out.println("CPF já cadastrado!");
                    }
                } else
                {
                    System.out.println("Por favor digitar 11 caracteres");
                    testaCPF = true;
                }
            } while (testaCPF);
            System.out.println("Informe o sexo:");
            sexo = leTexto().toUpperCase();
            System.out.println("Informe o endereço:");
            endereco = leTexto().toUpperCase();
            boolean testaTel = false;
            do
            {
                System.out.println("Informe o telefone: (DDD)+num.");
                telefone = leTexto();
                if (telefone.length() == 10 || telefone.length() == 11)
                {
                    testaTel = false;
                } else
                {
                    System.out.println("Telefone incorreto, tente novamente!");
                    testaTel = true;
                }
            } while (testaTel);
            idPessoa = cadPessoas.gerarId();
            Pessoa p = new Pessoa(idPessoa, nomePessoa, cpf, sexo, endereco, telefone);
            cadPessoas.add(p);
            System.out.println(p.getNomePessoa() + " sob o CPF: "
                    + formataCPF(cpf) + " foi cadastrado com sucesso!");

            System.out.println("Deseja continuar cadastrando? 1-Sim | 0-Não");
            continua = ler.nextInt();
        } while (continua == 1);
    }

    public static void imprimirPessoas()
    {
        System.out.println("-- Lista de Pessoas --");
        if (cadPessoas.getAll().isEmpty())
        {
            System.out.println("Cadastro de Pessoas vazio!");
        } else
        {
            for (Pessoa listPes : cadPessoas.getAll())
            {
                System.out.println("---");
                System.out.println("Id: " + listPes.getIdPessoa());
                System.out.println("Nome: " + listPes.getNomePessoa());
                System.out.println("CPF: " + listPes.getCpf());
            }
        }
    }

    public static void atualizarPessoa()
    {
        System.out.println("-- Atualiza Pessoa --");
        String cpf;
        do
        {
            System.out.println("Informe um CPF: ");
            cpf = leTexto();
            if (!cadPessoas.CPFExiste(cpf))
            {
                System.out.println("CPF inválido, tente novamente!");
            }
        } while (!cadPessoas.CPFExiste(cpf));
        Pessoa p = new Pessoa();
        p = cadPessoas.getByDoc(cpf);
        System.out.println(p.getNomePessoa() + " foi selecionado.");
        System.out.println("1 - Atualizar tudo");
        System.out.println("2 - Atualizar nome");
        System.out.println("3 - Atualizar sexo");
        System.out.println("4 - Atualizar endereço");
        System.out.println("5 - Atualizar telefone");
        boolean opM;
        do
        {
            opM = false;
            System.out.print("Escolha uma opção: ");
            int opA = ler.nextInt();
            switch (opA)
            {
                case 1:
                    System.out.println("Atualiza tudo");
                    System.out.print("Informe o nome: ");
                    p.setNomePessoa(leTexto().toUpperCase());
                    System.out.print("\nInforme o sexo: ");
                    p.setSexo(leTexto().toUpperCase());
                    System.out.print("\nInforme o endereço: ");
                    p.setEndereco(leTexto().toUpperCase());
                    System.out.print("\nInforme o telefone: ");
                    p.setTelefone(leTexto());
                    break;
                case 2:
                    System.out.print("Informe o nome: ");
                    p.setNomePessoa(leTexto().toUpperCase());
                    break;
                case 3:
                    System.out.print("\nInforme o sexo: ");
                    p.setSexo(leTexto().toUpperCase());
                    break;
                case 4:
                    System.out.print("\nInforme o endereço: ");
                    p.setEndereco(leTexto().toUpperCase());
                    break;
                case 5:
                    System.out.print("\nInforme o telefone: ");
                    p.setTelefone(leTexto());
                    break;
                default:
                    opM = true;
            }
        } while (opM);
    }

    public static void deletarPessoa()
    {
        System.out.println("-- Deletar Pessoa --\n");
        String cpf;
        do
        {
            System.out.println("Informe um CPF: ");
            cpf = leTexto();
            if (!cadPessoas.CPFExiste(cpf))
            {
                System.out.println("CPF inválido, tente novamente!");
            }
        } while (!cadPessoas.CPFExiste(cpf));
        Pessoa p = new Pessoa();
        p = cadPessoas.getByDoc(cpf);
        System.out.println(p.getNomePessoa() + " foi selecionado.");
        System.out.println("Deseja remover a Pessoa seleciona? 1-Sim | 0-Não");
        int i = ler.nextInt();
        switch (i)
        {
            case 1:
                boolean rp;
                rp = cadPessoas.remover(p);
                if (rp)
                {
                    System.out.println("Pessoa removida com sucesso!");
                } else
                {
                    System.out.println("Erro ao remover Pessoa!");
                }
                break;
            case 0:
                System.out.println("Ok, entendo sua escolha.");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void deletarPessoas()
    {
        System.out.println("-- Limpar Cadastro de Pessoas --");
        System.out.println("Tem certeza que deseja limpar todo o cadastro? 1-Sim | 0-Não");
        int i = ler.nextInt();
        if (i == 1)
        {
            cadPessoas.removerPessoas();
            System.out.println("Cadastro limpo!");
        } else
        {
            System.out.println("OK, entendido!");
        }
    }

    public static void imprimirCarro()
    {
        System.out.println("-- Lista de Carros --");
        if (cadCarros.getAll().isEmpty())
        {
            System.out.println("Cadastro de Carros vazio!");
        } else
        {
            for (Carro car : cadCarros.getAll())
            {
                System.out.println("---");
                System.out.println("Placa: " + car.getPlaca());
                System.out.println("Marca: " + car.getMarca());
                System.out.println("Modelo: " + car.getModelo());
                System.out.println("Proprietário: "
                        + cadPessoas.getNomePessoa(car.getIdPessoa()));
            }
        }
    }

    public static void cadastrarCarro()
    {
        System.out.println("-- Cadastro de Veículo --");
        Carro c = new Carro();
        do
        {
            System.out.print("Informe a placa do veículo: ");
            c.setPlaca(leTexto().toUpperCase());
            if (cadCarros.verPlaca(c.getPlaca()))
            {
                System.out.println("Placa já cadastrada, tente novamente!");
            }
        } while (cadCarros.verPlaca(c.getPlaca()));
        System.out.print("Informe a marca: ");
        c.setMarca(leTexto().toUpperCase());
        System.out.print("Informe o modelo: ");
        c.setModelo(leTexto().toUpperCase());
        Calendar cal = GregorianCalendar.getInstance();
        int anoAtual = cal.get(Calendar.YEAR);
        //valida ano fabricação
        do
        {
            System.out.print("Informe o ano de fabricação: ");
            c.setAnoFabricacao(ler.nextInt());
            if (c.getAnoFabricacao() > anoAtual)
            {
                System.out.println("Ano fabricação inválido, tente novamente!");
            }
        } while (c.getAnoFabricacao() > anoAtual);
        //valida ano modelo
        boolean anoM = true;
        do
        {
            System.out.print("Informe ano modelo: ");
            c.setAnoModelo(ler.nextInt());
            //|| pipe significa ou
            int anoF = c.getAnoFabricacao();
            int anoMod = c.getAnoModelo();
            if (anoMod == anoF || anoMod == anoF + 1)
            {
                anoM = false;
            } else
            {
                System.out.println("Ano modelo inválido, tente novamente!");
            }
        } while (anoM);
        System.out.print("Informe a cor do veículo: ");
        c.setCor(leTexto().toUpperCase());
        System.out.print("Informe o núm. de portas: ");
        c.setnPortas(ler.nextInt());
        //validar Proprietário
        boolean validaPes = false;
        do
        {
            System.out.print("Informe o cpf do Proprietário: ");
            String cpf = leTexto();
            validaPes = cadPessoas.CPFExiste(cpf);
            if (validaPes)
            {
                c.setIdPessoa(cadPessoas.getIdPessoa(cpf));
            } else
            {
                System.out.println("CPF inválido, tente novamente!");
            }
        } while (!validaPes);
        cadCarros.add(c);
        System.out.println("Veículo sob a placa: " + c.getPlaca()
                + " cadastrado com sucesso."
                + "\nSeu proprietário é: "
                + cadPessoas.getNomePessoa(c.getIdPessoa()));
    }

    public static void deletarCarro()
    {
        System.out.println("-- Deletar Veículo --");
        System.out.print("Informe a placa: ");
        String placa = leTexto();
        if (cadCarros.verPlaca(placa))
        {
            Carro c = cadCarros.getByDoc(placa);
            System.out.println("Deseja realmente remover o carro"
                    + " sob a placa " + c.getPlaca() + ",\ndo proprietário "
                    + cadPessoas.getNomePessoa(c.getIdPessoa())
                    + "? 1 - Sim | 0 - Não");
            int remCar = ler.nextInt();
            if (remCar == 1)
            {
                cadCarros.remover(c);
                System.out.println("Veículo removido com sucesso!");
            } else
            {
                System.out.println("Operação cancelada!");
            }
        } else
        {
            System.out.println("Placa inválida ou inexistente!");
        }
    }

    public static void editarCarro()
    {
        System.out.println("-- Atualizar Veículo --");
        System.out.print("Informe a placa do veículo: ");
        String placa = leTexto();
        if (cadCarros.verPlaca(placa))
        {
            Carro c = cadCarros.getByDoc(placa);
            System.out.println("O que deseja atualziar?"
                    + "\n1 - Cor"
                    + "\n2 - Proprietário"
                    + "\n0 - Cancelar");
            int upM = ler.nextInt();
            switch (upM)
            {
                case 1:
                    System.out.print("Informe a cor: ");
                    c.setCor(leTexto().toUpperCase());
                    break;
                case 2:
                    System.out.print("Informe o CPF: ");
                    String cpf = leTexto();
                    if (cadPessoas.CPFExiste(cpf))
                    {
                        c.setIdPessoa(cadPessoas.getIdPessoa(cpf));
                    } else
                    {
                        System.out.println("Proprietário não cadastrado!");
                    }
                    break;
                case 0:
                    System.out.println("Operação cancelada!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println("Veículo sob a placa " + c.getPlaca()
                    + "\nCor: " + c.getCor()
                    + "\nProprietário: " + cadPessoas.getNomePessoa(c.getIdPessoa())
                    + "\nFoi atualizado!");
        } else
        {
            System.out.println("Placa inválida ou inexistente!");
        }
    }

    public static void msg()
    {
        System.out.print("|");
        System.out.print("-----------------------------------------------");
        System.out.println("|");
        System.out.print("|");
        System.out.print(" Projeto concluído                    |");
        System.out.print("\n|");
        System.out.print("-----------------------------------------------");
        System.out.println("|");
    }

    public static void estacionar()
    {
        System.out.println("Estacionar");
        System.out.println(" Digite a placa do carro: ");
        String placa = ler.next();
        boolean horaCerta = true;
        int horaEntrada;

        do
        {
            System.out.println("Digite a hora de entrada: ");
            horaEntrada = ler.nextInt();

            if ((horaEntrada >= 0) && (horaEntrada <= 24))
            {
                horaCerta = false;
            } else
            {
                System.out.println("Digite um valor maior que ZERO");
            }
        } while (horaCerta);

        checkIn(placa, horaEntrada);
    }

    public static void checkIn(String placa, int horaEntrada)
    {
        //
        VagaCondominio vaga = new VagaCondominio();

        vaga = cadastraVaga.getVagaComCarro(placa);

        LocalTime checkIn = LocalTime.of(horaEntrada, 00);
        vaga.setCheckIn(checkIn);
    }

    public static void sairDoEstacionamento()
    {
        System.out.println("Sair do EStacionamento ");
        System.out.println(" Digite a placa do carro: ");
        String placa = ler.next();

        VagaCondominio vaga = new VagaCondominio();
        vaga = cadastraVaga.getVagaComCarro(placa);
        int horaEntrada = (int) vaga.getCheckIn().getHour();
        boolean horaCerta = true;
        int horaSaida;

        if (horaEntrada >= 0)
        {
            do
            {
                System.out.println("Digite a hora de saída: ");
                horaSaida = ler.nextInt();

                if (horaSaida >= horaEntrada)
                {
                    horaCerta = false;
                } else
                {
                    System.out.println("Digite um valor maior que: " + horaEntrada);
                }
            } while (horaCerta);
            
            checkOut(placa, horaSaida);
        }else
        {
            System.out.println("Faça o Checkin antes!");
        }
    }

    public static void checkOut(String placa, int horaSaida)
    {
        //
        System.out.println(" saindo - checkOut " + horaSaida);
        VagaCondominio vaga = new VagaCondominio();

        vaga = cadastraVaga.getVagaComCarro(placa);

        LocalTime checkOut = LocalTime.of(horaSaida, 00);
        vaga.setCheckOut(checkOut);

        Duration duracao = Duration.between(vaga.getCheckIn(), vaga.getCheckOut());
        int minutos = (int) duracao.toMinutes();
        System.out.println("Tempo(HH): " + minutos);
        System.out.println("Valor a pagar: R$ " + ((minutos / 60) * 10));

        cadastraVaga.remover(vaga);
    }

    public static void listarVagasComCarro()
    {
        //
        cadastraVaga.listaVagasComCarro();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        Calendar cal = GregorianCalendar.getInstance();
        int diaAtual = cal.get(Calendar.DAY_OF_MONTH);
        if (diaAtual == 13)
        {
            msg();
        }
        cadPessoas.mokPessoas();
        cadCarros.mokCarros();
        cadastraVaga.mokVaga();
        System.out.println(cadastraVaga.getAll());

        String s = "s";

        do
        {
            menu();
            int m = ler.nextInt();
            switch (m)
            {
                case 1:
                    boolean sis = true;
                    do
                    {
                        menuP();
                        int opM = ler.nextInt();
                        switch (opM)
                        {
                            case 1:
                                cadastrarPessoa();
                                break;
                            case 2:
                                imprimirPessoas();
                                break;
                            case 3:
                                atualizarPessoa();
                                break;
                            case 4:
                                deletarPessoa();
                                break;
                            case 5:
                                deletarPessoas();
                                break;
                            case 0:
                                sis = false;
                                break;
                            default:
                                System.out.println("Opção selecionada inválida, "
                                        + "tente novamente!");
                                break;
                        }
                    } while (sis);//fim 'do' Pessoa
                    break;
                case 2:
                    boolean sisC = true;
                    do
                    {
                        menuC();
                        int opM = ler.nextInt();
                        switch (opM)
                        {
                            case 1:
                                cadastrarCarro();
                                break;
                            case 2:
                                editarCarro();
                                break;
                            case 3:
                                imprimirCarro();
                                break;
                            case 4:
                                deletarCarro();
                                break;
                            case 0:
                                sisC = false;
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente!");
                                break;
                        }
                    } while (sisC);//fim 'do' Carro
                    break;
                case 3:
                    boolean sisEst = true;
                    do
                    {
                        menuEstacionar();
                        int opM = ler.nextInt();
                        switch (opM)
                        {
                            case 1:
                                estacionar();
                                break;
                            case 2:
                                sairDoEstacionamento();
                                break;
                            case 3:
                                listarVagasComCarro();
                                break;
                            case 0:
                                sisEst = false;
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente!");
                                break;
                        }
                    } while (sisEst);
                    break;
                case 0:
                    s = "n";
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        } while (s.equalsIgnoreCase("s"));

        System.out.println("");
        System.out.println("Aplicação encerrada pelo usuário!");
    }
}
