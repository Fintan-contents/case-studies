const path = require('path');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const environment = process.env.NODE_BUILD_ENV || 'development';

module.exports = {
  context: __dirname,
  entry: [
    'babel-polyfill',
    './src/index.js'
  ],
  output: {
    path: path.resolve(__dirname, 'dist'),
    publicPath: '/',
    filename: 'bundle.js',
  },
  module: {
    rules: [
      { test: /\.js?$/, enforce: 'pre', exclude: /node_modules/, loader: 'eslint-loader' },
      { test: /\.js?$/, exclude: /node_modules/, loaders: ['babel-loader'] },
    ],
  },
  resolve: {
    extensions: ['.js', '.jsx'],
    alias: {
      AppConfig: path.join(__dirname, `/src/config/${environment}.js`)
    }
  },
  devServer: {
    host: '0.0.0.0',
    port: 9002,
    contentBase: path.join(__dirname, 'public'),
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: './public/index.html',
      filename: 'index.html',
      inject: 'body',
    }),
    new webpack.LoaderOptionsPlugin({
      options: {
        eslint: {
          configFile: './.eslintrc',
        },
      },
    }),
  ],
};