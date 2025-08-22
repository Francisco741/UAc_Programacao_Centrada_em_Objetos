import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * A classe {@code Sistema} serve para armazenar os dados do programa e as funções principais.
 *
 * @author Francisco Arruda e Miguel Pacheco
 * @version 1.0
 * @since 2023-12-16
 */
public class Sistema {

    /**
     * Lista de medicamentos registados no sistema.
     */
    @SerializedName("drugs")
    private List<Medicamento> listaMedicamentos = new ArrayList<>();

    /**
     * Lista de interações alimentares registadas no sistema.
     */
    @SerializedName("foodInteractions")
    private List<InteracaoAlimentar> listaInteracoesAlimentares = new ArrayList<>();

    /**
     * Lista de alimentos registados no sistema.
     */
    @SerializedName("foodTypes")
    private List<Alimento> listaAlimentos = new ArrayList<>();

    /**
     * Lista de indústrias farmacêuticas registadas no sistema.
     */
    @SerializedName("laboratories")
    private List<IndustriaFarmaceutica> listaIndustriasFarmaceuticas = new ArrayList<>();

    /**
     * Lista de substâncias ativas registadas no sistema.
     */
    @SerializedName("substances")
    private List<SubstanciaAtiva> listaSubstanciasAtivas = new ArrayList<>();


    /**
    * Papel associado aos utilizadores farmacêuticos.
    */
    public static final String FARMACEUTICO = "farmaceutico";
    /**
    * Papel associado aos utilizadores da indústria farmacêutica.
    */
    public static final String INDUSTRIA = "industria";
    /**
    * Papel associado aos utilizadores administradores do sistema.
    */
    public static final String ADMINISTRADOR = "administrador";
    /**
    * Scanner utilizado para entrada do utilizador via consola.
    */
    public static final Scanner SCANNER = new Scanner(System.in);


    /**
     * UC03: Cria uma nova substância ativa no sistema.
     * 
     * @return Mensagem indicando o resultado da criação da substância.
     */
    public String criarNovaSubstancia() {
        SubstanciaAtiva sa = new SubstanciaAtiva();
        adicionarNovaSubstancia(sa);
        String confirmacao;
        do {
            System.out.print("Confirma a criação da nova substância ativa? [sim/nao]: ");
            confirmacao = SCANNER.nextLine().toLowerCase();
            switch (confirmacao) {
                case "sim":
                    for (SubstanciaAtiva substanciaAtiva : listaSubstanciasAtivas) {
                        if (substanciaAtiva.getNome().equalsIgnoreCase(sa.getNome())) {
                            System.out.println("Substância Ativa com nome já existente. Por favor, insira um nome único.");
                            adicionarNovaSubstancia(sa);
                            break;
                        }
                    }
                    return confirmarNovaSubstancia(sa);
                case "nao":
                    return cancelarNovaSubstancia();
                default:
                    System.out.println("Resposta inválida. Por favor digite 'sim' ou 'nao'.");
            }
        } while (!confirmacao.equals("sim") && !confirmacao.equals("nao"));
        return "";
    }

    /**
     * Adiciona uma nova substância ativa ao sistema.A
     * 
     * @param sa A substância ativa a ser adicionada.
     */
    public void adicionarNovaSubstancia(SubstanciaAtiva sa) {
        System.out.print("Insira o nome da nova Substância Ativa: ");
        sa.setNome(SCANNER.nextLine());
    }

    /**
     * Confirma a criação da nova substância ativa e adiciona-a à lista.
     *
     * @param sa A substância ativa a ser confirmada e adicionada.
     * @return Mensagem indicando o sucesso da operação.
     */
    public String confirmarNovaSubstancia(SubstanciaAtiva sa) {
        this.listaSubstanciasAtivas.add(sa);
        return "Substância Ativa criada com sucesso.";
    }

    /**
     * Cancela a criação da nova substância ativa.
     *
     * @return Mensagem indicando o cancelamento da operação.
     */
    public String cancelarNovaSubstancia() {
        return "Criação da Substância Ativa cancelada.";
    }


