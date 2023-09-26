package model;
import interfaces.Phone;
import interfaces.InternetBrowser;
import interfaces.MusicPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import enums.Color;
import enums.PhoneModel;
import enums.SimCard;
public class Iphone12 extends DefaultIphone implements Phone, MusicPlayer, InternetBrowser {
  List<String> tabs = new ArrayList<>();
  List<String> history = new ArrayList<String>(); 



  //#region Constructor
  public Iphone12(Color color, PhoneModel phoneModel, SimCard simCard) {
    super(color, phoneModel, simCard);
  }
  //#endregion

  //#region Internet Browser Methods

  @Override
  public void showPage(String url) {
    if (url.length() > 8){
      history.add(url);
      System.out.println("********************************");
      System.out.println("Exibindo página " + url);

      Scanner scanner = new Scanner(System.in);
      System.out.println("Você está na página " + url + "\nPARA ATUALIZAR A URL - DIGITE 1");
      int updateOption = scanner.nextInt();
      scanner.close();
      
      if (updateOption == 1) {
          updatePage();
      } else {
          System.out.println("Você permanece na página " + url);
      }

    } else {
      System.out.println("URL Inválida");
    }
  }

  @Override
  public void updatePage() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("DIGITE A NOVA URL que deseja acessar: ");
    String newUrl = scanner.nextLine();
    scanner.close();

    showPage(newUrl);
  }

  @Override
  public void addNewTab(String url) {
    tabs.add(url);
    System.out.println("Nova aba adicionada com a URL: " + url);
  }
 
  @Override   
  public void showTabs() {
    System.out.println("Abas abertas:");
    for (int i = 0; i < tabs.size(); i++) {
      System.out.println((i + 1) + ". " + tabs.get(i));
    }
  }

  @Override
  public void showHistory() {
    System.out.println("HISTÓRICO DE NAVEGAÇÃO:");
    for (int i = 0; i < history.size(); i++) {
      System.out.println((i + 1) + ". " + history.get(i));
    }
  }

  @Override
  public void clearHistory() {
    history.clear();
    System.out.println("Histórico de navegação removido.");
  }

  //#endregion

  //#region Music Player Methods

  //Playlists Disponíveis
  String pop[] = {"Brisa - Iza", "Homem Primata - Titãs", "Doce Vampiro - Rita Lee"};
  String forro[] = {"Cenário de Amor - Petrúcio Amorim", "Coração - Saia Rodada", "Asa Branca - Luiz Gonzaga"};
  String mpb[] = {"Por Supuesto - Marina Senna", "Ó Bixinho - Duda Beat", "Mulher do fim do mundo - Elza Soares"};
  String[][] playlists = {pop, forro, mpb };


  @Override
  public String playMusic (String selectedMusic) {
    System.out.println(" ***** Tocando " + selectedMusic + " *****");

    Scanner scanner = new Scanner(System.in);
    System.out.println("---- PARA PAUSAR DIGITE P");
    String pause_option = scanner.toString().toUpperCase();
    scanner.close();

    if (pause_option.equals("P")){
      return pauseMusic(selectedMusic);
    } else {
      return "Opção Inválida."; 
    }
   
  }

  @Override
  public String pauseMusic(String pauseMessage) {
    pauseMessage = "Música foi pausada.";
    return pauseMessage;
  }

  @Override
  public String selectMusic(String selectedMusic) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Qual Playlist deseja ouvir?\nPop - DIGITE 1\nForró - DIGITE 2\nMpb - DIGITE 3");
    int option = scanner.nextInt();

    if (option == 1){
      for(int music=0; music < pop.length; music++){
        System.out.println( music + " - " + pop[music]);
      }
      System.out.println("Digite o número correspondente a música que deseja: ");
      int musicChoice = scanner.nextInt();
      selectedMusic = pop[musicChoice];

    } else if (option == 2) {
      for(int music=0; music < forro.length; music++){
        System.out.println( music + " - " + forro[music]);
      }
      System.out.println("Digite o número correspondente a música que deseja: ");
      int musicChoice = scanner.nextInt();
      selectedMusic = forro[musicChoice];

    } else if (option == 3){
      for(int music=0; music < mpb.length; music++){
        System.out.println( music + " - " + mpb[music]);
      }
      System.out.println("Digite o número correspondente a música que deseja: ");
      int musicChoice = scanner.nextInt();
      selectedMusic = mpb[musicChoice];

    } else {
      System.out.println("Opção inválida.");
    }
    scanner.close();
    return playMusic(selectedMusic);
  };
  //#endregion

  //#region Phone Methods
  @Override
  public String makeCall(String phoneNumber) {
    if (phoneNumber.length() == 9){
      return "Discando para " + phoneNumber;
    } else {
      return "Número inválido. Verifique e tente novamente.";
    }
  }


  public static int generatingRandomPhone() {
    Random random = new Random();
    int minNumber = 900_000_001;
    int maxNumber = 999_999_999; 

    return random.nextInt(maxNumber - minNumber + 1) + minNumber;
    }

  @Override
  public String answerCall(String phoneNumber) {
    int randomPhone = generatingRandomPhone();
    phoneNumber = String.valueOf(randomPhone); // Converte o int em uma String
    String message = "Número: " + phoneNumber + " chamando...";
    
    Scanner scanner = new Scanner(System.in);
    System.out.println(message);
    System.out.println("Digite 1 para atender / 2 para recusar / 3 para encaminhar para o correio de voz:");
    int option = scanner.nextInt();
    
    if (option == 1) {
      message = "...Chamada atendida...";
    } else if (option == 2) {
      message = "xxx Chamada recusada xxx";
    } else if (option == 3) {
      startVoicemail();
      message = "Chamada encaminhada para o correio de voz";
    } else {
      message = "Opção inválida, chamada ignorada.";
    }
    
    scanner.close();
    return message;
  }
      

  @Override
  public String sendTextMessage(String phoneNumber, String textMessage, String feedbackMessage) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Informe o número para o qual deseja enviar mensagem, sem o ddd, apenas números: ");
    int number_entered = scanner.nextInt();
    phoneNumber = String.valueOf(number_entered);

    System.out.println("Agora, digite a mensagem que deseja: ");
    textMessage = scanner.toString();
    
    feedbackMessage = "Mensagem enviada com sucesso!\n Número: " + phoneNumber + "\n Mensagem: " + textMessage;
    
    scanner.close();
    return feedbackMessage;
  }


  @Override
  public void startVoicemail() {
    System.out.println("Correio de voz iniciando...");;
  }



  //#endregion
  
}
