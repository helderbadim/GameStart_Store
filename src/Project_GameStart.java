
import java.io.*;
import java.util.Scanner;

public class Project_GameStart {

    //##################################FUNÇÕES#############################################

    //*****************************FUNÇÃO DE LEITURA DO FICHEIRO****************************
    public static Scanner leituraFicheiro() throws FileNotFoundException {
        //Criação do ficheiro e scanner do mesmo
        File file = new File("src/Files/GameStart_V2.csv");
        Scanner sc = new Scanner(file);

        sc.nextLine(); //avançar cabeçalho

        return sc; //dar return do scanner para ser usado noutras funções
    } //Função de leitura do ficheiro para evitar código repetitivo;

    //*****************************FUNÇÃO DE Encerramento do Programa****************************
    public static void adeus() throws FileNotFoundException {
        //criar file e scanner
        File file = new File("src/Files/Adeus.txt");
        Scanner sc = new Scanner(file);

        String BLUE = "\033[0;94m";
        String BOLD = "\033[1m";
        String RESET = "\u001B[0m";

        //dar print na consola
        while (sc.hasNextLine()) {
            System.out.println(BLUE + BOLD + sc.nextLine() + RESET);
        }
    } //Função ativada quando encerramos o programa, dando print de um ASCII art

    //******************************FUNÇÕES DO MENU INICIAL********************************
    public static void printLogo() throws FileNotFoundException {
        File file = new File("src/Files/Logo.txt");

        Scanner sc = new Scanner(file);

        //variáveis que permitem modificar a aparência do texto que aparece na consola
        String BLUE = "\033[0;94m";
        String CYAN = "\033[0;96m";
        String BOLD = "\033[1m";
        String UNDERLINE = "\u001B[4m";
        String RESET = "\u001B[0m";

        System.out.println();
        System.out.println(BLUE + "******************************************************************************" + RESET);
        System.out.println(BLUE + "                        \uD83C\uDFAE   " + CYAN + BOLD + UNDERLINE + "BEM-VINDO À GAMESTART" + BLUE + "   \uD83C\uDFAE                       " + RESET);

        System.out.println(BLUE + "******************************************************************************" + RESET);

        while (sc.hasNextLine()) {
            System.out.println(CYAN + sc.nextLine() + RESET);
        }

    } //Print do logo GameStart no início do programa