    /**
     * UC04: Lista as substâncias ativas registradas no sistema.
     *
     * @return Mensagem indicando o resultado da operação.
     */
    public String listarSubstancias() {
        int indiceInicio = 0;
        int indiceFim = 10;
        int quantidade = 10;
        List<SubstanciaAtiva> listaOrdenadaSubstanciasAtivas = new ArrayList<>(listaSubstanciasAtivas);
        Collections.sort(listaOrdenadaSubstanciasAtivas, Comparator.comparing (SubstanciaAtiva::getNome));
        List<SubstanciaAtiva> substanciasExibicaoInicio = listaOrdenadaSubstanciasAtivas.subList(indiceInicio, indiceFim);
        for (SubstanciaAtiva substancia : substanciasExibicaoInicio) {
                System.out.println(substancia.getNome());
        }
        String resposta;
        while (true) {
            do {
                System.out.print("Deseja ver mais 10 substâncias ativas? [sim/nao]: ");
                resposta = SCANNER.nextLine().toLowerCase();
                switch (resposta) {
                    case "sim":
                        indiceInicio += quantidade;
                        indiceFim = Math.min(indiceInicio + quantidade, listaOrdenadaSubstanciasAtivas.size());
                        if (indiceFim < listaOrdenadaSubstanciasAtivas.size()) {
                            List<SubstanciaAtiva> substanciasExibicao = listaOrdenadaSubstanciasAtivas.subList(indiceInicio, indiceFim);
                            listarMais10Substancias(substanciasExibicao);
                        } else {
                            List<SubstanciaAtiva> substanciasExibicao = listaOrdenadaSubstanciasAtivas.subList(indiceInicio, indiceFim);
                            listarMais10Substancias(substanciasExibicao);
                            return "Não existem mais Substâncias Ativas disponíveis.";
                        }
                        break;
                    case "nao":
                        return terminarConsultaSubstancias();
                    default:
                        System.out.println("Resposta inválida. Por favor digite 'sim' ou 'nao'.");
                }
            } while (!resposta.equals("sim") && !resposta.equals("nao"));
        }
    }

    /**
     * Lista mais 10 substâncias ativas.
     *
     * @param substanciasExibicao Lista de substâncias a serem apresentadas.
     */
    public void listarMais10Substancias(List<SubstanciaAtiva> substanciasExibicao) {
        for (SubstanciaAtiva substancia : substanciasExibicao) {
            System.out.println(substancia.getNome());
        }
    }
    
    /**
     * Termina a consulta das substâncias ativas.
     *
     * @return Mensagem indicando o fim da consulta.
     */
    public String terminarConsultaSubstancias() {
        return "Fim da consulta das Substâncias Ativas.";
    }


    /**
     * UC05: Cria uma nova interação alimentar no sistema.
     *
     * @return Mensagem indicando o resultado da operação.
     */
    public String criarInteracaoAlimentar() {
        InteracaoAlimentar ia = new InteracaoAlimentar();
        indicarSubstanciaInteracao(ia);
        indicarExplicacaoInteracao(ia);
        indicarAlimentoInteracao(ia);
        indicarEfeitoInteracao(ia);
        indicarReferenciaInteracao(ia);
        String indicacao;
        loop: while (true) {
            do {
                indicacao = autorizarCriacaoInteracao();
                switch (indicacao) {
                    case "sim":
                        if (ia.getSubstanciaAtiva().isEmpty()) {
                            System.out.println("Nome da Substância Ativa em falta");
                        } else if (ia.getExplicacao().isEmpty()) {
                            System.out.println("Explicação da interação em falta");
                        } else if (ia.getAlimento().isEmpty()) {
                            System.out.println("Nome do alimento em falta");
                        } else if (ia.getEfeito().isEmpty()) {
                            System.out.println("Descrição do efeito em falta");
                        } else if (ia.getBibliografia().isEmpty()) {
                            System.out.println("Referência Bibliográfica em falta");
                        }
                        for (InteracaoAlimentar interacaoAlimentar : listaInteracoesAlimentares) {
                            if (ia.getSubstanciaAtiva().equalsIgnoreCase(interacaoAlimentar.getSubstanciaAtiva()) && 
                                (ia.getAlimento().equalsIgnoreCase(interacaoAlimentar.getAlimento()))) {
                                return "Interação Alimentar já existe";
                            }
                        }
                        for (SubstanciaAtiva substanciaAtiva : listaSubstanciasAtivas) {
                            if (substanciaAtiva.getNome().equalsIgnoreCase(ia.getSubstanciaAtiva())) {
                                break loop;
                            }
                        }
                        System.out.println("Substância Ativa não encontrada.\n" +
                                            "Por favor, insira uma Substância Ativa válida."
                        );
                        indicarSubstanciaInteracao(ia);
                        indicarExplicacaoInteracao(ia);
                        indicarAlimentoInteracao(ia);
                        indicarEfeitoInteracao(ia);
                        indicarReferenciaInteracao(ia);
                        break;
                    case "nao":
                        return cancelarInteracao();
                    default:
                        System.out.println("Resposta inválida. Por favor digite 'sim' ou 'nao'.");
                }
            } while (!indicacao.equals("sim") && !indicacao.equals("nao"));
        }
        String confirmacao;
        do {
            System.out.print("Confirma a criação da nova Interação Alimentar? [sim/nao]: ");
            confirmacao = SCANNER.nextLine().toLowerCase();
            switch (confirmacao) {
                case "sim":
                return confirmarInteracao(ia);
                case "nao":
                return cancelarInteracao();
                default:
                    System.out.println("Resposta inválida. Por favor digite 'sim' ou 'nao'.");
            }
        } while (!confirmacao.equals("sim") && !confirmacao.equals("nao"));
        return("");
    }

