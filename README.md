# 概要

Google Chromeのブックマークダウンロード機能でダウンロードされるHTMLファイルを、
CSVファイルに変換するプログラム

# 実行方法

## 準備
1. `./setup.sh`
1. resourceディレクトリ直下に、変換したいhtmlファイルを"target.html"という名前で保存する。

## 実行
1. `./gradlew build`
1. `./gradlew run`

## テスト
1. `./gradlew clean test`
