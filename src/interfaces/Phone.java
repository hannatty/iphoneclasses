package interfaces;

public interface Phone {
  void makecall(String phoneNumber);
  void answerCall();
  void endCall();
  void sendTextMessage(String phoneNumber, String message);
  void receiveTextMessage(String sender, String message);
  void startVoicemail();
}
