package com.rivkaer.moonnet.convert;

import com.google.gson.Gson;
import com.rivkaer.moonnet.exception.ResultException;
import com.rivkaer.moonnet.model.BaseResultBean;
import com.rivkaer.moonnet.model.BaseResultErrorBean;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @author: Junjian Jia
 * @Date: 19-4-20
 * @Email: cnrivkaer@outlook.com
 * @Description: Gson将Result数据解析成对象, 该步骤也可以进行统一外层剥离,
 * 而且可以直接剥离调外衣,不再需要 老鸨 帮你找到你喜欢的姑娘, 但我的姑娘在远方
 */
final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final Type type;

    GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T convert(ResponseBody value) throws IOException {
        String resp = value.string();

        try {
            BaseResultBean resultBean = gson.fromJson(resp, BaseResultBean.class);

            if (resultBean.getCode() == 200) {
                return (T) resultBean.getData();
            } else {
                throw new ResultException(resultBean.getCode(), resultBean.getMsg());
            }

        } catch (Exception e) {
            BaseResultErrorBean errorBean = gson.fromJson(resp, BaseResultErrorBean.class);
            throw new ResultException(errorBean.getCode(), errorBean.getMsg());
        } finally {
            value.close();
        }
    }
}
