package com.zqh.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import java.util.Properties;

@Intercepts({@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class})})
public class ExamplePlugin implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println(invocation.getMethod().getName() + " 执行");
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        System.out.println("ExamplePlugin plugin wrap");
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        System.out.println("ExamplePlugin plugin setProperties");
    }
}