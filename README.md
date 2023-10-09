# springApiSample

## 概要

SpringBootのサンプルプロジェクトリポジトリ

## 試すこと

- API作成
  - SteamAPIを使用する
  - サーバ時間の固定
- O/Rマッパー
- Junit5
  - Mockを使用したAPIのテスト
- Maven
- アノテーション
  - Autowired
    - Injection方法が三種類あり、どの方法を用いてもDiコンテナに登録されているBeanが注入される
    - @Beanで生成したインスタンスとは別に、新たにnewした場合は当然のことながら別のインスタンスとして扱われる
    - @Serviceのクラスにて@Beanをしている場合も、コンポーネントスキャンの対象になる
      - 別クラスにてAutoWiredする際には呼び出される