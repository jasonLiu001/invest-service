var path = require('path')
var webpack = require('webpack')

const APP_DIR = path.resolve(__dirname, './src');
const MODULES_DIR = path.resolve(__dirname, './node_modules');

const packageJson = require('./package.json');

module.exports = {
  entry: {
    main: './src/main.js',
    vue: ['vue'],
    vuetify: ['vuetify'],
    vueRouter: ['vue-router'],
    // vendor: Object.keys(packageJson.dependencies)
  },
  output: {
    path: path.resolve(__dirname, './dist'),
    chunkFilename: '[name].js',
    publicPath: '/service/dist/',//这里的/service是tomcat的虚拟目录
    filename: '[name].js',
    // filename: 'build.js'
  },
  module: {
    rules: [
      {
        test: /\.css$/,
        use: [
          'vue-style-loader',
          'css-loader'
        ],
      },
      {
        test: /\.scss$/,
        use: [
          'vue-style-loader',
          'css-loader',
          'sass-loader'
        ],
      },
      {
        test: /\.sass$/,
        use: [
          'vue-style-loader',
          'css-loader',
          'sass-loader?indentedSyntax'
        ],
      },
      {
        test: /\.vue$/,
        loader: 'vue-loader',
        options: {
          loaders: {
            // Since sass-loader (weirdly) has SCSS as its default parse mode, we map
            // the "scss" and "sass" values for the lang attribute to the right configs here.
            // other preprocessors should work out of the box, no loader config like this necessary.
            'scss': [
              'vue-style-loader',
              'css-loader',
              'sass-loader'
            ],
            'sass': [
              'vue-style-loader',
              'css-loader',
              'sass-loader?indentedSyntax'
            ]
          }
          // other vue-loader options go here
        }
      },
      {
        test: /\.js$/,
        loader: 'babel-loader',
        exclude: /node_modules/
      },
      {
        test: /\.(png|jpg|gif|svg)$/,
        loader: 'file-loader',
        options: {
          name: '[name].[ext]?[hash]'
        }
      },
      {
        test: /\.(eot|ttf|woff|woff2)$/,
        loader: 'file-loader',
        options: {
          name: '[name].[ext]'
        }
      }
    ]
  },
  resolve: {
    alias: {
      'vue$': 'vue/dist/vue.esm.js'
    },
    extensions: ['*', '.js', '.vue', '.json']
  },
  devServer: {
    historyApiFallback: true,
    noInfo: true,
    overlay: true,
    port: 9000
  },
  performance: {
    hints: false
  },
  devtool: '#eval-source-map'
}

if (process.env.NODE_ENV === 'production') {
  //module.exports.devtool = '#source-map'
  module.exports.devtool = 'false'
  // http://vue-loader.vuejs.org/en/workflow/production.html
  module.exports.plugins = (module.exports.plugins || []).concat([
    new webpack.DefinePlugin({
      'process.env': {
        NODE_ENV: '"production"'
      }
    }),
    //提取公共的或者第三方类库的js到单独的文件
    new webpack.optimize.CommonsChunkPlugin({
      names: ['vuetify', 'vueRouter', 'vue'],//这里面顺序注意，将公共引用的放到最后
      // filename: 'vue.js',//这里的filename会覆盖output中的filename，可以在这为output输出一个新的文件名，可以省略
    }),
    new webpack.optimize.UglifyJsPlugin({
      sourceMap: false,
      compress: {
        warnings: false
      }
    }),
    new webpack.LoaderOptionsPlugin({
      minimize: true
    })
  ])
}
