import $http from '../utils/http';

export default class {
  constructor(resource) {
    this.resource = resource;
  }

  async ajax({ type = 'get', path = '', body = null }) {
    return $http[type](this.resource + path, body);
  }

  async get(path = '') {
    return this.ajax({ path });
  }

  async post(body, path = '') {
    return this.ajax({ type: 'post', body, path });
  }

  async put(body, path = '') {
    return this.ajax({ type: 'put', body, path });
  }

  async delete(body, path = '') {
    return this.ajax({ type: 'delete', body, path });
  }
}