    /**
     * Indica o nome da substância ativa associada à interação alimentar.
     *
     * @param ia A interação alimentar a ser preenchida.
     */
    public void indicarSubstanciaInteracao(InteracaoAlimentar ia) {
        System.out.print("Insira o nome da Substância Ativa associada à Interação Alimentar: ");
        ia.setSubstanciaAtiva(SCANNER.nextLine());
    }

    /**
     * Fornece uma explicação detalhada da interação alimentar.
     *
     * @param ia A interação alimentar a ser preenchida.
     */
    public void indicarExplicacaoInteracao(InteracaoAlimentar ia) {
        System.out.print("Forneça uma explicação detalhada da interação alimentar,\n" +
                        "descrevendo como a Substância Ativa interage com o Alimento:"
                        );
        ia.setExplicacao(SCANNER.nextLine());
    }

    /**
     * Indica o tipo de alimento associado à interação alimentar.
     *
     * @param ia A interação alimentar a ser preenchida.
     */
    public void indicarAlimentoInteracao(InteracaoAlimentar ia) {
        System.out.print("Insira o tipo de alimento associado à Interação Alimentar: ");
        ia.setAlimento(SCANNER.nextLine());
    }

    /**
     * Indica o efeito da interação alimentar.
     *
     * @param ia A interação alimentar a ser preenchida.
     */
    public void indicarEfeitoInteracao(InteracaoAlimentar ia) {
        System.out.print("especifica o efeito da Interação Alimentar: ");
        ia.setEfeito(SCANNER.nextLine());
    }

    /**
     * Indica a referência bibliográfica à interação alimentar.
     *
     * @param ia A interação alimentar a ser preenchida.
     */
    public void indicarReferenciaInteracao(InteracaoAlimentar ia) {
        System.out.print("adicione a referência bibliográfica: ");
        ia.setBibliografia(SCANNER.nextLine());
    }

    /**
     * Solicita a autorização para a criação da interação alimentar.
     *
     * @return Resposta informando se o utilizador autoriza a criação.
     */
    public String autorizarCriacaoInteracao() {
        System.out.print("Pretende criar a Interação Alimentar com os dados inseridos? [sim/nao]: ");
        return SCANNER.nextLine().toLowerCase();
    }

    /**
     * Confirma a criação da nova interação alimentar e a adiciona à lista.
     *
     * @param ia A interação alimentar a ser confirmada e adicionada.
     * @return Mensagem a indicar o sucesso da operação.
     */
    public String confirmarInteracao(InteracaoAlimentar ia) {
        this.listaInteracoesAlimentares.add(ia);
        return "Interação Alimentar criada com sucesso.";
    }

    /**
     * Cancela a criação da interação alimentar.
     *
     * @return Mensagem indicando o cancelamento da operação.
     */
    public String cancelarInteracao() {
        return "Criação da Interação Alimentar cancelada.";
    }

