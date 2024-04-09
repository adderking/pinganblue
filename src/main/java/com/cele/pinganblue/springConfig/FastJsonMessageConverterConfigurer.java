package com.cele.pinganblue.springConfig;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.support.config.FastJsonConfig;
import com.alibaba.fastjson2.support.spring6.http.converter.FastJsonHttpMessageConverter;
import com.google.common.base.Charsets;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: kingcobra
 * create on 2023/12/26 15:44
 * HTTPMessage转换器，将spring默认使用的fasterxml-jackson修改为使用alibaba.fastjson2
 **/
@Configuration(proxyBeanMethods = false)
public class FastJsonMessageConverterConfigurer implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charsets.UTF_8);
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        fastJsonConfig.setWriterFeatures(
                //List为Null输出[]
                JSONWriter.Feature.WriteNullListAsEmpty,
                //格式化JSON
                JSONWriter.Feature.PrettyFormat,
                //String为Null输出""
                JSONWriter.Feature.WriteNullStringAsEmpty,
                //Map值为Null输出
                JSONWriter.Feature.WriteMapNullValue,
                //布尔值为Null输出false
                JSONWriter.Feature.WriteNullBooleanAsFalse,
                //数值为Null输出0
                JSONWriter.Feature.WriteNullNumberAsZero
        );
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        List<MediaType> supportedMediaTypes = new ArrayList<>();

        // 3. 添加支持的媒体类型
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);

        fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        converters.add(0, fastJsonHttpMessageConverter);
    }
}
