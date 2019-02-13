import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';
import { Loader } from 'react-bulma-components/full';
import API from '../api';
import userUtil from '../utils/userUtil';
import MessageComponent from './message';

class Login extends Component {
  constructor(props) {
    super(props);
    this.email = '';
    this.password = '';

    this.state = {
      // ログインしているかどうか
      isAuthenticated: false,
      // ログイン認証に失敗したかどうか
      isAuthenticationFail: false,
      loading: true,
      message: '',
    };
  }

  componentDidMount() {
    (async () => {
      await userUtil.getLoginUserInfo()
        .then(() => {
          this.setState({ isAuthenticated: true, loading: false });
        })
        .catch(() => {
          this.setState({ isAuthenticated: false, loading: false });
        });
    })();
  }

  onSubmit(event) {
    event.preventDefault();

    (async () => {
      await API.login.post({ email: this.email.value, password: this.password.value })
        .then(() => {
          this.setState({ isAuthenticated: true, isAuthenticationFail: false });
        })
        .catch(() => {
          this.setState({ isAuthenticationFail: true, message: 'メールアドレスまたはパスワードが間違っています。' });
        });
    })();
  }

  render() {
    // ログインチェック前なら、ローディングを表示.
    if (this.state.loading) {
      return <Loader />;
    }
    if (this.state.isAuthenticated) {
      return (<Redirect to="/questions" />);
    }

    return (
      <section className="section">
        <div className="hero-body">
          <div className="container has-text-centered">
            <div className="column is-4 is-offset-4">
              <h3 className="title has-text-grey">ログイン</h3>
              {this.state.isAuthenticationFail ? <MessageComponent title={this.state.message} /> : '' }
              <div className="box" box-background-color="info">
                <form onSubmit={event => this.onSubmit(event)}>
                  <div className="field">
                    <div className="control">
                      <input className="input is-large" required type="email" placeholder="メールアドレス" ref={(el) => { this.email = el; }} />
                    </div>
                  </div>
                  <div className="field">
                    <div className="control">
                      <input className="input is-large" required type="password" placeholder="パスワード" ref={(el) => { this.password = el; }} />
                    </div>
                  </div>
                  <br />
                  <button type="submit" className="button is-info is-large is-centered">ログインする</button>
                </form>
              </div>

            </div>
          </div>
        </div>
      </section>
    );
  }
}

export default Login;
