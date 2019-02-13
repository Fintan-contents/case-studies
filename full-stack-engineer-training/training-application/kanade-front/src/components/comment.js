import React from 'react';

const Comment = props => (
  <article className="media">
    <figure className="media-left">
      <p className="image is-48x48" />
    </figure>
    <div className="media-content">
      <div className="content is-small">
        <p>
          <strong>
            {' '}
            &gt;
            {' '}
            <a href="#top">{`${props.comment.lastName} ${props.comment.firstName}`}</a>
          </strong>
          <small>{props.comment.createTime}</small>
          <br />
          {props.comment.content}
          <br />
        </p>
      </div>
    </div>
  </article>
);

export default Comment;
