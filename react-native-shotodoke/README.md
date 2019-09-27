# React Nativeを用いたネイティブアプリケーション開発の事例

* [はじめに](#はじめに)
* [TL;DR](#TL;DR)
* [背景](#背景)
* [React Nativeについて](#React-Nativeについて)
* [サンプルコード](#サンプルコード)
  * [モジュール構成](#モジュール構成)
  * [サンプルコードの説明](#サンプルコードの説明)
* [まとめ](#まとめ)
  * [React Nativeを使ってみて感じたメリット](#React-Nativeを使ってみて感じたメリット) 
  * [React Nativeを使ってみて感じたデメリット](#React-Nativeを使ってみて感じたデメリット) 
* [今後の展望](#今後の展望)


## はじめに
本ドキュメントは、ネイティブアプリケーション開発においてFacebook製のネイティブアプリケーション向けフレームワークである React Nativeを用いて開発する事例をまとめた資料となります。  
本ドキュメントの目的は、ネイティブアプリケーション向けフレームワーク選定の参考情報となることです。

対象とする読者としては、以下を想定しています。

* JavaScriptを利用する開発者（ECMAScript 2015以降を知っていることが望ましい）
* Webアプリケーション開発の知見を生かしてネイティブアプリケーションを開発したい開発者
* AndroidまたはiOSのネイティブアプリケーションの開発経験は無いがネイティブアプリケーション開発をしたい開発者

## TL;DR
* ほとんどのメンバーがネイティブアプリケーション開発未経験だったが、半年足らずでAndroid、iOS両プラットフォームのネイティブアプリケーションを商用リリースすることができた。
* 実際にReact Nativeを使ってみて感じたメリット・デメリットについてまとめてみた。

## 背景
このドキュメントの事例となったプロジェクトでは、「確実な初期リリースとスピーディな継続リリース」を掲げており、  
顧客の要望に応えるためには、工期的にネイティブアプリケーションとサーバサイドアプリケーションを同時並行して開発する必要がありました。

しかし、当初アサインされたメンバーはWebアプリケーションの開発経験しかなく、  
ネイティブアプリケーションの開発経験者が不在という大きな課題を抱えてスタートしました。

KotlinとSwiftの開発を一から習得しながら顧客の求める納期に間に合わせることは困難であるため、  
Webアプリケーションの開発経験を生かしてネイティブアプリケーションを開発できる手法が無いか検討していた時にReact Nativeの存在を知りました。

顧客に対してプロジェクトを成功に導くポテンシャルを秘めていることなどを説明し、正式採用するに至りました。

## React Nativeについて
Facebook製のネイティブアプリケーション向けのフレームワークで、  
Facebookが開発したJavaScriptのフレームワークである React をネイティブで使えるようにしたものです。  
HTMLベースのフレームワークと異なり、React で培った仮想DOMを元にネイティブコードを呼び出すため、  
動作が軽快で、一般的なネイティブアプリケーションと比較しても遜色ありません。  

* 参考: [React Native公式](https://facebook.github.io/react-native/)

React Native は Node.js により、バックグラウンドでJavascriptのランタイムが動いていて、ネイティブコードを呼び出します。

## サンプルコード
当プロジェクトで実際に開発している方式で簡単なサンプルコードを紹介します。

### モジュール構成
説明に必要なモジュールのみ表記します。  
シンプルな構成ですが、コーディング規約として順守することで、  
メンテナンス性の向上や流用性に寄与します。

~~~console
root/
　├─ img/
　│ 　└─ sample.png            コンポーネントで使用する画像ファイル
　│ 
　└─ src/
　　　├─ components/           画面の構成要素（共通ヘッダー、カスタムテキストなど）をコンポーネント化したもの
　　　│ 　　└─ ImageText.js     コンポーネントのコード
　　　├─ config/               アプリケーション全体の設定をカテゴリ毎に集約（API接続先やタイムアウト時間など）
　　　├─ containers/           各画面のメインコード
　　　│ 　　└─ Sample.js        メインの画面コード
　　　├─ navigators/           アプリケーション全体の画面遷移制御モジュール
　　　├─ styles/               スタイルシート
　　　└─ utils/                表示変換や計算などの共通処理群
~~~

### サンプルコードの説明

#### ImageText.js（画像付きテキストコンポーネント）
注記を表示するためのシンプルなコンポーネントを作成します。

```javascript
import React from 'react';
import { Image, StyleSheet, View, Text, Platform } from 'react-native';
import PropTypes from 'prop-types';
import ImageContent from '../../img/sample.png';

const styles = StyleSheet.create({
  // styleは割愛
});

const AlertText = ({ children }) => (
  <View>
    <Image source={ImageContent} />
    <View>
      <Text>
        {children}
      </Text>
    </View>
  </View>
);

AlertText.propTypes = {
  children: PropTypes.node.isRequired,
};

export default AlertText;
```

#### Sample.js（メイン画面）
メイン画面に先ほど作成したコンポーネントを埋め込んでみます。

```javascript
import React, { Component } from 'react';
import { StyleSheet, View, Text } from 'react-native';
import ImageText from '../components/ImageText';
import Style from '../styles/Style';

const styles = StyleSheet.create({
  redEmphasis: {
    color: Style.text.red,
  },
});

class Sample extends Component {
  static navigationOptions = {
    title: 'サンプル',
    headerRight: <View />,
  };

  render() {
    return (
      <View style={Style.scrollViewContents} accessibilityLabel="Sample">
        <Text>通常のテキスト</Text>
        <ImageText>
            ここは黒字
          <Text style={styles.redEmphasis}>ここは赤字</Text>
            ここも黒字
        </ImageText>
      </View>
    );
  }
}

export default Sample;
```

#### 画面のイメージ  
![](img/sample001.png)

ここでは文頭にエクスクラメーションマークの画像を付与した`<ImageText>`を作成しました。  
非常にシンプルなコンポーネントですが、注記等を表示する箇所で再利用する可能性が高く、  
この様にコンポーネント化しておくことで、流用性やメンテナンス性の向上させています。

## まとめ
実際に React Native を使用して感じたことをまとめました。

### React Nativeを使ってみて感じたメリット
* KotlinやSwiftを書けなくてもAndroid,iOS両対応のネィティブアプリケーションが作成できる  
セキュリティ対策（※）のため、サードパーティ製品を組み込むためにAndroidの実装に手を入れることがありますが、  
基本的にはJavaScriptのコードだけ書ければ良いので、Javascript、cssに馴染みのある開発者なら敷居は低いと思います。  
※ React Native 自体にセキュリティ対策機構はないため、商用利用を目的とする際には別途セキュリティ対策製品の導入検討も必要になります。

* iOS、Android間でコードが共通化できる（90～95%程度）  
OSの差異や、端末の違い（Androidの豊富な機種やiPhone Xなど）により、Javascriptやcssに一部個別対応が必要となる部分はあったものの、  
90～95%程度共通で利用出来ていました。また、React Nativeが開発中であることもあり、バージョンが上がると個別対応が不要になることもありました。  

  * 個別対応その１：スタイルシートでAndroidとiOSで若干marginTopを微調整しないとレイアウトが崩れる場合
      ```javascript
      marginTop: Platform.OS === 'ios' ? -2 : 1,
      ```

  * 個別対応その２：Android9以降の端末で設定を切り分ける場合
      ```javascript
      this.isAndroid9AndLater = (Platform.OS === 'android' && parseInt(DeviceInfo.getSystemVersion(), 10) >= 9);
      ```

* JavascriptランタイムによりBuild不要でリロードができる  
開発中はAndroidエミュレーター及びiOSシミュレーターで動作確認することが多かったですが、  
双方ともショートカットコマンド１つでホットリロード可能なため、デバッグが容易で  
レイアウトの微調整などは顧客と一緒に画面を見ながらその場で実施出来るなど開発効率が良かったです。  

### React Nativeを使ってみて感じたデメリット
* 不具合があった時、ナレッジが少なく調査に時間を要することも。  
徐々に増えていますが、新しい問題に直面した時は日本語のナレッジがまだまだ少なく海外サイトを参考にしないとエラー解決に辿り着かないことも多々ありました。 

* バージョンアップにより大幅に仕様が変わることがある。  
2015年の初回リリースから4年経過した今でもバージョンはまだ0.60となっており、   
React Native がまだ発展途上にあるということもありますが  
バージョンアップに伴い既存コンポーネントが廃止されたり、仕様が大幅に変わることも珍しくなく、開発者の柔軟な対応が求められます。  
例えば画面遷移の実装に利用する react-navigation というライブラリーが存在するのですが、  
React Native のバージョンアップに伴い、react-navigationのバージョンもver.1からver.2にアップデートされました。その際に大幅な仕様変更があり、既存の実装に手を入れないと全く動作しないということがありました。  
バージョンアップは新OS対応など計画作業に伴って生じることが多いため、  
対応工数を見積もる場合はこの点にも留意しておくべきです。

* Android用とiOS用のコードを一括で抱えているため、アプリサイズが大きくなりがち。  
利用するライブラリの種類や数にも寄るため一概には言えませんが、  
特にAndroidが顕著で10,000stepに満たない小さなプロダクトでもAndroidで15MB(32Bit版)、iOSで5MBほどになります。



## 今後の展望
初回リリースを当初の目標通り達成することが出来たため、  
幸いにも機能追加や機能改善案件として次々にプロジェクト拡大している状況です。

今後もReact Nativeのノウハウを蓄積し、更なるナレッジとして情報発信出来ればと考えています。

この事例が、今後 React Native を用いて開発を行うプロジェクトにとって少しでも参考になればと思います。