    /**
     * UC06: Lista as interações alimentares do sistema.
     *
     * @return Mensagem indicando o resultado da operação.
     */
    public String listarInteracoesAlimentares() {
        int indiceInicio = 0;
        int indiceFim = 10;
        int quantidade = 10;
        List<InteracaoAlimentar> listaOrdenadaInteracaoAlimentar = new ArrayList<>(listaInteracoesAlimentares);
        Collections.sort(listaOrdenadaInteracaoAlimentar, Comparator.comparing (InteracaoAlimentar::getSubstanciaAtiva));
        List<InteracaoAlimentar> interacaoExibicaoInicio = listaOrdenadaInteracaoAlimentar.subList(indiceInicio, indiceFim);
        for (InteracaoAlimentar interacao : interacaoExibicaoInicio) {
                System.out.println(interacao.getSubstanciaAtiva());
                System.out.println(interacao.getAlimento());
                System.out.println(interacao.getEfeito() + "\n");
        }
        String resposta;
        while (true) {
            do {
                System.out.print("Deseja ver mais 10 interações alimentares? [sim/nao]: ");
                resposta = SCANNER.nextLine().toLowerCase();
                switch (resposta) {
                    case "sim":
                        indiceInicio += quantidade;
                        indiceFim = Math.min(indiceInicio + quantidade, listaOrdenadaInteracaoAlimentar.size());
                        if (indiceFim < listaOrdenadaInteracaoAlimentar.size()) {
                            List<InteracaoAlimentar> interacaoExibicao = listaOrdenadaInteracaoAlimentar.subList(indiceInicio, indiceFim);
                            listarMais10Interacoes(interacaoExibicao);
                        } else {
                            List<InteracaoAlimentar> interacaoExibicao = listaOrdenadaInteracaoAlimentar.subList(indiceInicio, indiceFim);
                            listarMais10Interacoes(interacaoExibicao);
                            return "Não existem mais Interações Alimentares disponíveis.";
                        }
                        break;
                    case "nao":
                        return terminarConsultaInteracoes();
                    default:
                        System.out.println("Resposta inválida. Por favor digite 'sim' ou 'nao'.");
                }
            } while (!resposta.equals("sim") && !resposta.equals("nao"));
        }
    }

    /**
     * Lista mais 10 interações alimentares da lista.   
     *
     * @param interacaoExibicao Lista de interações alimentares a serem apresentadas.
     */
    public void listarMais10Interacoes(List<InteracaoAlimentar> interacaoExibicao) {
        for (InteracaoAlimentar interacao : interacaoExibicao) {
            System.out.println(interacao.getSubstanciaAtiva());
            System.out.println(interacao.getAlimento());
            System.out.println(interacao.getEfeito() + "\n");
        }
    }

    /**
     * Termina a consulta das interações alimentares.
     *
     * @return Mensagem indicando o fim da consulta.
     */
    public String terminarConsultaInteracoes() {
        return "Fim da consulta das Interações Alimentares.";
    }
    
