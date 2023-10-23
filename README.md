# springApiSample

## 概要

SpringBootのサンプルプロジェクトリポジトリ

## 試すこと

- API作成
  - SteamAPIを使用する
  - サーバ時間の固定
- O/Rマッパー
  - MyBatis
- Maven
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