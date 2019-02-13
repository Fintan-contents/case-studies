# kanade

## このページについて

このページは、フルスタックエンジニア育成施策で使われたサンプルアプリケーションである"kanade"の構成、ビルド、ローカルでの動作確認方法を記載したものです。

フルスタックエンジニア育成施策での実施内容については、[こちら](../README.md)を参照してください。

また、実際の育成中にガイドとして利用したドキュメントについては、合わせて[こちら](training-text.md)も参照してください。


## リポジトリの全体構成
#### kanade-back
バックエンド側のプロジェクト
  * Spring-boot
  * PostgreSQL
  * DOMA2

#### kanade-front
フロントエンド側のプロジェクト
  * React+Redux
  * Bulma

### ディレクトリ構成
```
├─kanade-back
│  ├─src
│  │  ├─main
│  │  │  ├─java
│  │  │  │  └─kanade
│  │  │  │      └─back
│  │  │  │          ├─config			:各種設定クラス
│  │  │  │          ├─controller
│  │  │  │          ├─dao				:daoクラスインターフェース（DOMA2）
│  │  │  │          ├─dto
│  │  │  │          ├─entity
│  │  │  │          ├─service
│  │  │  │          └─Application.java
│  │  │  └─resources
│  │  │      └─META-INF
│  │  │          └─kanade
│  │  │              └─back
│  │  │                  └─dao			:daoインターフェースに対応するsqlファイル（DOMA2）
│  │  └─test
│  │      └─java
│  │          └─kanade
│  │              └─back
│  │                  └─service
│  └─pom.xml
│
│
│
└─kanade-front
    ├─public				:起点となるhtml（index.html）を格納
    ├─src
    │  ├─actions
    │  ├─components
    │  ├─constants
    │  ├─containers
    │  ├─middleware
    │  ├─reducers
    │  ├─utils				:storeを格納
    │  └─index.js
    ├─package.json
    ├─package-lock.json
    ├─webpack.config.js
    ├─.babelrc
    └─.eslintrc
```


***

## ローカル起動手順

### kanade-back

##### 事前準備  
* PostgreSQL10.6を以下のページからインストールする
  * https://www.enterprisedb.com/downloads/postgres-postgresql-downloads

* postgreSQLのユーザ、データベースを作成しておく。  
  > ユーザ名:postgres
  > パスワード:password
  > データベース名:kanade

##### 起動
  ```
  cd kanade-back/  # pom.xmlがあるディレクトリに移動
  mvn clean compile  
  mvn spring-boot:run
  ```
  * 起動はApplication.javaでも可。
  * デフォルトのポート(8080)が使えない場合、VM引数でポートを指定する。  
    ```-Dserver.port=9001```
  * CORSの設定で、APIアクセスを許可するオリジンをVM引数で指定する。
    *  例) ```-Dcors.allowedOrigins=https://api.example.com```
  * 指定しない場合は `http://localhost:8080` からのAPIアクセスが許可されている。
   
 ##### 静的解析
 * `checkstyle` と `spotbugs` で静的解析を行います。
 * ルールは [nablarch-style-guide](https://github.com/nablarch-development-standards/nablarch-style-guide) の物を利用します。
 * 設定ファイルは `static-analysis` フォルダに配置しています。
 * checkstyle実行方法
 ```
 cd kanade-back/  # pom.xmlがあるディレクトリに移動
 mvn checkstyle:check
 ```
 
 * spotbugs実行方法
 ```
 cd kanade-back/  # pom.xmlがあるディレクトリに移動
 mvn spotbugs:check
 ```
	 
 * どちらも違反があった場合はコンソールにエラーが表示されます。
 * 違反内容を確認して修正してください。
  * 起動時にSQLファイルを実行してテーブルの作成、データ投入を行いたい場合は、以下のVM引数を指定すること。  
    * ```-Dspring.datasource.initialization-mode=always```
  * `src/main/resources/` 配下の `schema.sql` 及び `data.sql` が実行される。
    * テストユーザーのパスワードは、`password`
  * データモデルに変更があった場合など、テーブルを削除したい場合は`droptable.sql`を実行すること。
  * データモデルに変更があった場合、`schema.sql`、`data.sql`、`droptable.sql`をメンテナンスすること。
	
### kanade-front

##### 事前準備
* node.jsのインストール
* 依存パッケージのインストール
  ```
  cd kanade-front/  # package.jsonがあるディレクトリに移動
  npm i
  ```

##### 起動
```
cd kanade-front/  # package.jsonがあるディレクトリに移動
npm start
```
※静的解析エラーがあった場合```Failed to compile.```と表示されるが、サーバは起動する。

##### ビルド
* 開発環境とプロダクション環境でコンフィグファイルが分かれており、ビルド時に環境変数を参照して使用するコンフィグファイルを切り替えられる。
* 環境変数を指定しなかった場合は開発環境用にビルドされる。  
  ```npm run build```  
* プロダクション環境用にビルドする場合は以下のように環境変数を指定する  
  ```NODE_ENV=production npm run build```  

##### 静的解析(ESLint)のみ実行
```
npm run lint
```
