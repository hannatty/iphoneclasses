package interfaces;

public interface Phone {
  String makeCall(String phoneNumber);
  String answerCall(String phoneNumber);
  String sendTextMessage(String phoneNumber, String textMessage, String feedbackMessage);
  void startVoicemail();
}