    public static void menuUtilizador() throws IOException {

        Scanner sc = new Scanner(System.in);
        //variável opção tem de ser declarada no global scope, caso contrário o while statmente não consegue aceder
        String opcão = "";
        String BLUE = "\033[0;94m";
        String CYAN = "\033[0;96m";
        String YELLOW = "\u001B[33m";
        String BOLD = "\033[1m";
        String RED = "\033[0;91m";
        String RESET = "\u001B[0m";


        System.out.println();

        //usamos um do/while statement para garantirmos que o código é utilizado pelo menos uma vez, e garantirmos que o usuário escolhe uma das opções pretendidas.
        do {
            System.out.println();
            System.out.println(BLUE + "******************************************************************************" + RESET);
            System.out.println(BLUE + "                         \uD83D\uDD79\uFE0F   " + CYAN + BOLD + "MENU DO UTILIZADOR" + BLUE + "   \uD83D\uDD79\uFE0F                              " + RESET);
            System.out.println(BLUE + "******************************************************************************" + RESET);
            System.out.println();
            System.out.println(BLUE + "Selecione o tipo de usuário: " + RESET);
            System.out.println(BLUE + "1." + RESET + " Administrador");
            System.out.println(BLUE + "2." + RESET + " Cliente");
            System.out.println(BLUE + "3." + RESET + " Terminar programa.");
            System.out.print(YELLOW + "Digite aqui a sua opção: " + RESET);
            opcão = sc.next();
            switch (opcão) {
                case "1":
                    System.out.println();
                    System.out.println(YELLOW + "\uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBC Selecionou a opção" + BOLD + " ADMINISTRADOR. Será direcionado para o Menu do Administrador... \uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBC" + RESET);
                    System.out.println();
                    System.out.println(BLUE + "******************************************************************************" + RESET);
                    System.out.println(BLUE + "                        \uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBC   " + CYAN + BOLD + "MENU DO ADMINISTRADOR" + BLUE + "   \uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBC                             " + RESET);
                    System.out.println(BLUE + "******************************************************************************" + RESET);
                    System.out.println();
                    System.out.println(BLUE + "Bem-vindo administrador!" + RESET);
                    passwordVerification();
                    break;
                case "2":
                    System.out.println();
                    System.out.println(YELLOW + "\uD83D\uDE4B\uD83C\uDFFB\u200D♂\uFE0F Selecionou a opção" + BOLD + " CLIENTE. Será direcionado para o Menu do Cliente... \uD83D\uDE4B\uD83C\uDFFB\u200D♂\uFE0F" + RESET);
                    System.out.println();
                    System.out.println(BLUE + "******************************************************************************" + RESET);
                    System.out.println(BLUE + "                          \uD83D\uDE4B\uD83C\uDFFB\u200D♂\uFE0F   " + CYAN + BOLD + "Menu do Cliente" + BLUE + "   \uD83D\uDE4B\uD83C\uDFFB\u200D♂\uFE0F                             " + RESET);
                    System.out.println(BLUE + "******************************************************************************" + RESET);
                    clienteMenu();
                    break;
                case "3":
                    adeus();
                    System.out.println();
                    System.out.println(YELLOW + "\uD83D\uDC4B Selecionou a opção" + BOLD + " TERMINAR PROGRAMA. A encerrar... \uD83D\uDC4B" + RESET);
                    return;
                default:
                    System.out.println();
                    System.out.println(RED + BOLD + "\uD83D\uDEAB Opção inválida. Introduza uma opção válida." + RESET);
            }
        } while (!opcão.equals("1") && !opcão.equals("2") && !opcão.equals("3"));//apenas quando uma destas opções for selecionada é que saímos do while loop


    sc.close();
    } //Menu do Utilizador/Inicial onde definimos se somos admninistrador ou cliente ou se queremos encerrar o programa.


    //*****************************FUNÇÕES DO ADMINISTRADOR********************************

    public static void passwordVerification() throws IOException {
        Scanner sc = new Scanner(System.in);
        String password = "bacalhau"; //palavra-passe definida para o sistema
        String passwordIntroduzida = ""; //palavra-passe inserida pelo user

        int tentativas = 3; //número de tentativas
        String RED = "\033[0;91m";
        String BOLD = "\033[1m";
        String RESET = "\u001B[0m";

        do {
            System.out.print("\uD83D\uDD11 Password: ");
            passwordIntroduzida = sc.nextLine();
            if (password.equals(passwordIntroduzida)) {
                System.out.println(BOLD + "✅ Senha correta!" + RESET);
                System.out.println();
                administradorMenu();
            } else {
                tentativas--;
                if (tentativas == 0) {
                    System.out.println(RED + "Esgotou o numero de tentativas! Será direcionado para o Menu do Utilizador!" + RESET);
                    menuUtilizador(); //o user é direcionado para o menu do utilizador caso esgote as 3 tentativas.
                } else {
                    System.out.println(RED + "❌ Senha incorreta! Tem " + tentativas + " tentativa/s." + RESET);
                }
            }
        } while (tentativas > 0 && !passwordIntroduzida.equals(password));
        sc.close();
    } //password de verificação para aceder ao menu do administrador. Incluímos um número limitado de tentativas.

    public static void administradorMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        String RED = "\033[0;91m";
        String BLUE = "\033[0;94m";
        String CYAN = "\033[0;96m";
        String BOLD = "\033[1m";
        String YELLOW = "\u001B[33m";
        String RESET = "\u001B[0m";
        String opcao = "";