    /**
     * UC07
     * Cria um novo Medicamento, indicando e armazenando as informações necessárias.
     * Verifica se os dados estão completos e se a Substância Ativa associada existe.
     * Retorna mensagens indicando sucesso ou cancelamento da operação.
     */
    public String criarMedicamento() {
        Medicamento m = new Medicamento();
        indicarNomeMedicamento(m);
        indicarFormaMedicamento(m);
        indicarDosagemMedicamento(m);
        fornecerSubstanciaAtiva(m);
        String indicacao;
        loop: while (true) {
            do {
                indicacao = confirmarDadosMedicamento();
                switch (indicacao) {
                    case "sim":
                        if (m.getNome().isEmpty()) {
                            System.out.println("Nome do medicamento em falta.");
                        } else if (m.getFormaFarmaceutica().isEmpty()) {
                            System.out.println("Forma farmacêutica do medicamento em falta.");
                        } else if (m.getDosagem().isEmpty()) {
                            System.out.println("Dosagem do medicamento em falta.");
                        } else if (m.getSubstanciaAtiva().isEmpty()) {
                            System.out.println("Nome da Substância Ativa em falta.");
                        }
                        for (Medicamento medicamento: listaMedicamentos) {
                            if (m.getNome().equalsIgnoreCase(medicamento.getNome())) {
                                return "Medicamento já existe";
                            }
                        }
                        for (SubstanciaAtiva substanciaAtiva : listaSubstanciasAtivas) {
                            if (substanciaAtiva.getNome().equalsIgnoreCase(m.getSubstanciaAtiva())) {
                                break loop;
                            }
                        }
                        System.out.println("Substância Ativa não encontrada.\n" +
                                            "Por favor, insira uma Substância Ativa válida."
                        );
                        indicarNomeMedicamento(m);
                        indicarFormaMedicamento(m);
                        indicarDosagemMedicamento(m);
                        fornecerSubstanciaAtiva(m);
                        break;
                    case "nao":
                        return cancelarCriacaoMedicamento();
                    default:
                        System.out.println("Resposta inválida. Por favor digite 'sim' ou 'nao'.");
                }
            } while (!indicacao.equals("sim") && !indicacao.equals("nao"));
        }
        String confirmacao;
        do {
            System.out.print("Confirma a criação do novo Medicamento? [sim/nao]: ");
            confirmacao = SCANNER.nextLine().toLowerCase();
            switch (confirmacao) {
                case "sim":
                return confirmarCriacaoMedicamento(m);
                case "nao":
                return cancelarCriacaoMedicamento();
                default:
                    System.out.println("Resposta inválida. Por favor digite 'sim' ou 'nao'.");
            }
        } while (!confirmacao.equals("sim") && !confirmacao.equals("nao"));
        return("");
    }

    /**
     * Indica e armazena o nome do Medicamento.
     */
    public void indicarNomeMedicamento(Medicamento m) {
        System.out.print("Insira o nome do Medicamento: ");
        m.setNome(SCANNER.nextLine());
    }

    /**
     * Indica e armazena a forma farmacêutica do Medicamento.
     */
    public void indicarFormaMedicamento(Medicamento m) {
        System.out.print("Insira a forma farmacêutica do Medicamento: ");
        m.setFormaFarmaceutica(SCANNER.nextLine());
    }

    /**
     * Indica e armazena a dosagem do Medicamento.
     */
    public void indicarDosagemMedicamento(Medicamento m) {
        System.out.print("Insira a dosagem do Medicamento: ");
        m.setDosagem(SCANNER.nextLine());
    }

    /**
     * Indica e armazena o nome da Substância Ativa associada ao Medicamento.
     */
    public void fornecerSubstanciaAtiva(Medicamento m) {  
        System.out.print("Insira o nome da Substância Ativa associada ao Medicamento: ");
        m.setSubstanciaAtiva(SCANNER.nextLine());
    }

    /**
     * Indica e retorna a confirmação para os dados inseridos.
     */
    public String confirmarDadosMedicamento() {
        System.out.print("Pretende criar o Medicamento com os dados inseridos? [sim/nao]: ");
        return SCANNER.nextLine().toLowerCase();
    }

    /**
     * Adiciona o Medicamento à lista de Medicamentos e retorna uma mensagem de sucesso.
     */
    public String confirmarCriacaoMedicamento(Medicamento m) {
        this.listaMedicamentos.add(m);
        return "Interação Alimentar criada com sucesso.";
    }

    /**
     * Retorna uma mensagem indicando o cancelamento da criação do Medicamento.
     */
    public String cancelarCriacaoMedicamento() {
        return "Criação do medicamento cancelada.";
    }

