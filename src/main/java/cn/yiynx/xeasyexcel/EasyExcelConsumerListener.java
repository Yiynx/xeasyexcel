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

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * EasyExcel消费监听.
 * @author www@yiynx.cn
 * @param <T> 泛型
 * see <a href="https://github.com/alibaba/easyexcel/blob/master/src/test/java/com/alibaba/easyexcel/test/demo/read/DemoDataListener.java">DemoDataListener</a>
 */
public class EasyExcelConsumerListener<T> extends AnalysisEventListener<T> {
    private int pageSize;
    private List<T> list;
    private Consumer<List<T>> consumer;

    public EasyExcelConsumerListener(int pageSize, Consumer<List<T>> consumer) {
        this.pageSize = pageSize;
        this.consumer = consumer;
        list = new ArrayList<>(pageSize);
    }

    @Override
    public void invoke(T data, AnalysisContext context) {
        list.add(data);
        if (list.size() >= pageSize) {
            consumer.accept(list);
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        consumer.accept(list);
    }
}
