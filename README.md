# springApiSample

## 概要

SpringBootのサンプルプロジェクトリポジトリ
コードを試したり、メモ書きする

## 試すこと

- API作成
  - SteamAPIを使用する
  - サーバ時間の固定
- O/Rマッパー
  - MyBatis
- Maven
  - ビルドすることを目的としたツール
    - ビルドとは
      - コンパイルをして.classファイル等を生成、実行可能ファイルへと変換する作業。
    - mavenでは、ライブラリインストール、コンパイル、自動テスト、パッケージの作成を実施できる。
    - mavenでは、実行する作業の目的を記述する。どのような作業を行い、何を作成するのかを指示することができる。ただし細かな作業手順は特に記述する必要はなく、ゴールが指定されれば、それに必要となる作業が自動で進められる。
    - プロジェクトで必要となるソフトウェアを管理する機能をもつ。ビルド時にセントラルリポジトリにアクセスし、必要なファイルをダウンロードできる。セントラルリポジトリは、ライブラリが集まる場所。
    - ゴールは全てプラグインにて追加する
  - command
    - mvn compile
      - .javaファイルを.classファイルに変換
      - targetファルダが生成される
        - classesフォルダが生成される。パッケージごとに整理された状態でクラスファイルが保存される。
      - maven-statusフォルダが生される。compileで利用される、compilerプラグインによって生成されるファイルが保存される。ソースコードとコンパイル実行時に作成されたファイルのリストが記述されている。
    - mvn test-compile
      - src/test内のソースコードをコンパイルし、target/test-classesフォルダを生成。その内部にクラスファイルを生成する。
    - mvn package
      - クラスファイルをjarファイルなどにパッケージ化する。
      - コンパイル、ユニットテスト、Jarファイルにパッケージ化する処理全てが実行される。
    - mvn clean
      - targetフォルダ内のほとんどのフォルダとファイルを削除する。classesはフォルダのみ残る。
    - mvn exec:java
      - mavenのmainClassに定義したjavaファイルを実行する
    - 
  - ビルド
- アノテーション
  - Autowired
    - Injection方法が三種類あり、どの方法を用いてもDiコンテナに登録されているBeanが注入される
    - @Beanで生成したインスタンスとは別に、新たにnewした場合は当然のことながら別のインスタンスとして扱われる
    - @Serviceのクラスにて@Beanをしている場合も、コンポーネントスキャンの対象になる
      - 別クラスにてAutoWiredする際には呼び出される
  - @Value
    - application-xxx.ymlやOS環境変数から値を注入できる
      - OS環境変数から値を注入する場合、.bash_profile等の設定ファイルから値を注入することはできない。コマンドラインからExportし、runさせる必要がある
      - 設定値には優先順位があるため、ymlとOS環境変数で同じ設定値を定義している場合OS環境変数が優先される。
      - 上記方法以外にもコマンドライン引数から反映させる方法等が存在する
      - 環境別にymlを切り替えるには、起動時オプションに 「--spring.profiles.active=xxxx」を指定する。application.ymlの設定値をapplication-xxxx.ymlの値で上書きすることができる。
  - @Configuration
  - @SpringBootTest
- Junit
  - Mock
    - @Mockと@MockBeanは違う
      - @Mockで生成されるBeanと、@Beanアノテーションがついている関数で生成されるBeanは別物
      - @MockBeanの場合は同じインスタンスとなる
    - staticメソッドのモック化は可能だが、通常のmock関数と同様、whenやdoreturnで定義しない関数はnullを返却するため注意。CALLS_REAL_METHODを渡すと@Spyのような挙動をする
    - @SpyBeanや@MockBeanはDIコンテナといい感じにつながってくれる