    /**
     * UC08: Lista os medicamentos do sistema.
     *
     * @return Mensagem indicando o resultado da operação.
     */
    public String listarMedicamentos() {
        int indiceInicio = 0;
        int indiceFim = 10;
        int quantidade = 10;
        List<Medicamento> listaOrdenadaMedicamentos = new ArrayList<>(listaMedicamentos);
        Collections.sort(listaOrdenadaMedicamentos, Comparator.comparing (Medicamento::getNome));
        List<Medicamento> medicamentoExibicaoInicio = listaOrdenadaMedicamentos.subList(indiceInicio, indiceFim);
        for (Medicamento medicamento : medicamentoExibicaoInicio) {
                System.out.println(medicamento.getNome());
                System.out.println(medicamento.getFormaFarmaceutica());
                System.out.println(medicamento.getDosagem());
                System.out.println(medicamento.getSubstanciaAtiva() + "\n");
        }
        String resposta;
        while (true) {
            do {
                System.out.print("Deseja ver mais 10 medicamentos? [sim/nao]: ");
                resposta = SCANNER.nextLine().toLowerCase();
                switch (resposta) {
                    case "sim":
                        indiceInicio += quantidade;
                        indiceFim = Math.min(indiceInicio + quantidade, listaOrdenadaMedicamentos.size());
                        if (indiceFim < listaOrdenadaMedicamentos.size()) {
                            List<Medicamento> medicamentoExibicao = listaOrdenadaMedicamentos.subList(indiceInicio, indiceFim);
                            listaMais10Medicamentos(medicamentoExibicao);
                        } else {
                            List<Medicamento> medicamentoExibicao = listaOrdenadaMedicamentos.subList(indiceInicio, indiceFim);
                            listaMais10Medicamentos(medicamentoExibicao);
                            return "Não existem mais medicamentos disponíveis.";
                        }
                        break;
                    case "nao":
                        return terminarConsultaMedicamentos();
                    default:
                        System.out.println("Resposta inválida. Por favor digite 'sim' ou 'nao'.");
                }
            } while (!resposta.equals("sim") && !resposta.equals("nao"));
        }
    }

    /**
     * Lista mais 10 medicamentos da lista.
     *
     * @param medicamentoExibicao Lista de medicamentos a serem apresentados.
     */
    public void listaMais10Medicamentos(List<Medicamento> medicamentoExibicao) {
        for (Medicamento medicamento : medicamentoExibicao) {
            System.out.println(medicamento.getNome());
            System.out.println(medicamento.getFormaFarmaceutica());
            System.out.println(medicamento.getDosagem());
            System.out.println(medicamento.getSubstanciaAtiva() + "\n");
        }
    }

    /**
     * Termina a consulta de medicamentos.
     *
     * @return Mensagem indicando o fim da consulta.
     */
    public String terminarConsultaMedicamentos() {
        return "Fim da consulta dos medicamentos.";
    }

    /**
     * UC09: Inicia a pesquisa de interações alimentares associadas a um medicamento.
     *
     * @return Mensagem indicando o resultado da operação.
     */
    public String iniciarPesquisaInteracao() {
        while (true) {
            String nomeMedicamentoEscolhido = realizarPesquisaInteracao();
            if (nomeMedicamentoEscolhido.equalsIgnoreCase("cancelar")) {
                return cancelarPesquisaInteracao();
            }
            for (Medicamento medicamento : listaMedicamentos) {
                if (medicamento.getNome().equalsIgnoreCase(nomeMedicamentoEscolhido)) {
                    String substanciaAtivaMedicamento = medicamento.getSubstanciaAtiva();
                    List<InteracaoAlimentar> interacoesRelacionadas = new ArrayList<>();
                    for (InteracaoAlimentar interacaoAlimentar : listaInteracoesAlimentares) {
                        if (substanciaAtivaMedicamento.equalsIgnoreCase(interacaoAlimentar.getSubstanciaAtiva())) {
                            interacoesRelacionadas.add(interacaoAlimentar);
                        }
                    }
                    if (!interacoesRelacionadas.isEmpty()) {
                        System.out.println("Detalhes das interações alimentares:");
                        for (InteracaoAlimentar interacaoRelacionada : interacoesRelacionadas) {
                            System.out.println("Nome do medicamento: " + medicamento.getNome() + "\n" +
                            "Nome da substância ativa: " + interacaoRelacionada.getSubstanciaAtiva() + "\n" + 
                            "Alimento da interação alimentar: " + interacaoRelacionada.getAlimento() + "\n" +
                            "Efeito da interação alimentar: " + interacaoRelacionada.getEfeito());
                        }
                        while (true) {
                            String interacaoSelecionada = selecionarInteracao();
                            if (interacaoSelecionada.equalsIgnoreCase("cancelar")) {
                                return cancelarPesquisaInteracao();
                            }
                            for (InteracaoAlimentar interacaoRelacionada : interacoesRelacionadas) {
                                if (interacaoSelecionada.equalsIgnoreCase(interacaoRelacionada.getSubstanciaAtiva())) {
                                    System.out.println("Descrição: " + interacaoRelacionada.getExplicacao() + "\n" +
                                            "Referência Bibliográfica: " + interacaoRelacionada.getBibliografia());
                                    break;
                                }
                            }
                        }
                    } else return "Não há interações alimentares para a substância ativa do medicamento.";
                }
            }
            if (nomeMedicamentoEscolhido.equalsIgnoreCase("")) {
                System.out.println("Dados em falta.");
            } else {
                System.out.println("Medicamento não encontrado.");
            }
        }
    }

