package com.banana.foundation.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangbo
 * @version 2018/1/31 18:27
 */
@Configuration
@ConditionalOnClass({JSON.class})
public class FastJsonHttpMessageConvertersConfiguration {

    @Configuration
    @ConditionalOnClass({FastJsonHttpMessageConverter.class}) //1 判断是否存在类
    @ConditionalOnProperty(//2 使用spring.http.converters.preferred-json-mapper属性来启动功能
            name = {"spring.http.converters.preferred-json-mapper"},
            havingValue = "fastjson",
            matchIfMissing = true
    )
    protected static class FastJson2HttpMessageConverterConfiguration {
        protected FastJson2HttpMessageConverterConfiguration() {
        }

        @Bean
        @ConditionalOnMissingBean({FastJsonHttpMessageConverter.class})//3 当没有注册这个类时，自动注册Bean
        public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
            FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

            FastJsonConfig fastJsonConfig = new FastJsonConfig();//4 使用最新的官方推荐配置对象的方式来注入fastjson的序列化特征
            fastJsonConfig.setSerializerFeatures(
                    SerializerFeature.PrettyFormat,
//                    SerializerFeature.WriteClassName,
                    SerializerFeature.WriteMapNullValue,
//                    SerializerFeature.WriteNullStringAsEmpty,
                    SerializerFeature.WriteEnumUsingToString,
                    SerializerFeature.WriteDateUseDateFormat
            );

            //处理中文乱码问题
            List<MediaType> fastMediaTypes = new ArrayList<>();
            fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
            converter.setSupportedMediaTypes(fastMediaTypes);

//            ValueFilter valueFilter = new ValueFilter() {//5 添加对json值的过滤，因为像移动APP，服务端在传json值时最好不要传null，而是使用“”，这是一个演示
//                //o 是class
//                //s 是key值
//                //o1 是value值
//                public Object process(Object o, String s, Object o1) {
//                    if (null == o1){
//                        o1 = "";
//                    }
//                    return o1;
//                }
//            };
//            fastJsonConfig.setSerializeFilters(valueFilter);

            converter.setFastJsonConfig(fastJsonConfig);

            return converter;
        }
    }
}