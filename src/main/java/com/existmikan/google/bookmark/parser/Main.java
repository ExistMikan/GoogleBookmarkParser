package com.existmikan.google.bookmark.parser;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Attributes;
import org.jsoup.select.Elements;
import java.util.Properties;
import java.util.ArrayList;
import java.util.List;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {

  private static final String PROPERTIES_FILE_PATH = "conf.properties";
  private static final String HTML_FILE_PATH_KEY = "htmlFilePath";
  private static final String CSV_PATH_KEY = "csvPath";
  private static final String HTML_CHARSET = "UTF-8";

  public static final void main(String[] args) throws Exception {
    Document document = Jsoup.parse(new File(getPropertyByKey(HTML_FILE_PATH_KEY)), HTML_CHARSET);
    List<String> folderList = new ArrayList<>();
    List<String> titleList = new ArrayList<>();
    List<String> urlList = new ArrayList<>();
    Elements elements = document.select("a");
    for (Element element : elements) {
      Element parent = element.parent().parent().parent();
      if (parent.tagName() == "body") {
        folderList.add("その他のブックマーク");
      } else {
        folderList.add(parent.child(0).text());
      }
      titleList.add(element.text());
      urlList.add(element.attributes().get("href"));
    }
    exportCsv(folderList, titleList, urlList);
  }

  private static final String getPropertyByKey(String key) throws Exception {
    InputStream stream = new FileInputStream(new File(PROPERTIES_FILE_PATH));
    Properties props = new Properties();
    props.load(stream);
    stream.close();
    return props.getProperty(key);
  }

  private static void exportCsv(List<String> folderList, List<String> titleList, List<String> urlList) throws Exception {
    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(getPropertyByKey(CSV_PATH_KEY), false)));
    writeRow(writer, "folder", "title", "url");
    for(int i = 0; i < folderList.size(); i++) {
      writeRow(writer, folderList.get(i), titleList.get(i), urlList.get(i));
    }
    writer.close();
  }

  private static void writeRow(PrintWriter writer, String folder, String title, String url) {
    writer.print(escape(folder));
    writer.print(",");
    writer.print(escape(title));
    writer.print(",");
    writer.print(escape(url));
    writer.println();
  }

  private static String escape(String value) {
    return "\"" + value.replace("\"","\"\"") + "\"";
  }

}
