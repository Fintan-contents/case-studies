import moment from 'moment';

// フォーマット変換用
const formatter = {};

// 質問本文の長さが255文字を超えた場合、超えた部分を「・・・」で省略
formatter.questionContentFormat = (input) => {
  let output = input;
  if (output != null && output.length > 255) {
    output = `${output.substr(0, 255)}・・・`;
  }
  return output;
};

// 質問日付フォーマットの修正
formatter.questionCreatetimeFormat = (input) => {
  const output = moment(input).format('YYYY-MM-DD HH:mm:ss');
  return output;
};

export default formatter;
