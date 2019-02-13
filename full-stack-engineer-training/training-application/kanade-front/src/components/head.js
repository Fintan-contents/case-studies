import React from 'react';
import { Link } from 'react-router-dom';
import { nav } from 'react-bulma-components/full';

export default () => (
  <nav className="navbar is-link">
    <div className="container">
      <div className="navbar-menu is-active">
        <div className="navbar-start">
          <div className="brand-logo">
            <Link to="/questions">
              <span className="icon is-large has-text-white">
                <i className="fab fa-bimobject fa-3x" />
              </span>
            </Link>
          </div>
        </div>
        <div className="navbar-end">
          <div className="navbar-item">
            <div className="field is-grouped">
              <div className="control has-icons-right">
                <input type="text" className="input" placeholder="検索内容..." />
                <span className="icon is-right">
                  <i className="fa fa-search" />
                </span>
              </div>
              <div className="control">
                <input type="submit" className="button is-info" value="検索" />
              </div>
            </div>
          </div>
          <a href="#top" className="navbar-item">質問</a>
          <a href="#top" className="navbar-item">ユーザー</a>
          <a href="#top" className="navbar-item">タグ</a>
          <Link className="navbar-item" to="/questions/create">質問する</Link>
          <div className="navbar-item has-dropdown is-hoverable">
            <a href="#top" className="navbar-link">
              <img src="https://bulma.io/images/placeholders/128x128.png" alt="" />
            </a>
            <div className="navbar-dropdown">
              <a href="#top" className="navbar-item">プロファイル</a>
              <a href="#top" className="navbar-item">設定</a>
              <hr className="navbar-divider" />
              <a href="#top" className="navbar-item">サインアウト</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </nav>
);
