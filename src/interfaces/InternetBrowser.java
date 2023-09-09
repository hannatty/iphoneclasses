package interfaces;

public interface InternetBrowser {
  void showPage();
  void updatePage();
  void addNewTab();
  void viewHistory();
  void clearHistory();
  void addFavorite(String pageUrl);
  void removeFavorite(String pageUrl);
}
