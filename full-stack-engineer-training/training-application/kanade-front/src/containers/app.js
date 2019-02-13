import React, { Fragment } from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Head from '../components/head';
import QuestionList from '../components/questionList';
import Foot from '../components/footer';
import Question from '../components/question';
import CreateQuestion from '../components/createQuestion';
import Login from '../components/login';

export default () => (
  <BrowserRouter>
    <Fragment>
      <Head />
      <div id="wrapper">
        <Switch>
          <Route exact path="/login" component={Login} />
          <Route exact path="/questions" component={QuestionList} />
          <Route exact path="/questions/create" component={CreateQuestion} />
          <Route exact path="/questions/:id" component={Question} />
        </Switch>
        <Foot />
      </div>
    </Fragment>
  </BrowserRouter>
);
