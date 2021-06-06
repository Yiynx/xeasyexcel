/**
 * Copyright (c) 2021 xeasyexcel
 * xeasyexcel is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package cn.yiynx.xeasyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.function.Consumer;

/**
 * Excel工具类.
 * @author www@yiynx.cn
 */
public class ExcelUtil extends EasyExcel {
    private ExcelUtil() {}

    public static <T> ExcelReaderBuilder read(String pathName, Class<T> head, Integer pageSize, Consumer<List<T>> consumer) {
        return read(pathName, head, new EasyExcelConsumerListener<>(pageSize, consumer));
    }

    public static <T> ExcelReaderBuilder read(File file, Class<T> head, Integer pageSize, Consumer<List<T>> consumer) {
        return read(file, head, new EasyExcelConsumerListener<>(pageSize, consumer));
    }

    public static <T> ExcelReaderBuilder read(InputStream inputStream, Class<T> head, Integer pageSize, Consumer<List<T>> consumer) {
        return read(inputStream, head, new EasyExcelConsumerListener<>(pageSize, consumer));
    }

}
