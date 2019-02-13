import React, { Component } from 'react';
import { Redirect } from 'react-router-dom';
import { Loader } from 'react-bulma-components/full';
import API from '../api';
import userUtil from '../utils/userUtil';
import MessageComponent from './message';

class CreatedQuestion extends Component {
  constructor(props) {
    super(props);
    this.title = '';
    this.content = '';
    this.state = {
      questionId: '',
      validationMessageList: [],
      loading: true,
      isAuthenticated: false,
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
      await API.questions.post(
        { title: this.title.value, content: this.content.value },
      )
        .then((res) => {
          this.setState({ questionId: res.data });
        })
        .catch((errors) => {
          if (errors.response.status === 400) {
            this.setState({ validationMessageList: errors.response.data.errors });
          }
          if (errors.response.status === 401) {
            this.setState({ isAuthenticated: false });
          }
        });
    })();
  }

  render() {
    if (this.state.questionId) {
      return (
        <Redirect to={`/questions/${this.state.questionId}`} />);
    }

    if (this.state.loading) {
      return <Loader />;
    }

    if (!this.state.isAuthenticated) {
      return (
        <Redirect to={{ pathname: '/login' }} />);
    }

    return (
      <div className="container">
        <div className="section">
          <div className="tile">
            <div className="tile is-vertical is-parent">
              <form onSubmit={event => this.onSubmit(event)}>
                <div className="media">
                  <div className="media-content">
                    <div className="content">
                      <h1>
                        {' '}
                        <strong>質問する</strong>
                      </h1>
                    </div>
                  </div>
                </div>

                <div className="box">
                  <div className="content">
                    <h2>タイトル</h2>
                    {
                      this.state.validationMessageList.map((message) => {
                        if (message.field === 'title') {
                          return (
                            <MessageComponent key={message.field} title={message.defaultMessage} />
                          );
                        }
                        return null;
                      })
                    }

                    <input required ref={(el) => { this.title = el; }} className="input" type="text" placeholder="タイトルを入力してください！" maxLength="300" />
                    <div align="right"><small>※ 最大文字数:300</small></div>
                  </div>

                  <div className="content">
                    <h2>本文</h2>
                    {
                      this.state.validationMessageList.map((message) => {
                        if (message.field === 'content') {
                          return (
                            <MessageComponent key={message.field} title={message.defaultMessage} />
                          );
                        }
                        return null;
                      })
                    }
                    <textarea type="text" required ref={(el) => { this.content = el; }} className="textarea" placeholder="本文を入力してください！" rows="13" maxLength="10000" />
                    <div align="right"><small>※ 最大文字数:10000</small></div>
                  </div>

                  <button type="submit" className="button is-info is-centered">投稿する</button>

                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default CreatedQuestion;
