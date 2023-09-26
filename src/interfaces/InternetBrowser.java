package interfaces;

public interface InternetBrowser {
  void showPage(String url);
  void updatePage();
  void addNewTab(String url);
  void showTabs();
  void showHistory();
  void clearHistory();
}
