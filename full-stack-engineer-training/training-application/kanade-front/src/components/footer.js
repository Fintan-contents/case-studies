import React from 'react';
import { Link } from 'react-router-dom';
import { footer } from 'react-bulma-components/full';

export default () => (
  <footer className="footer has-background-link">
    <div className="container">
      <div className="columns">
        <div className="column is-2 is-offset-1">
          <ul>
            <li><Link to="/questions"><p className="has-text-white is-size-5">質問</p></Link></li>
            <li><Link to="/questions/create"><p className="has-text-white is-size-5">質問する</p></Link></li>
            <li><a href="#top"><p className="has-text-white is-size-5">ユーザー</p></a></li>
            <li><a href="#top"><p className="has-text-white is-size-5">タグ</p></a></li>
          </ul>
        </div>
        <div className="column is-2">
          <ul>
            <li><a href="#top"><p className="has-text-white is-size-5">リリースノート</p></a></li>
            <li><a href="#top"><p className="has-text-white is-size-5">kanadeについて</p></a></li>
            <li><a href="#top"><p className="has-text-white is-size-5">検索ガイド</p></a></li>
          </ul>
        </div>
        <div className="column is-2">
          <ul>
            <li><a href="#top"><p className="has-text-white is-size-5">プライバシーポリシー</p></a></li>
            <li><a href="#top"><p className="has-text-white is-size-5">利用規約</p></a></li>
          </ul>
        </div>
      </div>
    </div>
  </footer>
);
