import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import StringFormatter from '../utils/stringFormatter';
import API from '../api';

class Question extends Component {
  constructor() {
    super();
    this.state = {
      questionList: [],
    };
  }

  componentDidMount() {
    (async () => {
      const { data } = await API.questions.get();
      this.setState({ questionList: data });
    })();
  }

  render() {
    const { questionList } = this.state;

    return (
      <div className="container">
        <div className="section">
          <div className="tile">
            <div className="tile is-vertical is-parent">

              <div className="media">
                <div className="media-content">
                  <div className="content">
                    <h1>
                      <strong>質問</strong>
                      <small className="grey-text">
                        {questionList.length}
                        件
                      </small>
                    </h1>
                  </div>
                </div>
              </div>

              {questionList.map((question) => {
                const content = StringFormatter.questionContentFormat(question.content);
                const createTime = StringFormatter.questionCreatetimeFormat(question.createTime);
                return (
                  <div key={question.questionId} className="box">
                    <div className="media">
                      <div className="media-content" style={{ width: '1000px' }}>
                        <div className="content">
                          <Link to={`/questions/${question.questionId}`}>
                            <p>
                              <strong>{question.title}</strong>
                            </p>
                          </Link>
                          <p>{content}</p>
                        </div>
                      </div>
                      <div className="media-right" style={{ width: '200px' }}>
                        <figure className="image is-64x64">
                          <img src={question.imageName} alt="" />
                        </figure>
                        <div>
                          <a href="#top" className="smallText">{question.lastName + question.firstName}</a>
                        </div>
                        <br />
                        <span className="icon is-small"><i className="far fa-clock fas" /></span>
                        {createTime}
                        <br />
                      </div>
                    </div>
                  </div>
                );
              })
              }
            </div>
          </div>
        </div>
      </div>
    );
  }
}


export default Question;
