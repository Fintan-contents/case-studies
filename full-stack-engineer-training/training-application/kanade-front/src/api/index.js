import BaseAPI from './baseAPI';

const questions = new BaseAPI('/questions');
const users = new BaseAPI('/users');
const login = new BaseAPI('/login');
const logout = new BaseAPI('/logout');


export default {
  questions,
  users,
  login,
  logout,
};
