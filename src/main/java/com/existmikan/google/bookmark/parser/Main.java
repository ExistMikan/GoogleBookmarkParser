package com.existmikan.google.bookmark.parser;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

  private static final String PROPERTIES_FILE_PATH = "conf.properties";
  private static final String HTML_FILE_PATH_KEY = "htmlFilePath";
  private static final String HTML_CHARSET = "UTF-8";

  public static final void main(String[] args) throws Exception {
    String path = getFilePath();
    System.out.println(path);
    Document document = Jsoup.parse(new File(path), HTML_CHARSET);
    //System.out.println(document.html());
  }

  private static final String getFilePath() throws Exception {
    File file = new File(PROPERTIES_FILE_PATH);
    InputStream stream = new FileInputStream(file);
    Properties props = new Properties();
    props.load(stream);
    stream.close();
    return props.getProperty(HTML_FILE_PATH_KEY);
  }

}
