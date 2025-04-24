<div align="center">
  <img src="./app/src/main/res/drawable/app_icon.png" alt="logo" width="100"/>
  <h1 align="center">TV Box</h1>
</div>

<div align="center">更加注重自定义直播功能的app,完全保留原有点播功能！实际就是为了练手，以前没学过java,会一点点c,python,matlab，第一次用github,还不怎么会</div>
<br>
<p align="center">
  <a href="https://github.com/wangweiwei104/TVBox/releases/latest">
    <img src="https://img.shields.io/github/v/release/wangweiwei104/TVBox" />
  </a>
  <a href="https://github.com/wangweiwei104/TVBox/releases/latest">
    <img src="https://img.shields.io/github/downloads/wangweiwei104/TVBox/total" />
  </a>
  <a href="https://github.com/wangweiwei104/TVBox/fork">
    <img src="https://img.shields.io/github/forks/wangweiwei104/TVBox" />
  </a>
  <a href="https://github.com/wangweiwei104/TVBox/star">
    <img src="https://img.shields.io/github/stars/wangweiwei104/TVBox" />
  </a>
</p>

- [📍代码修改自(或参考)](#📍代码修改自(或参考))
- [✅ 改了啥](#改了啥)
- [🗓️ 更新日志](./CHANGELOG.md)
- [❤️ 赞赏](#赞赏)
- [📣 免责声明](#免责声明)
- [⚖️ 许可证](#许可证)

## 📍代码修改自(或参考)：

- [takagen99/Box ](https://github.com/takagen99/Box)
- [q215613905/TVBoxOS](https://github.com/q215613905/TVBoxOS)

## 改了啥

- ✅ 修改了设置播放器（解码方式）的逻辑。原逻辑为直接从接口中读取，但如果用户自己定义了直播源，依然使用接口中定义的播放器类型，这就不合适了，造成的表象就是设置中更改了播放器类型，直播中也不生效；现修改为如果用户没有自定义直播源，依然从接口中读取；如果用户自定义了直播源（如http://xx/xx.txt），则从设置中读取；
- ✅ 修改了app图标，使用ChatGPT根据内置banner图生成
- ✅ 修改了内置的epg_data,原有的TV logo地址已失效（我这里测试无法读取），现已改为与q版TVBOX相同的epg_data，TV logo地址可以使用；在用户未自定义logo地址的情况下使用
- ✅ 增加了自定义logo地址的接口，如果用户自定义了logo地址，则不使用内置epg_data中定义的logo地址。自定义logo地址的格式为：
```bash
  http://xx/../{name}.png
  ```
- ⭐️ 上面四条更新的图以后再补上吧
- ✨ 代码修改自[takagen99/Box ](https://github.com/takagen99/Box) [20250325-0046](https://github.com/o0HalfLife0o/TVBoxOSC/releases/tag/20250325-0046)
- ✨ 后面再学习一下怎么合并两个仓库的代码，才能保持实时更新

## 更新日志

[更新日志](./CHANGELOG.md)

## 赞赏

<div>暂不需要~</div>


## 关注

不用


## 免责声明

本项目仅供学习交流用途，代码均来源于网络，如有侵权，请联系删除

## 许可证

[MIT](./LICENSE) License &copy; 2025-PRESENT [wangweiwei104](https://github.com/wangweiwei104)