        //loop para o menu do administrador
        do {
            System.out.println();
            System.out.println(BLUE + "******************************************************************************" + RESET);
            System.out.println(BLUE + "                        \uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBC   " + CYAN + BOLD + "MENU DO ADMINISTRADOR" + BLUE + "   \uD83D\uDC68\uD83C\uDFFB\u200D\uD83D\uDCBC                             " + RESET);
            System.out.println(BLUE + "******************************************************************************" + RESET);
            System.out.println();
            System.out.println(BLUE + "O que é que deseja consultar?" + RESET);
            System.out.println(BLUE + "1." + RESET + " A lista completa de stocks.");
            System.out.println(BLUE + "2." + RESET + " O número total de vendas e o valor resultante.");
            System.out.println(BLUE + "3." + RESET + " Verificar o lucro total das vendas efetuadas"); //20% das vendas totais
            System.out.println(BLUE + "4." + RESET + " Consultar os dados de um cliente.");
            System.out.println(BLUE + "5." + RESET + " Exibir o jogo mais caro vendido na GameStart, e que cliente/s compraram.");
            System.out.println(BLUE + "6." + RESET + " Exibir o cliente que gastou mais dinheiro na GameStart.");
            System.out.println(BLUE + "7." + RESET + " Voltar ao menu inicial.");
            System.out.println(BLUE + "8." + RESET + " Terminar o programa.");
            System.out.print(YELLOW + "Digite aqui a sua opção: " + RESET);
            opcao = sc.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println();
                    adminOpcao1();
                    voltarMenuAdministrador();
                    break;
                case "2":
                    System.out.println();
                    adminOpcao2();
                    voltarMenuAdministrador();
                    break;
                case "3":
                    System.out.println();
                    adminOpcao3();
                    voltarMenuAdministrador();
                    break;
                case "4":
                    System.out.println();
                    adminOpcao4();
                    voltarMenuAdministrador();
                    break;
                case "5":
                    System.out.println();
                    adminOpcao5();
                    voltarMenuAdministrador();
                    break;
                case "6":
                    System.out.println();
                    adminOpcao6();
                    voltarMenuAdministrador();
                    break;
                case "7":
                    System.out.println();
                    menuUtilizador();
                    break;
                case "8":
                    adeus();
                    System.out.println();
                    System.out.println(YELLOW + "\uD83D\uDC4B Selecionou a opção" + BOLD + " TERMINAR PROGRAMA. A encerrar... \uD83D\uDC4B" + RESET);
                    return;
                default:
                    System.out.println();
                    System.out.println(RED + BOLD + "\uD83D\uDEAB Opção inválida. Introduza uma opção válida." + RESET);
            }

        } while (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3") && !opcao.equals("4") && !opcao.equals("5") && !opcao.equals("6") && !opcao.equals("7") && !opcao.equals("8"));
    sc.close();
    } //Menu do administrador, que só é ativado em caso de password certa.

    public static void adminOpcao1() throws FileNotFoundException {

        Scanner sc = leituraFicheiro();

        String CYAN = "\033[0;96m";
        String BOLD = "\033[1m";
        String RESET = "\u001B[0m";
        System.out.println(CYAN + BOLD + " \uD83D\uDCE6 A LISTA COMPLETA DE VENDAS DA GAMESTART. \uD83D\uDCE6 " + RESET);
        System.out.println();
        //Codigo para gerar colunas do cabeçalho com espaços que queremos (%-ns)
        System.out.printf(CYAN + BOLD + "| %-12s | %-13s | %-21s | %-10s | %-33s | %-21s | %-12s | %-31s | %-8s |\n" + RESET,
                "ID_Venda", "ID_Cliente", "Nome_Cliente", "Contacto", "Email", "Editora", "Categoria", "Jogo", "Valor");

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] items = linha.split(";");

            //Print das linhas das vendas com a largura das colunas iguais à do cabeçalho
            System.out.printf("| %-12s | %-13s | %-21s | %-10s | %-33s | %-21s | %-12s | %-31s | %-8s |\n",
                    items[0], // ID_Venda
                    items[1], // ID_Cliente
                    items[2], // Nome_Cliente
                    items[3], // Contacto
                    items[4], // Email
                    items[5], // Editora
                    items[6], // Categoria
                    items[7], // Jogo
                    items[8]); // Valor
        }
    } //Opção 1 do menu do Admin. Dá print no ficheiro CSV em formato de "coluna"

    public static void adminOpcao2() throws FileNotFoundException {
        Scanner sc = leituraFicheiro();
        String CYAN = "\033[0;96m";
        String RESET = "\u001B[0m";
        String BOLD = "\033[1m";

        int numVendas = 0;
        double totalVendas = 0.00;
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] items = linha.split(";");
            numVendas++;
            totalVendas += Double.parseDouble(items[items.length - 1]); //total acumulado das vendas da GameStart
        }

        System.out.println(CYAN + "\uD83D\uDCC8 A GameStart realizou até ao momento " + BOLD + numVendas + " vendas." + RESET);
        System.out.printf(CYAN + "\uD83D\uDCB5 O valor total das vendas da GameStart é de " + BOLD + "%.2f euros.%n" + RESET, totalVendas); //total arredondado para ter apenas duas casas decimais
        sc.close();
    } //Opção 2 do menu do Admin. Calcula o número de vendas e o valor cumulativo das mesmas.

    public static void adminOpcao3() throws FileNotFoundException {
        Scanner sc = leituraFicheiro();

        String CYAN = "\033[0;96m";
        String RESET = "\u001B[0m";
        String BOLD = "\033[1m";

        double margemLucro = 0.20;
        double totalVendas = 0.00;
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] items = linha.split(";");
            totalVendas += Double.parseDouble(items[items.length - 1]);
        }

        double lucroVendas = totalVendas * margemLucro;
        System.out.printf(CYAN + "\uD83D\uDCB5 O lucro das vendas da GameStart é " + BOLD + "%.2f euros.%n" + RESET, lucroVendas);
        sc.close();
    } //Opção 3 do menu do Admin. Calcula o lucro obtido a partir das vendas.

    public static void adminOpcao4() throws FileNotFoundException {
        Scanner sc = leituraFicheiro();

        String CYAN = "\033[0;96m";
        String BLUE = "\033[0;94m";
        String RESET = "\u001B[0m";
        String BOLD = "\033[1m";
        String UNDERLINE = "\u001B[4m";

        Scanner sc2 = new Scanner(System.in);
        System.out.println(BLUE + BOLD + "\uD83C\uDD94 Qual é o ID do cliente que deseja procurar?" + RESET);
        String idCliente = sc2.nextLine().toLowerCase();

        String nome = "";
        String contacto = "";
        String email = "";
        boolean encontrado = false;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] items = linha.split(";");
            if (idCliente.equals(items[1])) {//identificamos o cliente pelo ID e damos print no nome, contacto e email
                encontrado = true;
                nome = items[2];
                contacto = items[3];
                email = items[4];
                break;
            }
        }

        if (encontrado) {
            System.out.println();
            System.out.println(CYAN + "************ \uD83C\uDD94 CLIENTE ID " + UNDERLINE + idCliente + RESET + CYAN + " \uD83C\uDD94 ************" + RESET);
            System.out.println(CYAN + "Nome: " + RESET + BOLD + nome + RESET);
            System.out.println(CYAN + "Contato: " + RESET + BOLD + contacto + RESET);
            System.out.println(CYAN + "E-mail: " + RESET + BOLD + email + RESET);
            System.out.println(CYAN + "********************************************" + RESET);
        }

        if (!encontrado) {
            System.out.println("O cliente com o " + idCliente + " não foi encontrado.");
        }
    } //Opção 4 do menu do Admin. Procura informação de um determinado cliente através do ID.

    public static void adminOpcao5() throws FileNotFoundException {
        Scanner sc = leituraFicheiro();

        double jogoMaisCaro = 0.00;
        String nomeJogoMaisCaro = "";
        String CYAN = "\033[0;96m";
        String BLUE = "\033[0;94m";
        String RESET = "\u001B[0m";
        String BOLD = "\033[1m";
        String UNDERLINE = "\u001B[4m";

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] items = linha.split(";");
            if (Double.parseDouble(items[items.length - 1]) > jogoMaisCaro) {//identificar qual é o jogo mais caro
                jogoMaisCaro = Double.parseDouble(items[items.length - 1]);
                nomeJogoMaisCaro = items[7];
            }
        }

        sc = leituraFicheiro();
        System.out.println(BLUE + "Os clientes que compraram o jogo mais caro (" + BOLD + UNDERLINE + nomeJogoMaisCaro + RESET + BLUE + "): " + RESET);
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] items = linha.split(";");
            double valor = Double.parseDouble(items[items.length - 1]);
            if (jogoMaisCaro == valor) {
                System.out.println(CYAN + "- " + items[2] + RESET);//identificar os clientes que compraram o jogo mais caro
            }
        }

    sc.close();
    } //Opção 5 do menu do Admin. Identifica o jogo mais caro da GameStart e quem comprou.

    public static void adminOpcao6() throws FileNotFoundException {
        Scanner sc = leituraFicheiro();

        String CYAN = "\033[0;96m";
        String BLUE = "\033[0;94m";
        String RESET = "\u001B[0m";
        String BOLD = "\033[1m";
        String UNDERLINE = "\u001B[4m";

        int numClientes = 0;

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] items = linha.split(";");
            int cliente = Integer.parseInt(items[1]);
            if (cliente > numClientes) {
                numClientes = cliente;//identificar quantos IDs temos na loja
            }
        }

        String[][] matriz = new String[numClientes][2];

        for (int i = 0; i < numClientes; i++) {//preencher a matriz
            matriz[i][0] = Integer.toString(i);
            matriz[i][1] = "0";
        }

        for (int i = 0; i < numClientes; i++) {
            sc = leituraFicheiro();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] items = linha.split(";");
                if (matriz[i][0].equals(items[1])) {
                    double valorMatriz = Double.parseDouble(matriz[i][1]);
                    double valorFicheiro = Double.parseDouble(items[items.length - 1]);
                    valorMatriz += valorFicheiro; //somar os valores correspondentes a cada ID
                    matriz[i][1] = Double.toString(valorMatriz);
                }
            }
        }

        double valorMaisAlto = 0;
        String cliente = "";

        for (int i = 0; i < numClientes; i++) { //identificar o valor mais alto na matriz e o respectivo cliente
            if (Double.parseDouble(matriz[i][1]) > valorMaisAlto) {
                valorMaisAlto = Double.parseDouble(matriz[i][1]);
                cliente = matriz[i][0];
            }
        }

        sc = leituraFicheiro();
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] items = linha.split(";");
            String nome = items[2];
            if (cliente.equals(items[1])) { //dar print no cliente que gastou mais
                System.out.printf(BLUE + "O cliente " + CYAN + BOLD + UNDERLINE + nome + RESET + BLUE + " com o " + CYAN + BOLD + UNDERLINE + "ID" + cliente + RESET + BLUE + " foi quem gastou mais na GameStart! No total gastou " + RESET + CYAN + BOLD + UNDERLINE + "%.2f euros.%n" + RESET, valorMaisAlto);
                break;
            }
        }
        sc.close();
    } //Opção 6 do menu do Admin. Identifica o ID do cliente que gastou mais na GameStart e quanto gastou.

    public static void voltarMenuAdministrador() throws IOException {
        Scanner sc = new Scanner(System.in);
        String RED = "\033[0;91m";
        String BLUE = "\033[0;94m";
        String YELLOW = "\u001B[33m";
        String BOLD = "\033[1m";
        String RESET = "\u001B[0m";

        //loop que garante ao utilizador a opção de continuar, e não encerrar o programa
        String resposta = "";
        do {
            System.out.println();
            System.out.println(BLUE + "Deseja voltar ao menu do Administrador?" + RESET);
            System.out.println(BLUE + "1." + RESET + " Sim.");
            System.out.println(BLUE + "2." + RESET + " Desejo voltar ao menu do Utilizador.");
            System.out.println(BLUE + "3." + RESET + " Terminar programa.");
            System.out.print(YELLOW + "Digite aqui a sua opção: " + RESET);
            resposta = sc.nextLine().toLowerCase();
            switch (resposta) {
                case "1":
                    administradorMenu();
                    break;
                case "2":
                    menuUtilizador();
                    break;
                case "3":
                    adeus();
                    System.out.println();
                    System.out.println(YELLOW + "\uD83D\uDC4B Selecionou a opção" + BOLD + " TERMINAR PROGRAMA. A encerrar... \uD83D\uDC4B" + RESET);
                    return;
                default:
                    System.out.println();
                    System.out.println(RED + BOLD + "\uD83D\uDEAB Opção inválida. Introduza uma opção válida" + RESET);
            }
        } while (!resposta.equals("1") && !resposta.equals("2") && !resposta.equals("3"));

        sc.close();
    } //No final de cada opção do Admin, temos opção de voltar ao menu Admin, ao Menu to utilizador ou encerrar o programa.

