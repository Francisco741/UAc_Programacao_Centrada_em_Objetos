import java.util.*;

public class Menu {

    private Menu() {
    }
    
    public static final Scanner SCANNER = new Scanner(System.in);
    
    public static void menuInicial(Sistema sistema, HandlerUtilizadores handlerUtilizadores) {
        System.out.println("Bem vindo ao menu da app farmacêutica!\n");
        do {
            System.out.println("1 - Autenticar utilizador");
            System.out.println("2 - Pesquisar interações alimentares");
            System.out.println("3 - Pesquisar contacto da farmacovigilância");
            System.out.println("0 - Exit");
            System.out.print("> ");
            String option;
            option = SCANNER.nextLine();
            if (option.equals("0")) {
                break;
            } else if (option.equals("1")) {
                String resultadoAutenticacao = handlerUtilizadores.autenticarUtilizador();
                System.out.println(resultadoAutenticacao);
                if (resultadoAutenticacao.equals("Opções para Farmacêutico.")) {
                    menuFarmaceutico(sistema);
                } else if (resultadoAutenticacao.equals("Opções para Indústria Farmacêutica.")) {
                    menuIndustriaFarmaceutica(sistema);
                } else if (resultadoAutenticacao.equals("Opções para Administrador.")) {
                    menuAdministrador(sistema, handlerUtilizadores);
                }
            } else if (option.equals("2")) {
                System.out.println(sistema.iniciarPesquisaInteracao());
            } else if (option.equals("3")) {
                System.out.println(sistema.iniciarPesquisaContacto());
            } else {
                System.out.println("Opção inválida.");
            }
            System.out.println("------------------------");
        } while (true);
        System.out.println("Adeus!");
        handlerUtilizadores.salvarUtilizadoresEmJSON();
        sistema.salvarDatasetEmJSON();
        SCANNER.close();
    }

    public static void menuAdministrador(Sistema sistema, HandlerUtilizadores handlerUtilizadores) {
        System.out.println("MENU ADMINISTRADOR:\n");
        do {
            System.out.println("1 - Registar utilizador");
            System.out.println("2 - Criar substância ativa");
            System.out.println("3 - Consultar substâncias ativas");
            System.out.println("4 - Pesquisar interações alimentares");
            System.out.println("5 - Pesquisar contacto da farmacovigilância");
            System.out.println("0 - Exit");
            System.out.print("> ");
            String option;
            option = SCANNER.nextLine();
            if (option.equals("0")) {
                break;
            } else if (option.equals("1")) {
                System.out.println(handlerUtilizadores.registarUtilizador());
            } else if (option.equals("2")) {
                System.out.println(sistema.criarNovaSubstancia());
            } else if (option.equals("3")) {
                System.out.println(sistema.listarSubstancias());
            } else if (option.equals("4")) {
                System.out.println(sistema.iniciarPesquisaInteracao());
            } else if (option.equals("5")) {
                System.out.println(sistema.iniciarPesquisaContacto());
            } else {
                System.out.println("Opção inválida.");
            }
            System.out.println("------------------------");
        } while (true);
    }

    public static void menuFarmaceutico(Sistema sistema) {
        System.out.println("MENU FARMACÊUTICO:\n");
        do {
            System.out.println("1 - Consultar substâncias ativas");
            System.out.println("2 - Criar interação alimentar");
            System.out.println("3 - Consultar interações alimentares");
            System.out.println("4 - Pesquisar interações alimentares");
            System.out.println("5 - Pesquisar contacto da farmacovigilância");
            System.out.println("0 - Exit");
            System.out.print("> ");
            String option;
            option = SCANNER.nextLine();
            if (option.equals("0")) {
                break;
            } else if (option.equals("1")) {
                System.out.println(sistema.listarSubstancias());
            } else if (option.equals("2")) {
                System.out.println(sistema.criarInteracaoAlimentar());
            } else if (option.equals("3")) {
                System.out.println(sistema.listarInteracoesAlimentares());
            } else if (option.equals("4")) {
                System.out.println(sistema.iniciarPesquisaInteracao());
            } else if (option.equals("5")) {
                System.out.println(sistema.iniciarPesquisaContacto());
            } else {
                System.out.println("Opção inválida.");
            }
            System.out.println("------------------------");
        } while (true);
    }

    public static void menuIndustriaFarmaceutica(Sistema sistema) {
        System.out.println("MENU INDÚSTRIA FARMACÊUTICA:\n");
        do {
            System.out.println("1 - Consultar substâncias ativas");
            System.out.println("2 - Adicionar medicamento");
            System.out.println("3 - Consultar medicamentos");
            System.out.println("4 - Pesquisar interações alimentares");
            System.out.println("5 - Pesquisar contacto da farmacovigilância");
            System.out.println("0 - Exit");
            System.out.print("> ");
            String option;
            option = SCANNER.nextLine();
            if (option.equals("0")) {
                break;
            } else if (option.equals("1")) {
                System.out.println(sistema.listarSubstancias());
            } else if (option.equals("2")) {
                System.out.println(sistema.criarMedicamento());
            } else if (option.equals("3")) {
                System.out.println(sistema.listarMedicamentos());
            } else if (option.equals("4")) {
                System.out.println(sistema.iniciarPesquisaInteracao());
            } else if (option.equals("5")) {
                System.out.println(sistema.iniciarPesquisaContacto());
            } else {
                System.out.println("Opção inválida.");
            }
            System.out.println("------------------------");
        } while (true);
    }
}
