import React from 'react';
import { Message } from 'react-bulma-components/full';

const MessageComponent = props => (
  <Message color="danger">
    <Message.Header>
      {props.title}
    </Message.Header>
  </Message>
);

export default MessageComponent;
