package com.rivkaer.moonnet.template;

import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Types;

import java.io.IOException;
import java.lang.reflect.Type;

import com.rivkaer.moonnet.Exception.ApiException;
import com.rivkaer.moonnet.Exception.ResultException;
import com.rivkaer.moonnet.NetworkConfig;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * function: Json Unified outer stripping
 */
final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final Type type;

    GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        Type baseBaseBean = $Gson$Types.newParameterizedTypeWithOwner(null, BaseBean.class, type);
        BaseBean bean = gson.fromJson(response, baseBaseBean);

        if (bean.isError()){
            throw new ResultException(901,"服务器异常");
        }else {
            return (T) bean.getResults();
        }
    }
}
