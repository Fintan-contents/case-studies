import API from '../api';

const userUtil = {};

userUtil.getLoginUserInfo = async () => (API.users.get('/userInfo'));

export default userUtil;