//*****************************FUNÇÕES DO CLIENTE********************************

    public static void clienteMenu() throws IOException {
        Scanner sc = new Scanner(System.in);
        String opcao = "";
        String RED = "\033[0;91m";
        String BLUE = "\033[0;94m";
        String YELLOW = "\u001B[33m";
        String BOLD = "\033[1m";
        String RESET = "\u001B[0m";

        do {
            System.out.println();
            System.out.println(BLUE + "O que é que deseja consultar?" + RESET);
            System.out.println(BLUE + "1." + RESET + " Registar novo cliente." + RESET);
            System.out.println(BLUE + "2." + RESET + " Verificar as vagas de estacionamento." + RESET);
            System.out.println(BLUE + "3." + RESET + " Exibir todos os títulos de jogos disponíveis." + RESET); //20% das vendas totais
            System.out.println(BLUE + "4." + RESET + " Exibir todos os jogos de uma determinada editora por categoria." + RESET);
            System.out.println(BLUE + "5." + RESET + " Voltar ao Menu do Utilizador.");
            System.out.println(BLUE + "6." + RESET + " Terminar o programa." + RESET);
            System.out.print(YELLOW + "Digite aqui a sua opção: " + RESET);
            opcao = sc.nextLine();
            switch (opcao) {
                case "1":
                    System.out.println();
                    clienteOpcao1();
                    System.out.println();
                    voltarMenuCliente();
                    break;
                case "2":
                    System.out.println();
                    clienteOpcao2();
                    voltarMenuCliente();
                    break;
                case "3":
                    System.out.println();
                    clienteOpcao3();
                    voltarMenuCliente();
                    break;
                case "4":
                    System.out.println();
                    clienteOpcao4();
                    voltarMenuCliente();
                    break;
                case "5":
                    System.out.println();
                    menuUtilizador();
                    break;
                case "6":
                    adeus();
                    System.out.println();
                    System.out.println(YELLOW + "\uD83D\uDC4B Selecionou a opção" + BOLD + " TERMINAR PROGRAMA. A encerrar... \uD83D\uDC4B" + RESET);
                    return;
                default:
                    System.out.println();
                    System.out.println(RED + BOLD + "Opção inválida. Introduza uma opção válida." + RESET);
            }

        } while (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3") && !opcao.equals("4") && !opcao.equals("5") && !opcao.equals("6"));
        sc.close();
    } //Menu do cliente.

    public static void clienteOpcao1() throws IOException {
        Scanner sc = new Scanner(System.in);
        String BLUE = "\033[0;94m";
        String YELLOW = "\u001B[33m";
        String CYAN = "\033[0;96m";
        String BOLD = "\033[1m";
        String RESET = "\u001B[0m";

        new File("novosClientes.txt");
        PrintWriter pw = new PrintWriter("src/Files/registoClientes.txt");

        System.out.println();
        System.out.println(BLUE + "******************************************************************************" + RESET);
        System.out.println(BLUE + "                        \uD83E\uDEAA   " + CYAN + BOLD + "REGISTO DE NOVO CLIENTE" + BLUE + "   \uD83E\uDEAA                             " + RESET);
        System.out.println(BLUE + "******************************************************************************" + RESET);
        System.out.print(CYAN + "\uD83D\uDC64 Nome do cliente: " + RESET);
        String nome = sc.nextLine();
        System.out.print(CYAN + "\uD83D\uDCF1 Contacto: " + RESET);
        String contacto = sc.nextLine();
        System.out.print(CYAN + "✉\uFE0F Email: " + RESET);
        String email = sc.nextLine();

        pw.println(nome + " | " + contacto + " | " + email );

        System.out.println();
        System.out.print(YELLOW + BOLD + "Inserido com sucesso: " + RESET + BOLD + "\uD83D\uDC64 " + nome + " | " + "\uD83D\uDCF1 " + contacto + " | " + "✉\uFE0F " + email + RESET);
        pw.close();
    } //Simula o registo de um cliente.

    public static void clienteOpcao2()  {

        int numTriangular = 0;
        int n = 1;
        String CYAN = "\033[0;96m";
        String BOLD = "\033[1m";
        String RESET = "\u001B[0m";

        System.out.println(CYAN + "\uD83C\uDD7F\uFE0F As vagas de estacionamento disponíveis são: \uD83C\uDD7F\uFE0F" + RESET);
        while (numTriangular < 121) {
            numTriangular = (n * (n + 1)) / 2;
            n++;
            if (numTriangular < 121 && numTriangular % 5 == 0) {
                System.out.print(CYAN + BOLD + " | " + RESET + numTriangular);
            }
        }
        System.out.print(CYAN + BOLD + " |" + RESET);
        System.out.println();
    } //Apresenta os números de estacionamento disponíveis, sendo que são apenas números tringulares, multiplos de 5 e menores que 121.

    public static void clienteOpcao3() throws FileNotFoundException {

        Scanner sc = leituraFicheiro();
        String BLUE = "\033[0;94m";
        String BOLD = "\033[1m";
        String RESET = "\u001B[0m";

        String[] arrayDiferentes = new String[200];
        int diferentesIndex = 0;


        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] items = linha.split(";");
            String game = items[7];
            boolean isDifferent = true;
            for (int i = 0; i < diferentesIndex; i++) {
                if (arrayDiferentes[i].equals(game)) {
                    isDifferent = false;
                    break;
                }
            }

            if (isDifferent) {
                arrayDiferentes[diferentesIndex++] = game;
            }
        }

        System.out.println(BLUE + "\uD83C\uDFB2 Número de jogos disponíveis na GameStart: " + RESET + BOLD + diferentesIndex + RESET);
        System.out.println(BLUE + "\uD83D\uDCCC Lista de jogos disponíveis: \uD83D\uDCCC" + RESET);
        int num = 1;
        for (int i = 0; i < diferentesIndex; i++) {
            System.out.println(BLUE + num + ". " + RESET + arrayDiferentes[i]);
            num++;
        }
        sc.close();
    } //Apresenta a lista de jogos vendidos na GameStart

    public static void clienteOpcao4() throws FileNotFoundException {
        Scanner sc = leituraFicheiro();
        Scanner sc2 = new Scanner(System.in);

        String BLUE = "\033[0;94m";
        String CYAN = "\033[0;96m";
        String BOLD = "\033[1m";
        String RESET = "\u001B[0m";

        // Definir tamanho máximo de categorias e jogos (estimativa)
        int maxCategorias = 20;
        int maxJogosPorCategoria = 50;

        // Arrays para armazenar categorias e jogos agrupados
        String[] todasCategorias = new String[maxCategorias]; //
        String[][] jogosPorCategoria = new String[maxCategorias][maxJogosPorCategoria];
        int[] contadorJogos = new int[maxCategorias]; // Número de jogos por categoria
        int totalCategorias = 0;
        boolean existeEditora = false; //

        // Solicitar o nome da editora ao utilizador
        System.out.print(BLUE + "Digite o nome da editora: " + RESET);
        String editoraInput = sc2.nextLine().toLowerCase();

        // Processar o ficheiro linha por linha
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] items = linha.split(";");
            String editora = items[5].toLowerCase();
            String categoria = items[6];
            String jogo = items[7];

            // Verificar se a linha pertence à editora fornecida
            if (editora.equals(editoraInput)) {
                existeEditora = true; //se editora existe, existeEditora é igual a true
                int indexCategoria = -1;

                for (int i = 0; i < totalCategorias; i++) { //procurar se a categoria existe no array totalCategorias
                    if (todasCategorias[i].equalsIgnoreCase(categoria)) {//se a categoria for encontrada, o valor da o indexCategoria será igual ao valor de i
                        indexCategoria = i;
                        break;
                    }
                } //inicialmente este código não vai ser processado porque o valor da variável totalCategorias é 0, pelo que saltamos para a próxima linha

                if (indexCategoria == -1) {//este código vai correr enquanto não forem identificadas categorias iguais
                    todasCategorias[totalCategorias] = categoria; //vai atribuir ao array todasCategorias com o index da variável total de categorias o valor de categoria
                    jogosPorCategoria[totalCategorias][0] = jogo; //o número de linhas dos jogos por categoria vai aumentando, à medida que o total de categorias aumenta
                    contadorJogos[totalCategorias] = 1; //no array contadorJogos, enquanto indexCategoria==-1, uma nova linha é inserida (nova categoria), sabendo que pelo menos 1 jogo dessa categoria existe.
                    totalCategorias++; //aumentamos o número de categorias
                } else {
                    // se a categoria existe, verificar se o jogo já está em jogosPorCategoria
                    boolean existe = false;
                    for (int j = 0; j < contadorJogos[indexCategoria]; j++) {
                        if (jogosPorCategoria[indexCategoria][j].equalsIgnoreCase(jogo)) {
                            existe = true;//se o jogo existe, existe = true
                            break; //saltamos para a próxima iteração
                        }
                    }

                    // Adicionar jogo se não for duplicado
                    if (!existe) { //se a variavel existe = false (ou seja, o jogo não existir em jogosPorCategoria) adicionamos o jogo aos Jogos por categorias, e aumentamos o número de jogos no array contadorJogos em 1 no elemento com o valor de index de indexCategoria
                        jogosPorCategoria[indexCategoria][contadorJogos[indexCategoria]] = jogo;
                        contadorJogos[indexCategoria]++;
                    }
                }
            }
        }

         //Exibir os resultados agrupados por categoria
        if (existeEditora) { //se a variavel existeEditora for igual a true, damos print neste código iterando a partir do array totalCategorias e o array jogosPorCategoria
            System.out.println();
            System.out.println(BLUE+ "*************** " + BOLD + editoraInput.toUpperCase() + RESET + BLUE + " ***************" + RESET);
            for (int i = 0; i < totalCategorias; i++) {
                System.out.println(BLUE + "Categoria: " + CYAN + todasCategorias[i] + RESET);
                for (int j = 0; j < contadorJogos[i]; j++) {
                    System.out.println( BLUE + "  - " + RESET + BOLD + jogosPorCategoria[i][j] + RESET);
                }
            }
        }
        if (!existeEditora) { //caso o valor seja falso, devolvemos isto
            System.out.println(BLUE + "Não existem jogos desenvolvidos pela editora " + CYAN + BOLD + editoraInput + RESET + BLUE + " em stock." + RESET);
        }
    } //Apresenta os jogos de uma editora por categoria

    public static void voltarMenuCliente() throws IOException {
        Scanner sc = new Scanner(System.in);
        String RED = "\033[0;91m";
        String BLUE = "\033[0;94m";
        String BOLD = "\033[1m";
        String RESET = "\u001B[0m";
        String YELLOW = "\u001B[33m";
        String resposta = "";


        //garantir que após a execução do menu cliente, o user pode executar novas funções sem ter que encerrar o programa
       do {
           System.out.println();
           System.out.println(BLUE + "Deseja voltar ao Menu do Cliente?" + RESET);
           System.out.println("1. Sim.");
           System.out.println("2. Desejo voltar ao Menu do Utilizador.");
           System.out.println("3. Terminar programa.");
           System.out.print(YELLOW + "Digite aqui a sua opção: " + RESET);
           resposta = sc.nextLine().toLowerCase();

           switch (resposta) {
               case "1":
                   clienteMenu();
                   break;
               case "2":
                   menuUtilizador();
                   break;
               case "3":
                   adeus();
                   System.out.println();
                   System.out.println(YELLOW + "\uD83D\uDC4B Selecionou a opção" + BOLD + " TERMINAR PROGRAMA. A encerrar... \uD83D\uDC4B" + RESET);
                   return;
               default:
                   System.out.println();
                   System.out.println(RED + BOLD + "\uD83D\uDEAB Opção inválida. Introduza uma opção válida." + RESET);
           }
       }while (!resposta.equals("1") && !resposta.equals("2") && !resposta.equals("3"));

       sc.close();
    } // No final de cada opção do Cliente, temos opção de voltar ao menu Cliente, ao Menu to utilizador ou encerrar o programa.

    //****************************************** MAIN ******************************************
    public static void main(String[] args) throws IOException {
        //chamar a funcão para dar print no Logo no início da execução do programa
        printLogo();
        //apresentação do menu do Utilizador/Inicial
        menuUtilizador();
    } //Função de execução do programa
}