    /**
     * Realiza a pesquisa por interações alimentares.
     *
     * @return Nome do medicamento escolhido ou "cancelar" para cancelar a pesquisa.
     */
    public String realizarPesquisaInteracao() {
        System.out.print("Insira o nome do medicamento  (escreva 'cancelar' para cancelar): ");
        return SCANNER.nextLine();
    }

    /**
     * Permite ver os detalhes de uma interação alimentar específica.
     *
     * @return Nome da substância ativa selecionada ou "cancelar" para cancelar a seleção.
     */
    public String selecionarInteracao() {
        System.out.print("Digite a substância ativa para selecionar " +
                        "uma interação alimentar (escreva 'cancelar' para cancelar): ");
        return SCANNER.nextLine();
    }

    /**
     * Cancela a pesquisa por interações alimentares.
     *
     * @return Mensagem indicando o cancelamento da pesquisa.
     */
    public String cancelarPesquisaInteracao() {
        return "Pesquisa cancelada.";
    }

    /**
     * UC10: Inicia a pesquisa pelo contacto da farmacovigilância associado a um medicamento.
     *
     * Este método permite ao utilizador encontrar o contacto da farmacovigilância associado a um medicamento.
     *
     * @return Mensagem indicando o resultado da operação.
     */
    public String iniciarPesquisaContacto() {
        while (true) {
            String nomeMedicamentoEscolhido = realizarPesquisaContacto();
            if (nomeMedicamentoEscolhido.equalsIgnoreCase("cancelar")) {
                return cancelarPesquisaContacto();
            }
            for (Medicamento medicamento : listaMedicamentos) {
                if (medicamento.getNome().equalsIgnoreCase(nomeMedicamentoEscolhido)) {
                    for (IndustriaFarmaceutica industria : listaIndustriasFarmaceuticas) {
                        if (medicamento.getIndustriaFarmaceutica().equalsIgnoreCase(industria.getNome())) {
                            return "Detalhes:\n" +
                            "Nome do medicamento: " + medicamento.getNome() + "\n" +
                            "Nome da indústria farmacêutica: " + industria.getNome() + "\n" + 
                            "Email da indústria farmacêutica: " + industria.getEmail() + "\n" +
                            "Telefone da farmacovigilância: " + industria.getContactoFarmaco();
                        }
                    }
                }
            }
            if (nomeMedicamentoEscolhido.equalsIgnoreCase("")) {
                System.out.println("Dados em falta.");
            } else System.out.println("Medicamento não encontrado.");
        }
    }

    /**
     * Realiza a pesquisa pelo contacto da farmacovigilância.
     *
     * @return Nome do medicamento escolhido ou "cancelar" para cancelar a pesquisa.
     */
    public String realizarPesquisaContacto() {
        System.out.print("Insira o nome do medicamento (escreva 'cancelar' para cancelar): ");
        return SCANNER.nextLine();
    }

    /**
     * Cancela a pesquisa pelo contacto da farmacovigilância.
     *
     * @return Mensagem indicando o cancelamento da pesquisa.
     */
    public String cancelarPesquisaContacto() {
        return "Pesquisa cancelada.";
    }

    /**
     * Salva o dataset em formato JSON.
     *
     * Este método utiliza a biblioteca Gson para converter o objeto atual em formato JSON e
     * armazena-o num arquivo especificado.
     *
     * @throws IOException Se ocorrer um erro de E/S durante a escrita do arquivo JSON.
     */
    public void salvarDatasetEmJSON() {
        Gson gson = new Gson();
        String jsonUsersPath = "src/dataset.json";
        try (FileWriter writer = new FileWriter(jsonUsersPath)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
