//通过require 方法来同步加载依赖的其他模块
const webpack = require('webpack');
const writeFilePlugin = require('write-file-webpack-plugin');
const webpackMerge = require('webpack-merge');
const BrowserSyncPlugin = require('browser-sync-webpack-plugin');
const ForkTsCheckerWebpackPlugin = require('fork-ts-checker-webpack-plugin');
const FriendlyErrorsWebpackPlugin = require('friendly-errors-webpack-plugin');
const SimpleProgressWebpackPlugin = require('simple-progress-webpack-plugin');
const WebpackNotifierPlugin = require('webpack-notifier');
const path = require('path');

const utils = require('./utils.js');
const commonConfig = require('./webpack.common.js');

const ENV = 'development';
//module.exports 导出需要暴露的接口
module.exports = (options) => webpackMerge(commonConfig({env: ENV}), {
  devtool: 'eval-source-map',
  devServer: {
    contentBase: './build/www',
    proxy: [{
      context: [
        /* jhipster-needle-add-entity-to-webpack - JHipster will add entity api paths here */
        '/api',
        '/management',
        '/swagger-resources',
        '/v2/api-docs',
        '/h2-console',
        '/auth'
      ],
      target: 'http://127.0.0.1:8080',
      secure: false,
      headers: {host: 'localhost:9000'}
    }],
    stats: options.stats,
    watchOptions: {
      ignored: /node_modules/
    }
  },
  // entry:  JavaScript 执行入口文件
  entry: {
    polyfills: './src/main/webapp/app/polyfills',
    global: './src/main/webapp/content/scss/global.scss',
    // vendor: [ 'popper.js', 'bootstrap'],

    main: './src/main/webapp/app/app.main'
  },
  output: {
    path: utils.root('build/www'),      // 将输出文件都放到 'build/www' 目录下
    filename: 'app/[name].bundle.js',   //将所有依赖的模块合并输出到app/[name].bundle.js文件
    chunkFilename: 'app/[id].chunk.js'
  },
  // 配置里的module.rules 数组配置了一组规则,告诉Webpack 在遇到哪些文件时使用哪些Loader去加载和转换
  module: {
    rules: [{
      test: /\.ts$/,
      enforce: 'pre',
      loaders: 'tslint-loader',
      exclude: ['node_modules', new RegExp('reflect-metadata\\' + path.sep + 'Reflect\\.ts')]
    },
      {
        test: /\.ts$/,
        use: [
          {loader: 'angular2-template-loader'},
          {loader: 'cache-loader'},
          {
            loader: 'thread-loader',
            options: {
              // there should be 1 cpu for the fork-ts-checker-webpack-plugin
              workers: require('os').cpus().length - 1
            }
          },
          {
            loader: 'ts-loader',
            options: {
              transpileOnly: true,
              happyPackMode: true
            }
          },
          {loader: 'angular-router-loader'}
        ],
        exclude: ['node_modules']
      },
      {
        test: /\.scss$/,
        loaders: ['to-string-loader', 'css-loader', 'sass-loader'],
        exclude: /(vendor\.scss|global\.scss)/
      },
      {
        test: /(vendor\.scss|global\.scss)/,
        loaders: ['style-loader', 'css-loader', 'postcss-loader', 'sass-loader']
      },
      {
        test: /\.css$/,
        loaders: ['to-string-loader', 'css-loader'],
        exclude: /(vendor\.css|global\.css)/
      },
      //用正则表达式去匹配要用该Loader 转换的css 文件
      //如下配置告诉 Webpack，在遇到以.css 结尾的文件时，先使用css-loader 读取css 文件，
      // 再由styleloade 将css 的内容注入JavaScript 里。
      {
        test: /(vendor\.css|global\.css)/,
        loaders: ['style-loader', 'css-loader']
      }]
  },
  stats: options.stats,
  plugins: [
    new SimpleProgressWebpackPlugin({
      format: options.stats === 'minimal' ? 'compact' : 'expanded'
    }),
    new FriendlyErrorsWebpackPlugin(),
    new ForkTsCheckerWebpackPlugin(),
    new BrowserSyncPlugin({
      host: 'localhost',
      port: 9000,
      proxy: {
        target: 'http://localhost:9060'
      }
    }, {
      reload: false
    }),
    new webpack.ContextReplacementPlugin(
      /angular(\\|\/)core(\\|\/)/,
      path.resolve(__dirname, './src/main/webapp')
    ),
    new writeFilePlugin(),
    new webpack.WatchIgnorePlugin([
      utils.root('src/test'),
    ]),
    new WebpackNotifierPlugin({
      title: 'JHipster',
      contentImage: path.join(__dirname, 'logo-jhipster.png')
    })
  ],
  mode: 'development'
});
