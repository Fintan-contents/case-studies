import axios from 'axios';
import config from 'AppConfig';

const instance = axios.create({
  baseURL: config.API_URL,
});

instance.defaults.withCredentials = true;

export default instance;
