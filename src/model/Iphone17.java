package model;
import interfaces.Phone;
import interfaces.InternetBrowser;
import interfaces.MusicPlayer;

import java.util.Random;
import java.util.Scanner;

import enums.Color;
import enums.PhoneModel;
import enums.SimCard;
public class Iphone17 extends DefaultIphone implements Phone, MusicPlayer, InternetBrowser {


  //#region Constructor
  public Iphone17(Color color, PhoneModel phoneModel, SimCard simCard) {
    super(color, phoneModel, simCard);
  }
  //#endregion

  //#region Internet Browser Methods
  @Override
  public void showPage() {
    throw new UnsupportedOperationException("Unimplemented method 'showPage'");
  }

  @Override
  public void updatePage() {
    throw new UnsupportedOperationException("Unimplemented method 'updatePage'");
  }

  @Override
  public void addNewTab() {
    throw new UnsupportedOperationException("Unimplemented method 'addNewTab'");
  }

  @Override
  public void viewHistory() {
    throw new UnsupportedOperationException("Unimplemented method 'viewHistory'");
  }

  @Override
  public void clearHistory() {
    throw new UnsupportedOperationException("Unimplemented method 'clearHistory'");
  }

  //#endregion

  //#region Music Player Methods
  @Override
  public void playMusic() {
    throw new UnsupportedOperationException("Unimplemented method 'playMusic'");
  }

  @Override
  public void pauseMusic() {
    throw new UnsupportedOperationException("Unimplemented method 'pauseMusic'");
  }

  @Override
  public void selectMusic() {
    throw new UnsupportedOperationException("Unimplemented method 'selectMusic'");
  }

  @Override
  public void nextTrack() {
    throw new UnsupportedOperationException("Unimplemented method 'nextTrack'");
  }

  @Override
  public void previousTrack() {
    throw new UnsupportedOperationException("Unimplemented method 'previousTrack'");
  }
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
