package iit.csp595.bean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class GenericPageBean<T> implements Serializable {

  private String browserPageTitle = "CSP-595 Store";
  private final String pageDirFileName;
  private Map<String, String> breadcrumb = new LinkedHashMap<String, String>();
  private String activeNavName;
  private Message message;

  protected GenericPageBean(String pageDirFileName) {
    this.pageDirFileName = pageDirFileName;
  }

  protected GenericPageBean(String pageDirFileName, Message message) {
    this.pageDirFileName = pageDirFileName;
    this.message = message;
  }

  public Map<String, String> getBreadcrumb() {
    return breadcrumb;
  }

  public void setBreadcrumb(Map<String, String> breadcrumb) {
    this.breadcrumb = breadcrumb;
  }

  public String getActiveNavName() {
    return activeNavName;
  }

  public void setActiveNavName(String activeNavName) {
    this.activeNavName = activeNavName;
  }

  public String getBrowserPageTitle() {
    return browserPageTitle;
  }

  public void setBrowserPageTitle(String browserPageTitle) {
    this.browserPageTitle = browserPageTitle;
  }

  public String getPageDirFileName() {
    return pageDirFileName;
  }

  public Message getMessage() {
    return message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }

}
