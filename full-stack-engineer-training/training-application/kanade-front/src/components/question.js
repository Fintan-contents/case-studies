import React, { Component } from 'react';
import { Loader } from 'react-bulma-components/full';
import Comment from './comment';
import StringFormatter from '../utils/stringFormatter';
import API from '../api';

class QuestionAnswer extends Component {
  constructor() {
    super();
    this.state = {
      question: {
        commentList: [],
        answerWithCommentDtoList: [],
      },
      loading: true,
    };
  }

  componentDidMount() {
    (async () => {
      const { data } = await API.questions.get(`/${this.props.match.params.id}`);
      this.setState({ question: data, loading: false });
    })();
  }

  render() {
    const { question } = this.state;
    if (this.state.loading) {
      return <Loader />;
    }

    const contentKaigyo = question.content;
    const createTime = StringFormatter.questionCreatetimeFormat(question.createTime);
    return (
      <div className="container">
        <div className="section">
          <div className="tile">
            <div className="tile is-vertical is-parent">
              <div className="box">
                <div className="media">
                  <div className="media-content">
                    <div className="content">
                      <h3 className="title is-3">{question.title}</h3>
                      {contentKaigyo.split('\n').map(contents => (
                        <p>{contents}</p>))}
                    </div>

                    <div className="row mbn">
                      <div className="col m10">
                        <div className="buttons has-addons is-right ">
                          <span className="button is-primary">編集</span>
                        </div>
                      </div>
                    </div>
                    <br />
                    <br />
                    {/* 質問のコメント表示 */}
                    {question.commentList.map(comment => (
                      <Comment comment={comment} />
                    ))}

                    <article className="media">
                      <div className="media-content">
                        <div className="field">
                          <div id="commentOutput1" />
                          <a href="#top" className="button is-white is-small is-primary">コメントする</a>
                        </div>
                      </div>
                    </article>

                  </div>
                  <div className="media-right">
                    <figure className="image is-64x64">
                      <img src={question.imageName} alt="" />
                    </figure>
                    <div>
                      <a href="#top" className="smallText">{`${question.lastName} ${question.firstName}`}</a>
                      <br />
                      <small>{createTime}</small>
                    </div>
                  </div>
                </div>
              </div>

              {/* 回答表示 */}
              {question.answerWithCommentDtoList.map(answer => (
                <div className="box">
                  <div className="content">
                    <h2><strong>回答</strong></h2>
                  </div>
                  <hr />
                  <article className="media">
                    <figure className="media-left">
                      <p className="image is-64x64">
                        <a href="#top">
                          <img src={answer.imageName} alt="" />
                        </a>
                      </p>
                    </figure>
                    <div className="media-content">
                      <div className="content">
                        <p>
                          <a href="#top"><strong>{`${answer.lastName} ${answer.firstName}`}</strong></a>
                          <small>{answer.createTime}</small>
                          <br />
                          {answer.content}
                        </p>
                      </div>

                      {/* 回答のコメント表示 */}
                      {answer.commentList.map(comment => (
                        <Comment comment={comment} />
                      ))}

                      <article className="media">
                        <figure className="media-left">
                          <p className="image is-48x48" />
                        </figure>
                        <div className="media-content">
                          <div className="field">
                            <div id="commentOutput2" />
                            <a href="#top" className="button is-white is-small is-primary">コメントする</a>
                          </div>
                        </div>
                      </article>
                    </div>
                    <div className="media-right">
                      <figure className="image is-64x64" />
                    </div>
                  </article>
                </div>
              ))}
            </div>
          </div>
          <div className="pvl mbm">
            <div className="content">
              <br />
              <h4 className="grey-text">あなたの回答</h4>
            </div>
            <textarea className="textarea" />
            <div>&nbsp;</div>
            <button className="button is-primary" type="submit">投稿</button>
          </div>
        </div>
      </div>
    );
  }
}

export default QuestionAnswer;
