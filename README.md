![AreDoko_original](https://user-images.githubusercontent.com/11924482/233084907-1146f1f2-a028-4cc4-a317-2ab8177f541d.png)

# 持ち物管理アプリ  `AreDoko`

このアプリは、自分が持っているものを室内のどこに片付けたかを記録するためのWebアプリです。
Spring BootにThymeleafのテンプレートエンジンを使用して開発されています。

> **Warning**
> - まだ開発の初期段階です。README.mdの記載内容と実際の実装は異なります。
> - VPS上のDBのパスワードが含まれるため、`src/main/resources/application.properties`はレポジトリ管理対象外としています。

## 機能

*   アイテムの追加、編集、削除
*   アイテムの検索
*   アイテムの場所の変更

## 必要なもの

*   Java 17+
*   Maven
*   MySQL

## インストール

1.  このリポジトリをクローンしてください。

```bash
git clone https://github.com/your-username/your-repo.git
```

2.  `application.properties` ファイルを編集し、MySQLの接続情報を設定してください。

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/items spring.datasource.username=your-username spring.datasource.password=your-password
```

3.  Mavenでアプリをビルドし、実行してください。

```arduino
mvn spring-boot:run
```

4.  ブラウザで `http://localhost:8080` にアクセスし、アプリが正しく動作していることを確認してください。

## 使用方法

1.  「アイテムの追加」ボタンをクリックし、アイテムの名前、説明、場所を入力してください。
2.  追加したアイテムをクリックすると、詳細ページに移動します。
3.  詳細ページで、アイテムの情報を編集できます。
4.  「アイテムを探す」ページで、アイテムを検索できます。
5.  詳細ページで、アイテムの場所を変更できます。

## 作者

*   kouairchair
*   toranomon@kotori-systems.com

## ライセンス

このプロジェクトは、MITライセンスのもとで公開されています。詳細については、`LICENSE` ファイルを参照してください。
