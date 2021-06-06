# 简介 | Intro
easyexcel 扩展工具包 - 分页读取excel

# 快速开始

## 添加依赖
引入Xif依赖
``` xml
<dependency>
    <groupId>cn.yiynx</groupId>
    <artifactId>xeasyexcel</artifactId>
    <version>1.0.0</version>
</dependency>
```
## 使用示例
``` java
ExcelUtil.read(excelFile, DemoData.class, pageSize, pageList -> dataService.save(pageList)).sheet().doRead();
```
